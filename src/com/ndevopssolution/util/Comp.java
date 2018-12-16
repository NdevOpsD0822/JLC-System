package com.ndevopssolution.util;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
		button = new JButton(text);
		button.addActionListener(listener);
		button.setActionCommand(text);
		
		if(iconLoc != null) {
			button.setIcon(new ImageIcon(iconLoc));
		}
		
		return button;
	}
	
	public static JButton createBtn(JButton button, String text, int width, int height, String iconLoc, ActionListener listener) {
		button = createBtn(button, text, iconLoc, listener);
		button.setPreferredSize(new Dimension(width,height));
		
		return button;
	}
	
	public static JButton createBtn(JButton button, String text, Dimension size, String iconLoc, ActionListener listener) {
		return createBtn(button, text, size.width, size.height, iconLoc, listener);
	}


}
