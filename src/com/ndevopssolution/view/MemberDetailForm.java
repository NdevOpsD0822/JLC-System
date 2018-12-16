package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.toedter.calendar.JDateChooser;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class MemberDetailForm extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField memberIDField;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField address1Field;
	private JTextField address2Field;
	private JTextField cityField;
	private JTextField provinceField;
	private JTextField postalCodeField;
	private JTextField countryField;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 613, 746);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Member Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 36, 585, 190);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMemberID = new JLabel("MemberID");
		lblMemberID.setBounds(10, 32, 74, 14);
		panel_1.add(lblMemberID);
		
		memberIDField = new JTextField();
		memberIDField.setText("(Auto Generated)");
		memberIDField.setEnabled(false);
		memberIDField.setMinimumSize(new Dimension(8, 20));
		lblMemberID.setLabelFor(memberIDField);
		memberIDField.setBounds(94, 29, 172, 20);
		panel_1.add(memberIDField);
		memberIDField.setColumns(10);
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setBounds(10, 57, 74, 14);
		panel_1.add(lblFirstname);
		
		firstnameField = new JTextField();
		lblFirstname.setLabelFor(firstnameField);
		firstnameField.setBounds(94, 54, 172, 20);
		panel_1.add(firstnameField);
		firstnameField.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setBounds(10, 82, 74, 14);
		panel_1.add(lblLastname);
		
		lastnameField = new JTextField();
		lastnameField.setColumns(10);
		lastnameField.setBounds(94, 79, 172, 20);
		panel_1.add(lastnameField);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 107, 74, 14);
		panel_1.add(lblGender);
		
		JComboBox<String> genderField = new JComboBox<String>();
		genderField.setBackground(Color.WHITE);
		genderField.setModel(new DefaultComboBoxModel<String>(new String[] {"Male", "Female"}));
		genderField.setBounds(94, 104, 172, 20);
		panel_1.add(genderField);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 132, 74, 14);
		panel_1.add(lblStatus);
		
		JComboBox<String> statusField = new JComboBox<String>();
		statusField.setModel(new DefaultComboBoxModel<String>(new String[] {"Single", "Married"}));
		statusField.setBounds(94, 129, 172, 20);
		panel_1.add(statusField);
		
		JLabel lblAddress1 = new JLabel("Address1");
		lblAddress1.setBounds(319, 32, 74, 14);
		panel_1.add(lblAddress1);
		
		JLabel lblAddress2 = new JLabel("Address2");
		lblAddress2.setBounds(319, 57, 74, 14);
		panel_1.add(lblAddress2);
		
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
		
		address1Field = new JTextField();
		address1Field.setBounds(403, 29, 172, 20);
		panel_1.add(address1Field);
		address1Field.setColumns(10);
		
		address2Field = new JTextField();
		address2Field.setColumns(10);
		address2Field.setBounds(403, 54, 172, 20);
		panel_1.add(address2Field);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(403, 79, 172, 20);
		panel_1.add(cityField);
		
		provinceField = new JTextField();
		provinceField.setColumns(10);
		provinceField.setBounds(403, 104, 172, 20);
		panel_1.add(provinceField);
		
		postalCodeField = new JTextField();
		postalCodeField.setColumns(10);
		postalCodeField.setBounds(403, 129, 172, 20);
		panel_1.add(postalCodeField);
		
		countryField = new JTextField();
		countryField.setColumns(10);
		countryField.setBounds(403, 154, 172, 20);
		panel_1.add(countryField);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 157, 74, 14);
		panel_1.add(lblBirthDate);
		
		JDateChooser birthDateField = new JDateChooser();
		birthDateField.setBounds(94, 154, 172, 20);
		panel_1.add(birthDateField);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 397, 585, 309);
		panel.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Contributions", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "1", "2018/12/16", "Tithes", new Integer(50)},
			},
			new String[] {
				"TransactionID", "BatchID", "Transaction Date", "Compaign Name", "Amount"
			}
		) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(72);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(72);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(122);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(127);
		table.getColumnModel().getColumn(4).setResizable(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(null);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Family Members", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Primary Contacts", null, panel_4, null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 595, 36);
		panel.add(toolBar);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toolBar.add(panel_6);
		
		JButton btnNewButton = new JButton("Save");
		panel_6.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save & Close");
		panel_6.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		panel_6.add(btnNewButton_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "Additional Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 237, 585, 135);
		panel.add(panel_5);
		
		JLabel label = new JLabel("Phone");
		label.setBounds(10, 30, 74, 14);
		panel_5.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 27, 172, 20);
		panel_5.add(textField);
		
		JLabel label_1 = new JLabel("Email");
		label_1.setBounds(319, 30, 74, 14);
		panel_5.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(403, 27, 172, 20);
		panel_5.add(textField_1);
		
		JTextArea textArea = new JTextArea();
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea);
		scrollPane_1.setBounds(10, 69, 565, 55);
		panel_5.add(scrollPane_1);
		
		JLabel label_2 = new JLabel("Memo/Notes:");
		label_2.setBounds(10, 55, 565, 14);
		panel_5.add(label_2);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{memberIDField, firstnameField, lastnameField, genderField, statusField, birthDateField, address1Field, address2Field, cityField, provinceField, postalCodeField, countryField}));

	}
}
