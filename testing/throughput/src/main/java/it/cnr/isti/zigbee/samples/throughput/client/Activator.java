package it.cnr.isti.zigbee.samples.throughput.client;


import it.cnr.isti.zigbee.samples.throughput.client.data.Token;
import it.cnr.isti.zigbee.samples.throughput.client.service.Configurator;
import it.cnr.isti.zigbee.samples.throughput.client.threads.Orchestrator;

import java.util.Properties;
import java.util.Stack;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator{

	private final static String CONFIG_PID= "it.cnr.isti.zigbee.throughput";
	
	private Orchestrator tp = null;
	public static BundleContext context;
	
	public static final Stack<Token> emitter2worker = new Stack<Token>();
	public static final Stack<Token> worker2collector = new Stack<Token>();
		
	
	public static Token[] tokens;
	public static Configurator configuration;
	private ServiceRegistration configurationRegistration;
			
	
	private void doRegisterManageService() {
		configuration = new Configurator();
		Properties dictionary = new Properties();
		dictionary.setProperty(Constants.SERVICE_PID, CONFIG_PID);
		configurationRegistration = context.registerService(
				ManagedService.class.getName(), configuration, dictionary
		);
	}
	
	public void start(BundleContext bc) throws Exception {
		context = bc;
		doRegisterManageService();
		tp = new Orchestrator();
		tp.start();	
	}

	public void stop(BundleContext bc) throws Exception {	
		if ( tp != null ) tp.join();
		configurationRegistration.unregister();
	}

}
