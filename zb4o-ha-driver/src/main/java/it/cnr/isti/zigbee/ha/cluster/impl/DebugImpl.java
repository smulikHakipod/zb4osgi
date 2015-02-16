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
import it.cnr.isti.zigbee.ha.cluster.glue.general.DebugGlue;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.impl.general.DebugCluster;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @since 0.1.0
 *
 */
public class DebugImpl implements DebugGlue {

	private final DebugCluster debugCluster;
	private final Attribute uInt24;
	private final Attribute uInt32;
	private final Attribute uInt40;
	private final Attribute uInt48;
	private final Attribute uInt56;
	private final Attribute uInt64;
	
	private final Attribute sInt24;
	private final Attribute sInt32;
	private final Attribute sInt40;
	private final Attribute sInt48;
	private final Attribute sInt56;
	private final Attribute sInt64;

	public DebugImpl(ZigBeeDevice zbDevice) {
		debugCluster = new DebugCluster(zbDevice);

		uInt24 = debugCluster.getAttributeUint24();
		uInt32 = debugCluster.getAttributeUint32();
		uInt40 = debugCluster.getAttributeUint40();
		uInt48 = debugCluster.getAttributeUint48();
		uInt56 = debugCluster.getAttributeUint56();
		uInt64 = debugCluster.getAttributeUint64();
		sInt24 = debugCluster.getAttributeSint24();
		sInt32 = debugCluster.getAttributeSint32();
		sInt40 = debugCluster.getAttributeSint40();
		sInt48 = debugCluster.getAttributeSint48();
		sInt56 = debugCluster.getAttributeSint56();
		sInt64 = debugCluster.getAttributeSint64();
		

	}

	
	public Attribute[] getAttributes() {
		return debugCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = debugCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getId() == id)
				return attributes[i];
		}
		return null;
	}





	public String getDescription() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}


	public long getUint24() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getUint32() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getUint40() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getUint48() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getUint56() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getUint64() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getSint24() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getSint32() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getSint40() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getSint48() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getSint56() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getSint64() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}
	public Subscription[] getActiveSubscriptions() {
		return debugCluster.getActiveSubscriptions();
	}

	public int getId() {
		return debugCluster.getId();
	}

	public String getName() {
		return debugCluster.getName();
	}



}
