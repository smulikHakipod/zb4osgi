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

package it.cnr.isti.zigbee.zcl.library.impl.field;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:stefano.lenz@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * 
 */
public class SimpleFieldDescriptor implements FieldDescriptor {

	private int fieldIndex;
	private String name;
	private ZigBeeType zigbeeType;
	private FieldType fieldtype;
	private Class<?> javaType;
	private boolean hasDependency = false;
	private Dependency dependency;

	public SimpleFieldDescriptor() {
	}

	public String getName() {
		return name;
	}

	public SimpleFieldDescriptor setName(String name) {
		this.name = name;
		return this;
	}

	public int getFieldIndex() {
		return fieldIndex;
	}

	public SimpleFieldDescriptor setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
		return this;
	}

	public boolean hasDependency() {
		return hasDependency;
	}

	public SimpleFieldDescriptor setDependency(Dependency dep) {
		this.dependency = dep;
		this.hasDependency = true;
		return this;
	}

	public Dependency getDependency() {
		if (!hasDependency) {
			return new BitmaskDependency();
		} else
			return this.dependency;
	}

	public FieldType getFieldType() {
		return fieldtype;
	}

	public SimpleFieldDescriptor setFieldType(FieldType field) {
		this.fieldtype = field;
		return this;
	}

	public Class<?> getJavaType() {
		return javaType;
	}

	public SimpleFieldDescriptor setJavaType(Class<?> javaType) {
		this.javaType = javaType;
		return this;
	}

	public SimpleFieldDescriptor setZigBeeType(ZigBeeType zigbeeType) {
		this.zigbeeType = zigbeeType;
		return this;
	}

	public ZigBeeType getZigBeeType() {
		return zigbeeType;
	}

}
