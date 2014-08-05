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

package it.cnr.isti.zigbee.zcl.library.impl.global.read;

import it.cnr.isti.zigbee.zcl.library.api.core.Status;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.api.global.ReadAttributesStatus;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.AttributeDescriptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200(mar, 06 ago 2013) $)
 *
 */
public class ReadAttributeStatusImpl implements ReadAttributesStatus {

    private final static Logger logger = LoggerFactory
            .getLogger(ReadAttributeStatusImpl.class);

    private byte status;

    private int attributeId;

    private byte dataType;

    private Class<?> clazz;

    private Object data;

    public ReadAttributeStatusImpl(AttributeDescriptor descriptor,
            ZBDeserializer deserializer) throws ZigBeeClusterException {

        attributeId = deserializer.read_short();
        status = deserializer.read_byte();
        if (Status.getStatus(status).equals(Status.SUCCESS)) {
            dataType = deserializer.read_byte();
            final ZigBeeType type = ZigBeeType.getType(dataType);
            if (type == null) {
                logger.debug(
                        "Unable to find a {} for the dataType {} it is not supported by the current implementation",
                        ZigBeeType.class, dataType);
                throw new ZigBeeClusterException("Unsupported data type "
                        + dataType);
            }
            clazz = type.getJavaClass();
            data = deserializer.readZigBeeType(type);
        }

        // TODO Attribute Check
        // indeed the order could be different, so we should receive all the
        // list
        // and in any case we could also avoid to throw an Exception

    }

    public Object getAttributeData() {
        return data;
    }

    public byte getAttributeDataType() {
        return dataType;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public byte getStatus() {
        return status;
    }

    public Class<?> getDataClass() {
        return clazz;
    }
}
