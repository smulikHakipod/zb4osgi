package it.cnr.isti.zigbee.samples.throughput.client.threads;

import it.cnr.isti.zigbee.samples.throughput.client.Activator;
import it.cnr.isti.zigbee.samples.throughput.client.data.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Collector extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(Collector.class);

	public Collector(String name){
		super(name);
	}
	
	public void run(){
		for (int i = 0; i < Activator.configuration.getIterations(); i++) {	
			Token t = null;
			synchronized (Activator.worker2collector) {
				while(Activator.worker2collector.size()<=0){
					try {
						Activator.worker2collector.wait();
					} catch (InterruptedException e) {
					}
				}
				t = Activator.worker2collector.pop();
				logger.debug("Completed task {}", t.id);
			}			
		}			
	}	
}
