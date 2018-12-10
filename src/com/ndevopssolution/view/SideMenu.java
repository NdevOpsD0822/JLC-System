package com.ndevopssolution.view;

import java.awt.Font;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 * 
 * @FileName SideMenu.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/09/2018
 */
public class SideMenu extends JTree {

	private static final long serialVersionUID = 1L;
	
	public SideMenu() {
		setFont(new Font("Tahoma", Font.BOLD,18));
		setExpandsSelectedPaths(true);
		setModel(new TreeModel(new Node(), false));
	}
	
	private class TreeModel extends DefaultTreeModel {
		
		public TreeModel(TreeNode node) {
			super(node);
		}

		public TreeModel(TreeNode node, boolean allowChild) {
			super(node, allowChild);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	private class Node extends DefaultMutableTreeNode {
		
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
}
	