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

package it.cnr.isti.zigbee.eh.cluster.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl;
import it.cnr.isti.zigbee.eh.zcl.library.impl.ApplianceControlCluster;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;

/**
 * @author <a href="giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * 
 */
public class ApplianceControlImpl implements ApplianceControl {

	private ApplianceControlCluster applianceControlCluster;
	private Attribute zclVersion;

	public ApplianceControlImpl(ZigBeeDevice zbDevice) {
		// basicCluster = new BasicCluster(zbDevice);
		// zclVersion = basicCluster.getAttributeZCLVersion();

	}

	public Attribute getZCLVersion() {
		return zclVersion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getId()
	 */
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getActiveSubscriptions()
	 */
	public Subscription[] getActiveSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getAttributes()
	 */
	public Attribute[] getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getAttribute(int)
	 */
	public Attribute getAttribute(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getDescription
	 * ()
	 */
	public String getDescription() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#
	 * getBasicIdentification()
	 */
	public long getBasicIdentification() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getCompanyName
	 * ()
	 */
	public String getCompanyName() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getCompanyId
	 * ()
	 */
	public int getCompanyId() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getBrandName
	 * ()
	 */
	public String getBrandName() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getBrandId()
	 */
	public int getBrandId() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getPartNumber
	 * ()
	 */
	public String getPartNumber() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#
	 * getProductRevision()
	 */
	public String getProductRevision() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#
	 * getSoftwareRevision()
	 */
	public String getSoftwareRevision() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#
	 * getApplicationType()
	 */
	public String getApplicationType() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#
	 * getProductTypeName()
	 */
	public String getProductTypeName() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#getProductTypeId
	 * ()
	 */
	public int getProductTypeId() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see it.cnr.isti.zigbee.eh.cluster.glue.general.ApplianceControl#
	 * getCECEDSpecificationVersion()
	 */
	public short getCECEDSpecificationVersion() throws ZigBeeHAException {
		// TODO Auto-generated method stub
		return 0;
	}

}
