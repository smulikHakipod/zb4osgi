/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
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

package org.persona.zigbee.tester;




import java.util.HashMap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.persona.zigbee.tester.event.EHListenerFactoryServiceTracker;
import org.persona.zigbee.tester.event.HAListenerFactoryServiceTracker;

/**
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class Activator implements BundleActivator {

	public static BundleContext context;
    public static HashMap<Options, Object> options = new HashMap<Options, Object>();
    
	private ControlPoint cp;

	public static HAListenerFactoryServiceTracker tracker = null;
	public static EHListenerFactoryServiceTracker trackerEH = null;
	
	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
	    Options[] opts = Options.values();
	    for ( int i = 0; i < opts.length; i++ ) {
            options.put( opts[i], opts[i].defaultValue );
        }
	    tracker = new HAListenerFactoryServiceTracker(context);
	    trackerEH = new EHListenerFactoryServiceTracker(context);
		Activator.context = context;
        cp = new ControlPoint();
        
        
	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		cp.close();
		Activator.context=null;
		context.removeServiceListener(tracker);
		tracker = null;

		context.removeServiceListener(trackerEH);
		trackerEH = null;
	}
}
