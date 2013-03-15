/*
   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


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
package it.cnr.isti.cc2480.low;

import java.io.OutputStream;

import com.itaca.ztool.RxTxSerialComm;
import com.itaca.ztool.api.ZToolException;
import com.itaca.ztool.api.ZToolPacketHandler;
import com.itaca.ztool.api.ZToolPacketParser;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.6.0
 * 
 */
public class RealSerialComm extends RxTxSerialComm implements SerialHandler{

    private Object parserLock = new Object();

    private ZToolPacketParser parser;
    
    public void open( String port, int baudRate, ZToolPacketHandler packethandler ) throws ZToolException {
        try {
            this.openSerialPort( port, baudRate );
            parser = new ZToolPacketParser( super.getInputStream(), packethandler, parserLock );
        } catch ( Exception e ) {
            throw new ZToolException("Unable to open SerialHandler due to exception",e);
        }        
    }

    public OutputStream getOutputStream(){
        return super.getOutputStream();
    }
    
    /**
     * Called by RXTX to notify us that data is available to be read.
     */
    protected void handleSerialData() {
        synchronized ( parser ) {
            parser.notify();
        }
    }
    
    /**
     * Shuts down RXTX and input stream threads
     */
    public void close() {
        // shutdown parser thread
        if ( parser != null ) {
            parser.setDone( true );
            // wake up if it's waiting for data
            parser.interrupt();
        }
        super.close();
    }

}
