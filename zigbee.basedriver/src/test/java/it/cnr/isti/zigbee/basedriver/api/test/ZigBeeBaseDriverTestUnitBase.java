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
package it.cnr.isti.zigbee.basedriver.api.test;

import static org.easymock.EasyMock.*;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Properties;

import org.easymock.*;
import org.junit.*;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;

/**
*
* @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
* @version $LastChangedRevision$ ($LastChangedDate$ )
*
*/
public class ZigBeeBaseDriverTestUnitBase {


    private ConfigurationService cs = null;
    private BundleContext bc = null;

    private BundleContext stub;
    private Properties contextProperties = (Properties) System.getProperties().clone();

    public BundleContext createBundleContextStub() {
        stub = createMock(BundleContext.class);

        try {
            expect(stub.getServiceReferences(anyObject(String.class),anyObject(String.class)))
            	.andReturn(null).anyTimes();
            expect(stub.getProperty(anyObject(String.class))).andAnswer(new IAnswer<String>() {

				public String answer() throws Throwable {
					return contextProperties.getProperty((String) getCurrentArguments()[0]);
				}
				
			}).anyTimes();
        } catch (InvalidSyntaxException ex) {
        }
        replay(stub);

        return stub;
    }	
	
	protected ZigBeeBaseDriverTestUnitBase(){
        bc = createBundleContextStub();
		cs = new ConfigurationService();
        Activator.setStubObjectes(cs, bc);
	}
	
	protected void setBundleContextProperty(String name, String value) {
		this.contextProperties.setProperty(name, value);
	}
	
	protected void setBundleContextProperties(Properties update) {
		Enumeration<Object> keys = update.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			contextProperties.setProperty(key, update.getProperty(key));
		}
	}

	protected Properties getBundleContextProperties() {
		return (Properties) contextProperties.clone();
	}
	
}
