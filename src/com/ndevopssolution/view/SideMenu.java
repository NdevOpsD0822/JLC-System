package com.ndevopssolution.view;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		setFont(new Font("Tahoma", Font.BOLD,18));
		setExpandsSelectedPaths(true);
		addTreeSelectionListener(this);
		addMouseListener(this);
		setModel(new TreeModel(new Node(), false));
		setRootVisible(false);
		
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
				"New Compaign", "Manage Compaign", "Compaign List"
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
				parentNode.add(new DefaultMutableTreeNode(label));
			}
			
			return parentNode;
		}
		
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		String selectedNode = e.getNewLeadSelectionPath().getLastPathComponent().toString();
		if(selectedNode == "New Member") {
			/*NewMember member = new NewMember();
			member.setVisible(true);
			MasterFrame.addInternalFrame(member);*/
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int clickCount = e.getClickCount();
		TreePath tp = this.getLeadSelectionPath();
		if(tp != null && clickCount == 2) {
			String selectedNode = tp.getLastPathComponent().toString();
			if(selectedNode == "New Member") {
				MemberDetailForm member = new MemberDetailForm();
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
	