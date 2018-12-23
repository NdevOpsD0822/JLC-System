package com.ndevopssolution.view;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTable;
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
public class MemberListTable extends JTable {
	
	private static final long serialVersionUID = 1L;
	private static DefaultTableModel tableModel;

	public MemberListTable() {
		super(buildTableModel(MemberUtil.getMembersList()));
		
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
		            if(columnIndex == 8) {
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

}
