/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
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

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Hashtable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.persona.zigbee.tester.event.api.HAGenericListener;
import org.persona.zigbee.tester.event.api.HAListenerFactoryService;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.3.0
 *
 */
public class HAEventActionPanel extends JPanel {
	
	HAEvent event;
	JPanel buttonPanel;
	
	private JButton subscribeButton;
	
	private Hashtable<HAEvent, HAGenericListener> subscription = new Hashtable<HAEvent, HAGenericListener>();
	
	/**
	 * 
	 */
	public HAEventActionPanel() {
		super(new GridBagLayout());
		buildButtonPanel();
		add(buttonPanel,Util.setConstrains(0,2,1,1,1,1));
	}
		
	@SuppressWarnings("serial")
	private JButton getSubscribeButton(){
		if( subscribeButton != null ){
			return subscribeButton;
		}
		JButton doAction = new JButton("Subscribe");
		doAction.addActionListener(new AbstractAction(){
			public void actionPerformed(ActionEvent e) {
				HAListenerFactoryService factory = event.getHAListenerFactoryService();
				if ( factory == null ) return;
				HAGenericListener listener = subscription.get(event);
				if ( listener == null ){
					listener = createListener();
					subscription.put(event, listener);
					getSubscribeButton().setText("Unsubscribe");
					factory.addListener(event.getCluster(), listener);
				} else {
					if ( factory.removeListener(event.getCluster(), listener) == false ) return;
					subscription.remove(event);
					getSubscribeButton().setText("Subscribe");
				}
			}

			private HAGenericListener createListener() {
				return new HAGenericListener() {
					public void eventReceived(Cluster source, Object event, String eventString) {
						LogPanel.log("Received from "+source+" as "+event+" with value:\n"+eventString);
					}
				};
			}

		});		
		subscribeButton = doAction;
		subscribeButton.setVisible(true);
		return subscribeButton;
	}
	
	private void buildButtonPanel(){
		buttonPanel = new JPanel();
    	buttonPanel.add(getSubscribeButton());
	}
	
	public void setHAEvent(HAEvent action){
		this.event = action;
		subscribeButton.setEnabled(event.isSubscribable());
	}
	
}

