package com.ndevopssolution.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @FileName Comp.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/15/2018
 */
public class Comp {
	
	public static JButton createBtn(JButton button, String text, String iconLoc, ActionListener listener) {
		button = new JButton();
		button.addActionListener(listener);
		button.setActionCommand(text);
		
		if(iconLoc != null) {
			button.setIcon(new ImageIcon(iconLoc));
			button.setToolTipText(text);
		} else {
			button.setText(text);
		}
		
		return button;
	}
	
	public static JButton createBtn(JButton button, String text, int width, int height, String iconLoc, ActionListener listener) {
		button = createBtn(button, text, iconLoc, listener);
		button.setPreferredSize(new Dimension(width,height));
		
		return button;
	}
	
	public static JButton createBtn(JButton button, String text, Dimension size, String iconLoc, ActionListener listener) {
		button = createBtn(button, text, size.width, size.height, iconLoc, listener);
		return button;
	}
	
	public static JLabel createLbl(JLabel objLabel, String txtLabel, int x, int y, Dimension size) {
		objLabel = new JLabel(txtLabel);
		objLabel.setFont(new Font("Arial",Font.PLAIN, 13));
		objLabel.setBounds(x, y, size.width, size.height);
		
		return objLabel;
	}
	
	public static JTextField createTxtField(JTextField txtField, int x, int y, Dimension size) {
		txtField = new JTextField();
		txtField.setBounds(x, y, size.width, size.height);
		
		return txtField;
	}
	
	public static JTextField createTxtField(JTextField txtField, int x, int y, Dimension size, boolean enabled) {
		
		txtField = createTxtField(txtField, x, y, size);
		txtField.setEnabled(enabled);
		
		return txtField;
	}
	
	public static JTextArea createTxtArea(JTextArea textArea, int x, int y, Dimension size) {
		
		textArea = new JTextArea(5, 10);
		textArea.setLineWrap(true);
		textArea.setBounds(x, y, size.width, size.height);
		
		return textArea;
	}
	
	public static JComboBox<String> createComboBx(JComboBox<String> comboBx, int x, int y, Dimension size, String[] options) {
		
		comboBx = new JComboBox<String>();
		comboBx.setModel(new DefaultComboBoxModel<String>(options));
		comboBx.setBackground(Color.WHITE);
		comboBx.setBounds(x, y, size.width, size.height);
		
		return comboBx;
		
	}


}
