package com.ndevopssolution.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.ndevopssolution.controller.ButtonListener;
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
public class MemberForm extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static final String className = "MemberForm";
	
	private final Dimension btnSize = new Dimension(60,60);
	private final Dimension txtSize = new Dimension(172,20);
	private final Dimension lblSize = new Dimension(74,20);
	
	private JPanel contentPane; 
	private JPanel toolBarPanel, centerPanel;
	private JPanel memberInfoPanel, contactInfoPanel;
	private JToolBar toolBar;
	private JTextField memberIDField, firstnameField, lastnameField, phoneField, emailField;
	private JTextField address1Field, address2Field, cityField, postalCodeField, countryField;
	private JTextArea memoField;
	private JComboBox<String> genderField, statusField, stateField;
	private JDateChooser birthdateField;
	private ButtonListener listener = new ButtonListener();
	
	
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
		
		toolBarPanel.add(Comp.createBtn(new JButton(), "Save", btnSize, "resources/icons/32x32/saveButton.png", listener,this.getClass().getSimpleName()));
		toolBarPanel.add(Comp.createBtn(new JButton(), "New Member", btnSize, "resources/icons/32x32/newMember.png", listener, this.getClass().getSimpleName()));
		toolBarPanel.add(Comp.createBtn(new JButton(), "Close", btnSize, "resources/icons/32x32/close.png", listener, this.getClass().getSimpleName()));
	}
	
	private void centerPanelInit() {
		
		TitledBorder titleBorder = new TitledBorder("Member Info");
		titleBorder.setTitleFont(new Font("Arial",Font.BOLD, 11));
		
		birthdateField = new JDateChooser();
		birthdateField.setBounds(94, 192, 172, 20);
		
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
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "MemberID", 12,32, lblSize));
		memberInfoPanel.add(Comp.createTxtField(memberIDField, 94, 32, txtSize, false));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Firstname", 12, 64, lblSize));
		memberInfoPanel.add(Comp.createTxtField(firstnameField, 94, 64, txtSize));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Lastname", 12, 96, lblSize));
		memberInfoPanel.add(Comp.createTxtField(lastnameField, 94, 96, txtSize));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Gender", 12, 128, lblSize));
		memberInfoPanel.add(Comp.createComboBx(genderField, 94, 128, txtSize, new String[] {"", "Male","Female"}));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Status", 12, 160, lblSize));
		memberInfoPanel.add(Comp.createComboBx(statusField, 94, 160, txtSize,new String[] {"", "Single","Maried"}));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Birth Date", 12, 192, lblSize));
		memberInfoPanel.add(birthdateField);
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Address1", 350, 32, lblSize));
		memberInfoPanel.add(Comp.createTxtField(address1Field, 432, 32, txtSize));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Address2", 350, 64, lblSize));
		memberInfoPanel.add(Comp.createTxtField(address2Field, 432, 64, txtSize));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "City", 350, 96, lblSize));
		memberInfoPanel.add(Comp.createTxtField(cityField, 432, 96, txtSize));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Province", 350, 128, lblSize));
		memberInfoPanel.add(Comp.createComboBx(stateField, 432, 128, txtSize, new String[] {"","AB","BC","MB","SK","ON","QC","NS","NB","NL","NS","NT","YT","NU"}));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Postal Code", 350, 160, lblSize));
		memberInfoPanel.add(Comp.createTxtField(postalCodeField, 432, 160, txtSize));
		
		memberInfoPanel.add(Comp.createLbl(new JLabel(), "Country", 350, 192, lblSize));
		memberInfoPanel.add(Comp.createTxtField(countryField, 432, 192, txtSize));
		
		centerPanel.add(memberInfoPanel);
		
		contactInfoPanel.add(Comp.createLbl(new JLabel(), "Phone", 12, 32, lblSize));
		contactInfoPanel.add(Comp.createTxtField(phoneField, 94, 32, txtSize));
		
		contactInfoPanel.add(Comp.createLbl(new JLabel(), "Email", 350, 32, lblSize));
		contactInfoPanel.add(Comp.createTxtField(emailField, 432, 32, txtSize));
		
		JScrollPane memoScrollPane = new JScrollPane(Comp.createTxtArea(memoField, 12, 90, new Dimension(620,100)));
		memoScrollPane.setBounds(12, 90, 590, 100);
		
		contactInfoPanel.add(Comp.createLbl(new JLabel(), "Memo/Notes:", 12, 64, new Dimension(120,20)));
		contactInfoPanel.add(memoScrollPane);
		
		centerPanel.add(contactInfoPanel);
	}
	
	public static String getClassName() {
		return className;
	}
	

}
