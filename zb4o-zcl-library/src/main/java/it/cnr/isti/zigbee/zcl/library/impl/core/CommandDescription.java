/*
   Copyright 2014-2014 CNR-ISTI, http://isti.cnr.it
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

import it.cnr.isti.zigbee.zcl.library.impl.field.FieldDescriptor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * 
 */
public class CommandDescription {

	private ArrayList<FieldDescriptor> fields = new ArrayList<FieldDescriptor>();
	private String name;

	public CommandDescription addField(FieldDescriptor fd) {
		fields.add(fd);
		return this;
	}

	public FieldDescriptor[] getFields() {
		return fields.toArray(new FieldDescriptor[] {});
	}

	public CommandDescription addAllowedResponseId(byte id) {
		if (allowedResponseIds == null) {
			allowedResponseIds = new HashSet<Byte>();
		}
		allowedResponseIds.add(id);

		return this;
	}

	public GenericCommand createCommand() {
		return new GenericCommand(this);
	}

	private byte id;
	private int manufacturerId = -1;
	private boolean isClientServerDirection = true;
	private boolean isClusterSpecific = true;
	private Set<Byte> allowedResponseIds;

	public CommandDescription(byte id) {
		this.id = id;
	}

	public CommandDescription setName(String name) {
		this.name = name;
		return this;
	}

	public CommandDescription setId(byte id) {
		this.id = id;
		return this;
	}

	public CommandDescription setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
		return this;
	}

	public CommandDescription setClientServerDirection() {
		this.isClientServerDirection = true;
		return this;
	}

	public CommandDescription setServerClientDirection() {
		this.isClientServerDirection = false;
		return this;
	}

	public CommandDescription setClusterSpecific() {
		this.isClusterSpecific = true;
		return this;
	}

	public CommandDescription setClusterGeneral() {
		this.isClusterSpecific = false;
		return this;
	}

	public String getName() {
		return name;
	}

	public byte getId() {
		return id;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public boolean isClientServerDirection() {
		return isClientServerDirection;
	}

	public boolean isClusterSpecific() {
		return isClusterSpecific;
	}

	public byte[] getAllowedResponseIds() {
		if (allowedResponseIds == null) {
			return new byte[0];
		}

		byte[] ret = new byte[allowedResponseIds.size()];
		int idx = 0;
		for (Iterator<Byte> i = allowedResponseIds.iterator(); i.hasNext();) {
			Byte b = (Byte) i.next();
			ret[idx] = b;
			idx++;
		}
		return ret;
	}
}
