package it.cnr.isti.zigbee.samples.throughput.client.service;

import it.cnr.isti.zigbee.samples.throughput.client.Activator;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configurator implements ManagedService {

	private final static String CONFIG_PERIOD_KEY = "it.cnr.isti.zigbee.throughput.period";
	private final static String CONFIG_PERIOD_DEFULAT = "500";
	
	private final static String CONFIG_COUNT_KEY = "it.cnr.isti.zigbee.throughput.count";
	private final static String CONFIG_COUNT_DEFAULT = "100"; 
	
	private final static String CONFIG_EMITERS_KEY = "it.cnr.isti.zigbee.throughput.emiters";
	private final static String CONFIG_EMITERS_DEFAULT = "1"; 
	
	private final static String CONFIG_WORKERS_KEY = "it.cnr.isti.zigbee.throughput.workers";
	private final static String CONFIG_WORKERS_DEFAULT = "1"; 

	private final static String CONFIG_MULTI_DEVICE_KEY = "it.cnr.isti.zigbee.throughput.multidevice";
	private final static String CONFIG_MULTI_DEVICE_DEFAULT = "false"; 

	private final static String CONFIG_USE_LIGHT_KEY = "it.cnr.isti.zigbee.throughput.light";
	private final static String CONFIG_USE_LIGHT_DEFAULT = "1"; 
	
	private static final Logger logger = LoggerFactory.getLogger(Configurator.class);

	
	private int iterations;
	private int emiters;
	private int workers;
	private long period;
	private boolean multiDevice;
	private boolean useLight;
	
	private BundleContext context;
	
	
	public Configurator() {
		context = Activator.context;
		doReadProperties();
	}
	
	public int getIterations() {
		return iterations;
	}

	public int getEmiters() {
		return emiters;
	}

	public int getWorkers() {
		return workers;
	}

	public long getPeriod() {
		return period;
	}

	public boolean isMultiDevice() {
		return multiDevice;
	}

	public boolean isUseLight() {
		return useLight;
	}

	public void doReadProperties() {
		period = Long.parseLong( 
				context.getProperty(CONFIG_PERIOD_KEY) == null ?
				CONFIG_PERIOD_DEFULAT : context.getProperty(CONFIG_PERIOD_KEY)
		);
		iterations = Integer.parseInt( 
				context.getProperty(CONFIG_COUNT_KEY) == null ?
				CONFIG_COUNT_DEFAULT : context.getProperty(CONFIG_COUNT_KEY) 
		);
		emiters = Integer.parseInt( 
				context.getProperty(CONFIG_EMITERS_KEY) == null ?
				CONFIG_EMITERS_DEFAULT : context.getProperty(CONFIG_EMITERS_KEY) 
		);
		workers = Integer.parseInt( 
				context.getProperty(CONFIG_WORKERS_KEY) == null ?
				CONFIG_WORKERS_DEFAULT : context.getProperty(CONFIG_WORKERS_KEY) 
		);
		multiDevice = Boolean.parseBoolean( 
				context.getProperty(CONFIG_MULTI_DEVICE_KEY) == null ?
				CONFIG_MULTI_DEVICE_DEFAULT : context.getProperty(CONFIG_MULTI_DEVICE_KEY) 
		);
		
		useLight = Boolean.parseBoolean( 
				context.getProperty(CONFIG_USE_LIGHT_KEY) == null ?
				CONFIG_USE_LIGHT_DEFAULT : context.getProperty(CONFIG_USE_LIGHT_KEY) 
		);
	}

	@SuppressWarnings("unchecked")
	public void updated(Dictionary dictionary) throws ConfigurationException {
		logger.debug("Updating configuration with {}", dictionary);
		if( dictionary == null ){
			return;
		}
		period = Long.parseLong( 
				dictionary.get(CONFIG_PERIOD_KEY) == null ?
				Long.toString(period) : (String) dictionary.get(CONFIG_PERIOD_KEY)
		);
		iterations = Integer.parseInt( 
				dictionary.get(CONFIG_COUNT_KEY) == null ?
				Integer.toString(iterations) : (String)  dictionary.get(CONFIG_COUNT_KEY) 
		);
		emiters = Integer.parseInt( 
				dictionary.get(CONFIG_EMITERS_KEY) == null ?
				Integer.toString(emiters) : (String)  dictionary.get(CONFIG_EMITERS_KEY) 
		);
		workers = Integer.parseInt( 
				dictionary.get(CONFIG_WORKERS_KEY) == null ?
				Integer.toString(workers) : (String)  dictionary.get(CONFIG_WORKERS_KEY) 
		);
		multiDevice = Boolean.parseBoolean( 
				dictionary.get(CONFIG_MULTI_DEVICE_KEY) == null ?
				Boolean.toString(multiDevice) : (String)  dictionary.get(CONFIG_MULTI_DEVICE_KEY) 
		);			
		useLight = Boolean.parseBoolean( 
				dictionary.get(CONFIG_USE_LIGHT_KEY) == null ?
				Boolean.toString(useLight) : (String)  dictionary.get(CONFIG_USE_LIGHT_KEY) 
		);
	}

}
