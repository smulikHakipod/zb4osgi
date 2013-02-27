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

package org.persona.zigbee.tester;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import org.osgi.framework.BundleException;
import org.persona.zigbee.tester.discovery.RootDeviceListener;
import org.persona.zigbee.tester.gui.LogPanel;
import org.persona.zigbee.tester.gui.PropertiesViewer;
import org.persona.zigbee.tester.gui.TreeViewer;
import org.persona.zigbee.tester.gui.Util;

 
/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ControlPoint implements PopupMenuListener {
	RootDeviceListener listener;
	TreeViewer viewer;
	PropertiesViewer properties;
	JFrame frame;
	
	
	public ControlPoint() {
		frame = new JFrame("Persona ZigBee Tester");
       try {
            URL eventIconUrl = Util.class.getResource("IMAGES/logo.gif");           
            ImageIcon icon=  new ImageIcon(eventIconUrl,"logo");
            frame.setIconImage(icon.getImage());
       }
        catch (Exception ex){
                System.out.println("Resource: IMAGES/logo.gif not found : " + ex.toString());
        }
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				try {
					Activator.context.getBundle().stop();
				} catch (BundleException ex) {
					ex.printStackTrace();
				}
			}

		});       
		frame.setBounds(0,0,300,200);
        
        
        doMenuBar(frame);
		doControlPanel();
        Mediator.setControlPoint(this);
        Mediator.setMainFrame(frame);
		listener = new RootDeviceListener();
        Mediator.setRootDeviceListener(listener);
		listener.setDeviceNodeListener(viewer);
		
		frame.pack();
		frame.setVisible(true);
        
//		DriverProxy driverProxy = new DriverProxy();
//        Mediator.setDriverProxy(driverProxy);
        
		listener.activate();
	}
	
	public void close(){
		listener.deactive();
		frame.dispose();
//        Mediator.getDriverProxy().close();           
	}
	
	private void doControlPanel(){
		JPanel panel = new JPanel(new BorderLayout());
		viewer = new TreeViewer();
		viewer.setPreferredSize(new Dimension(180,450));
		properties = new PropertiesViewer();
		Mediator.setPropertiesViewer(properties);
	
		JSplitPane treeSplitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,viewer,properties);
		JPanel logPanel = new LogPanel();
		logPanel.setPreferredSize(new Dimension(180,100));
		JSplitPane logSplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT,treeSplitter,logPanel);
		panel.add(logSplitter);
		frame.getContentPane().add(panel);
		
		
	}
	
    public void doMenuBar(JFrame frame) {

        JMenuBar menuBar = new JMenuBar();
        
        JMenu file_menu = new JMenu("File");
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Activator.context.getBundle().stop();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
        
        file_menu.addSeparator();
        file_menu.add(exitItem);

        JMenu option_menu = new JMenu("Option");
        final Options[] opts = Options.values();
        for ( int i = 0; i < opts.length; i++ ) {
            final int j = i;
            if ( opts[i].defaultValue.getClass() != Boolean.class ){
                continue;
            }
            JCheckBoxMenuItem opt = new JCheckBoxMenuItem(opts[i].title);
            opt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    synchronized ( Activator.options ) {
                        Activator.options.put( opts[j], ( ( JCheckBoxMenuItem ) e.getSource() ).getState() );
                    }
                }
            });
            option_menu.add( opt );
        }
                
        menuBar.add(file_menu);                   
        menuBar.add(option_menu);                   
        frame.setJMenuBar(menuBar);

    }

 
    public void popupMenuCanceled(PopupMenuEvent e) { }
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) { }
	public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) { }
	
}
