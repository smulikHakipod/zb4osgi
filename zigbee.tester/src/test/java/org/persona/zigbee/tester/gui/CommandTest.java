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

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import it.cnr.isti.zigbee.ha.cluster.impl.GroupsImpl;

import org.junit.Test;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 */
public class CommandTest {

    @Test
    public void testInvoke() {
        Exception ex = null;
        try {
            //TODO We should use Mocking for better error handling rather then using the exception type
            Command command = new Command(
                    new GroupsImpl(null),
                    GroupsImpl.class.getMethod("addGroupIfIdentifying", int.class, String.class)
            );
            command.invoke(new String[]{"100","test"});
        } catch (Exception e) {
            assertTrue("Expected exception InvocationTargetException", e.getClass() == InvocationTargetException.class);
            ex = (Exception) ((InvocationTargetException) e).getTargetException();
        }
        assertNotNull(ex);
        assertTrue(ex.getClass() == NullPointerException.class);
        assertNull("Expecting empty message for standard JRE NPE", ex.getMessage());
    }

    @Test
    public void testInvokeWithArray() {
        Exception ex = null;
        try {
            //TODO We should use Mocking for better error handling rather then using the exception type
            Command command = new Command(
                    new GroupsImpl(null),
                    GroupsImpl.class.getMethod("getGroupMembership", int[].class)
            );
            command.invoke(new String[]{"100,200;300, 400; 500 "});
        } catch (Exception e) {
            assertTrue("Expected exception InvocationTargetException", e.getClass() == InvocationTargetException.class);
            ex = (Exception) ((InvocationTargetException) e).getTargetException();
        }
        assertNotNull(ex);
        assertTrue(ex.getClass() == NullPointerException.class);
        assertNull("Expecting empty message for standard JRE NPE", ex.getMessage());
    }

}
