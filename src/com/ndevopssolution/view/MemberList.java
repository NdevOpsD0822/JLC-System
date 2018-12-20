package com.ndevopssolution.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class MemberList extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberList frame = new MemberList();
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
	public MemberList() {
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(100, 100, 697, 570);

	}

}
