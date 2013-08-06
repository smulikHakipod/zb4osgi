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

import it.cnr.isti.zigbee.api.ZigBeeNode;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.api.impl.ZigBeeNodeImpl;
import it.cnr.isti.zigbee.dongle.api.AnnunceListner;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import org.aaloa.zb4osgi.api.monitor.ZigBeeDiscoveryMonitor;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;

/**
 *
 * <b>NOTE:</b>This class doesn't implement a real {@link Thread}, anyway<br>
 * because it is a {@link AnnunceListner} a different thread then the application will call
 * the {@link #notify(ZToolAddress16, ZToolAddress64, ZToolAddress16, int)} method.
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class AnnunceListnerThread implements AnnunceListner{

    private final static Logger logger = LoggerFactory.getLogger(AnnunceListnerThread.class);

    private final ImportingQueue queue;

    /**
     * Created the {@link AnnunceListnerThread} object and register itself to the {@link SimpleDriver}<br>
     * as {@link ImportingQueue}
     *
     * @param queue the {@link ImportingQueue} used to add the discovered devices
     * @param driver the {@link SimpleDriver} to use for subscription
     */
    public AnnunceListnerThread(final ImportingQueue queue) {
        this.queue = queue;
    }

    public void notify(ZToolAddress16 senderAddress,
            ZToolAddress64 ieeeAddress, ZToolAddress16 destinationAddress,
            int capabilitiesBitmask) {

        logger.info("received an ANNUNCE from {} {}", senderAddress, ieeeAddress);
        queue.push(senderAddress, ieeeAddress);
        annuncedNode( new ZigBeeNodeImpl( senderAddress.get16BitValue(), ieeeAddress ) );
    }

    private void annuncedNode(ZigBeeNode node) {
        ServiceReference[] refs = null;
        try {
            refs = Activator.getBundleContext().getServiceReferences(ZigBeeDiscoveryMonitor.class.getName(), null);
        } catch (InvalidSyntaxException ex) {
            logger.error( "CODE BROKEN we need to recompile and fix", ex );
        }
        if ( refs == null ){
            return ;
        }

        for (int i = 0; i < refs.length; i++) {
            final ZigBeeDiscoveryMonitor listener;
            try{
                listener = (ZigBeeDiscoveryMonitor) Activator.getBundleContext().getService(refs[i]);
                listener.annuncedNode( node );
            }catch(Exception ex) {
                logger.error("Handled excepetion during notification", ex);
            }
        }
    }

}
