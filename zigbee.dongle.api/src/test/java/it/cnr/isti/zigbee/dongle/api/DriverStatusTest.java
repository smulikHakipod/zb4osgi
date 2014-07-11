package it.cnr.isti.zigbee.dongle.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class DriverStatusTest {

    @Test
    public void testDriverStatusEnum() {
        String[] expectedStatus = {"CREATED", "HARDWARE_INITIALIZING", "HARDWARE_READY", "NETWORK_INITIALIZING", "NETWORK_READY", "CLOSED"};
        DriverStatus[] status = DriverStatus.values();
        for (int i = 0; i < status.length; i++) {
            DriverStatus match = DriverStatus.valueOf(expectedStatus[i]);
            assertEquals("Expected status name ", match, status[i]);
            assertEquals("Expected status ordinal ", i, match.ordinal());
        }
    }

}
