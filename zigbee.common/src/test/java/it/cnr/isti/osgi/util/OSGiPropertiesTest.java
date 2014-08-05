package it.cnr.isti.osgi.util;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.*;
import org.osgi.framework.BundleContext;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.6.0
 */
public class OSGiPropertiesTest {

    private final String[] properties = new String[]{ NetworkMode.COORDINATOR.toString(), "router", "RouTer", "pippo" };
    private final NetworkMode[] values = new NetworkMode[]{ NetworkMode.COORDINATOR, NetworkMode.ROUTER, NetworkMode.ROUTER, NetworkMode.END_DEVICE };

    private BundleContext stub;

    public BundleContext createBundleContextStub() {
        stub = createMock(BundleContext.class);


        for (int i = 0; i < properties.length; i++) {
            expect(stub.getProperty((String) anyObject())).andReturn(properties[i]).once();
        }
        replay(stub);

        return stub;
    }

    @Test
    public void testGetEnum() {
         BundleContext bc = createBundleContextStub();
         for (int i = 0; i < properties.length; i++) {
             assertEquals(values[i], OSGiProperties.getEnum(bc, "net", NetworkMode.END_DEVICE));
        }
    }

}
