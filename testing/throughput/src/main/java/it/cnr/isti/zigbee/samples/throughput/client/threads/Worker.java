package it.cnr.isti.zigbee.samples.throughput.client.threads;

import it.cnr.isti.zigbee.ha.cluster.glue.general.Identify;
import it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff;
import it.cnr.isti.zigbee.ha.device.api.lighting.OnOffLight;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.samples.throughput.client.Activator;
import it.cnr.isti.zigbee.samples.throughput.client.data.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Worker extends Thread {

	
	private static final Logger logger = LoggerFactory.getLogger(Worker.class);
	
	boolean on = true;
	final private OnOff clusterOnOff;
	final private Identify clusterIdentify;
	
	public Worker(String name, HADevice device){
		super(name);
		if( Activator.configuration.isUseLight() ) {
			clusterOnOff = ((OnOffLight) device).getOnOff();
			clusterIdentify = null;
		}else{
			clusterIdentify = device.getIdentify();
			clusterOnOff = null;
		}
	}
	
	public void run(){
		final int tasks = Activator.configuration.getIterations() * Activator.configuration.getEmiters();
		for (int i = 0; i < tasks; i++) {	
			Token t = null;
			synchronized (Activator.emitter2worker) {
				while(Activator.emitter2worker.size()<=0){
					try {
						Activator.emitter2worker.wait();
					} catch (InterruptedException e) {
					}
				}
				t = Activator.emitter2worker.pop();
			}
			
			logger.debug("Working on task {} out of {}", t.id, tasks);
			
			t.t1 = System.currentTimeMillis();
			try{
				if ( clusterOnOff != null ){
					if(on) {
						clusterOnOff.off();
					}else{
						clusterOnOff.on();
					}
					on=!on;
				} else {
					if(on) {
						clusterIdentify.identify(60);
					}else{
						clusterIdentify.identify(0);
					}
					on=!on;
				}
			}catch(ZigBeeHAException e){
					logger.info("Round {}: ZigBeeHA Exception: {}", t.id, e);
			}	
			t.t2 = System.currentTimeMillis();

			logger.debug("Finished to work on task {}", t.id);
			
			synchronized (Activator.worker2collector) {
				Activator.worker2collector.add(t);
				Activator.worker2collector.notifyAll();
			}
		}			
	}
	
}
