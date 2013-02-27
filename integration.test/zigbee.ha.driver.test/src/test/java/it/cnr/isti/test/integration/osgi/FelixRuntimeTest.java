package it.cnr.isti.test.integration.osgi;
import org.ops4j.pax.drone.api.DroneConnector;
import org.ops4j.pax.drone.connector.paxrunner.PaxRunnerBundleProvision;
import org.ops4j.pax.drone.connector.paxrunner.Platforms;
import org.ops4j.pax.drone.spi.junit.DroneTestCase;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

import static org.ops4j.pax.drone.connector.paxrunner.GenericConnector.*;


public class FelixRuntimeTest extends DroneTestCase {
	
	private final static String[] bundles = new String[]{
		"mvn:org.ops4j.pax.logging/pax-logging-api",
		"mvn:org.ops4j.pax.logging/pax-logging-service",
		"mvn:org.aal-persona.sail/org.aal-persona.zigbee.basedriver.api/0.2.0-SNAPSHOT",		
		"mvn:org.aal-persona.sail/org.aal-persona.zigbee.driver.zcl/0.1.0-SNAPSHOT",		
		"mvn:org.aal-persona.sail/org.aal-persona.zigbee.driver.ha/0.1.0-SNAPSHOT"	
	};
	
	@Override
	protected DroneConnector configure() {
		final PaxRunnerBundleProvision provisions = createBundleProvision();
		for (int i = 0; i < bundles.length; i++) {
			provisions.addBundle(bundles[i]);
		}		
		
		return create(createRunnerContext(),provisions).setPlatform(Platforms.FELIX);		
	}
	
	public void testBundles(){        
		assertNotNull( bundleContext );
		        
        final Bundle[] bundles = bundleContext.getBundles();
        for (int i = 0; i < bundles.length; i++) {
        	assertEquals(Bundle.ACTIVE, bundles[i].getState());
		}
        
	}
}
