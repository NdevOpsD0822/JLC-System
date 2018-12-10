package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @FileName MasterFrame.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/09/2018
 */

public class MasterFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Default constructor
	 */
	public MasterFrame() {
		super("Jesus Lighthouse Church");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.10);
		
		splitPane.setLeftComponent(new SideMenu());
		splitPane.setRightComponent(new InterFramePane());
		
		contentPane.add(splitPane, BorderLayout.CENTER);
	}
	/**
	 * @param args - arguments to be pass when run in commandline
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MasterFrame frame = new MasterFrame();
		frame.setVisible(true);
	}

}
