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

import it.cnr.isti.zigbee.api.ZigBeeBasedriverTimeOutException;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Hashtable;

import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import org.persona.zigbee.tester.gui.Command.CommandParsingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.util.ByteUtils;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.3.0
 */
public class CommandActionPanel extends JPanel {
	
	final static Logger logger = LoggerFactory.getLogger(CommandActionPanel.class);
	
	Command action;
	ArgumentsModel argsModel;
	MyTable table; 
	JPanel buttonPanel;
	
	JTextField result; 
	
	JScrollPane tablePanel;
	JScrollPane resultPanel;
	
	public CommandActionPanel() {
		super(new GridBagLayout());
		buildButtonPanel();
		buildTable();
		tablePanel = new JScrollPane(table);
		resultPanel = new JScrollPane(result);
		add(tablePanel,Util.setConstrains(0,0,1,1,100,100));
		add(resultPanel,Util.setConstrains(0,1,1,1,1,1)); 
		add(buttonPanel,Util.setConstrains(0,2,1,1,1,1));
	}

	private void buildButtonPanel(){
		buttonPanel = new JPanel();
		JButton doAction = new JButton("Execute Specific Cluster Command");
		doAction.addActionListener(new AbstractAction(){
			public void actionPerformed(ActionEvent e) {

				String[] params = null;
				if (argsModel.getRowCount()!= 0){
					if (table.isEditing()) table.getCellEditor().stopCellEditing();
					params = new String[argsModel.getRowCount()];
					for (int i = 0; i < argsModel.getRowCount(); i++){
						params[i] = (String) argsModel.getValueAt(i,1);
					}
				}
				try {
					Object returned = action.invoke(params);
					showActionResult(returned);
				} catch (CommandParsingException ex) {
					ByteArrayOutputStream bof = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(bof);
					ps.println(
							"No cluster sent on the, because I was not able to handle the parameter " + 
							argsModel.getValueAt(ex.index, 0)+" with value '"+ex.value+"' "
					);
					ps.println("More dettails on the issue:");
					ex.printStackTrace(ps);
					ps.close();
                    printReport(params,bof.toString());
				} catch (InvocationTargetException ex){
					ByteArrayOutputStream bof = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(bof);
					if( ex.getTargetException() instanceof ZigBeeHAException) {
						ZigBeeHAException haex = (ZigBeeHAException) ex.getTargetException();
						if ( haex.getCause() instanceof ZigBeeBasedriverTimeOutException ) {
							ps.println("Command cluster sent correctly but no answer from the device");
							ps.println("More dettails on the issue:");
							ex.getTargetException().printStackTrace(ps);
						}							
					} else {
						ex.getTargetException().printStackTrace(ps);
					}
					ps.flush();
					ps.close();
                    printReport(params,bof.toString());                   
				} catch (Exception ex){
					ByteArrayOutputStream bof = new ByteArrayOutputStream();
					PrintStream ps = new PrintStream(bof);
					ex.printStackTrace(ps);
					ps.close();
                    printReport(params,bof.toString());
				}
			}
			
            private void showActionResult(Object returned) {
				if ( returned == null ) {
					result.setText("Invokation successed without error, but without return values");
					return;
				}
				final Class clz = returned.getClass();
				if ( clz.isPrimitive() || clz == String.class ){
					result.setText(returned.toString());
				} else if ( returned instanceof Response){
					Response r = (Response) returned;
					String str = r.toString();
					try {
						final Class clzToString = clz.getMethod("toString").getDeclaringClass();
						if ( clzToString == Object.class || clzToString == ResponseImpl.class) {
							//TODO A default response to String in a ResponseBase class or Response.stringValueOf(Response) should be provided
							str = "The response object do not provide any String representation of itself\n";
							str += "Trying to guess the actual content\n";				
						}
						str += "{\n";
						final Method[] methods = clz.getMethods();
						for (int i = 0; i < methods.length; i++) {
							final String name = methods[i].getName();
							if( methods[i].getParameterTypes().length == 0 && name.startsWith("get") ){
								try {
									str+="\t"+name.substring(3)+":"+methods[i].invoke(r, new Object[]{})+"\n";
								}catch(Exception ignored){
									logger.debug("Failed to inspect response packet", ignored);
								};
							}
						}
						str += "}\n";
					} catch (Exception ex) {
						logger.debug("Failed to convert response to string", ex);
					}
					result.setText(
							"Invokation successed, the raw response payload is \n" +
							ByteUtils.toBase16( r.getPayload() ) + "\n" +
							"String representaion of the response is:\n" + str
					);
				} else { 
					result.setText("Invokation successed without error, but unknown return type "+returned.getClass()+" ["+returned.toString()+"]");
				}
			}

			private void printReport(String[] params,Object result) {
                String input = "";
                String output = "";
                if (params != null) input = Arrays.toString(params);
                if (result != null) output = result.toString();
                String method = action.getName();
                String report = "\n==== Action:: " + method + " ====\n"
                                + input 
                                + "\n----------- result ----------\n"
                                + output
                                + "\n-----------------------------";
               LogPanel.log(report);
            }
		});		
	    buttonPanel.add(doAction);
	}
	
	private void buildTable(){
		argsModel = new ArgumentsModel();
	    table = new MyTable(argsModel); 
		argsModel.setTable(table); 		

	    result = new JTextField(""); 
	}

	public void setCommand(Command action){
		this.action = action;
		argsModel.setData(action);
		tablePanel.setVisible( action.getInputParameters().length != 0 );
		result.setText("");
		validate();
		repaint();
	}
	
}

//thanks to Thomas Wagner 12/10/2005
class ArgumentsModel extends  AbstractTableModel {
	int size = 0;
	private MyTable table;	
    String[] types = new String[]{""};
    String[] values = new String[]{""};
	String[] header = new String[]{"Java Type","Value"};
   
	public void setTable(MyTable table) { 
		this.table = table;
	}
 
	public int getColumnCount() { return 2; }
    public int getRowCount() { return size;}
    public String getColumnName(int col) { return header[col]; }
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    	return (columnIndex ==1);
    }
    public Object getValueAt(int row, int col) { 
    	if (col == 0) return types[row];
        else if (col == 1) return values[row];
    	return null;
	}   
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	values[rowIndex]= (String) aValue; 
    }

    public void setData(Command  action){

		table.deleteMyCellEditors();
   	    size = 0;
    	this.types = action.getInputParameters();
    	if (types!=null){
	    	values = new String[types.length];
	    	for (int i=0;i<types.length;i++) {
                values[i]="";
            }   	
	    	size = types.length;
    	}
		this.fireTableChanged(new TableModelEvent(this));
        this.fireTableStructureChanged();
    }
}

// thanks to Thomas Wagner 12/10/2005
class MyTable extends JTable { 

	private Hashtable cellEditors;
	
	public MyTable(TableModel dm) {
		super(dm);
		cellEditors = new Hashtable();
	}

	public void setMyCellEditor(TableCellEditor editor,int col){
		cellEditors.put(new Integer(col),editor);
	}

	public void deleteMyCellEditors(){
		cellEditors.clear();
	}

	//overwritten JTable method	
	public TableCellEditor getCellEditor(int row,int col) {
		TableCellEditor tce = (TableCellEditor) cellEditors.get(new Integer(row));
		if( tce != null) {
			return tce;
		} else {
			return super.getCellEditor(row,col);
		}
	}
}

class SliderEditor extends AbstractCellEditor implements TableCellEditor
{
    JPanel editor;
    JTextField text;
    JSlider slider;
    public SliderEditor(int min, int max, int value){
         editor = new JPanel(new BorderLayout());
         //editor.setBorder(new EmptyBorder(1,0,1,0));
         text = new JTextField(Integer.toString(max).length());
         slider = new JSlider(SwingConstants.HORIZONTAL,min,max,value);
         editor.add(text,BorderLayout.WEST);
         editor.add(slider);
         slider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                //if (! replSlider.getValueIsAdjusting()){
                text.setText(new Integer(slider.getValue()).toString());
                //}
            }
         });

    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        text.setText((String) value);
        try {
            slider.setValue(Integer.parseInt((String)value));
        } catch (NumberFormatException ignored) {}
        return editor;
    }

    public Object getCellEditorValue() {
        return text.getText();
    }
}

