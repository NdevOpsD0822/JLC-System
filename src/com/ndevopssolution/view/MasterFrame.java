package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
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
	private static DesktopFrame deskPane;

	/**
	 * Default constructor
	 */
	public MasterFrame() {
		super("Jesus Lighthouse Church");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
		setIconImage(new ImageIcon("resources/icons/app_logo.png").getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		deskPane = new DesktopFrame();
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.02);
		
		JScrollPane scrollPane = new JScrollPane(deskPane);
		scrollPane.setAutoscrolls(true);
		deskPane.setAutoscrolls(true);
		
		splitPane.setLeftComponent(new SideMenu());
		splitPane.setRightComponent(scrollPane);
		
		
		contentPane.add(splitPane, BorderLayout.CENTER);
	}
	/**
	 * @param args - arguments to be pass when run in commandline
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
		MasterFrame frame = new MasterFrame();
		frame.setVisible(true);
	}
	
	public static void addInternalFrame(JInternalFrame frame) {
		deskPane.add(frame);
	}
	
	public static Dimension getDims() {
		return deskPane.getSize();
	}

}
