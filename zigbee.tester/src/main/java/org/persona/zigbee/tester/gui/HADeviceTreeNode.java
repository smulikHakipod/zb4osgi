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
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.ImageObserver;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToolTip;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.persona.zigbee.tester.Activator;
import org.persona.zigbee.tester.discovery.DeviceNode;


/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HADeviceTreeNode extends DefaultMutableTreeNode {

	public final static String HA_DEVICE = "RootDeviceNode";
	public final static String HA_EVENT = "HAEventNode";
	public final static String ZIGBEE_DEVICE = "DeviceNode";
	public final static String SERVICE = "UPnPService";
	public final static String ZCL_COMMAND = "ZCLCommand";
	public final static String ZCL_ATTRIBUTE = "ZCLAttribute";
	public final static String EVENTED_STATE = "ZCLReportableAttribute";
	public final static String SUBSCRIBED_STATE = "ZCLSubcribedAttribute";
	
	protected String category;
	private HADevice device;
	
	public HADeviceTreeNode(String obj) {
		super(obj);
		category = obj.getClass().getName();
	}
	
	public HADeviceTreeNode(DeviceNode node, HADeviceTreeNode root) {
		super(node);
		
		category = HA_DEVICE;
		
		final HADevice device = node.getDevice(Activator.context);
		/* Adding the wrapped ZigBeeDevice as subnode and removing it from the sibling nodes */
		ServiceReference[] sr = null;
        try {
            sr = Activator.context.getServiceReferences( 
                ZigBeeDevice.class.getName(), 
                "(" +  ZigBeeDevice.UUID + "=" + device.getZBDevice().getUniqueIdenfier() + ")"
            );
        } catch ( InvalidSyntaxException e ) {
            //IGNORED 
        }
        this.add( new HADeviceTreeNode( sr[0] ) );    
		
        final long sid = (Long) sr[0].getProperty( Constants.SERVICE_ID );
		for(int i = 0; i < root.getChildCount(); i++){
			final HADeviceTreeNode current = (HADeviceTreeNode) root.getChildAt(i);
			if ( current.category != HADeviceTreeNode.ZIGBEE_DEVICE ) {
				continue;
			}
			final ServiceReference currentSR = ( ServiceReference ) current.getUserObject();
			final long currentSID = (Long) currentSR.getProperty( Constants.SERVICE_ID );
			if ( sid == currentSID ){
				current.removeFromParent();
				break;
			}
		}
		
		
		/* Adding all the clusters of this HADevice as subtree */
		Cluster[] clusters = device.getAvailableCluster();		
		if (clusters != null){
			Arrays.sort(clusters, new Comparator<Cluster>() {
				public int compare(Cluster a, Cluster b) {
					if ( a == b ) return 0;
					if ( a == null ) return -1;
					if ( b == null ) return 1;
					return a.getId() - b.getId();
				}
			});
			
			for (int i=0; i<clusters.length; i++) {
				if ( clusters[i] != null ) {
					this.add(new HADeviceTreeNode(device, clusters[i]));
				}
			}
		}
		
		Activator.context.ungetService(node.getReference());
	}
	
	public HADevice getHADevice() {
		return device;
	}
	
	public HADeviceTreeNode(HADevice device, Cluster obj) {
		super(obj);
		category = SERVICE;
		Attribute[] variables = obj.getAttributes();
		if (variables != null) {
			for (int i=0;i<variables.length;i++)
				this.add(new HADeviceTreeNode(device, variables[i]));
		}
		Method[] methods = obj.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Class<?> declaringClass = methods[i].getDeclaringClass();
			if( declaringClass == Cluster.class || declaringClass == Object.class ) {
				continue;
			}
			final String methodName = methods[i].getName();
			final Class<?> returnType = methods[i].getReturnType();
			if ( methodName.equals("subscribe") || methodName.equals("unsubscribe") ){
				//We skip method that are only a way to access method available at level of attribute
				continue;
			} else if ( methodName.startsWith("get") && ( ! ( Response.class.isAssignableFrom(returnType) || returnType == void.class ) ) ) {
				//We skip method that are only a way to access method available at level of attribute
				continue;				
			} else if ( methodName.startsWith("add") || methodName.startsWith("remove") ) {
			    Class<?>[] args = methods[i].getParameterTypes();
               if( args.length == 1 && args[0].getName().endsWith( "Listener" ) ){
	                String pairName = null;
	                if ( ( pairName = checkForAddRemoveMethodsPair(methods,i) ) == null ) continue;
	                int childCount = this.getChildCount();
	                boolean isDuplicate = false;
	                for (int j = 0; j < childCount && ! isDuplicate; j++) {
	                    HADeviceTreeNode node = (HADeviceTreeNode) this.getChildAt(j);
	                    if( node.category != HA_EVENT ) continue;
	                    HAEvent event = (HAEvent) node.getUserObject();
	                    isDuplicate = event.getName().equals(pairName);
	                }
	                if( isDuplicate ) continue;
	                //TODO Add support for Specific Cluster Eventing
	                this.add(new HADeviceTreeNode(new HAEvent(obj, pairName)));
	                continue;
			    }
			}
			this.add(new HADeviceTreeNode(new Command(obj, methods[i])));
		}
		
	}	
	
	private String checkForAddRemoveMethodsPair(Method[] methods, int i) {
		String name = methods[i].getName();
		String paired = null;
		if ( name.startsWith("add") ){
			name = name.substring(3);
			paired = "remove" + name;
		} else if ( name.startsWith("remove") ) {
			name = name.substring(6);
			paired = "add" + name;
		}
		for (int j = 0; j < methods.length; j++) {
			if( methods[j].getName().equals(paired) ) {
				return name;
			}
		}
		return null;
	}

	public HADeviceTreeNode(HADevice device, Attribute obj) {
		super(obj);
		if (obj.isReportable()) category = EVENTED_STATE;
		else category = ZCL_ATTRIBUTE;
	}
	
	public HADeviceTreeNode(ServiceReference sr) {
		super(sr);
		category = ZIGBEE_DEVICE;
	}
	
	public HADeviceTreeNode(Command obj) {
		super(obj);
		category = ZCL_COMMAND;
	}

	public HADeviceTreeNode(HAEvent obj) {
		super(obj);
		category = HA_EVENT;
	}
	
	public String toString() {
		if (category.equals(HA_DEVICE)){
			DeviceNode node =  (DeviceNode) getUserObject();
			return node.toString();
		}
		else if (category.equals(ZIGBEE_DEVICE) ){
		    ServiceReference sr = (ServiceReference) getUserObject();
			return (String) sr.getProperty( ZigBeeDevice.UUID );
		}
		else if (category.equals(SERVICE)){
			Cluster node =  (Cluster) getUserObject();
			return node.getName();
		}
		else if (category.equals(ZCL_ATTRIBUTE) ||category.equals(EVENTED_STATE)||category.equals(SUBSCRIBED_STATE)){
			Attribute node =  (Attribute) getUserObject();
			return node.getName();
		}
		else
			return getUserObject().toString();
	}
}

//   local class for JTree icon renderer
class TreeNodeCellRenderer extends DefaultTreeCellRenderer implements ImageObserver {
	
	private HashMap icons ;
	ImageIcon image;
	
	public TreeNodeCellRenderer() {
		super();
		icons = new HashMap();
		try {
			icons.put( HADeviceTreeNode.EVENTED_STATE, loadIcon( HADeviceTreeNode.EVENTED_STATE ) );
            image = loadIcon( HADeviceTreeNode.SUBSCRIBED_STATE );
            // to use animate gif
            //image.setImageObserver(this);
            icons.put( HADeviceTreeNode.SUBSCRIBED_STATE, image );

            icons.put( HADeviceTreeNode.HA_DEVICE, loadIcon( HADeviceTreeNode.HA_DEVICE ) );
            icons.put( HADeviceTreeNode.ZIGBEE_DEVICE, loadIcon( HADeviceTreeNode.ZIGBEE_DEVICE ) );
            icons.put( HADeviceTreeNode.SERVICE, loadIcon( HADeviceTreeNode.SERVICE ) );
            icons.put( HADeviceTreeNode.ZCL_COMMAND, loadIcon( HADeviceTreeNode.ZCL_COMMAND ) );
            icons.put( HADeviceTreeNode.ZCL_ATTRIBUTE, loadIcon( HADeviceTreeNode.ZCL_ATTRIBUTE ) );
            icons.put( HADeviceTreeNode.HA_EVENT, loadIcon( HADeviceTreeNode.HA_EVENT ) );
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
    
    public JToolTip createToolTip() {
        JToolTip tip = super.createToolTip();
        tip.setBackground(Color.yellow);
        return tip;
    }

	//test to display animated gif
	/* 
	 public boolean imageUpdate(Image img, int infoflags,
		       int x, int y, int width, int height){
	       	//System.out.println("image update");
	        Mediator.getUPnPDeviceTree().validate();
	        Mediator.getUPnPDeviceTree().repaint();
	        return true;
	   }
	 */

	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		Icon icon = selectIcon((HADeviceTreeNode) value);
        setToolTip((HADeviceTreeNode) value);
		if (icon != null) {
			setOpenIcon(icon);
			setClosedIcon(icon);
			setLeafIcon(icon);
		} else {
			setOpenIcon(getDefaultOpenIcon());
			setClosedIcon(getDefaultClosedIcon());
			setLeafIcon(getDefaultLeafIcon());
		}
		return super.getTreeCellRendererComponent(tree, value, sel, expanded,
				leaf, row, hasFocus);
	}
	
    public Icon selectIcon(HADeviceTreeNode node) {
        Icon icon = null;
        try {
                String tag = node.category;
                icon = (Icon) icons.get(tag);
        } catch (Exception ex) {
            System.out.println("getTreeCellRendererComponent Exception:" + ex);
        }
        return icon;
    }
    
    public void setToolTip(HADeviceTreeNode node) {
        String tag = node.category;
        if (tag.equals(HADeviceTreeNode.HA_DEVICE) )
        {
            DeviceNode device = (DeviceNode) node.getUserObject();
            setToolTipText("<html><TABLE BORDER='0' CELLPADDING='0' CELLSPACING='0' ><TR BGCOLOR='#F9FF79' ><TD>" 
                    + device.getReference().getProperty(HADevice.HA_DEVICE_NAME).toString()
                    +"</TD></TR></TABLE ></html>");
        } 
        else if ( tag.equals(HADeviceTreeNode.ZIGBEE_DEVICE) )
        {
            ServiceReference sr = (ServiceReference) node.getUserObject();
            setToolTipText("<html><TABLE BORDER='0' CELLPADDING='0' CELLSPACING='0' ><TR BGCOLOR='#F9FF79' ><TD>" 
                    + sr.getProperty( ZigBeeDevice.UUID ) 
                    +"</TD></TR></TABLE ></html>");
        }
        else
        {
            setToolTipText(null);
        }
     }
	
    public  static ImageIcon loadIcon(String name)
    {
        try {
            URL eventIconUrl = HADeviceTreeNode.class.getResource("IMAGES/" + name + ".gif");           
            return new ImageIcon(eventIconUrl,name);
        } catch (Exception ex) {
            System.out.println("Resource:" + name + " not found : " + ex.toString());
            return null;
        }
    }

}
