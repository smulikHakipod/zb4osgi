/*
   Copyright 2008-2013 Andrew Rapp, http://code.google.com/p/xbee-api/
   
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 

   Copyright 2008-2013 ITACA-TSB, http://www.tsb.upv.es/
   Instituto Tecnologico de Aplicaciones de Comunicacion 
   Avanzadas - Grupo Tecnologias para la Salud y el 
   Bienestar (TSB)


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.itaca.ztool.api;

import it.cnr.isti.io.MarkableInputStream;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.util.ByteUtils;

/**
 * @author <a href="mailto:andrew.rapp@gmail.com">Andrew Rapp</a>
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:michele.girolami@isti.cnr.it">Michele Girolami</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ZToolPacketParser implements Runnable {
	
	private final static Logger logger = LoggerFactory.getLogger(ZToolPacketParser.class);
	private final static Logger profiler = LoggerFactory.getLogger("profiling."+ZToolPacketParser.class.getName());
	private final int DEFAULT_TIMEOUT = 60000;
	
	private ZToolPacketHandler handler;
	private Object newPacketNotification = null;
	private final InputStream in;
	private int timeout = DEFAULT_TIMEOUT;
	
	private Thread thread = null;
	
	private boolean done = false;

	public ZToolPacketParser(InputStream in, ZToolPacketHandler handler, Object lock) {
		logger.debug("Creating ZToolPacketParser");
		if ( in.markSupported() ) {
			this.in = in;
		} else {
			logger.warn(
					"Provided InputStream {} doesn't provide the mark()/reset() feature, " +
					"wrapping it up as BufferedInputStream", in.getClass()
			);
			this.in = new MarkableInputStream(in);
		}
		this.handler = handler;
		this.newPacketNotification = lock;

		thread = new Thread(this,"ZToolPacketParser");
		thread.setDaemon(true);
		thread.start();
	}
	
	public void run() {

		int val = -1;
		
		ZToolPacket response = null;
		ZToolPacketStream packetStream = null;
		logger.debug("Thread used by ZToolPacketParser started");		
		while (!done) {
			
			try {
				if (in.available() > 0) {
					//THINK Why we loop on in.available() instead of wait on in.read ?
					val = in.read();
					logger.trace("Read {} from input stream ", ByteUtils.formatByte(val));
					if (val == ZToolPacket.START_BYTE) {
						in.mark(256);
						profiler.info("Start reading packet");
						packetStream = new ZToolPacketStream(in);
						response = packetStream.parsePacket();
						profiler.info("Packet read and decoded");
						
						logger.debug("Response is {} -> {}", response.getClass(), response);
						if ( response.isError() ){
							logger.error("Received a BAD PACKET {}", response.getPacket() );
							in.reset();
							continue;
						} 
						// wrap around entire parse routine
						synchronized (this.newPacketNotification) {							
							// add to handler and newPacketNotification
							handler.handlePacket(response);
							//log.debug("Notifying API user that packets are ready");
							newPacketNotification.notifyAll();
						}
					} else {
						logger.warn("Discared stream: expected start byte but received this {}", ByteUtils.toBase16(val));
					}
				} else {
					logger.info("No data available, waiting for new data event or timeout");
					long start = System.currentTimeMillis();
					
					// we will wait here for RXTX to notify us of new data
					synchronized (this) {
						// There's a chance that we got notified after the first in.available check
						if (in.available() > 0) {
							continue;
						}
						
						// serial event will wake us up
						this.wait(timeout);
					}
										
					//Looking for deadlock when packet is not received
					synchronized (this.newPacketNotification) {
						newPacketNotification.notifyAll();						
					}					
					
					final long waited = System.currentTimeMillis() - start; 
					if ( waited >= timeout) {
						logger.debug("Timeout fired: checking for data");
					} else {
						logger.debug("Serial Event fired: Thread woken up");
					}
				}
			} catch(InterruptedException ie) {
				logger.debug("Thread woken up by InterruptedException");
				// we've been told to stop
				//FIX replace break with continue, because 
				//	the interrupt could be generated for other meanings 
				break;
			} catch (Exception e) {
				/*
				 * handling exceptions in a thread is a bit dicey.
				 * the rest of the packet will be discarded
				 * 
				 */				
				logger.error("Exception in reader thread", e);
				handler.error(e);
				
				synchronized (this.newPacketNotification) {
					newPacketNotification.notify();
				}
			}				
		}
		logger.debug("Thread used by ZToolPacketParser terminated");
	}

	public int getTimeout() {
		return timeout;
	}

	/**
	 * This is hosw long we wait until we check for new data in the event RXTX fails to notify us.
	 * 
	 * @param timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	public void interrupt() {
		thread.interrupt();
	}

	/**
	 * @return the internal thread that is handling the {@link InputStream} for parsing packet
	 * @since 0.6.0
	 */
	public Thread getInternalThread() {
		return thread;
	}
}
