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

package it.cnr.isti.zigbee.zcl.library.impl.core;

import it.cnr.isti.zigbee.zcl.library.impl.field.Dependency;
import it.cnr.isti.zigbee.zcl.library.impl.field.FieldDescriptor;
import it.cnr.isti.zigbee.zcl.library.impl.field.ListFieldDescriptor;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 *         *
 */

public class GenericCommand extends AbstractCommand {

	private Object[] values;

	private FieldDescriptor[] descriptions;

	// public GenericCommand(byte commandID, Field[] commandPayload) {
	// super(commandID);
	// this.commandPayload = commandPayload;
	// }
	//
	// public GenericCommand(byte commandID, FieldDescriptor[] descriptions) {
	// super(commandID);
	// }

	public GenericCommand(CommandDescription cd) {
		super(cd.getId(), cd.isClusterSpecific());
		if (cd.getManufacturerId() != -1) {
			// TODO Set the manufacturer code
		}
		// TODO set the Client-Server direction flag
		super.setAllowedResponseId(cd.getAllowedResponseIds());
		this.descriptions = cd.getFields();
		this.values = new Object[descriptions.length];
	}

	public FieldDescriptor getFieldDescription(int idx) {
		return descriptions[idx];
	}

	public int getFieldCount() {
		return values.length;
	}

	public GenericCommand setFieldValue(Object obj, FieldDescriptor fd) {
		// TODO Check value type
		return setFieldValue(obj, fd.getFieldIndex());
	}

	/**
	 * @param obj
	 * @param idx
	 * @return
	 * @deprecated {@link #setFieldValue(Object, FieldDescriptor)} should be
	 *             used because it avoid to misplace value for the fields
	 */
	public GenericCommand setFieldValue(Object obj, int idx) {
		// TODO Check value type
		if (checkValue(obj, descriptions[idx]) == false) {
			throw new IllegalArgumentException("Invalid value " + obj
					+ " for the ZigBee type "
					+ descriptions[idx].getZigBeeType());
		}
		values[idx] = obj;
		return this;
	}

	private boolean checkValue(Object value, FieldDescriptor fd) {
		// TODO Auto-generated method stub
		return true;
	}

	public Object getFieldValue(int idx) {
		return values[idx];
	}

	public byte[] getPayload() {

		if (payload == null) {
			ByteArrayOutputStreamSerializer serializer = new ByteArrayOutputStreamSerializer();
			for (int i = 0; i < descriptions.length; i++) {
				Dependency dep = descriptions[i].getDependency();
				if (dep == null
						|| (dep != null && dep.match(
								values[dep.getFieldIndex()], descriptions[dep
										.getFieldIndex()].getZigBeeType()))) {

					switch (descriptions[i].getFieldType()) {

					case SIMPLE_FIELD: {
						serializer.appendZigBeeType(values[i],
								descriptions[i].getZigBeeType());
					}
						break;

					case LIST: {
						ListFieldDescriptor lfd = (ListFieldDescriptor) descriptions[i];
						if (lfd.hasCounter()) {
							serializer.appendZigBeeType(values[i], lfd
									.getCounterDescriptor().getZigBeeType());
							i++;
							int len = ((Number) values[i]).intValue();
							if (((Number) values[i]).longValue() != (long) len) {
								new IllegalArgumentException(
										"We are not suppportting list type with more than 2^32-1 values");
							}
							for (int idx = 0; idx < len; idx++) {
								serializer
										.appendZigBeeType(values[i], lfd
												.getElementDescriptor()
												.getZigBeeType());
								i++;
							}
						} else {
							// while (en.hasMoreElements()) {
							// type type = (type) en.nextElement();
							//
							// }
						}
					}
						break;
					case PATTERN:
						break;
					default:
						break;
					}
				}
			}
			payload = serializer.getPayload();

		}
		return payload;
	}
}
