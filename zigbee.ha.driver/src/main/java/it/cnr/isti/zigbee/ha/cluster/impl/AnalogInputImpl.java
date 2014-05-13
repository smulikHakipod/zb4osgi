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

package it.cnr.isti.zigbee.ha.cluster.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.Activator;
import it.cnr.isti.zigbee.ha.cluster.glue.general.AnalogInput;
import it.cnr.isti.zigbee.ha.cluster.glue.general.event.PresentValueListener;
import it.cnr.isti.zigbee.ha.cluster.impl.event.PresentValueBridgeListeners;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.impl.general.AnalogInputCluster;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision:  $ ($LastChangedDate: $)
 *
 */


public class AnalogInputImpl implements AnalogInput {	
    private final Attribute presentValue;
	private AnalogInputCluster analogInputCluster;
	private PresentValueBridgeListeners eventBridge;

    public AnalogInputImpl(ZigBeeDevice zbDevice){
    	analogInputCluster = new AnalogInputCluster(zbDevice);
        presentValue = analogInputCluster.getAttributePresentValue();  
        eventBridge = new PresentValueBridgeListeners(Activator.getConfiguration(), presentValue, this);
    }
	

    public boolean subscribe(PresentValueListener listener) {
        return eventBridge.subscribe(listener);
    }

    public boolean unsubscribe(PresentValueListener listener) {
        return eventBridge.unsubscribe(listener);
    }
    

	public Subscription[] getActiveSubscriptions() {
		return analogInputCluster.getActiveSubscriptions();
	}

	public int getId() {
		return analogInputCluster.getId();
	}

	public String getName() {
		return analogInputCluster.getName();
	}

	
	
	public Attribute getAttribute(int id) {		
		Attribute[] attributes = analogInputCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if( attributes[i].getId() == id ) 
				return attributes[i];
		}
		return null;
	}

	public Attribute[] getAttributes() {
		return analogInputCluster.getAvailableAttributes();
	}


	public String getDescription() throws ZigBeeHAException {
		 try {
	            return (String) analogInputCluster.getAttributeDescription().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeHAException(e);
	        }
	}
	 public int getReliability() throws ZigBeeHAException {
	        try {
	            return (Integer) analogInputCluster.getAttributeReliability().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeHAException(e);
	        }
	    }


	    public long getApplicationType() throws ZigBeeHAException {
	        try {
	            return (Long) analogInputCluster.getAttributeApplicationType().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeHAException(e);
	        }
	    }


	    public boolean getOutOfService() throws ZigBeeHAException {
	        try {
	            return (Boolean) analogInputCluster.getAttributeOutOfService().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeHAException(e);
	        }
	    }


	    public float getPresentValue() throws ZigBeeHAException {
	        try {
	            return (Float) analogInputCluster.getAttributePresentValue().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeHAException(e);
	        }
	    }


	    public int getStatusFlags() throws ZigBeeHAException {
	        try {
	            return (Integer) analogInputCluster.getAttributeStatusFlags().getValue();
	        } catch (ZigBeeClusterException e) {
	            throw new ZigBeeHAException(e);
	        }
	    }


		public float getMaxPresentValue() throws ZigBeeHAException {
			 try {
		            return (Float) analogInputCluster.getAttributeMaxPresentValue().getValue();
		        } catch (ZigBeeClusterException e) {
		            throw new ZigBeeHAException(e);
		        }
		}


		public float getMinPresentValue() throws ZigBeeHAException {
			 try {
		            return (Float) analogInputCluster.getAttributeMinPresentValue().getValue();
		        } catch (ZigBeeClusterException e) {
		            throw new ZigBeeHAException(e);
		        }
		}


		public float getResolution() throws ZigBeeHAException {
			// TODO Auto-generated method stub
			return 0;
		}


		public int getEngineeringUnits() throws ZigBeeHAException {
			// TODO Auto-generated method stub
			return 0;
		}


	



	
}
