package com.ndevopssolution.view;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.ndevopssolution.controller.MemberUtil;

/**
 * 
 * @FileName MemberListTable.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/22/2018
 */
public class MemberListTable extends JTable implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tableModel;

	public MemberListTable() throws SQLException {
		super(buildTableModel(MemberUtil.getMembersList()));
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addMouseListener(this);
		
		getColumnModel().getColumn(0).setPreferredWidth(72);
		getColumnModel().getColumn(1).setPreferredWidth(130);
		getColumnModel().getColumn(2).setPreferredWidth(130);
		getColumnModel().getColumn(3).setPreferredWidth(120);
		getColumnModel().getColumn(4).setPreferredWidth(200);
		getColumnModel().getColumn(5).setPreferredWidth(56);
		getColumnModel().getColumn(6).setPreferredWidth(56);
		getColumnModel().getColumn(7).setPreferredWidth(120);
		getColumnModel().getColumn(8).setPreferredWidth(172);
		getColumnModel().getColumn(9).setPreferredWidth(96);
		getColumnModel().getColumn(10).setPreferredWidth(120);
		getColumnModel().getColumn(11).setPreferredWidth(56);
		getColumnModel().getColumn(12).setPreferredWidth(72);
		getColumnModel().getColumn(13).setPreferredWidth(96);
		getColumnModel().getColumn(14).setPreferredWidth(320);
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getTableHeader().setReorderingAllowed(false);
		setFont(new Font("Arial",Font.PLAIN,14));
		setRowHeight(24);
		
	}
	
	private static DefaultTableModel buildTableModel(ResultSet rs) {

	    ResultSetMetaData metaData;
		try {
			
			metaData = rs.getMetaData();
			// names of columns
		    Vector<String> columnNames = new Vector<String>();
		    int columnCount = metaData.getColumnCount();
		    for (int i = 1; i <= columnCount; i++) {
		    	String column = metaData.getColumnName(i);
		    	if(column.equalsIgnoreCase("DateOfBirth")) {
		    		columnNames.add("Birth Date");
		    	} else {
		    		columnNames.add(column);
		    	}
		    }
		    
		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (rs.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
		            if(columnIndex == 8 && rs.getDate(columnIndex) !=null) {
		            	//System.out.println(rs.getDate(columnIndex));
		            	SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		            	String formattedDate = dateFormat.format(rs.getDate(columnIndex));
		            	vector.add(formattedDate);
		            } else {
		            	vector.add(rs.getObject(columnIndex));
		            }
		        }
		        data.add(vector);
		    }

		    tableModel = new DefaultTableModel(data, columnNames) {
		    	private static final long serialVersionUID = 1L;

				@Override
		    	public boolean isCellEditable(int row, int column) {
		    		return false;
		    	}
		    };
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return tableModel;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int clickCount = e.getClickCount();
		if(clickCount == 2) {
			DefaultTableModel t = (DefaultTableModel)this.getModel();
			Object[] record = new Object[t.getColumnCount()]; 
			//String[] record = new String[t.getColumnCount()];
			for(int c = 0; c < t.getColumnCount(); c++) {
				record[c] = t.getValueAt(this.getSelectedRow(), c);
			}
			
			//System.out.println(record.length);
			for(int i=0; i < record.length; i++) {
				System.out.print(record[i].toString() + "\t");
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
