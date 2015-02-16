/*
   Copyright 2008-2014 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.zcl.library.impl.general;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.general.AnalogInput;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.Attributes;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;


/**
*
* @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
* @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
* @version $LastChangedRevision$ ($LastChangedDate$)
* @since 0.9.0
*
*/
public class AnalogInputCluster extends ZCLClusterBase implements AnalogInput {

    private final AttributeImpl description;
    private final AttributeImpl maxPresentValue;
    private final AttributeImpl minPresentValue;
    private final AttributeImpl outOfService;
    private final AttributeImpl presentValue;
    private final AttributeImpl reliability;
    private final AttributeImpl resolution;
    private final AttributeImpl statusFlags;
    private final AttributeImpl engineeringUnits;
    private final AttributeImpl applicationType;

    private final Attribute[] attributes;

    public AnalogInputCluster(ZigBeeDevice zbDevice){
        super(zbDevice);

         description  = new AttributeImpl(zbDevice,this,Attributes.DESCRIPTION);
         maxPresentValue  = new AttributeImpl(zbDevice,this,Attributes.MAX_PRESENT_VALUE);
         minPresentValue  = new AttributeImpl(zbDevice,this,Attributes.MIN_PRESENT_VALUE);
         outOfService  = new AttributeImpl(zbDevice,this,Attributes.OUT_OF_SERVICE);
         presentValue  = new AttributeImpl(zbDevice,this,Attributes.ANALOG_PRESENT_VALUE);
         reliability  = new AttributeImpl(zbDevice,this,Attributes.RELIABILITY);
         resolution  = new AttributeImpl(zbDevice,this,Attributes.RESOLUTION);
         statusFlags  = new AttributeImpl(zbDevice,this,Attributes.STATUS_FLAGS);
         engineeringUnits  = new AttributeImpl(zbDevice,this,Attributes.ENGINEERING_UNITS);
         applicationType  = new AttributeImpl(zbDevice,this,Attributes.APPLICATION_TYPE);


        attributes = new AttributeImpl[]{description,maxPresentValue,minPresentValue,outOfService,
                presentValue,reliability,resolution,statusFlags,engineeringUnits,applicationType
                                        };
    }

    @Override
    public short getId() {
        return AnalogInput.ID;
    }

    @Override
    public String getName() {
        return AnalogInput.NAME;
    }

    @Override
    public Attribute[] getStandardAttributes() {
        return attributes;
    }



    public Attribute getAttributeDescription() {
        return description;
    }

    public Attribute getAttributeMaxPresentValue() {
        return maxPresentValue;
    }

    public Attribute getAttributeMinPresentValue() {
        return minPresentValue;
    }

    public Attribute getAttributeOutOfService() {
        return outOfService;
        }

    public Attribute getAttributePresentValue() {
        return presentValue;
    }

    public Attribute getAttributeReliability() {
        return reliability;
    }

    public Attribute getAttributeResolution() {
        return resolution;
    }
    public Attribute getAttributeStatusFlags() {
        return statusFlags;
    }


    public Attribute getAttributeEngineeringUnits() {
        return engineeringUnits;
    }

    public Attribute getAttributeApplicationType() {
        return applicationType;
    }









}
