package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class Update implements ActionListener{
	
	JFrame frmUpdate;
	JLabel lblImg,lblHead,lblId;
	JTextField txtId;
	JButton btnSearch,btnBack,btnUpdateStudent,btnUpdateCourse;
	
	public Update() 
	{
		frmUpdate = new JFrame("Update Student Details");
		frmUpdate.setBackground(Color.WHITE);
		frmUpdate.setLayout(null);
		
		frmUpdate.getContentPane().setBackground(Color.WHITE);
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/background.png"));
		Image img1 = icon1.getImage().getScaledInstance(400, 385, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(img1);
		lblImg = new JLabel(icon2);
		lblImg.setBounds(0, 0, 400, 385);
		frmUpdate.add(lblImg);
		
		lblHead = new JLabel("Delete Student's Detail");
		lblHead.setFont(new Font("Times New Roman",Font.PLAIN,28));
		lblHead.setBounds(65, 10, 400, 30);
		lblImg.add(lblHead);
		
		lblId = new JLabel("Student ID :");
		lblId.setFont(new Font("Times New Roman",Font.BOLD,16));
		lblId.setBounds(100, 50, 175, 25);
		lblImg.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Times New Roman",Font.BOLD,14));
		txtId.setBounds(200, 50, 85, 25);
		lblImg.add(txtId);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(235, 90, 80, 30);
		btnSearch.setFocusable(false);
		lblImg.add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(135, 90, 80, 30);
		btnBack.setFocusable(false);
		lblImg.add(btnBack);
		btnBack.addActionListener(this);
		
		btnUpdateStudent = new JButton("Update Student Details");
		btnUpdateStudent.setBounds(65, 180, 250, 40);
		btnUpdateStudent.setBackground(Color.BLACK);
		btnUpdateStudent.setForeground(Color.WHITE);
		btnUpdateStudent.setFocusable(false);
		lblImg.add(btnUpdateStudent);
		btnUpdateStudent.addActionListener(this);
		
		btnUpdateCourse = new JButton("Update Course Details");
		btnUpdateCourse.setBounds(65, 240, 250, 40);
		btnUpdateCourse.setBackground(Color.BLACK);
		btnUpdateCourse.setForeground(Color.WHITE);
		btnUpdateCourse.setFocusable(false);
		lblImg.add(btnUpdateCourse);
		btnUpdateCourse.addActionListener(this);


		btnUpdateStudent.setVisible(false);
		btnUpdateCourse.setVisible(false);
		
		frmUpdate.setVisible(true);
		frmUpdate.setSize(400,385);
		frmUpdate.setResizable(false);
//		frmUpdate.setLocation(450,100);
		frmUpdate.setLocationRelativeTo(null);
		frmUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == btnSearch)
		{
			try {
				Conn con = new Conn();
				String q = "select stdid from studentdetails where stdid = '"+txtId.getText()+"' and deleted = 'N'";
				ResultSet rs = con.s.executeQuery(q);
				
				
				int flag = 0;
				if(rs.next())
				{
					flag =1;
					btnUpdateStudent.setVisible(true);
					btnUpdateCourse.setVisible(true);
				
					
				}
				
				if(flag==0)
				{
					
					txtId.setText("");
					txtId.requestFocus();
					
					btnUpdateStudent.setVisible(false);
					btnUpdateCourse.setVisible(false);
					JOptionPane.showMessageDialog(null, "Rocords not found");
	
				}
				rs.close();
				con.s.close();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else if(ae.getSource() == btnBack)
		{
			new Details();
			frmUpdate.setVisible(false);
		}
		
		else if(ae.getSource() == btnUpdateStudent)
		{
			new UpdateStudentDetails(txtId.getText());
			frmUpdate.setVisible(false);
		}
		else if(ae.getSource() == btnUpdateCourse)
		{
			new UpdateCourseDetails(txtId.getText());
			frmUpdate.setVisible(false);
		}
		
		
	}
	
	public static void main(String[] args)
	{
		new Update();
	}
	

}
