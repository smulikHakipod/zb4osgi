package it.cnr.isti.zigbee.samples.throughput.client.threads;

import it.cnr.isti.zigbee.samples.throughput.client.Activator;
import it.cnr.isti.zigbee.samples.throughput.client.data.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Emitter extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(Emitter.class);
	final int id;
	
	public Emitter(String name, int id){
		super(name+Integer.toString(id));
		this.id = id;
	}
	
	public void run(){
		final int s = id * Activator.configuration.getIterations()*Activator.configuration.getWorkers();
		final int e = s + Activator.configuration.getIterations()*Activator.configuration.getWorkers();
		for (int i = s; i < e; i++) {	
			final Token t;
			try {
				Thread.sleep(Activator.configuration.getPeriod());
			} catch (InterruptedException ex) {
			}
			synchronized (Activator.emitter2worker) {
				t = Activator.tokens[i];
				Activator.emitter2worker.add(t);
				Activator.emitter2worker.notifyAll();
			}
			logger.debug("Added task {} to the queue chosen with idx {}", t.id, i);
		}			
	}
	
}
