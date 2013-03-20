/**
 * 
 */
package it.cnr.isti.zigbee.ha.cluster.glue.protocol_interfaces;


/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 */
public interface AdvertiseProtocolAddressListener {

    public void protocolAddressChanged(String protocolAddress);
}
