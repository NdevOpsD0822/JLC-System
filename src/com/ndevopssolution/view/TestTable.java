package com.ndevopssolution.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.PropertyChangeEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;

public class TestTable extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTable frame = new TestTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestTable() {
		
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(100, 100, 549, 432);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFocusCycleRoot(true);
		textField.setBounds(24, 42, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.requestFocus();
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 42, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFocusCycleRoot(true);
		textField_2.setBounds(24, 79, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(24, 124, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(204, 79, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(24, 155, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(204, 124, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		/*setFocusTraversalPolicy(getFocusTraversalPolicy());
		
		System.out.println(getFocusTraversalPolicy().getFirstComponent(textField));*/
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane()}));

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
}
