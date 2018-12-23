package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class MemberList extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable memberList;

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
		super("Member List");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setBounds(0, 0, 780, 640);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		memberList = new MemberListTable();
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(memberList);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setLayout(new BorderLayout());
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toolBar.add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_1.add(btnNewButton_3);

	}

}
