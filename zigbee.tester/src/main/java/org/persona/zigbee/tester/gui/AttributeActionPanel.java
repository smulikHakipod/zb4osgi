/*
   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
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

package org.persona.zigbee.tester.gui;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.AnalogSubscription;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.ReportListener;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;

import org.persona.zigbee.tester.Mediator;
import org.persona.zigbee.util.Converter;


/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class AttributeActionPanel extends JPanel {
	
	Attribute attribute;
	JPanel buttonPanel;
	
	private JButton readButton;
	private JButton writeButton;
	private JButton subscribeButton;
	private JTextField inputText; 
	
	private Hashtable<Attribute, ReportListener> subscription = new Hashtable<Attribute, ReportListener>();
    private JPanel subscriptionPanel;
    private JTextField minText;
    private JTextField maxText;
    private JTextField changeText;
	private HADevice device;
	
	class PanelLogReportListener implements ReportListener {
		
		final HADevice device;
		
		PanelLogReportListener(HADevice d){
			device = d;
		}
		
		public void receivedReport(Dictionary<Attribute, Object> reports) {
			Enumeration<Attribute> attributes = reports.keys();
			while (attributes.hasMoreElements()) {							
				Attribute a = (Attribute) attributes.nextElement();
				Object v = reports.get(a);
				LogPanel.log(
						"Received Event from device " + device.getName() + "[" + 
						device.getZBDevice().getUniqueIdenfier() + "] for attribute "+a.getName()+" with value "+v
				);
			}
		}
	}
	
	/**
	 * 
	 */
	public AttributeActionPanel() {
		super(new GridBagLayout());
		buildButtonPanel();
		add(new JScrollPane(getInputText()),Util.setConstrains(0,1,1,1,100,100)); 
		add(buttonPanel,Util.setConstrains(0,2,1,1,1,1));
	}
	
	private JTextField getInputText(){
		if( inputText != null ){
			return inputText;
		}
		inputText = new JTextField();
		return inputText;
	}

	private JButton getWriteButton(){
		if( writeButton != null ){
			return writeButton;
		}
		JButton doAction = new JButton("Write");
		doAction.addActionListener(new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				Object newValue = null;
				try {
					try{
						newValue = Converter.fromString(getInputText().getText(), attribute.getZigBeeType());
					}catch(NumberFormatException ex){
						LogPanel.log(
								"Invalid value for " + attribute.getName() + " we where expecting a number." +
								"\n\tStatus: SKYPPED"
						);
						return;
					}
					attribute.setValue( newValue );
					LogPanel.log(
							"Set Attribute " + attribute.getName() + " to " + newValue  +
							"\n\tStatus: SUCCESS\n"
					);
				} catch (ZigBeeClusterException ex) {
					LogPanel.log(
							"Set Attribute " + attribute.getName() + " to " + newValue  +
							"\n\tStatus: FAILED\n\tException: " + ex + "\n"
					);
					ex.printStackTrace();
				}
			}
		});		
		writeButton = doAction;
		return writeButton;
	}
	
	private JButton getReadButton(){
		if( readButton != null ){
			return readButton;
		}
		JButton doAction = new JButton("Read");
		doAction.addActionListener(new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				try {
					Object result = attribute.getValue();
					LogPanel.log(
							"Read Attribute " + attribute.getName() + 
							"\n\tStatus: SUCCESS\n\tResult: " + result+ "\n"
					);
				} catch (ZigBeeClusterException ex) {
					LogPanel.log(
							"Read Attribute " + attribute.getName() + 
							"\n\tStatus: FAILED\n\tException: " + ex + "\n"
					);
					ex.printStackTrace();
				}
			}
		});		
		readButton = doAction;
		return readButton;
	}
	
	private JButton getSubscribeButton(){
		if( subscribeButton != null ){
			return subscribeButton;
		}
		JButton doAction = new JButton("Subscribe");
		doAction.addActionListener(new AbstractAction(){
		    
		    public void doSubscribe(ReportListener listener) {
		        
                final Subscription sub = attribute.getSubscription();
                try{
                	sub.setMaximumReportingInterval( Integer.parseInt( maxText.getText() ) );
                }catch(NumberFormatException ex){
                	LogPanel.log( 
                		"The value '"+maxText.getText()+"' typed in the Maximum field is not a number" +
                		"Using default value " + Subscription.DEFAULT_MAX_REPORTING_INTERVAL + ", " +
        				"that means report the value at least once every " + Subscription.DEFAULT_MAX_REPORTING_INTERVAL + " seconds"
                	);
                	sub.setMaximumReportingInterval( Subscription.DEFAULT_MAX_REPORTING_INTERVAL ); 
                }
                try{
                	sub.setMinimumReportingInterval( Integer.parseInt( minText.getText() ) );
                }catch(NumberFormatException ex){
                	LogPanel.log( 
                		"The value '"+minText.getText()+"' typed in the Minimum field is not a number." +
                		"Using default value " + Subscription.DEFAULT_MIN_REPORTING_INTERVAL + ", " +
        				"that means reports every time the value of the attribute changes"
                	);
                	sub.setMinimumReportingInterval( Subscription.DEFAULT_MIN_REPORTING_INTERVAL );
                }
                if ( sub instanceof AnalogSubscription ) {
					AnalogSubscription asub = (AnalogSubscription) sub;
					final ZigBeeType type = attribute.getZigBeeType();
					try {
						asub.setReportableChange(Converter.fromString(
								changeText.getText(), type));
					} catch (NumberFormatException ex) {
						LogPanel.log(
								"The value '" + changeText.getText() +"' typed in the Delta field is not a number." + 
								"Using default value " + AnalogSubscription.DEFAULT_REPORTABLE_CHANGE_INTERVAL + ", " +
								"that means reports every changes of the Analog attribute greter then " +
								AnalogSubscription.DEFAULT_REPORTABLE_CHANGE_INTERVAL
						);
						asub.setReportableChange(AnalogSubscription.DEFAULT_REPORTABLE_CHANGE_INTERVAL);
					}
                }
                
                if ( attribute.getSubscription().addReportListner(listener) ) {
                    LogPanel.log(
                            "Subscribed to " + attribute.getName() + "\n\t" +
                                    "Status: SUCCESS\n"
                    );
                    updateCategory(HADeviceTreeNode.SUBSCRIBED_STATE);
                    subscription.put(attribute, listener);
                    getSubscribeButton().setText("Unsubscribe");
                } else {
                    LogPanel.log(
                            "Subscribed to " + attribute.getName() + "\n\t" +
                                    "Status: FAILED\n"
                    );                          
                }
		    }
		    
		    public void doUnsubscribe(ReportListener listener) {
                if ( attribute.getSubscription().removeReportListner(listener) ) {
                    LogPanel.log(
                            "Unsubscribed to " + attribute.getName() + "\n\t" +
                                    "Status: SUCCESS\n"
                    );
                    updateCategory(HADeviceTreeNode.EVENTED_STATE);
                    subscription.remove(attribute);
                    getSubscribeButton().setText("Subscribe");
                } else {
                    LogPanel.log(
                            "Unsubscribed to " + attribute.getName() + "\n\t" +
                                    "Status: FAILED\n"
                    );                          
                }
		    }
		    
			public void actionPerformed(ActionEvent e) {
				ReportListener listener = subscription.get(attribute);
				if ( listener == null ){
					listener = new PanelLogReportListener(device);
					doSubscribe( listener );
				} else {
				    doUnsubscribe( listener );
				}
			}
			private void updateCategory(String category) {
				HADeviceTreeNode node = (HADeviceTreeNode) Mediator.getUPnPDeviceTree().getLastSelectedPathComponent();
			    node.category = category;
			    JTree tree = Mediator.getUPnPDeviceTree();
			    tree.validate();
			    tree.repaint();
			}
		});		
		subscribeButton = doAction;
		return subscribeButton;
	}
	
	private JPanel getSubscriptionPanel() {
	    if ( subscriptionPanel != null ) {
	        return subscriptionPanel;
	    }
	    
	    subscriptionPanel = new JPanel(new GridBagLayout());
	    subscriptionPanel.setBorder( BorderFactory.createLineBorder(Color.black) );
	    
	    subscriptionPanel.add( 
	    		new JLabel( "Reporting Configuration", JLabel.CENTER ), 
	    		Util.setConstrains( 0, 0, 3, 1, 1, 1 ) 
		);
	    
	    subscriptionPanel.add( new JLabel("Minimum", JLabel.CENTER ), Util.setConstrains( 0, 1, 1, 1, 1, 1 ) );
        subscriptionPanel.add( new JLabel("Maximum", JLabel.CENTER ), Util.setConstrains( 1, 1, 1, 1, 1, 1 ) );
        subscriptionPanel.add( new JLabel("Delta", JLabel.CENTER ), Util.setConstrains( 2, 1, 1, 1, 1, 1 ) );
        
        minText = new JTextField();
        subscriptionPanel.add( minText, Util.setConstrains( 0, 2, 1, 1, 1, 1 ) );
        
        maxText = new JTextField();
        subscriptionPanel.add( maxText, Util.setConstrains( 1, 2, 1, 1, 1, 1 ) );
        
        changeText = new JTextField();
        subscriptionPanel.add( changeText, Util.setConstrains( 2, 2, 1, 1, 1, 1 ) );
        
        return subscriptionPanel;
	}
	
	private void buildButtonPanel(){
		buttonPanel = new JPanel(new GridBagLayout());
	    buttonPanel.add( getReadButton(), Util.setConstrains( 0, 0, 1, 1, 1, 1 ) );
    	buttonPanel.add( getWriteButton(), Util.setConstrains( 1, 0, 1, 1, 1, 1 ) );
    	buttonPanel.add( getSubscribeButton(), Util.setConstrains( 2, 0, 1, 1, 1, 1 ) );
    	buttonPanel.add( getSubscriptionPanel(), Util.setConstrains( 0, 1, 3, 1, 1, 1 ) );
	}
	
	public void setAttribute(HADevice device, Attribute action){
		this.device = device;
		this.attribute = action;
		
		getWriteButton().setVisible(attribute.isWritable());
		getInputText().setVisible(attribute.isWritable());
		
		if( attribute.isReportable() ){
			getSubscribeButton().setVisible(true);
			final Subscription sub = attribute.getSubscription();
			maxText.setText( "" + sub.getMaximumReportingInterval() );
            minText.setText( "" + sub.getMinimumReportingInterval() );
            if ( sub instanceof AnalogSubscription ) {
                final AnalogSubscription  asub = (AnalogSubscription) sub;
                changeText.setText( "" + asub.getReportableChange() );
                changeText.setEnabled( true );
            } else {
                changeText.setEnabled( false );
            }
			if( subscription.get(attribute) == null ){
				getSubscribeButton().setText("Subscribe");
			} else {
				getSubscribeButton().setText("Unsubscribe");
			}
		}else{
			getSubscribeButton().setVisible(false);
		}
        getSubscriptionPanel().setVisible( getSubscribeButton().isVisible() );
	}
	
}

