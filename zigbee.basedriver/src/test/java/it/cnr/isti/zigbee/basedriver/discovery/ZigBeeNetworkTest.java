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

package it.cnr.isti.zigbee.basedriver.discovery;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.api.impl.ZigBeeNodeImpl;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.DuplicateMacPolicy;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 *
 */
public class ZigBeeNetworkTest {

    private class ZigBeeNetworkSample {
        private ZigBeeNodeImpl[] nodes;
        private ZigBeeDevice[] devices;

    }

    final private ZigBeeNetworkSample mock_d11_n10 = new ZigBeeNetworkSample();
    final private ZigBeeNetworkSample fake_d11_n10 = new ZigBeeNetworkSample();


    private static final Logger logger = LoggerFactory
            .getLogger(DeviceBuilderThreadTest.class);

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

        try {
            expect(
                    stub.getServiceReferences((String) anyObject(),
                            (String) anyObject())).andReturn(null).anyTimes();
        } catch (InvalidSyntaxException ex) {
        }
        replay(stub);

        return stub;
    }

    public ConfigurationService createConfigurationServiceStub() {
        ConfigurationService stub = createMock(ConfigurationService.class);

        expect(stub.getDiscoveryDuplicateMacPolicy()).andReturn(DuplicateMacPolicy.IGNORE).anyTimes();

        replay(stub);

        return stub;
    }



    public void setUp_MockNetwork11Devices_10Nodes() {
        String[] ieees = new String[] { "00:12:4B:00:00:03:0B:AC",
                "00:12:4B:00:00:03:0B:AE", "00:12:4B:00:00:03:0D:F8",
                "00:12:4B:00:00:03:0E:1B", "00:12:4B:00:00:03:0F:6E",
                "00:12:4B:00:00:03:0F:9D", "00:12:4B:00:00:03:15:AC",
                "00:12:4B:00:00:03:15:AD", "00:12:4B:00:00:03:16:69",
                "00:12:4B:00:01:25:6B:FA" };

        ZigBeeNodeImpl[] nodes = new ZigBeeNodeImpl[ieees.length];
        boolean[] inserted = new boolean[ieees.length];
        for (int i = 0; i < nodes.length; i++) {
            final ZigBeeNodeImpl node = createMock(ZigBeeNodeImpl.class);
            expect(node.getIEEEAddress()).andReturn(ieees[i]).anyTimes();

            replay(node);
            nodes[i] = node;
            inserted[i] = false;
        }

        mock_d11_n10.nodes = nodes;
    }

    public void setUp_FakeNetwork11Devices_10Nodes() {
        String[] ieees = new String[] { "00:12:4B:00:00:03:0B:AC",
                "00:12:4B:00:00:03:0B:AE", "00:12:4B:00:00:03:0D:F8",
                "00:12:4B:00:00:03:0E:1B", "00:12:4B:00:00:03:0F:6E",
                "00:12:4B:00:00:03:0F:9D", "00:12:4B:00:00:03:15:AC",
                "00:12:4B:00:00:03:15:AD", "00:12:4B:00:00:03:16:69",
                "00:12:4B:00:01:25:6B:FA" };

        ZigBeeNodeImpl[] nodes = new ZigBeeNodeImpl[ieees.length];
        boolean[] inserted = new boolean[ieees.length];
        for (int i = 0; i < nodes.length; i++) {
            final ZigBeeNodeImpl node = new ZigBeeNodeImpl(0, ieees[i],
                    (short) 0);
            nodes[i] = node;
            inserted[i] = false;
        }

        fake_d11_n10.nodes = nodes;
    }

    public void setUp_MockDriverForNetwork11Devices_10Nodes() {

    }




    /*obsolete, they must reflect change in node discovery architecture.
     *
     *
     *
     * 	@Test
     * public void testDuplicatedDevices() {
        Object[][] devices = new Object[][] {
                new Object[] { 0x0000, "00:12:4B:00:01:25:6B:FA", true },
                new Object[] { 0x0001, "00:12:4B:00:00:03:0F:6E", true },
                new Object[] { 0x0001, "00:12:4B:00:00:03:15:AD", true },
                new Object[] { 0x0002, "00:12:4B:00:00:03:15:AC", true },
                new Object[] { 0x0002, "00:12:4B:00:00:03:16:69", true },
                new Object[] { 0x143E, "00:12:4B:00:00:03:0D:F8", true },
                new Object[] { 0x143E, "00:12:4B:00:00:03:15:AD", false },
                new Object[] { 0x143F, "00:12:4B:00:00:03:0E:1B", true },
                new Object[] { 0x143F, "00:12:4B:00:00:03:0F:9D", true },
                new Object[] { 0x179C, "00:12:4B:00:00:03:0F:9D", false },
                new Object[] { 0x179C, "00:12:4B:00:00:03:15:AC", false },
                new Object[] { 0x1AF9, "00:12:4B:00:00:03:0F:6E", false },
                new Object[] { 0x1AF9, "00:12:4B:00:00:03:16:69", false },
                new Object[] { 0x287B, "00:12:4B:00:00:03:0B:AC", true },
                new Object[] { 0x287B, "00:12:4B:00:00:03:0E:1B", false },
                new Object[] { 0x3CB8, "00:12:4B:00:00:03:0B:AC", false },
                new Object[] { 0x50F5, "00:12:4B:00:00:03:0B:AE", true },
                new Object[] { 0x50F6, "00:12:4B:00:00:03:0B:AE", false },
                new Object[] { 0x50F6, "00:12:4B:00:00:03:0D:F8", false } };

        ZigBeeNetwork network = new ZigBeeNetwork();
        ZigBeeNodeImpl[] nodes = new ZigBeeNodeImpl[devices.length];
        boolean[] inserted = new boolean[devices.length];
        for (int i = 0; i < devices.length; i++) {
            final ZigBeeNodeImpl node = new ZigBeeNodeImpl(
                    (Integer) devices[i][0], (String) devices[i][1], (short) 0);
            network.addNode(node);

            final ZigBeeDevice device = createMock(ZigBeeDevice.class);
            expect(device.getPhysicalNode()).andReturn(node).anyTimes();
            expect(device.getId()).andReturn((short) i).anyTimes();
            expect(device.getProfileId()).andReturn(0x104).anyTimes();

            replay(device);

            System.out.println();
            assertEquals("Inserting device " + i + "-th on the network",
                    devices[i][2], network.addDevice(device));

        }
    }

    *//**
     * This test verify that is impossible to add twice a node with the same
     * IEEEAddress. It partially cover issue: <a
     * href="http://zb4osgi.aaloa.org/redmine/issues/50"
     * title="Duplicated devices registered">#50</a>
     *//*
    @Test
    public void testAvoidDuplicatedNodeMock() {

        ZigBeeNetwork network = new ZigBeeNetwork();
        ZigBeeNodeImpl[] nodes = mock_d11_n10.nodes;

        boolean[] inserted = new boolean[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            inserted[i] = false;
        }

        int dup;
        for (int i = 0; i < nodes.length; i++) {
            assertEquals(
                    "Inserimento di dato sequenziale atteso true se non presente false altrimenti",
                    !inserted[i], network.addNode(nodes[i]));
            inserted[i] = true;

            dup = (int) ((Math.random() * 1000.0d) % (nodes.length));
            assertEquals(
                    "Inserimento di dato casuale atteso true se non presente false altrimenti",
                    !inserted[dup], network.addNode(nodes[dup]));
            inserted[dup] = true;

            dup = (int) ((Math.random() * 1000.0d) % (nodes.length));
            assertEquals(
                    "Inserimento di dato casuale atteso true se non presente false altrimenti",
                    !inserted[dup], network.addNode(nodes[dup]));
            inserted[dup] = true;
        }
    }

    *//**
     * This test verify that is impossible to add twice a node with the same
     * IEEEAddress. It partially cover issue: <a
     * href="http://zb4osgi.aaloa.org/redmine/issues/50"
     * title="Duplicated devices registered">#50</a>
     *//*
    @Test
    public void testAvoidDuplicatedNodeFake() {

        ZigBeeNetwork network = new ZigBeeNetwork();
        ZigBeeNodeImpl[] nodes = fake_d11_n10.nodes;

        boolean[] inserted = new boolean[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            inserted[i] = false;
        }

        int dup;
        for (int i = 0; i < nodes.length; i++) {
            assertEquals(
                    "Inserimento di dato sequenziale atteso true se non presente false altrimenti",
                    !inserted[i], network.addNode(nodes[i]));
            inserted[i] = true;

            dup = (int) ((Math.random() * 1000.0d) % (nodes.length));
            assertEquals(
                    "Inserimento di dato casuale atteso true se non presente false altrimenti",
                    !inserted[dup], network.addNode(nodes[dup]));
            inserted[dup] = true;

            dup = (int) ((Math.random() * 1000.0d) % (nodes.length));
            assertEquals(
                    "Inserimento di dato casuale atteso true se non presente false altrimenti",
                    !inserted[dup], network.addNode(nodes[dup]));
            inserted[dup] = true;
        }
    }*/

    @Test
    public void testAddDevice() {
        ZigBeeNetwork network = new ZigBeeNetwork();
        ZigBeeNodeImpl nodeAlpha = createMock(ZigBeeNodeImpl.class);
        expect(nodeAlpha.getIEEEAddress()).andReturn("01:02:03:04:05:06:07:08")
                .anyTimes();
        expect(nodeAlpha.getNetworkAddress()).andReturn(0x0001).anyTimes();

        ZigBeeDevice deviceAlpha = createMock(ZigBeeDevice.class);
        expect(deviceAlpha.getPhysicalNode()).andReturn(nodeAlpha).anyTimes();
        expect(deviceAlpha.getId()).andReturn((short) 0x20).anyTimes();
        expect(deviceAlpha.getProfileId()).andReturn(0x104).anyTimes();

        ZigBeeDevice deviceBeta = createMock(ZigBeeDevice.class);
        expect(deviceBeta.getPhysicalNode()).andReturn(nodeAlpha).anyTimes();
        expect(deviceBeta.getId()).andReturn((short) 0x20).anyTimes();
        expect(deviceBeta.getProfileId()).andReturn(0x104).anyTimes();

        replay(nodeAlpha);
        replay(deviceAlpha);
        replay(deviceBeta);
        assertTrue(network.addNode(nodeAlpha));
        assertTrue(network.addDevice(deviceAlpha));
        assertFalse(network.addDevice(deviceBeta));
    }

    @Test
    public void testContainsString() {
        ZigBeeNetwork network = new ZigBeeNetwork();
        ZigBeeNodeImpl nodeAlpha = createMock(ZigBeeNodeImpl.class);
        expect(nodeAlpha.getIEEEAddress()).andReturn("01:02:03:04:05:06:07:08");
        replay(nodeAlpha);
        assertTrue(network.addNode(nodeAlpha));
        assertEquals(nodeAlpha, network.containsNode("01:02:03:04:05:06:07:08"));

        final String beta = "00:01:02:03:04:05:06:07";
        ZigBeeNodeImpl nodeBeta = createMock(ZigBeeNodeImpl.class);
        expect(nodeBeta.getIEEEAddress()).andReturn(beta);
        replay(nodeBeta);
        assertTrue(network.addNode(nodeBeta));
        assertEquals(nodeBeta, network.containsNode(beta));
    }

}