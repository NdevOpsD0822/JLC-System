package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

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
		setBounds(0, 0, 981, 742);
		
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
