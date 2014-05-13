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
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;

import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.persona.zigbee.tester.Activator;
import org.persona.zigbee.tester.Options;
import org.persona.zigbee.tester.discovery.DeviceNode;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.3.0
 *
 */
public class TreeNodeBindPopupMenu
    extends JPopupMenu
    implements PopupMenuListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3175875257203883428L;
	JTree tree;
    final JMenu bind;
    final Action action;
    HADeviceTreeNode lastNode = null;
    
    public TreeNodeBindPopupMenu(final JTree tree){
        super();
        addPopupMenuListener(this);
        this.tree = tree;
        bind = new JMenu("Bind To");
        add( bind );
        action = new AbstractAction(){

            /**
			 * 
			 */
			private static final long serialVersionUID = 7784951706085415028L;

			public void actionPerformed( ActionEvent e ) {
                final JMenuItem item = (JMenuItem) e.getSource();
                final String uuidTo = item.getText();
                final Cluster binding = (Cluster) lastNode.getUserObject();
                LogPanel.log( "Binding on cluster " + binding.getName() + " invoked" );
                final int clusterId = binding.getId();
                final DeviceNode device = (DeviceNode) ( (HADeviceTreeNode) lastNode.getParent() ).getUserObject();
                final String uuidFrom = (String) device.getReference().getProperty( HADevice.ZIGBEE_DEVICE_UUID );
                final String filter = 
                    "(|" +
                    "(" + ZigBeeDevice.UUID + "=" + uuidFrom + ")" +
                    "(" + ZigBeeDevice.UUID + "=" + uuidTo + ")" +
                    ")";
                try {
                    ServiceReference[] pair = Activator.context.getServiceReferences( ZigBeeDevice.class.getName(), filter );
                    if ( pair == null || pair.length != 2 ) {
                        LogPanel.log( "Binding failed because one of the service expired" );
                        return;
                    }
                    final ZigBeeDevice fromDevice;
                    final ZigBeeDevice toDevice;
                    if ( pair[0].getProperty( ZigBeeDevice.UUID ).equals( uuidFrom ) ){
                        fromDevice = (ZigBeeDevice) Activator.context.getService( pair[0] );
                        toDevice = (ZigBeeDevice) Activator.context.getService( pair[1] );
                    } else {
                        toDevice = (ZigBeeDevice) Activator.context.getService( pair[0] );
                        fromDevice = (ZigBeeDevice) Activator.context.getService( pair[1] );
                    }
                    if ( fromDevice == null || toDevice == null ) {
                        LogPanel.log( "Binding failed because one of the service expired" );
                        return;
                    }
                    LogPanel.log( "Binding cluster " + clusterId + " from " + uuidFrom + " to " + uuidTo + "... ");
                    if ( fromDevice.bindTo( toDevice, clusterId ) ) {
                        LogPanel.log( "Binding cluster " + clusterId + " from " + uuidFrom + " to " + uuidTo + "... SUCCESS");
                    } else {
                        LogPanel.log( "Binding cluster " + clusterId + " from " + uuidFrom + " to " + uuidTo + "... FAILED");
                    }
                    if ( (Boolean) Activator.options.get( Options.AlwaysDoubleBinding ) ){
                        LogPanel.log( "Binding cluster " + clusterId + " from " + uuidTo + " to " + uuidFrom + "... ");
                        if ( toDevice.bindTo( fromDevice, clusterId ) ) {
                            LogPanel.log( "Binding cluster " + clusterId + " from " + uuidTo + " to " + uuidFrom + "... SUCCESS");
                        } else {
                            LogPanel.log( "Binding cluster " + clusterId + " from " + uuidTo + " to " + uuidFrom + "... FAILED");
                        }
                    }
                }
                catch ( Throwable ex ) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream( out );
                    ex.printStackTrace( ps );
                    ps.flush();
                    ps.close();
                    LogPanel.log( out.toString() );
                }
                
            }
            
        };
    }    
    
    public void popupMenuCanceled( PopupMenuEvent e ) { }
    
    public void popupMenuWillBecomeInvisible( PopupMenuEvent e ) { }

    public void popupMenuWillBecomeVisible( PopupMenuEvent e ) {
        HADeviceTreeNode selectedNode = (HADeviceTreeNode) tree.getLastSelectedPathComponent();
        if ( lastNode != selectedNode && selectedNode.category == HADeviceTreeNode.SERVICE ) {
            //bind.setVisible( true );
            bind.setEnabled( true );
            lastNode = selectedNode;
            generateSubItems(lastNode);
        } else {
            bind.setEnabled( selectedNode.category == HADeviceTreeNode.SERVICE );
            //bind.setVisible( selectedNode.category == HADeviceTreeNode.SERVICE );
        }
    }

    private void generateSubItems(HADeviceTreeNode node) {
        final String filter;
        bind.removeAll();
        final Cluster binding = (Cluster) node.getUserObject();
        if ( (Boolean) Activator.options.get( Options.StrictBinding ) ){
            filter = "( " + ZigBeeDevice.CLUSTERS_OUTPUT_ID + "=" + binding.getId() + ")";
        } else {
            filter = null;
        }
        try {
            ServiceReference[] refs = Activator.context.getServiceReferences( ZigBeeDevice.class.getName(), filter );
            JMenuItem item;
            if ( refs == null ) {
                item = new JMenuItem("No valid target");
                bind.add( item );
                return;
            }
            for ( int i = 0; i < refs.length; i++ ) {
                final String uuid = (String) refs[i].getProperty( ZigBeeDevice.UUID );
                item = new JMenuItem( uuid );
                final String hadevice = "( " + HADevice.ZIGBEE_DEVICE_UUID + "=" + uuid + ")"; 
                final ServiceReference[] refined = Activator.context.getServiceReferences( HADevice.class.getName(), hadevice );
                if ( refined != null ) {
                    item.setToolTipText( (String) refined[0].getProperty( HADevice.HA_DEVICE_NAME ) );
                } else {
                    item.setText( uuid );
                }
                item.addActionListener( action );
                bind.add( item );                
            }
            bind.repaint();
        } catch ( InvalidSyntaxException e ) {
        }
    }

}
