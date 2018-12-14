package com.ndevopssolution.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MemberDetailForm extends JInternalFrame {
	private JTextField memberIDBx;
	private JTextField firstNameBx;
	private JTextField lastNameBx;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDetailForm frame = new MemberDetailForm();
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
	public MemberDetailForm() {
		setMaximizable(true);
		setTitle("New Member");
		setClosable(true);
		setBounds(100, 100, 642, 562);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Member Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 11, 606, 316);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMemberid = new JLabel("MemberID");
		lblMemberid.setBounds(10, 32, 74, 14);
		panel_1.add(lblMemberid);
		
		memberIDBx = new JTextField();
		lblMemberid.setLabelFor(memberIDBx);
		memberIDBx.setEditable(false);
		memberIDBx.setBounds(94, 29, 129, 20);
		panel_1.add(memberIDBx);
		memberIDBx.setColumns(10);
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setBounds(10, 57, 74, 14);
		panel_1.add(lblFirstname);
		
		firstNameBx = new JTextField();
		lblFirstname.setLabelFor(firstNameBx);
		firstNameBx.setBounds(94, 54, 129, 20);
		panel_1.add(firstNameBx);
		firstNameBx.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setBounds(10, 82, 74, 14);
		panel_1.add(lblLastname);
		
		lastNameBx = new JTextField();
		lastNameBx.setColumns(10);
		lastNameBx.setBounds(94, 79, 129, 20);
		panel_1.add(lastNameBx);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 107, 74, 14);
		panel_1.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(94, 104, 129, 20);
		panel_1.add(comboBox);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 132, 74, 14);
		panel_1.add(lblStatus);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married"}));
		comboBox_1.setBounds(94, 129, 129, 20);
		panel_1.add(comboBox_1);
		
		JLabel lblAddress = new JLabel("Address1");
		lblAddress.setBounds(319, 32, 74, 14);
		panel_1.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address2");
		lblAddress_1.setBounds(319, 57, 74, 14);
		panel_1.add(lblAddress_1);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(319, 82, 74, 14);
		panel_1.add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(319, 107, 74, 14);
		panel_1.add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setBounds(319, 132, 74, 14);
		panel_1.add(lblPostalCode);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(319, 157, 74, 14);
		panel_1.add(lblCountry);
		
		textField = new JTextField();
		textField.setBounds(403, 29, 140, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(403, 54, 140, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(403, 79, 140, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(403, 104, 140, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(403, 129, 140, 20);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(403, 154, 140, 20);
		panel_1.add(textField_5);

	}
}
