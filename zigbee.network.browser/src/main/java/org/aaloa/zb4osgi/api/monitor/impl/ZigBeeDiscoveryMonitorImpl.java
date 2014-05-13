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
package org.aaloa.zb4osgi.api.monitor.impl;
import it.cnr.isti.zigbee.api.ZigBeeNode;

import java.util.Collection;

import org.aaloa.zb4osgi.api.monitor.ZigBeeDiscoveryMonitor;
import org.aaloa.zb4osgi.network.browser.ui.model.ZigBeeEdge;
import org.aaloa.zb4osgi.network.browser.ui.model.ZigBeeVertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.jung.graph.SparseMultigraph;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ZigBeeDiscoveryMonitorImpl implements ZigBeeDiscoveryMonitor {

	private static final Logger logger = LoggerFactory.getLogger(ZigBeeDiscoveryMonitorImpl.class);
	
	private SparseMultigraph<ZigBeeVertex, ZigBeeEdge> graph;
	
	public ZigBeeDiscoveryMonitorImpl(SparseMultigraph<ZigBeeVertex, ZigBeeEdge> sparseMultigraph){
		this.graph = sparseMultigraph;
	}

	public void annuncedNode(ZigBeeNode node) {
		final ZigBeeVertex v = new ZigBeeVertex(node);
		if( graph.containsVertex( v ) == false ){
			graph.addVertex( v );
			logger.debug("Added node {} to the graph that has been annunced", node);
		} else {
			logger.debug("Annunced node {} but it has been already added to the graph", node);
		}
	}

	public void browsedNode(ZigBeeNode parent, ZigBeeNode child) {
		if ( parent == null ){
			final ZigBeeVertex v = new ZigBeeVertex( child );
			if ( graph.containsVertex( v ) == false ) {
				graph.addVertex( v );
				logger.debug("Added node {} to the graph that has been discovered as root node", child);
			} else {
				logger.debug("Discovered root node {} but it has been already added to the graph", child);
			}
			return;
		}
		
		final ZigBeeVertex p = new ZigBeeVertex( parent );
		final ZigBeeVertex c = new ZigBeeVertex( child );
		final ZigBeeEdge p2c = new ZigBeeEdge( p, c );
		if ( graph.containsEdge( p2c ) ) {
			logger.debug("Discovered edge {}->{} but it has been already added to the graph", parent, child);
		} else if ( graph.containsVertex( c ) ) {
			Collection<ZigBeeEdge> parents = graph.getInEdges( c );	
			if ( parents.size() > 0 ) {
				logger.debug("Multiple parents for node {} that differ from current parent, deleting them all ", child );
				for (ZigBeeEdge edge : parents) {
					logger.debug("Removing edge {}", edge);
					graph.removeEdge(edge);
				}
				logger.debug("Removed all incoming edge to node {}", child);
			}
		}
		graph.addEdge(p2c, p, c);
		logger.debug("Added edge {}->{} to the graph that has been annunced", parent, child);
	}
	
}
