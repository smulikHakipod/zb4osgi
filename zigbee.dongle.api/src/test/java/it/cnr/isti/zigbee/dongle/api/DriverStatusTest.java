package it.cnr.isti.zigbee.dongle.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi -
 *         ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.8.0
 *
 */
public class DriverStatusTest {

    @Test
    public void testDriverStatusEnum() {
        final String WARNING = "please be aware that adding or modifying states has side effects on implementation";

        String[] expectedStatus = {
                "CREATED", "HARDWARE_INITIALIZING", "HARDWARE_READY", "NETWORK_INITIALIZING", "NETWORK_READY", "CLOSED"
        };
        DriverStatus[] status = DriverStatus.values();
        for (int i = 0; i < status.length; i++) {
            DriverStatus match = DriverStatus.valueOf(expectedStatus[i]);
            assertEquals("Expected status name error, " + WARNING, match, status[i]);
            assertEquals("Expected status ordinal error, " + WARNING, i, match.ordinal());
        }
    }

}
