/**
 * 
 */
package it.cnr.isti.zigbee.ha.cluster.glue.protocol_interfaces;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;


/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 */
public interface MatchProtocolAddressResponse extends Response {

    public long getIEEEAddress();
    
    public String getProtocolAddress();
    
}
