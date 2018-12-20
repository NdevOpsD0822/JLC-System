package com.ndevopssolution.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JToolBar;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class TransactionEntry extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionEntry frame = new TransactionEntry();
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
	public TransactionEntry() {
		setClosable(true);
		setBounds(100, 100, 981, 742);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JPanel TransactionPanel = new JPanel();
		splitPane.setLeftComponent(TransactionPanel);
		TransactionPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel BatchTransactionPanel = new JPanel();
		splitPane.setRightComponent(BatchTransactionPanel);
		BatchTransactionPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 72));
		getContentPane().add(panel, BorderLayout.SOUTH);

	}
}
