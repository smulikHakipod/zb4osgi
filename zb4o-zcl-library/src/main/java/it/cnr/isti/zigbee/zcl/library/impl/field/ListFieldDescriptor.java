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

public class ListFieldDescriptor implements ComplexFieldDescriptor {

	private int fieldIndex;
	private String name;
	private FieldType fieldtype;
	private Class<?> javaType;
	private boolean hasDependency = false;
	private Dependency dependency;
	private ZigBeeType zigbeeType;

	private SimpleFieldDescriptor elementDescriptor;
	private SimpleFieldDescriptor counterDescriptor;

	private ZigBeeType counterType;
	private boolean hasCounter=false;

	public SimpleFieldDescriptor getElementDescriptor() {
		return elementDescriptor;
	}

	public ListFieldDescriptor setElementDescriptor(
			SimpleFieldDescriptor elementDescriptor) {
		this.elementDescriptor = elementDescriptor;
		
		return this;
	}

	public SimpleFieldDescriptor getCounterDescriptor() {
		return counterDescriptor;
	}

	public ListFieldDescriptor setCounterDescriptor(
			SimpleFieldDescriptor counterDescriptor) {
		this.counterDescriptor = counterDescriptor;
		this.setCounterType(counterDescriptor.getZigBeeType());
		this.hasCounter = true;
		return this;
	}

	final public String getName() {
		return name;
	}

	public ListFieldDescriptor setName(String name) {
		this.name = name;
		return this;
	}

	final public int getFieldIndex() {
		return fieldIndex;
	}

	public ListFieldDescriptor setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
		return this;
	}

	public boolean hasDependency() {
		return hasDependency;
	}

	public ListFieldDescriptor setDependency(Dependency dep) {
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

	public ListFieldDescriptor setFieldType(FieldType field) {
		this.fieldtype = field;
		return this;
	}

	public Class<?> getJavaType() {
		return javaType;
	}

	public ListFieldDescriptor setJavaType(Class<?> javaType) {
		this.javaType = javaType;
		return this;
	}

	public ZigBeeType getCounterType() {
		return counterType;
	}

	public ListFieldDescriptor setCounterType(ZigBeeType counterType) {
		this.counterType = counterType;
		return this;

	}

	public boolean hasCounter() {
		return this.hasCounter;
	}

	public ListFieldDescriptor setZigbeeType(ZigBeeType zigbeeType) {
		this.zigbeeType = zigbeeType;
		return this;
	}

	public ZigBeeType getZigBeeType() {
		return zigbeeType;
	}

	public boolean isHasCounter() {
		return hasCounter;
	}

}
