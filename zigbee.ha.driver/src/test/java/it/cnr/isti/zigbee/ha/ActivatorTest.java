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
package it.cnr.isti.zigbee.ha;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 */
public class ActivatorTest {

    private static final Logger logger = LoggerFactory.getLogger( ActivatorTest.class );

    /**
     * Test method for {@link it.cnr.isti.zigbee.ha.Activator#start(org.osgi.framework.BundleContext)}.
     */
    @Test
    public void testStart() {
        Activator testing = new Activator();
        BundleContext mock = createNiceMock( BundleContext.class );
        replay( mock );
        
        try {
            testing.start( mock );
        } catch ( Exception e ) {
            e.printStackTrace();
            fail( "Unexpected exception" + e );
        }
    }

}
