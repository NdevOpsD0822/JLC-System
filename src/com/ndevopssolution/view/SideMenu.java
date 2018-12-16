package com.ndevopssolution.view;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * 
 * @FileName SideMenu.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/09/2018
 */
public class SideMenu extends JTree implements TreeSelectionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	public SideMenu() {
		setFont(new Font("Arial", Font.PLAIN,16));
		setExpandsSelectedPaths(true);
		addTreeSelectionListener(this);
		addMouseListener(this);
		setModel(new TreeModel(new Node(), false));
		setRootVisible(false);
		setRowHeight(32);
		
		for(int i=0; i <this.getRowCount(); i++) {
			this.expandRow(i);
		}
	}
	
	private class TreeModel extends DefaultTreeModel {
		
		private static final long serialVersionUID = 1L;

		public TreeModel(TreeNode node) {
			super(node);
		}

		public TreeModel(TreeNode node, boolean allowChild) {
			super(node, allowChild);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	private class Node extends DefaultMutableTreeNode {
		
		private static final long serialVersionUID = 1L;
		String[] accounting = new String[] {
				"Income Transaction", "Expense Transaction", "Batch Transaction"
		};
		String[] members = new String[] {
				"New Member", "Update Member", "Member List"
		};
		String[] compaigns = new String[] {
				"New Compaign", "Manage Compaign", "Compaign List"
		};
		String[] ministries = new String[] {
				"New Ministry", "Manage Ministry", "Ministry List"
		};
		
		public Node() {
			super("JLC DASHBOARD");
			add(createNodes("ACCOUNTING", accounting));
			add(createNodes("MEMBERS", members));
			add(createNodes("MINISTRIES",ministries));
			add(createNodes("COMPAIGNS",compaigns));
		}
		
		private DefaultMutableTreeNode createNodes(String parentNodeLabel, String[] childNodeLabel) {
			DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(parentNodeLabel);
			for(String label : childNodeLabel) {
				DefaultMutableTreeNode child = new DefaultMutableTreeNode(label);
				parentNode.add(child);
			}
			
			return parentNode;
		}
		
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		String selectedNode = e.getNewLeadSelectionPath().getLastPathComponent().toString();
		//System.out.println(e.getOldLeadSelectionPath());
		if(e.getOldLeadSelectionPath() == null) {
			if(selectedNode.equalsIgnoreCase("new member")) {
				//MemberForm frame = new MemberForm("New Member");
				//frame.setVisible(true);
				//MasterFrame.addInternalFrame(frame);
			}
		} else {
			String previousNode = e.getOldLeadSelectionPath().getLastPathComponent().toString();
			System.out.println(previousNode + " -> " + selectedNode);
			if(selectedNode.equals(previousNode)) {
				JOptionPane.showMessageDialog(this, "You clicked the same node as before", null, JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int clickCount = e.getClickCount();
		TreePath tp = this.getLeadSelectionPath();
		//System.out.println(tp.getLastPathComponent().toString());
		if(tp != null && clickCount == 2) {
			String selectedNode = tp.getLastPathComponent().toString();
			if(selectedNode == "New Member") {
				//MemberDetailForm member = new MemberDetailForm();
				MemberForm member = new MemberForm("New Member");
				member.setVisible(true);
				MasterFrame.addInternalFrame(member);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	