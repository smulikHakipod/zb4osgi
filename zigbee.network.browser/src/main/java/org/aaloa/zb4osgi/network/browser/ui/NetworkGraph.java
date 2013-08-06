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
package org.aaloa.zb4osgi.network.browser.ui;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.api.ZigBeeNode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;

import org.aaloa.zb4osgi.network.browser.Activtor;
import org.aaloa.zb4osgi.network.browser.ui.model.ZigBeeEdge;
import org.aaloa.zb4osgi.network.browser.ui.model.ZigBeeVertex;
import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

public class NetworkGraph extends JFrame {
    
    private SparseMultigraph<ZigBeeVertex, ZigBeeEdge> graph = new SparseMultigraph<ZigBeeVertex, ZigBeeEdge>();
    private VisualizationViewer<ZigBeeVertex,ZigBeeEdge> viewer = null;
	private JToolBar jToolBar;
	private JPanel statusBar;
	private JLabel statusLeft;
	private JLabel statusMiddle;
	private JLabel statusRight;

    
    
    public NetworkGraph() {    	
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add( getToolBar(), BorderLayout.NORTH );
        getContentPane().add( getGraphViewer(), BorderLayout.CENTER );
        getContentPane().add( getStatusBar(), BorderLayout.SOUTH );
        pack();
        setVisible( true );
    }
    
	private JPanel getStatusBar() {
		if ( statusBar != null ) {
			return statusBar;
		}
		statusBar = new JPanel();
		statusBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		statusBar.setLayout(new GridBagLayout());
		statusBar.setPreferredSize( new Dimension( 800, 16 ) );
		Dimension dimension = new Dimension(1280, 16);
		GridBagConstraints opt = new GridBagConstraints();
		opt.fill = GridBagConstraints.HORIZONTAL;
		opt.gridy = 0;
		opt.ipady = 1;
		opt.ipadx = 3;

		opt.gridx = 0;
		statusLeft = new JLabel("");
		statusLeft.setPreferredSize(dimension);
		statusLeft.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		statusBar.add(statusLeft, opt);

		opt.gridx = 1;
		statusLeft.setPreferredSize(dimension);
		statusMiddle = new JLabel("Picking Mode");
		statusMiddle.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		statusBar.add(statusMiddle, opt);
		
		opt.gridx = 2;
		statusLeft.setPreferredSize(dimension);
		statusRight = new JLabel("");
		statusRight.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		statusBar.add(statusRight, opt);
		return statusBar;
	}

	private VisualizationViewer<ZigBeeVertex, ZigBeeEdge> getGraphViewer() {
		if ( viewer != null ){
			return viewer;
		}
        viewer =  new VisualizationViewer<ZigBeeVertex, ZigBeeEdge>( new FRLayout<ZigBeeVertex, ZigBeeEdge>( graph ) );

        Transformer<ZigBeeVertex, Paint> transformerNode = new Transformer<ZigBeeVertex, Paint>() {            
            public Paint transform( ZigBeeVertex v) {
            	if ( v.getZigBeeDevice() == null )
            		return Color.BLUE;
            	
            	return Color.GREEN;
            }
        };

        viewer.getRenderContext().setVertexFillPaintTransformer( transformerNode );
        viewer.getRenderContext().setVertexLabelTransformer( new Transformer<ZigBeeVertex, String>(){
			public String transform(ZigBeeVertex v) {
				return v.toString();
			}
        });
        
        viewer.setVertexToolTipTransformer( new Transformer<ZigBeeVertex, String>(){
			public String transform(ZigBeeVertex v) {
				return v.getNetworkAddress() + "\n" + v.getIEEEAddress();
			}
        });
        viewer.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
        
        DefaultModalGraphMouse<ZigBeeNode, Paint> hci = new DefaultModalGraphMouse<ZigBeeNode, Paint>();
        hci.setMode( ModalGraphMouse.Mode.PICKING  );
        viewer.setGraphMouse( hci );
        
        return viewer;
	}
	
	private Component getToolBar() {
		if ( jToolBar != null )
			return jToolBar;
		
		jToolBar = new JToolBar();
		addButton(jToolBar,"P", new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
		        DefaultModalGraphMouse<ZigBeeNode, Paint> hci = new DefaultModalGraphMouse<ZigBeeNode, Paint>();
		        hci.setMode( ModalGraphMouse.Mode.PICKING  );
		        getGraphViewer().setGraphMouse( hci );
		        statusMiddle.setText("Pick Mode");

			}			
		});
		addButton(jToolBar,"T", new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
		        DefaultModalGraphMouse<ZigBeeNode, Paint> hci = new DefaultModalGraphMouse<ZigBeeNode, Paint>();
		        hci.setMode( ModalGraphMouse.Mode.TRANSFORMING  );
		        getGraphViewer().setGraphMouse( hci );
		        statusMiddle.setText("Transform Mode");

			}			
		});
		return jToolBar;
	}

	private void addButton(final JToolBar bar, final String name, final ActionListener listener) {
		JButton btn = new JButton(name);
		btn.addActionListener(listener);
		bar.add(btn);
	}

	public SparseMultigraph<ZigBeeVertex,ZigBeeEdge> getGraph() {
		return graph;
	}

}
