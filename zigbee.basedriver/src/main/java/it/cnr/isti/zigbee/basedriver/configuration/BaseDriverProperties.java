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
package it.cnr.isti.zigbee.basedriver.configuration;
import java.util.EnumSet;


/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 */
public interface BaseDriverProperties {

    public enum DiscoveryMode {
        Announce(1),
        Addressing(2),
        LinkQuality(4);
        
        public static final EnumSet<DiscoveryMode> ALL = EnumSet.allOf(DiscoveryMode.class);
        
        public final int bits;
        
        private DiscoveryMode(int i){
            this.bits = i;           
        }
        
        public static int fromEnumSet(EnumSet<DiscoveryMode> set){
            int value = 0;
            for ( DiscoveryMode mode : set ) {
                value += mode.bits;
            }
            return value;
        }
        
        public static EnumSet<DiscoveryMode> toEnumSet(int mask){
            DiscoveryMode[] modes = DiscoveryMode.values();
            EnumSet<DiscoveryMode> value = EnumSet.noneOf(DiscoveryMode.class);   
            for ( int i = 0; i < modes.length; i++ ) {
                if ( ( modes[i].bits & mask ) > 0 ) {
                    value.add( modes[i] );
                }
            }
            return value;
        }
    }
        
    /**
     * The default value for the {@link #DISCOVERY_MODE_KEY} property, that is <b>all discovery enabled</b>
     */
    public final static int DISCOVERY_MODE = DiscoveryMode.fromEnumSet( DiscoveryMode.ALL );
    
    /**
     * Key to use to control which discovery technique should be used by the ZigBee Base Driver.<br>
     * For the bits associated to each discovery mode see {@link DiscoveryMode}
     */
    public final static String DISCOVERY_MODE_KEY = "it.cnr.isti.zigbee.driver.discovery.mode";
    
}
