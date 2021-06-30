package student;

import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class Add implements ActionListener{
	
	JFrame frmAdd;
	JLabel lblHead,lblImg,lblId,lblName,lblFName,lblDob,lblDate,lblMonth,lblYear,lblGender,lblMStatus,lblAddress,lblPin,lblDist,lblState,lblReligion,lblCategory,lblEducation,lblAadhar,lblMobile,lblEmail;
	JTextField txtId,txtName,txtFName,txtAddress,txtPin,txtDist,txtState,txtAadhar,txtMobile,txtEmail;
//	JRadioButton radioMale,radioFemale,radioOther;
	JComboBox comboDate,comboMonth,comboYear,comboReligion,comboCategory,comboEducation,comboGender,comboMStatus;
	JButton btnNext,btnCheck,btnCancel,btnAddCourse,btnPhoto;
	
	String imgPath=null;
//	byte[] stdImg;
	
	Add()
	{
		initialize();
	}
	
	private void initialize() {
		frmAdd = new JFrame("Add Student Details");
		frmAdd.setBackground(Color.WHITE);
		frmAdd.setLayout(null);
		
		frmAdd.getContentPane().setBackground(Color.WHITE);
		
		lblHead = new JLabel("Student's Detail");
		lblHead.setFont(new Font("Arial",Font.PLAIN,28));
		lblHead.setBounds(250, 10, 200, 30);
		frmAdd.add(lblHead);
		
		lblId = new JLabel("Student ID");
		lblId.setFont(new Font("Arial",Font.PLAIN,18));
		lblId.setBounds(250, 50, 100, 25);
		frmAdd.add(lblId);
		
		txtId = new JTextField(10);
		txtId.setFont(new Font("Times New Roman",Font.PLAIN,16));
		txtId.setBounds(352, 50, 100, 25);
		frmAdd.add(txtId);
		
		btnCheck = new JButton("Check");
		btnCheck.setBounds(470, 50, 70, 25);
		btnCheck.setFocusable(false);
		frmAdd.add(btnCheck);
		btnCheck.addActionListener(this);
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial",Font.PLAIN,14));
		lblName.setBounds(50, 100, 175, 25);
		frmAdd.add(lblName);
		
		txtName = new JTextField(70);
		txtName.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtName.setBounds(227, 100, 300, 25);
		frmAdd.add(txtName);
		
		lblFName = new JLabel("Father's Name");
		lblFName.setFont(new Font("Arial",Font.PLAIN,14));
		lblFName.setBounds(50, 140, 175, 25);
		frmAdd.add(lblFName);
		
		txtFName = new JTextField(70);
		txtFName.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtFName.setBounds(227, 140, 300, 25);
		frmAdd.add(txtFName);
		
		lblImg = new JLabel();
		lblImg.setBounds(544, 80, 80, 92);
		frmAdd.add(lblImg);
		
		btnPhoto = new JButton("Upload");
		btnPhoto.setFont(new Font("Arial",Font.PLAIN,11));
		btnPhoto.setBounds(555, 180, 72, 25);
		btnPhoto.setFocusable(false);
		frmAdd.add(btnPhoto);
		btnPhoto.addActionListener(this);
		
		
		lblDob = new JLabel("Date Of Birth");
		lblDob.setFont(new Font("Arial",Font.PLAIN,14));
		lblDob.setBounds(50, 180, 175, 25);
		frmAdd.add(lblDob);
		
//		lblDate = new JLabel("Date");
//		lblDate.setFont(new Font("Arial",Font.PLAIN,18));
//		lblDate.setBounds(227, 180, 60, 25);
//		frmAdd.add(lblDate);
		
		String date[] = {"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		comboDate = new JComboBox(date);
		comboDate.setBackground(Color.WHITE);
		comboDate.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboDate.setBounds(227, 180, 100, 25);
		frmAdd.add(comboDate);
		
//		lblMonth = new JLabel("Month");
//		lblMonth.setFont(new Font("Arial",Font.PLAIN,18));
//		lblMonth.setBounds(362, 180, 60, 25);
//		frmAdd.add(lblMonth);

		String month[] = {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
		comboMonth = new JComboBox(month);
		comboMonth.setBackground(Color.WHITE);
		comboMonth.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboMonth.setBounds(337, 180, 100, 25);
		frmAdd.add(comboMonth);
		
//		lblYear = new JLabel("Year");
//		lblYear.setFont(new Font("Arial",Font.PLAIN,18));
//		lblYear.setBounds(492, 180, 60, 25);
//		frmAdd.add(lblYear);

		String year[] = {"Year","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
		comboYear = new JComboBox(year);
		comboYear.setBackground(Color.WHITE);
		comboYear.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboYear.setBounds(447, 180, 100, 25);
		frmAdd.add(comboYear);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Arial",Font.PLAIN,14));
		lblGender.setBounds(50, 220, 175, 25);
		frmAdd.add(lblGender);
		
		String gender[] = {"Male","Female","Others",};
		comboGender = new JComboBox(gender);
		comboGender.setBackground(Color.WHITE);
		comboGender.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboGender.setBounds(227, 220, 100, 25);
		frmAdd.add(comboGender);
		
		lblMStatus = new JLabel("Marital status");
		lblMStatus.setFont(new Font("Arial",Font.PLAIN,14));
		lblMStatus.setBounds(420, 220, 175, 25);
		frmAdd.add(lblMStatus);
		
		String mstatus[] = {"Single","Married","Other",};
		comboMStatus = new JComboBox(mstatus);
		comboMStatus.setBackground(Color.WHITE);
		comboMStatus.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboMStatus.setBounds(527, 220, 100, 25);
		frmAdd.add(comboMStatus);
		
		
		
//		radioMale = new JRadioButton("Male");
//		radioMale.setFont(new Font("Arial",Font.PLAIN,12));
//		radioMale.setBackground(Color.WHITE);
//		radioMale.setBounds(227, 220, 100, 25);
//		frmAdd.add(radioMale);
//		
//		radioFemale = new JRadioButton("Female");
//		radioFemale.setFont(new Font("Arial",Font.PLAIN,12));
//		radioFemale.setBackground(Color.WHITE);
//		radioFemale.setBounds(337, 220, 100, 25);
//		frmAdd.add(radioFemale);
//		
//		radioOther = new JRadioButton("Others");
//		radioOther.setFont(new Font("Arial",Font.PLAIN,12));
//		radioOther.setBackground(Color.white);
//		radioOther.setBounds(447, 220, 100, 25);
//		frmAdd.add(radioOther);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial",Font.PLAIN,14));
		lblAddress.setBounds(50, 260, 175, 25);
		frmAdd.add(lblAddress);
		
		txtAddress = new JTextField(200);
		txtAddress.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtAddress.setBounds(227, 260, 400, 25);
		frmAdd.add(txtAddress);
		
		lblPin = new JLabel("PIN");
		lblPin.setFont(new Font("Arial",Font.PLAIN,14));
		lblPin.setBounds(50, 300, 175, 25);
		frmAdd.add(lblPin);
		
		txtPin = new JTextField(10);
		txtPin.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtPin.setBounds(227, 300, 400, 25);
		frmAdd.add(txtPin);
		
		lblDist = new JLabel("Dist");
		lblDist.setFont(new Font("Arial",Font.PLAIN,14));
		lblDist.setBounds(50, 340, 175, 25);
		frmAdd.add(lblDist);
		
		txtDist = new JTextField(25);
		txtDist.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtDist.setBounds(227, 340, 400, 25);
		frmAdd.add(txtDist);
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("Arial",Font.PLAIN,14));
		lblState.setBounds(50, 380, 175, 25);
		frmAdd.add(lblState);
		
		txtState = new JTextField(25);
		txtState.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtState.setBounds(227, 380, 400, 25);
		frmAdd.add(txtState);
		
		lblReligion = new JLabel("Religion");
		lblReligion.setFont(new Font("Arial",Font.PLAIN,14));
		lblReligion.setBounds(50, 420, 175, 25);
		frmAdd.add(lblReligion);
		
		String religion[] = {"Hinduism","Islam","Christianity","Buddhism","Shikhism"};
		comboReligion = new JComboBox(religion);
		comboReligion.setBackground(Color.WHITE);
		comboReligion.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboReligion.setBounds(227, 420, 100, 25);
		frmAdd.add(comboReligion);
		
		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Arial",Font.PLAIN,14));
		lblCategory.setBounds(420, 420, 175, 25);
		frmAdd.add(lblCategory);
		
		String category[] = {"UR","OBC","SC","ST","Others"};
		comboCategory = new JComboBox(category);
		comboCategory.setBackground(Color.WHITE);
		comboCategory.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboCategory.setBounds(527, 420, 100, 25);
		frmAdd.add(comboCategory);
		
		lblEducation = new JLabel("Educational Qualification");
		lblEducation.setFont(new Font("Arial",Font.PLAIN,14));
		lblEducation.setBounds(50, 460, 175, 25);
		frmAdd.add(lblEducation);
		
		String education[] = {"Under 8th","8th","Secondary","Higher Secondary","Graduate","Post Graduate"};
		comboEducation = new JComboBox(education);
		comboEducation.setBackground(Color.WHITE);
		comboEducation.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboEducation.setBounds(227, 460, 100, 25);
		frmAdd.add(comboEducation);
		
		lblAadhar = new JLabel("Aadhar No.");
		lblAadhar.setFont(new Font("Arial",Font.PLAIN,14));
		lblAadhar.setBounds(420, 460, 175, 25);
		frmAdd.add(lblAadhar);
		
		txtAadhar = new JTextField(12);
		txtAadhar.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtAadhar.setBounds(490, 460, 137, 25);
		frmAdd.add(txtAadhar);
		
		lblMobile = new JLabel("Mobile No.");
		lblMobile.setFont(new Font("Arial",Font.PLAIN,14));
		lblMobile.setBounds(50, 500, 175, 25);
		frmAdd.add(lblMobile);
		
		txtMobile = new JTextField(12);
		txtMobile.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtMobile.setBounds(227, 500, 150, 25);
		frmAdd.add(txtMobile);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial",Font.PLAIN,14));
		lblEmail.setBounds(420, 500, 175, 25);
		frmAdd.add(lblEmail);
		
		txtEmail = new JTextField(70);
		txtEmail.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtEmail.setBounds(490, 500, 137, 25);
		frmAdd.add(txtEmail);
		
		btnNext = new JButton("Next");
		btnNext.setBackground(Color.BLACK);
		btnNext.setForeground(Color.WHITE);
		btnNext.setBounds(525, 555, 100, 30);
		btnNext.setFocusable(false);
		frmAdd.add(btnNext);
		btnNext.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(360, 555, 100, 30);
		btnCancel.setFocusable(false);
		frmAdd.add(btnCancel);
		btnCancel.addActionListener(this);
		
		btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBackground(Color.BLACK);
		btnAddCourse.setForeground(Color.WHITE);
		btnAddCourse.setBounds(50, 560, 100, 25);
		btnAddCourse.setFocusable(false);
		frmAdd.add(btnAddCourse);
		btnAddCourse.addActionListener(this);
		
		
		txtName.setEditable(false);
		txtFName.setEditable(false);
		txtAddress.setEditable(false);
		txtPin.setEditable(false);
		txtDist.setEditable(false);
		txtState.setEditable(false);
		txtAadhar.setEditable(false);
		txtEmail.setEditable(false);
		txtMobile.setEditable(false);
		
		comboCategory.setEnabled(false);
		comboDate.setEnabled(false);
		comboEducation.setEnabled(false);
		comboGender.setEnabled(false);
		comboMonth.setEnabled(false);
		comboMStatus.setEnabled(false);
		comboReligion.setEnabled(false);
		comboYear.setEnabled(false);
		
		
		
		
		
		frmAdd.setVisible(true);
		frmAdd.setSize(700,650);
		frmAdd.setResizable(false);
//		frmAdd.setLocation(320,30);
		frmAdd.setLocationRelativeTo(null);
		frmAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public ImageIcon ResizeImage(String ImagePath, byte[] pic)
	{
		ImageIcon MyImage = null;
		if(ImagePath != null)
		{
			MyImage = new ImageIcon(ImagePath);
		}
		else
		{
			MyImage = new ImageIcon(pic);
		}
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}
	
	
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentmanagementsystem","root","Root@MySQL");
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	

	
	public void actionPerformed(ActionEvent ae)
	{
		
		String stdId = txtId.getText();
		String stdName = txtName.getText();
		String fName = txtFName.getText();
		
		String dobDate =(String) comboDate.getSelectedItem();
		String dobMonth =(String) comboMonth.getSelectedItem();
		String dobYear =(String) comboYear.getSelectedItem();
		
		String gender = (String) comboGender.getSelectedItem();
		String mstatus = (String) comboMStatus.getSelectedItem();
		
		
//		String val = null;
//		if(radioMale.isSelected())
//		{
//			val = "Male";
//			radioFemale.enable(false);
//		}
//		else if(radioFemale.isSelected())
//		{
//			val = "Female";
//		}
//		else if(radioOther.isSelected())
//		{
//			val = "Others";
//		}
		
		String address = txtAddress.getText();		
		String pin = txtPin.getText();		
		String dist = txtDist.getText();
		String state = txtState.getText();
		
		String religion =(String) comboReligion.getSelectedItem();		
		String category =(String) comboCategory.getSelectedItem();		
		String education =(String) comboEducation.getSelectedItem();
		
		String aadhar = txtAadhar.getText();
		String mobile = txtMobile.getText();
		String email = txtEmail.getText();
		
		
		
		
		
		
		
		
		try {
//				Conn con = new Conn();
				
				String quaryUpdate = "insert into studentdetails(stdid,stdname,fname,dte,mnth,yr,gender,mstatus,address,pin,dist,state,religion,category,education,aadhar,mobile,email,pic,deleted) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				String quary = "select * from studentdetails where stdid = '"+stdId+"'";
				
				
				
				if(ae.getSource() == btnCheck)
				{
					ResultSet rs = getConnection().prepareStatement(quary).executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Student Id already exists, try another");
						txtId.requestFocus();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Continue");
						txtName.requestFocus();
						
						txtName.setEditable(true);
						txtFName.setEditable(true);
						txtAddress.setEditable(true);
						txtPin.setEditable(true);
						txtDist.setEditable(true);
						txtState.setEditable(true);
						txtAadhar.setEditable(true);
						txtEmail.setEditable(true);
						txtMobile.setEditable(true);
						
						comboCategory.setEnabled(true);
						comboDate.setEnabled(true);
						comboEducation.setEnabled(true);
						comboGender.setEnabled(true);
						comboMonth.setEnabled(true);
						comboMStatus.setEnabled(true);
						comboReligion.setEnabled(true);
						comboYear.setEnabled(true);
						
					}
					rs.close();
				}
				else if(ae.getSource() == btnNext)
				{		
					if(imgPath != null)
					{
						try {
							if(txtAadhar.getText().equals("")||txtAddress.getText().equals("")||txtDist.getText().equals("")||txtEmail.getText().equals("")||txtFName.getText().equals("")||txtId.getText().equals("")||txtMobile.getText().equals("")||txtName.getText().equals("")||txtPin.getText().equals("")||txtState.getText().equals(""))
							{
								JOptionPane.showMessageDialog(null, "Fill all the fields");
							}
							else
							{
//								con.s.executeUpdate(quaryUpdate);
								
								PreparedStatement ps = getConnection().prepareStatement(quaryUpdate);
								ps.setString(1, stdId);
								ps.setString(2, stdName);
								ps.setString(3, fName);
								ps.setString(4, dobDate);
								ps.setString(5, dobMonth);
								ps.setString(6, dobYear);
								ps.setString(7, gender);
								ps.setString(8, mstatus);
								ps.setString(9, address);
								ps.setString(10, pin);
								ps.setString(11, dist);
								ps.setString(12, state);
								ps.setString(13, religion);
								ps.setString(14, category);
								ps.setString(15, education);
								ps.setString(16, aadhar);
								ps.setString(17, mobile);
								ps.setString(18, email);
								
								InputStream img = new FileInputStream(new File(imgPath));
								ps.setBlob(19, img);
								
								ps.setString(20, "N");
								
								ps.executeUpdate();
								
//								if(ps.executeUpdate() == 1)
//								{
//									JOptionPane.showMessageDialog(null, "Data Inserted");
//								}

						
								new Add2(txtId.getText());
								frmAdd.setVisible(false);
							}
							
						}
						catch(Exception e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No Image Selected");
					}
					imgPath = null;
					
			
				}
				else if(ae.getSource() == btnCancel)
				{
					new Details();
					frmAdd.setVisible(false);
				}
				else if(ae.getSource() == btnAddCourse)
				{
					new Add2("");
					frmAdd.setVisible(false);
				}
				
				else if(ae.getSource() == btnPhoto)
				{
					{
						JFileChooser file = new JFileChooser();
						file.setCurrentDirectory(new File(System.getProperty("user.home")));
						FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","jpeg","png");
						file.addChoosableFileFilter(filter);
						int result = file.showSaveDialog(null);
						
						if(result == JFileChooser.APPROVE_OPTION)
						{
							File selectedFile = file.getSelectedFile();
							String path = selectedFile.getAbsolutePath();
							lblImg.setIcon(ResizeImage(path,null));
							imgPath = path;
						}
						else if(result == JFileChooser.CANCEL_OPTION)
						{
							JOptionPane.showMessageDialog(null, "No file selected");
						}
					}
				}
				getConnection().close();
//				con.s.close();
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, e);
			}	
	}
	
	public static void main(String[] args)
	{
		new Add();
	}

}
