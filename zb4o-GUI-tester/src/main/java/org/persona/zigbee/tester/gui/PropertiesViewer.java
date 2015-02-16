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



import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;


/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class PropertiesViewer extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3181670269001968195L;
	AttributeActionPanel attributePanel;
    CommandActionPanel commandPanel;
    HAEventActionPanel eventPanel;
	DataModel dataModel;
	JTable table;
	
	public PropertiesViewer(){
		super(new GridBagLayout());
		buildTable();
		attributePanel = new AttributeActionPanel();
		commandPanel = new CommandActionPanel();
		eventPanel = new HAEventActionPanel();
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(500,200));
		//commandPanel.setPreferredSize(new Dimension(500,200)); 
		attributePanel.setPreferredSize(new Dimension(500,200));
		add(scroll,Util.setConstrains(0,0,6,2,100,50));
		add(attributePanel,Util.setConstrains(0,2,6,1,100,10));
		add(commandPanel,Util.setConstrains(0,3,6,1,100,100));
		add(eventPanel,Util.setConstrains(0,4,6,1,100,100));
		showAttrbutePanel(false);
		showCommandPanel(false);
		showHAEventPanel(false);
        table.addMouseMotionListener(new MouseMotionListener(){
           private final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
           
           public void mouseDragged(MouseEvent e) {}
           public void mouseMoved(MouseEvent e) {
                String link = getDataLink(e.getPoint());
                if (link != null)
                    table.setCursor(handCursor);                       
                else
                    table.setCursor(Cursor.getDefaultCursor());
           }

        });
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                String link = getDataLink(e.getPoint());
                if (link != null)
                    Util.openUrl(link);              
            }
        });

    }   
        
    public String getDataLink(Point p) {
//        int col = table.columnAtPoint(p);
//        if (col != 1) 
//            return null;
//        else {
//            int row = table.rowAtPoint(p);
//            String data = (String) dataModel.getValueAt(row,col);
//            if (data == null) return null;
//            if (data.length()<4) return null;
//            String begin = data.substring(0,4);
//            if (begin.equalsIgnoreCase("http"))
//                return data;
//            else {
//                String propertyName= (String) dataModel.getValueAt(row,0);
//                if (propertyName.equalsIgnoreCase(UPnPDevice.PRESENTATION_URL)
//                    ||propertyName.equalsIgnoreCase(UPnPDevice.MANUFACTURER_URL)
//                    ||propertyName.equalsIgnoreCase(UPnPDevice.MODEL_URL) )
//                    {
//                    JTree tree = Mediator.getUPnPDeviceTree();
//                    HADeviceTreeNode selectedNode = (HADeviceTreeNode)tree.getLastSelectedPathComponent();   
//                    String url = "";
//                    if (selectedNode.category.equals(HADeviceTreeNode.DEVICE)){
//                        HADeviceTreeNode parent =  (HADeviceTreeNode)selectedNode.getParent();
//                        while (parent.category!=HADeviceTreeNode.ROOT_DEVICE)
//                             parent =  (HADeviceTreeNode)parent.getParent();
//                        DeviceNode device =  (DeviceNode) parent.getUserObject();
//                        String udn = (String)device.getReference().getProperty(UPnPDevice.UDN);
//                        url = Mediator.getDriverProxy().resolveRelativeUrl(udn,data);
//                        return url;
//                    }                           
//                    else if (selectedNode.category.equals(HADeviceTreeNode.ROOT_DEVICE))
//                    {
//                        DeviceNode node =  (DeviceNode) selectedNode.getUserObject();
//                        String udn = (String)node.getReference().getProperty(UPnPDevice.UDN);
//                        url = Mediator.getDriverProxy().resolveRelativeUrl(udn,data);
//                        return url;
//                    }
//                }
//                return null;     
//            }
//        }
    	return null;
	}
	
	public void setProperties(String[]name,String[]values){
		dataModel.setData(name,values);
	}
	
	public void setAction(Command action){
		commandPanel.setCommand(action);
	}
	
	public void setAttributeAction(HADevice device, Attribute action){
		attributePanel.setAttribute(device, action);
	}
	
	public void showAttrbutePanel(boolean show){
		attributePanel.setVisible(show);
	}
	
	
	public void showCommandPanel(boolean show){
	    commandPanel.setVisible(show);
	}
	
	public void showHAEventPanel(boolean show){
	    eventPanel.setVisible(show);
	}
	
	public void setHAEvent(HAEvent event){
		eventPanel.setHAEvent(event);
	}
	
	private void buildTable(){
		dataModel = new DataModel();
	    table = new JTable(dataModel);
        table.setDefaultRenderer(table.getColumnClass(1), new LinkCellRenderer());
	}


}

class DataModel extends  AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2094592918201988677L;
	int size = 0;
	String[] names = new String[]{""};
	String[] values = new String[]{""};
    String[] header = new String[]{"property key","value"};
    
    public String getColumnName(int col) { return header[col]; }
	public int getColumnCount() { return 2; }
    public int getRowCount() { return size;}
    public Object getValueAt(int row, int col) { 
    	if (col==0) return names[row];
    	else return values[row];
    }
    
    /*
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    */
    
    public void setData(String[]names,String[]values){
    	this.names=names;
    	this.values=values;
    	size = names.length;
		this.fireTableChanged(new TableModelEvent(this));
    }
    
}

class LinkCellRenderer extends DefaultTableCellRenderer
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 123271155225735344L;

	public LinkCellRenderer(){
        super();
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        if (column==1){
            String propertyName = (String)table.getModel().getValueAt(row,0);
//            if (propertyName.equalsIgnoreCase(UPnPDevice.PRESENTATION_URL)
//                ||propertyName.equalsIgnoreCase(UPnPDevice.MODEL_URL)
//                ||propertyName.equalsIgnoreCase(UPnPDevice.MANUFACTURER_URL))
//            {
//                if (!value.equals(""))
//                    setValue("<html><a href=''>"+value+"</a></html>");
//                return this;
//            }
            
            if (((String) value).length()<4) return this;
            String begin = ((String) value).substring(0,4);
            if (begin.equalsIgnoreCase("http"))
                setValue("<html><a href=''>"+value+"</a></html>");
        }
        return this;
    }
 
}

