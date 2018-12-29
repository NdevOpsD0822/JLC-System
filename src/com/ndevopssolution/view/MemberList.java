package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import com.ndevopssolution.util.Comp;

public class MemberList extends JInternalFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTable memberList;
	private final Dimension btnSize = new Dimension(60,60);

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
		setClosable(true);
		setBounds(0, 0, 780, 640);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		try {
			memberList = new MemberListTable();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
		
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
		
		panel_1.add(Comp.createBtn(new JButton(), "New Member", btnSize, "resources/icons/32x32/newMember.png", this));
		panel_1.add(Comp.createBtn(new JButton(), "Edit", btnSize, "resources/icons/32x32/edit.png", this));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MemberForm member = new MemberForm("New Member");
		member.setVisible(true);
		MasterFrame.addInternalFrame(member);
		try {
			member.setSelected(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
