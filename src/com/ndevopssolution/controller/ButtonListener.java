package com.ndevopssolution.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ndevopssolution.view.MemberForm;

/**
 * 
 * @FileName ButtonListener.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * @Created on Dec/16/2018
 */
public class ButtonListener implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Save." + MemberForm.getClassName())) {
			System.out.println("Save button was pressed");
		} else if(e.getActionCommand().equals("Close." + MemberForm.getClassName())) {
			System.out.println(MemberForm.getClassName());
		}
	}

}
