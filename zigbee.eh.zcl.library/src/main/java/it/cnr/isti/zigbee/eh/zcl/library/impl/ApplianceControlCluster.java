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

package it.cnr.isti.zigbee.eh.zcl.library.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.eh.zcl.library.api.ApplianceControl;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.Attributes;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 * This class represent the <b>Appliance Control</b> Cluster as defined by the
 * document:<br>
 * <i>E@H Technical specification </i> public release Version 0.95
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public class ApplianceControlCluster extends ZCLClusterBase
		implements
			ApplianceControl {

	private static AttributeImpl description;
	private static AttributeImpl basicIdentification;
	private static AttributeImpl companyName;
	private static AttributeImpl companyId;
	private static AttributeImpl brandName;
	private static AttributeImpl brandId;
	private static AttributeImpl model;
	private static AttributeImpl partNumber;
	private static AttributeImpl productRevision;
	private static AttributeImpl softwareRevision;
	private static AttributeImpl productTypeName;
	private static AttributeImpl productTypeId;
	private static AttributeImpl CECEDSpecificationVersion;

	private final Attribute[] attributes;

	public ApplianceControlCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);

		description = new AttributeImpl(zbDevice, this, Attributes.DESCRIPTION);
		basicIdentification = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.BASIC_IDENTIFICATION);
		companyName = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.COMPANY_NAME);
		companyId = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.COMPANY_ID);
		brandName = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.BRAND_NAME);
		brandId = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.BRAND_ID);
		model = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.MODEL);
		partNumber = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.PART_NUMBER);
		productRevision = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.PRODUCT_REVISION);
		softwareRevision = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.SOFTWARE_REVISION);
		productTypeName = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.PRODUCT_TYPE_NAME);
		productTypeId = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.PRODUCT_TYPE_ID);
		CECEDSpecificationVersion = new AttributeImpl(zbDevice, this,
				AttributesApplianceControl.CECED_SPECIFICATION_VERSION);

		attributes = new AttributeImpl[]{description, basicIdentification,
				companyName, companyId, brandName, brandId, model, partNumber,
				productRevision, softwareRevision, productTypeName,
				productTypeId, CECEDSpecificationVersion};
	}

	
	@Override
	public short getId() {
		return ApplianceControl.ID;
	}

	@Override
	public String getName() {
		return ApplianceControl.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Attribute getAttributeDescription() {
		return description;
	}

	public Attribute getBasicIdentification() {

		return basicIdentification;
	}

	public Attribute getCompanyName() {

		return companyName;
	}

	public Attribute getCompanyId() {

		return companyId;
	}

	public Attribute getBrandName() {

		return brandName;
	}

	public Attribute getBrandId() {

		return brandId;
	}

	public Attribute getModel() {

		return model;
	}

	public Attribute getPartNumber() {

		return partNumber;
	}

	public Attribute getProductRevision() {

		return productRevision;
	}

	public Attribute getSoftwareRevision() {

		return softwareRevision;
	}

	public Attribute getProductTypeName() {

		return productTypeName;
	}

	public Attribute getProductTypeId() {

		return productTypeId;
	}

	public Attribute getCECEDSpecificationVersion() {

		return CECEDSpecificationVersion;
	}

}
