package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import com.ndevopssolution.controller.ButtonListener;
import com.ndevopssolution.util.Comp;
import com.toedter.calendar.JDateChooser;

/**
 * 
 * @FileName MemberForm.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/15/2018
 */
public class MemberForm extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, toolBarPanel;
	private JToolBar toolBar;
	private JTextField memberIDField, firstnameField, lastnameField, phoneField, emailField;
	private JTextField address1Field, address2Field, cityField, stateField, postalCodeField, countryField;
	private JTextArea memoField;
	private JComboBox genderField, statusField;
	private JDateChooser birthdateField;
	private ButtonListener listener = new ButtonListener();
	private Dimension btnSize = new Dimension(64,64);
	
	
	public MemberForm(String title) {
		super(title);
		setBounds(0, 0, 613, 746);
		setClosable(true);
		init();
	}
	
	private void init() {
		
		/*initialize the content pane of the internal frame 
		with NORTH, EAST, WEST, and SOUTH placement of the components.*/
		contentPane = new JPanel(new BorderLayout(1,1));
		
		/*Set the toolBar panel to have a FlowLayout to align them horizontally
		from left to right.*/
		toolBarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 1));
		
		/*Setting the toolBar*/
		toolBar = new JToolBar(JToolBar.HORIZONTAL);
		toolBar.setLayout(new BorderLayout());
		toolBar.setFloatable(false);
		toolBar.add(toolBarPanel, BorderLayout.CENTER);
		
		toolBarPanel.add(Comp.createBtn(new JButton(), "Save", btnSize, null, listener));
		toolBarPanel.add(Comp.createBtn(new JButton(), "Close", btnSize, null, listener));
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		
		
		setContentPane(contentPane); //set the content pane of the internal frame
		
		
	}
	

}
