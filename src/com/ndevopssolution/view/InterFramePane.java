package com.ndevopssolution.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDesktopPane;

/**
 * 
 * @FileName InterFramePane.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/09/2018
 */
public class InterFramePane extends JDesktopPane {

	private static final long serialVersionUID = 1L;
	
	public InterFramePane() {
		setBackground(Color.darkGray);
	}
	
	public static Dimension getDims() {
		return new Dimension(WIDTH, HEIGHT);
	}
	
}
