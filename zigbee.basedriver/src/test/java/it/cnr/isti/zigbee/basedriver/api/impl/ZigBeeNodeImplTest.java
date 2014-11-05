package it.cnr.isti.zigbee.basedriver.api.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.DuplicateMacPolicy;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

import com.itaca.ztool.api.ZToolAddress64;

public class ZigBeeNodeImplTest {

    private ConfigurationService cs = null;
    private BundleContext bc = null;

    private BundleContext stub;

    @Before
    public void createActivatorStub() {
        cs = createConfigurationServiceStub();
        bc = createBundleContextStub();
        Activator.setStubObjectes(cs, bc);
    }

    public BundleContext createBundleContextStub() {
        stub = createMock(BundleContext.class);
        return stub;
    }

    public ConfigurationService createConfigurationServiceStub() {
        ConfigurationService stub = createMock(ConfigurationService.class);
        expect(stub.getPanId()).andReturn(new Short((short) 13531)).anyTimes();

        replay(stub);

        return stub;
    }
    
    /**
     * This test verify that any negative value assigned as network address is translated 
     * to complement-to-2 positive value, so that we avoid signing issues due to implicit
     * casts of Java. For example: -25 is translated to 65511
     * 
     * @see redmine issue #271
     */
	@Test
	public void testZigBeeNodeImplIntStringShort() {
		ZigBeeNodeImpl node =  null;
		final int NEGATIVE_NWK_ADDR = -25;
		final int NORMALIZED_NWK_ADDR = NEGATIVE_NWK_ADDR & 0xFFFF;
		final int EXPECTED_NWK_ADDR = 65511;
		assertEquals("Normalized value matches", NORMALIZED_NWK_ADDR, EXPECTED_NWK_ADDR);
		node = new ZigBeeNodeImpl(NEGATIVE_NWK_ADDR, "01:02:03:04:05:06", (short) 40);
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
		node = new ZigBeeNodeImpl(NEGATIVE_NWK_ADDR, "01:02:03:04:05:06");
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
		node = new ZigBeeNodeImpl(NEGATIVE_NWK_ADDR, new ZToolAddress64(0x010203040506L) );
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
		node.setNetworkAddress(NEGATIVE_NWK_ADDR);
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
	}

}
