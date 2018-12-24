package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.ndevopssolution.controller.MemberUtil;
import com.ndevopssolution.util.Comp;
import com.toedter.calendar.JDateChooser;

/**
 * 
 * @FileName MemberForm.java
 *
 * @Project Name JLC-System
 * @author NDevOps
 * 
 * @Created on Dec/15/2018
 */
public class MemberForm extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final Dimension btnSize = new Dimension(60,60);
	private final Dimension txtSize = new Dimension(172,20);
	private final Dimension lblSize = new Dimension(74,20);
	
	private JPanel contentPane; 
	private JPanel toolBarPanel, centerPanel;
	private JPanel memberInfoPanel, contactInfoPanel;
	private JToolBar toolBar;
	private JTextField memberIDField, firstName, lastName, phone, email;
	private JTextField address1, address2, city, postalCode, country;
	private JTextArea memo;
	private JComboBox<String> gender, status, state;
	private JDateChooser birthDate;
	
	
	public MemberForm(String title) {
		super(title);
		setSize(660,570);
		setLocation(0, 0);
		setClosable(true);
		setFrameIcon(new ImageIcon("resources/icons/member.png"));
		init();
	}
	
	private void init() {
		
		/*initialize the content pane of the internal frame 
		with NORTH, EAST, WEST, and SOUTH placement of the components.*/
		contentPane = new JPanel(new BorderLayout(1,1));
		
		northPanelInit();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		centerPanelInit();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		
		setContentPane(contentPane); //set the content pane of the internal frame
		
		
	}
	
	
	/*This method is used to initialize all the components on northPanel of the contentPane such as:
		ToolBar, panel for buttons, and buttons.
	*/
	private void northPanelInit() {
		/*Set the toolBar panel to have a FlowLayout to align them horizontally
		from left to right.*/
		toolBarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 1));
		
		/*Components for toolBar that will be put into North section of contentPane*/
		toolBar = new JToolBar(JToolBar.HORIZONTAL);
		toolBar.setLayout(new BorderLayout());
		toolBar.setFloatable(false);
		toolBar.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		toolBar.add(toolBarPanel, BorderLayout.CENTER); //toolBarPanel is being used for proper placement of toolBar components
		
		toolBarPanel.add(Comp.createBtn(new JButton(), "Save", btnSize, "resources/icons/32x32/saveButton.png", this));
		toolBarPanel.add(Comp.createBtn(new JButton(), "New Member", btnSize, "resources/icons/32x32/newMember.png", this));
		toolBarPanel.add(Comp.createBtn(new JButton(), "Close", btnSize, "resources/icons/32x32/close.png", this));
	}
	
	private void centerPanelInit() {
		
		TitledBorder titleBorder = new TitledBorder("Member Info");
		titleBorder.setTitleFont(new Font("Arial",Font.BOLD, 11));
		
		centerPanel = new JPanel(null);
		
		memberInfoPanel = new JPanel(null);
		memberInfoPanel.setBorder(titleBorder);
		memberInfoPanel.setBounds(12, 10, 620, 236);
		
		contactInfoPanel = new JPanel(null);
		titleBorder = new TitledBorder("Additional Info");
		titleBorder.setTitleFont(new Font("Arial",Font.BOLD, 11));
		contactInfoPanel.setBorder(titleBorder);
		contactInfoPanel.setBounds(12, 250, 620, 210);
		
		//Adding components to memberInfoPanel
		memberIDField = Comp.createTxtField(memberIDField, 94, 32, txtSize, false);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "MemberID", 12,32, lblSize));
		memberInfoPanel.add(memberIDField);
		
		firstName = Comp.createTxtField(firstName, 94, 64, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Firstname", 12, 64, lblSize));
		memberInfoPanel.add(firstName);
		
		lastName = Comp.createTxtField(lastName, 94, 96, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Lastname", 12, 96, lblSize));
		memberInfoPanel.add(lastName);
		
		gender = Comp.createComboBx(gender, 94, 128, txtSize, new String[] {"", "Male","Female"});
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Gender", 12, 128, lblSize));
		memberInfoPanel.add(gender);
		
		status = Comp.createComboBx(status, 94, 160, txtSize,new String[] {"", "Single","Maried"});
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Status", 12, 160, lblSize));
		memberInfoPanel.add(status);
		
		birthDate = new JDateChooser();
		birthDate.setBounds(94, 192, 172, 20);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Birth Date", 12, 192, lblSize));
		memberInfoPanel.add(birthDate);
		
		address1 = Comp.createTxtField(address1, 432, 32, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Address1", 350, 32, lblSize));
		memberInfoPanel.add(address1);
		
		address2 = Comp.createTxtField(address2, 432, 64, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Address2", 350, 64, lblSize));
		memberInfoPanel.add(address2);
		
		city = Comp.createTxtField(city, 432, 96, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "City", 350, 96, lblSize));
		memberInfoPanel.add(city);
		
		state = Comp.createComboBx(state, 432, 128, txtSize, new String[] {"","AB","BC","MB","SK","ON","QC","NS","NB","NL","NS","NT","YT","NU"});
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Province", 350, 128, lblSize));
		memberInfoPanel.add(state);
		
		postalCode = Comp.createTxtField(postalCode, 432, 160, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Postal Code", 350, 160, lblSize));
		memberInfoPanel.add(postalCode);
		
		country = Comp.createTxtField(country, 432, 192, txtSize);
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Country", 350, 192, lblSize));
		memberInfoPanel.add(country);
		
		centerPanel.add(memberInfoPanel);
		
		phone = Comp.createTxtField(phone, 94, 32, txtSize);
		contactInfoPanel.add(Comp.createLbl(new JLabel(), "Phone", 12, 32, lblSize));
		contactInfoPanel.add(phone);
		
		email = Comp.createTxtField(email, 432, 32, txtSize);
		contactInfoPanel.add(Comp.createLbl(new JLabel(), "Email", 350, 32, lblSize));
		contactInfoPanel.add(email);
		
		memo = Comp.createTxtArea(memo, 12, 90, new Dimension(620,100));
		JScrollPane memoScrollPane = new JScrollPane(memo);
		memoScrollPane.setBounds(12, 90, 590, 100);
		
		contactInfoPanel.add(Comp.createLbl(new JLabel(), "Memo/Notes:", 12, 64, new Dimension(120,20)));
		contactInfoPanel.add(memoScrollPane);
		
		centerPanel.add(contactInfoPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getActionCommand().equals("Save")) {
			String memberID = firstName.getText().substring(0, 1).toUpperCase() + lastName.getText().substring(0, 1).toUpperCase() + newId;
			
			SimpleDateFormat birthDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			int record = MemberUtil.saveMember(memberID,firstName.getText(), lastName.getText(), gender.getSelectedItem().toString(), status.getSelectedItem().toString(), 
					birthDateFormat.format(birthDate.getDate()), address1.getText(), address2.getText(), city.getText(), state.getSelectedItem().toString(), postalCode.getText(), 
					country.getText(), phone.getText(), email.getText(), memo.getText());
			
			if(record == 1) {
				memberIDField.setText(memberID);
			}
		} else if(e.getActionCommand().equals("Close")) {
			this.dispose();
		}*/
		if(e.getActionCommand().equals("Save")) {
			if(isRequiredFieldsFilled()) {
				String lastLine = null;
				String newId = null;
				int id = 0;
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader("logs/log.id"));
					while((lastLine = reader.readLine()) != null) {
						id = Integer.parseInt(lastLine);
					}
					reader.close(); // close the BufferedReader to avoid memory leak
					newId = String.format("%05d", id + 1); //format the id with 5 digit
					
					File file = new File("logs/log.id"); //create a file object for the id logs
					FileWriter writer = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(writer);
					bw.write(newId + "\n");
					bw.close();
					
					String memberId = firstName.getText().substring(0, 1).toUpperCase() + lastName.getText().substring(0, 1).toUpperCase() + newId;
					
					if(getBirthDate() != null) {
						try {
							int record = MemberUtil.saveMember(memberId, firstName.getText(), lastName.getText(), gender.getSelectedItem().toString(), 
									status.getSelectedItem().toString(), getBirthDate(), address1.getText(), address2.getText(), city.getText(), 
									state.getSelectedItem().toString(), postalCode.getText(), country.getText(), phone.getText(), email.getText(), memo.getText());
							System.out.println(record);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						try {
							int record = MemberUtil.saveMember(memberId, firstName.getText(), lastName.getText(), gender.getSelectedItem().toString(), 
									status.getSelectedItem().toString(), address1.getText(), address2.getText(), city.getText(), 
									state.getSelectedItem().toString(), postalCode.getText(), country.getText(), phone.getText(), email.getText(), memo.getText());
							System.out.println(record);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					
					
				} catch(IOException ioe) {
					JOptionPane.showMessageDialog(null, ioe.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		} else if(e.getActionCommand().equals("New Member")) {
			if(getBirthDate() != null) {
				System.out.println(getBirthDate());
			}
			System.out.println(validateComboBox(state));
		}
	}
	
	private String getBirthDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM-dd-yyyy");
		if(birthDate != null && birthDate.getDate() != null) {
			return dateFormatter.format(birthDate.getDate());
		}
		
		return null;
	}
	
	private boolean validateComboBox(JComboBox<String> dropDown) {
		String strValue = null;
		if(dropDown != null && dropDown.getSelectedItem() != null) {
			strValue = dropDown.getSelectedItem().toString();
			if(strValue != null && !strValue.isEmpty()) {
				return true;
			}
		}
		
		return false;
	}
	
	private boolean isRequiredFieldsFilled() {
		
		if(firstName == null || firstName.getText().isEmpty()) {
			return false;
		} else if(lastName == null || lastName.getText().isEmpty()) {
			return false;
		}
		
		return true;
	}
	

}
