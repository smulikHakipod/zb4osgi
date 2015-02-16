/*
   Copyright 2012-2013 CNR-ISTI, http://isti.cnr.it
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
package org.persona.zigbee.tester.gui;

import static org.junit.Assert.assertTrue;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.impl.AlarmsImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.GroupsImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IdentifyImpl;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public class HADeviceTreeNodeTest {


    private void testSingleCluster(Cluster c, String[] methods){
        final HADeviceTreeNode node = new HADeviceTreeNode( null,  c);
        Arrays.sort(methods);
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(methods));
        int n = node.getChildCount();
        int cmd = 0;
        for (int j = 0; j < n; j++) {
            HADeviceTreeNode child = (HADeviceTreeNode) node.getChildAt(j);
            if ( child.category == HADeviceTreeNode.ZCL_COMMAND ) {
                cmd++;
                assertTrue(
                        "Command "+child.toString()+" is not part of the expected command "+Arrays.toString(methods),
                        Arrays.binarySearch(methods, child.toString()) >= 0
                );
                list.remove(child.toString());
            }
        }
        assertTrue("The following methods were expected " + list, list.isEmpty() );
        //assertEquals("Expected "+methods.length+" but found only "+cmd+" command for the cluster "+c.getName(), methods.length, cmd);

    }

    @Test
    public void testHADeviceTreeNodeHADeviceCluster() {
        testSingleCluster(
                new GroupsImpl(null),
                new String[]{ "addGroup", "addGroupIfIdentifying", "getGroupMembership", "removeAllGroup", "removeGroup", "viewGroup" }
        );
        testSingleCluster(
                new IdentifyImpl(null),
                new String[]{ "identify", "IdentifyQuery" }
        );
        testSingleCluster(
                new AlarmsImpl(null),
                new String[]{ "getAlarm", "resetAlarm", "resetAlarmLog", "resetAllAlarms" }
        );
    }
}
