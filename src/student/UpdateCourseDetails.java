package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class UpdateCourseDetails implements ActionListener{
	
	JFrame frmAdd2;
	JLabel lblHead,lblId,lblCourseName,lblCourseDuration,lblCourseAmount,lblPaidAmount,lblCourseJoiningDate;
	JTextField txtId,txtCourseAmount,txtPaidAmount;
	JComboBox comboCourseName,comboDuration,comboJDate,comboJMonth,comboJYear;
	JButton btnSave,btnCancel;
	
	String vcourse,vduration,vamount,vpaidamount,vjoind,vjoinm,vjoiny;
	
	
	
	public UpdateCourseDetails(String id)
	{
		
		try {
			Conn con = new Conn();
			String q = "select * from coursedetails where stdid = '"+id+"' and deleted = 'N'";
			ResultSet rs = con.s.executeQuery(q);
			
			while(rs.next())
			{
//				vid = rs.getString("stdid");
//				vname = rs.getString("stdname");
//				vfname = rs.getString("fname");
//				vsd = rs.getString("dte");
//				vsm = rs.getString("mnth");
//				vsy = rs.getString("yr");
//				vsex = rs.getString("gender");
//				vmstatus = rs.getString("mstatus");
//				vaddress = rs.getString("address");
//				vpin = rs.getString("pin");
//				vdist = rs.getString("dist");
//				vstate = rs.getString("state");
//				vreligion = rs.getString("religion");
//				vcategory = rs.getString("category");
//				vedu = rs.getString("education");
//				vaadhar = rs.getString("aadhar");
//				vmob = rs.getString("mobile");
//				vemail = rs.getString("email");
				vcourse = rs.getString("coursedetails.coursename");
				vduration = rs.getString("coursedetails.courseduration");
				vamount = rs.getString("coursedetails.courseamount");
				vpaidamount = rs.getString("coursedetails.paidamount");
				vjoind = rs.getString("coursedetails.dojd");
				vjoinm = rs.getString("coursedetails.dojm");
				vjoiny = rs.getString("coursedetails.dojy");
				
				
				
				
			}
		rs.close();
		con.s.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
		
		
		
		frmAdd2 = new JFrame("Add Course Details");
		frmAdd2.setBackground(Color.WHITE);
		frmAdd2.setLayout(null);
		
		frmAdd2.getContentPane().setBackground(Color.WHITE);
		
		lblHead = new JLabel("Course Detail");
		lblHead.setFont(new Font("Arial",Font.PLAIN,28));
		lblHead.setBounds(250, 10, 200, 30);
		frmAdd2.add(lblHead);
		
		lblId = new JLabel("Student ID");
		lblId.setFont(new Font("Arial",Font.PLAIN,18));
		lblId.setBounds(250, 50, 100, 25);
		frmAdd2.add(lblId);
		
		txtId = new JTextField(10);
		txtId.setFont(new Font("Times New Roman",Font.PLAIN,16));
		txtId.setBounds(352, 50, 100, 25);
		frmAdd2.add(txtId);
		
		
		lblCourseName = new JLabel("Course name");
		lblCourseName.setFont(new Font("Arial",Font.PLAIN,14));
		lblCourseName.setBounds(50, 100, 175, 25);
		frmAdd2.add(lblCourseName);
		
		String course[] = {"Select","CCA","DCA","ADCA","DSD","DOAM","DFA","DDTP","DHT","DMWD","DCTT","ADCHNT","DAT","CBM","MVE","CWD","CDEO","Typing","Junior-IT","Spoken English"};
		comboCourseName = new JComboBox(course);
		comboCourseName.setBackground(Color.WHITE);
		comboCourseName.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboCourseName.setBounds(227, 100, 150, 25);
		frmAdd2.add(comboCourseName);
				
		lblCourseDuration = new JLabel("Course Duration");
		lblCourseDuration.setFont(new Font("Arial",Font.PLAIN,14));
		lblCourseDuration.setBounds(50, 140, 175, 25);
		frmAdd2.add(lblCourseDuration);
		
		String courseduration[] = {"Select","1 Month","2 Months","3 Months","4 Months","5 Months","6 Months","7 Months","8 Months","9 Months","10 Months","11 Months","12 Months","13 Months","14 Months","15 Months","16 Months","17 Months","18 Months","19 Months","20 Months","21 Months","22 Months","23 Months","24 Months","25 Months","26 Months","27 Months","28 Months","29 Months","30 Months","31 Months","32 Months","33 Months","34 Months","35 Months","36 Months"};
		comboDuration = new JComboBox(courseduration);
		comboDuration.setBackground(Color.WHITE);
		comboDuration.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboDuration.setBounds(227, 140, 150, 25);
		frmAdd2.add(comboDuration);
				
		lblCourseAmount = new JLabel("Course Amount");
		lblCourseAmount.setFont(new Font("Arial",Font.PLAIN,14));
		lblCourseAmount.setBounds(50, 180, 175, 25);
		frmAdd2.add(lblCourseAmount);
		
		txtCourseAmount = new JTextField(70);
		txtCourseAmount.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtCourseAmount.setBounds(227, 180, 150, 25);
		frmAdd2.add(txtCourseAmount);
		txtCourseAmount.requestFocus();
		
		lblPaidAmount = new JLabel("Paid Amount");
		lblPaidAmount.setFont(new Font("Arial",Font.PLAIN,14));
		lblPaidAmount.setBounds(50, 220, 175, 25);
		frmAdd2.add(lblPaidAmount);
		
		txtPaidAmount = new JTextField(70);
		txtPaidAmount.setFont(new Font("Times New Roman",Font.PLAIN,12));
		txtPaidAmount.setBounds(227, 220, 150, 25);
		frmAdd2.add(txtPaidAmount);
		
		lblCourseJoiningDate = new JLabel("Course Joining date");
		lblCourseJoiningDate.setFont(new Font("Arial",Font.PLAIN,14));
		lblCourseJoiningDate.setBounds(50, 260, 175, 25);
		frmAdd2.add(lblCourseJoiningDate);
		
		String date[] = {"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		comboJDate = new JComboBox(date);
		comboJDate.setBackground(Color.WHITE);
		comboJDate.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboJDate.setBounds(227, 260, 100, 25);
		frmAdd2.add(comboJDate);
		
		String month[] = {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
		comboJMonth = new JComboBox(month);
		comboJMonth.setBackground(Color.WHITE);
		comboJMonth.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboJMonth.setBounds(337, 260, 100, 25);
		frmAdd2.add(comboJMonth);
		
		String year[] = {"Year","2025","2024","2023","2022","2021","2020","2019"};
		comboJYear = new JComboBox(year);
		comboJYear.setBackground(Color.WHITE);
		comboJYear.setFont(new Font("Times New Roman",Font.PLAIN,12));
		comboJYear.setBounds(447, 260, 100, 25);
		frmAdd2.add(comboJYear);
		
		btnSave = new JButton("Update");
		btnSave.setBackground(Color.BLACK);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBounds(525, 400, 100, 30);
		btnSave.setFocusable(false);
		frmAdd2.add(btnSave);
		btnSave.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(360, 400, 100, 30);
		btnCancel.setFocusable(false);
		frmAdd2.add(btnCancel);
		btnCancel.addActionListener(this);
		
		
		txtId.setEditable(false);
		txtId.setText(id);
		comboCourseName.setSelectedItem(vcourse);
		comboDuration.setSelectedItem(vduration);
		txtCourseAmount.setText(vamount);
		txtPaidAmount.setText(vpaidamount);
		comboJDate.setSelectedItem(vjoind);
		comboJMonth.setSelectedItem(vjoinm);
		comboJYear.setSelectedItem(vjoiny);
		
		
			
		
		frmAdd2.setVisible(true);
		frmAdd2.setSize(700,650);
		frmAdd2.setResizable(false);
//		frmAdd2.setLocation(320,30);
		frmAdd2.setLocationRelativeTo(null);
		frmAdd2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	





	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == btnSave)
		{
			try {
				Conn con = new Conn();
				String q = "update coursedetails set coursename = '"+comboCourseName.getSelectedItem()+"', courseduration = '"+comboDuration.getSelectedItem()+"', courseamount = '"+txtCourseAmount.getText()+"', paidamount = '"+txtPaidAmount.getText()+"', dojd = '"+comboJDate.getSelectedItem()+"', dojm = '"+comboJMonth.getSelectedItem()+"', dojy = '"+comboJYear.getSelectedItem()+"' where stdid = '"+txtId.getText()+"'";
				
				int response = JOptionPane.showConfirmDialog(null, "Are you sure to update?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					con.s.executeUpdate(q);
					JOptionPane.showMessageDialog(null, "Updated successfully");
					frmAdd2.setVisible(false);
					new Update();
				}
				con.s.close();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else if(ae.getSource() == btnCancel)
		{
			new Update();
			frmAdd2.setVisible(false);
		}
		
		
	}
	

	public static void main(String[] args) {
		
		new UpdateCourseDetails("");
		

	}


}
