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
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import it.cnr.isti.thread.ThreadUtils;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.DuplicateMacPolicy;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_REQ;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-10-30 10:52:39
 *          +0100 (mer, 30 ott 2013) $)
 *
 */
public class DeviceBuilderThreadTest {

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
        int messageRetryCount = 10;
        expect(stub.getFirstFreeEndPoint()).andReturn(new Integer(2))
                .anyTimes();

        expect(stub.getDeviceInspectionPeriod()).andReturn(new Long(250))
                .anyTimes();

        expect(stub.getMessageRetryCount()).andReturn(messageRetryCount)
                .anyTimes();

        expect(stub.getMessageRetryDelay()).andReturn(new Integer(100))
                .anyTimes();

        expect(stub.getPanId()).andReturn(new Short((short) 13531)).anyTimes();

        expect(stub.getDiscoveryDuplicateMacPolicy())
                .andReturn(DuplicateMacPolicy.IGNORE).times(1)
                .andReturn(DuplicateMacPolicy.UPDATE).times(1)
                .andReturn(DuplicateMacPolicy.REGISTER).times(1);

        replay(stub);

        return stub;
    }

    @Test
    public void testDuplicateDeviceCreationIgnorePolicy() {
        SimpleDriver driver = createMock(SimpleDriver.class);
        expect(
                driver.sendZDOActiveEndPointRequest(isA(ZDO_ACTIVE_EP_REQ.class)))
                .andReturn(null).anyTimes();
        replay(driver);
        ImportingQueue queue = new ImportingQueue();
        queue.push(new ZToolAddress16(0x00, 0x01), new ZToolAddress64(
                "00 12 4B 00 00 03 15 AD"));
        DeviceBuilderThread builder = new DeviceBuilderThread(queue, driver);
        Thread thread = new Thread(builder, DeviceBuilderThread.class.getName());
        thread.start();
        ThreadUtils.waitNonPreemptive(2000);
        builder.end();
        queue.push(new ZToolAddress16(0x14, 0x3E), new ZToolAddress64(
                "00 12 4B 00 00 03 15 AD"));
        try {
            thread.join();
        } catch (InterruptedException e) {
        }

        assertEquals(0, builder.getPendingNodes());
        assertEquals(0, builder.getPendingDevices());

    }

    @Test
    public void testDuplicateDeviceCreationUpdatePolicy() {
        SimpleDriver driver = createMock(SimpleDriver.class);
        expect(
                driver.sendZDOActiveEndPointRequest(isA(ZDO_ACTIVE_EP_REQ.class)))
                .andReturn(null).anyTimes();
        replay(driver);
        ImportingQueue queue = new ImportingQueue();
        queue.push(new ZToolAddress16(0x00, 0x01), new ZToolAddress64(
                "00 12 4B 00 00 03 15 AD"));
        DeviceBuilderThread builder = new DeviceBuilderThread(queue, driver);
        Thread thread = new Thread(builder, DeviceBuilderThread.class.getName());
        thread.start();
        ThreadUtils.waitNonPreemptive(2000);
        builder.end();
        queue.push(new ZToolAddress16(0x14, 0x3E), new ZToolAddress64(
                "00 12 4B 00 00 03 15 AD"));
        try {
            thread.join();
        } catch (InterruptedException e) {
        }

        assertEquals(0, builder.getPendingNodes());
        assertEquals(0, builder.getPendingDevices());

    }

    @Test
    public void testDuplicateDeviceCreationRegisterPolicy() {
        SimpleDriver driver = createMock(SimpleDriver.class);
        expect(
                driver.sendZDOActiveEndPointRequest(isA(ZDO_ACTIVE_EP_REQ.class)))
                .andReturn(null).anyTimes();
        replay(driver);
        ImportingQueue queue = new ImportingQueue();
        queue.push(new ZToolAddress16(0x00, 0x01), new ZToolAddress64(
                "00 12 4B 00 00 03 15 AD"));
        DeviceBuilderThread builder = new DeviceBuilderThread(queue, driver);
        Thread thread = new Thread(builder, DeviceBuilderThread.class.getName());
        thread.start();
        ThreadUtils.waitNonPreemptive(2000);
        builder.end();
        System.out.println(cs.getDiscoveryDuplicateMacPolicy());
        queue.push(new ZToolAddress16(0x14, 0x3E), new ZToolAddress64(
                "00 12 4B 00 00 03 15 AD"));
        try {
            thread.join();
        } catch (InterruptedException e) {
        }

        assertEquals(0, builder.getPendingNodes());
        assertEquals(0, builder.getPendingDevices());

    }
}