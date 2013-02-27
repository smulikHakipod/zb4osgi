package it.cnr.isti.zigbee.it.measuredvalue.reporting;

import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.RelativeHumidityMeasurement;
import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.TemperatureMeasurement;
import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.event.MeasuredValueEvent;
import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.event.MeasuredValueListener;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.HAProfile;
import it.cnr.isti.zigbee.persona.cluster.glue.measurement_sensing.BreakMeasurement;
import it.cnr.isti.zigbee.persona.cluster.glue.measurement_sensing.GasMeasurement;
import it.cnr.isti.zigbee.persona.cluster.glue.measurement_sensing.WeightMeasurement;
import it.cnr.isti.zigbee.persona.driver.core.PERSONAProfile;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 *         </a> - Copyright (c) 2008 - 2009
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class Activator implements BundleActivator, MeasuredValueListener {

	
	private static BundleContext context;
	
	private final static ArrayList<TemperatureMeasurement> temperatureSubscribed = 
		new ArrayList<TemperatureMeasurement>();
	
	private final static ArrayList<RelativeHumidityMeasurement> humiditySubscribed = 
		new ArrayList<RelativeHumidityMeasurement>();
	
	private final static ArrayList<GasMeasurement> gasSubscribed = 
		new ArrayList<GasMeasurement>();
	
	private final static ArrayList<BreakMeasurement> breakSubscribed = 
		new ArrayList<BreakMeasurement>();
	
	private final static ArrayList<WeightMeasurement> weightSubscribed = 
		new ArrayList<WeightMeasurement>();
	
	private void doSubscribe(){
		ServiceReference[] refs = null;
		try {
			refs = Activator.context.getAllServiceReferences(HADevice.class.getName(), null);
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		if ( refs == null ){
			return;
		}
		for (int i = 0; i < refs.length; i++) {
			final HADevice device = (HADevice) Activator.context.getService(refs[i]);
			addTemperature(device);
			addHumidity(device);
			addGas(device);
			addBreak(device);
			addWeight(device);
		}
	}
	
	private void addWeight(HADevice device) {
		try{
			final WeightMeasurement cluster = 
				(WeightMeasurement) device.getCluster(PERSONAProfile.WEIGHT_MEASUREMENT);
			if ( cluster == null ) return;
			if ( cluster.subscribe(this) ){
				weightSubscribed.add(cluster);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addBreak(HADevice device) {
		try{
			final BreakMeasurement cluster = 
				(BreakMeasurement) device.getCluster(PERSONAProfile.BREAK_MEASUREMENT);
			if ( cluster == null ) return;
			if ( cluster.subscribe(this) ){
				breakSubscribed.add(cluster);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addGas(HADevice device) {
		try{
			final GasMeasurement cluster = 
				(GasMeasurement) device.getCluster(PERSONAProfile.GAS_MEASUREMENT);
			if ( cluster == null ) return;
			if ( cluster.subscribe(this) ){
				gasSubscribed.add(cluster);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addHumidity(HADevice device) {
		try{
			final RelativeHumidityMeasurement cluster = 
				(RelativeHumidityMeasurement) device.getCluster(HAProfile.RELATIVE_HUMIDITY_MEASUREMENT);
			if ( cluster == null ) return;
			if ( cluster.subscribe(this) ){
				humiditySubscribed.add(cluster);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void addTemperature(HADevice device) {
		try{
			final TemperatureMeasurement cluster = 
				(TemperatureMeasurement) device.getCluster(HAProfile.TEMPERATURE_MEASUREMENT);
			if ( cluster == null ) return;
			if ( cluster.subscribe(this) ){
				temperatureSubscribed.add(cluster);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void doUnSubscribe(){
		for (TemperatureMeasurement cluster : temperatureSubscribed) {
			cluster.unsubscribe(this);
		}		
		for( RelativeHumidityMeasurement cluster : humiditySubscribed) {
			cluster.unsubscribe(this);
		}
		for( BreakMeasurement cluster : breakSubscribed) {
			cluster.unsubscribe(this);
		}
		for( GasMeasurement cluster : gasSubscribed) {
			cluster.unsubscribe(this);
		}
		for( WeightMeasurement cluster : weightSubscribed) {
			cluster.unsubscribe(this);
		}
	}

	
	public void start(BundleContext bc) throws Exception {
		context = bc;
		doSubscribe();
	}

	public void stop(BundleContext bc) throws Exception {
		doUnSubscribe();
		context = null;
	}
	
	public void changedMeasuredValue(MeasuredValueEvent event) {
		System.out.println("Receieved event "+event.getClass()+" new value = "+event.getEvent());		
	}

}
