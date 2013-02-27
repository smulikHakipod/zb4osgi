package it.cnr.isti.zigbee.samples.throughput.client.threads;

import java.util.ArrayList;

import it.cnr.isti.zigbee.ha.device.api.lighting.OnOffLight;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.samples.throughput.client.Activator;
import it.cnr.isti.zigbee.samples.throughput.client.data.Token;
import it.cnr.isti.zigbee.samples.throughput.client.service.Configurator;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Orchestrator extends Thread {
	
	private static final Logger logger = LoggerFactory.getLogger(Orchestrator.class);
	private static final Logger dataLogger = LoggerFactory.getLogger("rawdata."+Orchestrator.class);

	private Thread[] testers;
	private ServiceReference[] services;
	
	private Configurator configuration;
	
	public Orchestrator(){
		setName("Orchestrator");
		configuration = Activator.configuration;
		Activator.worker2collector.clear();
		Activator.emitter2worker.clear();
	}
	
	private boolean doInitSharedData(){
		try {
			if ( configuration.isUseLight() ) {
				services = Activator.context.getAllServiceReferences(OnOffLight.class.getName(), null);
			} else {
				services = Activator.context.getAllServiceReferences(HADevice.class.getName(), null);
			}
		} catch (InvalidSyntaxException e) {
			logger.error("Unable to look for light service",e);
		}
		if ( services == null 
		|| configuration.isMultiDevice() == true && services.length < configuration.getWorkers() 
		|| configuration.isMultiDevice() == false && services.length < 1) {
			logger.warn("Not enough ZigBeeDevice to run the test in multiDevice mode");
			return false;
		}
					
		Activator.tokens = new Token[configuration.getIterations()*configuration.getEmiters()*configuration.getWorkers()];
		for (int i = 0; i < Activator.tokens.length; i++) {
			Activator.tokens[i] = new Token(i);
		}		
		
		return true;
	}
	
	private void doInitThreads(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		threads.add(new Collector("Collector"));
		
		logger.info("Creating {}x Worker", configuration.getWorkers());
		
		/* Creating all the Worker threads */
		for (int i = 0; i < configuration.getWorkers(); i++) {
			final Worker w;
			if ( configuration.isMultiDevice() ){
				w = new Worker( "Worker-"+i, (HADevice) Activator.context.getService(services[i]));
			} else {
				w = new Worker( "Worker-"+i, (HADevice) Activator.context.getService(services[0]));
			}
			logger.debug("Created worker: {}", w);
			threads.add(w);
		}
		
		logger.info("Creating {}x Emitter", configuration.getEmiters());
		
		/* Creating all the Emitter threads */
		for (int i = 0; i < configuration.getEmiters(); i++) {
			final Emitter e = new Emitter("Emitter-", i );
			threads.add(e);
			logger.debug("Created emitter: {}", e);
		}
		
		testers = threads.toArray(new Thread[]{});
	}
	
	private boolean init(){
		if ( doInitSharedData() == false ) return false;
		doInitThreads();
		return true;
	}
	
	public void run(){
		Thread.currentThread().setName("Orchestrator-"+System.currentTimeMillis());
		
		if ( init() == false ) {
			logger.warn("Test not executed because initilization didn't complete");
		}
		
		long s,e;
		s=System.currentTimeMillis();
		logger.info("Test starting at: {}",s);
		for (int i = 0; i < testers.length; i++) {			
			testers[i].start();
		}
		
		for (int i = 0; i < testers.length; i++) {			
			try {
				testers[i].join();
			} catch (InterruptedException ex) {
			}
		}
		e=System.currentTimeMillis();
		logger.info("Test ended at: {}",e);
		logger.info("Test elapsed in {}ms",(e-s));
		DescriptiveStatistics errorFree = new DescriptiveStatistics();
		DescriptiveStatistics errorOnly =  new DescriptiveStatistics();
		DescriptiveStatistics total = new DescriptiveStatistics();
		for (int i = 0; i < Activator.tokens.length; i++) {
			final long delta = (Activator.tokens[i].t2-Activator.tokens[i].t1);
			if ( delta == 0 ) {
				logger.warn("Execution of task {} has not been performed", Activator.tokens[i].id);
				continue;
			}
			final int success = delta < 5000 ? 1 : 0;
			logger.info("Execution {} started {} and ended at {} for a total of {}ms",
					new Object[]{Activator.tokens[i].id, Activator.tokens[i].t1, Activator.tokens[i].t2, delta}
			);
			dataLogger.info(
					"{},{},{},{},{}",new Object[]{
					Activator.tokens[i].id, Activator.tokens[i].t1, Activator.tokens[i].t2, delta, success
			});
			total.addValue(delta);
			if( success == 1 ){
				errorFree.addValue(delta);
			}else{
				errorOnly.addValue(delta);
			}
		}
		logger.info(
			"\n" +
			"TEST SUMMARY\n" +
			"-----------\n\n" +
			"Test Enviroment:\n\t" +
			"Iterations per emitter: {}\n\t" +
			"Emitter Emitting period: {}ms ( {}Hz )\n\t" +				
			"Total emitter: {}\n\t" +				
			"Bandwith between emitters and workers: {}Hz\n\t" +				
			"Total worker: {}\n\n" +
			"Test Results:\n\t" +
			"Error Free Comunication: \n\t\t" +
			"Total: {}\n\t\t" +
			"Time of Service [mean, variance]: [ {} \t {} ]\n\t\t" +
			"Time of service [q5, q25, q75, q95]: [ {} \t {} \t {} \t {} ]\n\t" +
			"Failed Comunication: \n\t\t" +
			"Total: {}\n\t\t" +
			"Time of Service [mean, variance]: [ {} \t {} ]\n\t\t" +
			"Time of service [q5, q25, q75, q95]: [ {} \t {} \t {} \t {} ]\n\t" +
			"Total Comunication: \n\t\t" +
			"Total: {}\n\t\t" +
			"Time of Service [mean, variance]: [ {} \t {} ]\n\t\t" +
			"Time of service [q5, q25, q75, q95]: [ {} \t {} \t {} \t {} ]\n\t" +
			"",
			new Object[]{
				configuration.getIterations(), configuration.getPeriod(), (1000.0d/(double)configuration.getPeriod()), configuration.getEmiters(), 1000.0d * ((double) configuration.getEmiters()/ (double) configuration.getPeriod()), configuration.getWorkers(), 
				errorFree.getN(), errorFree.getMean(), errorFree.getVariance(), 
					errorFree.getPercentile(5.0d), errorFree.getPercentile(25.0d), errorFree.getPercentile(75.0d), errorFree.getPercentile(95.0d),
				errorOnly.getN(), errorOnly.getMean(), errorOnly.getVariance(),
					errorOnly.getPercentile(5.0d), errorOnly.getPercentile(25.0d), errorOnly.getPercentile(75.0d), errorOnly.getPercentile(95.0d),
				total.getN(), total.getMean(), total.getVariance(),
					total.getPercentile(5.0d), total.getPercentile(25.0d), total.getPercentile(75.0d), total.getPercentile(95.0d),
			}
		);
	}
}
