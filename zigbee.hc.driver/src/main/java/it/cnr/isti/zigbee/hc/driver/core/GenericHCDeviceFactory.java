package it.cnr.isti.zigbee.hc.driver.core;
/*
   Copyright 2013-2013 CNR-ISTI, http://isti.cnr.it
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



import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

import java.lang.reflect.Constructor;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Generic class that simplify the creation of factory, and avoids the creation of a class for<br>
 * each factory that we want to register
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @since 0.1.0
 * @version $LastChangedRevision$ ($LastChangedDate$)
 */
public class GenericHCDeviceFactory extends HCDeviceFactoryBase {

    static final Logger logger = LoggerFactory.getLogger(GenericHCDeviceFactory.class);

    final protected String deviceId;
    final protected Class<?> inter, impl;

    protected String[] classes;


    /**
     * Build an {@link HCDeviceFactory} that refine {@link ZigBeeDevice} by means of <code>cImplementation</code>,<br>
     * into a <code>cInterface</code> service. This factory build the instance of the new service by invoking<br>
     * the constructor  <code>cImplementation(BundleContext, ZigBeeDevice)</code>.<br>
     * By default the {@link #getRefinedInterfaces()} is built to return the values:<br>
     * <pre>
     * cInterface.getName()
     * HADevice.class.getName()
     * </pre>
     *
     *
     * @param ctx {@link BundleContext} to use for registering the {@link HCDeviceFactory} service
     * @param cInterface {@link Class} representing the refined service that this factory will install
     * @param cImplementation {@link Class} representing the implementation of the refinement service that will be created by the factory
     *
     * @throws ZigBeeHAException
     */
    public GenericHCDeviceFactory(BundleContext ctx, Class<?> cInterface, Class<?> cImplementation) throws ZigBeeHCException {
        super(ctx, cInterface);

        this.inter = cInterface;
        this.impl = cImplementation;
        classes = new String[]{ cInterface.getName(), HCDevice.class.getName() };

        try {
            deviceId = cInterface.getField("DEVICE_ID").get(null).toString();
        } catch (Exception e) {
            logger.error(
                "Unable to retrive the implemented the DeviceId refined by this driver"
                + " by means of the reflection, the class {} does not provide the static "
                + "field DEVICE_ID.\n"
                + "Please modify the source code of the class by adding such static field or"
                + "implement a proper {} class",
                cInterface.getName(), HCDeviceFactory.class.getName()
            );
            logger.debug("Stack exception of the GenericHCDeviceFactory() error", e);

            throw new ZigBeeHCException("Unable to retrieve DEVICE_ID by means of reflection", e);
        }
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    public GenericHCDeviceFactory setRefinedInterfaces(String[] classNames) {
        classes = classNames;
        return this;
    }

    @Override
    public String[] getRefinedInterfaces() {
        return classes;
    }

    @Override
    public HCDeviceBase getInstance(ZigBeeDevice zbd) throws ZigBeeHCException {
        try {
            Constructor<?> builder = impl.getConstructor(BundleContext.class, ZigBeeDevice.class);
            HCDeviceBase device = (HCDeviceBase) builder.newInstance(ctx, zbd);
            return device;
        } catch (Exception e) {
            logger.error("Unable to create an instance of the refined device due to:", e);
            return null;
        }
    }

}
