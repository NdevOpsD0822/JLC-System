package com.ndevopssolution.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * 
 * @FileName ButtonListener.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/15/2018
 */
public class ButtonListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Save") {
			JOptionPane.showMessageDialog(null, "YOU CLICK SAVE",null, JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
