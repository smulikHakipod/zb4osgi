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

package it.cnr.isti.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public class ThreadUtilsTest {

	private final static long WAITING_TIME = 500;
	
	@Test
	public void waitNonPreemptive() {
		long s = System.currentTimeMillis();
		ThreadUtils.waitNonPreemptive(WAITING_TIME);
		assertTrue("Waited for enough time", s+WAITING_TIME <= System.currentTimeMillis() );
	}
	
	@Test
	public void waitingUntil() {
		long e = System.currentTimeMillis()+WAITING_TIME;
		ThreadUtils.waitingUntil(e);
		assertTrue("Waited for enough time", e <= System.currentTimeMillis() );		
	}
}
