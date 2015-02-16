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

import java.util.ArrayList;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:stefano.lenz@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * 
 */

public class PatternFieldDescriptor implements ComplexFieldDescriptor {

	private int fieldIndex;
	private String name;
	private FieldType fieldtype;
	private Class<?> javaType;
	private boolean hasDependency = false;
	private Dependency dependency;
	private ZigBeeType zigbeeType;

	private ArrayList<SimpleFieldDescriptor> patternDescriptor;

	private ZigBeeType counterType;
	private boolean hasCounter = false;

	public ArrayList<SimpleFieldDescriptor> getElementDescriptor() {
		return patternDescriptor;
	}

	public PatternFieldDescriptor setElementDescriptor(
			ArrayList<SimpleFieldDescriptor> elementDescriptor) {
		this.patternDescriptor = elementDescriptor;

		return this;
	}

	final public String getName() {
		return name;
	}

	public PatternFieldDescriptor setName(String name) {
		this.name = name;
		return this;
	}

	final public int getFieldIndex() {
		return fieldIndex;
	}

	public PatternFieldDescriptor setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
		return this;
	}

	public boolean hasDependency() {
		return hasDependency;
	}

	public PatternFieldDescriptor setDependency(Dependency dep) {
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

	public PatternFieldDescriptor setFieldType(FieldType field) {
		this.fieldtype = field;
		return this;
	}

	public Class<?> getJavaType() {
		return javaType;
	}

	public PatternFieldDescriptor setJavaType(Class<?> javaType) {
		this.javaType = javaType;
		return this;
	}

	public ZigBeeType getCounterType() {
		return counterType;
	}

	public PatternFieldDescriptor setCounterType(ZigBeeType counterType) {
		this.counterType = counterType;
		return this;

	}

	public boolean hasCounter() {
		return this.hasCounter;
	}

	public PatternFieldDescriptor setZigbeeType(ZigBeeType zigbeeType) {
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
