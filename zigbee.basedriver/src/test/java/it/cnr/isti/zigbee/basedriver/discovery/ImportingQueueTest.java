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

package it.cnr.isti.zigbee.basedriver.discovery;

import org.junit.Test;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;
/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class ImportingQueueTest {

	private static int ID = 0;
	
	private class QueueUser extends Thread {
		protected ImportingQueue queue;
		protected int elements;				
		protected long sleeping;
		protected final int id;
		
		
		public QueueUser(){
			id = ID;
			ID++;
		}		
		
	}

	private class Producer extends QueueUser {		
		public void run() {
			final ZToolAddress16 nwk = new ZToolAddress16();
			final ZToolAddress64 ieee = new ZToolAddress64();
			final int total = elements;
			System.out.println("[PRODUCER"+id+"] Starting to write "+total+" elements");
			while(elements>=0){
				try {
					Thread.sleep(sleeping);
				} catch (InterruptedException e) {
				}
				if( ( ( elements * 100 / total ) % 10 ) == 0 ){
					System.out.println("[PRODUCER"+id+"] Pushed "+(100-elements*100/total)+"%");
				}
				queue.push(nwk, ieee);				
				elements--;
			}
			System.out.println("[PRODUCER"+id+"] Wrote all the "+total+" elements");
		}
	}

	private class Consumer extends QueueUser {
		public void run() {
			final ZToolAddress16 nwk = new ZToolAddress16();
			final ZToolAddress64 ieee = new ZToolAddress64(); 
			final int total = elements;
			System.out.println("[CONSUMER"+id+"] Starting to read "+total+" elements");
			while(elements>=0){
				try {
					Thread.sleep(sleeping);
				} catch (InterruptedException e) {
				}
				if( ( ( elements * 100 / total ) % 10 ) == 0 ){
					System.out.println("[CONSUMER"+id+"] Poped "+(100-elements*100/total)+"%");
				}
				queue.pop();				
				elements--;
			}
			System.out.println("[CONSUMER] Read all the "+total+" elements");
		}
	}
	
	@Test
	public void testPushPop() {
		if( System.getProperty("testing.thread") == null ){
			System.out.println("Skipping multi threading test on ImportingQueue");
			return;
		}
		
		final int ELEMENTS = 400;
		final long SLEEPING = 500;
		final ImportingQueue queue = new ImportingQueue();
		final QueueUser[] producers = new QueueUser[]{
				new Producer(), new Producer(),
				new Producer(), new Producer()
		};

		final QueueUser[] consumers = new QueueUser[]{
				new Consumer(),
				new Consumer()
		};

		
		for (int i = 0; i < producers.length; i++) {
			producers[i].queue = queue;
			producers[i].elements = ELEMENTS;
			producers[i].sleeping = SLEEPING/5;
			producers[i].start();
		}		
		for (int i = 0; i < consumers.length; i++) {
			consumers[i].queue = queue;
			consumers[i].elements = ELEMENTS/4 * (i % 2 == 0 ? 1 : 3);
			consumers[i].sleeping = SLEEPING;
			consumers[i].start();
		}		
		
		for (int i = 0; i < consumers.length; i++) {
			try {
				consumers[i].join(ELEMENTS*producers.length*SLEEPING);
			} catch (InterruptedException e) {
				System.out.println("WARNING: Thread hasn't terminated within the computed time!");
			}
		}
	}

	
	@Test
	public void testPopPush() {
		if( System.getProperty("testing.thread") == null ){
			System.out.println("Skipping multi threading test on ImportingQueue");
			return;
		}
		
		final int ELEMENTS = 400;
		final long SLEEPING = 50;
		final ImportingQueue queue = new ImportingQueue();
		final QueueUser[] producers = new QueueUser[]{
				new Producer(), new Producer(),
				new Producer(), new Producer()
		};

		final QueueUser[] consumers = new QueueUser[]{
				new Consumer(),
				new Consumer()
		};

		
		for (int i = 0; i < producers.length; i++) {
			producers[i].queue = queue;
			producers[i].elements = ELEMENTS;
			producers[i].sleeping = SLEEPING/5;
			producers[i].start();
		}		
		for (int i = 0; i < consumers.length; i++) {
			consumers[i].queue = queue;
			consumers[i].elements = ELEMENTS/4 * (i % 2 == 0 ? 1 : 3);
			consumers[i].sleeping = SLEEPING;
			consumers[i].start();
		}		
		
		for (int i = 0; i < consumers.length; i++) {
			try {
				consumers[i].join(ELEMENTS*producers.length*SLEEPING);
			} catch (InterruptedException e) {
				System.out.println("WARNING: Thread hasn't terminated within the computed time!");
			}
		}
	}
	
}
