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

import com.mysql.cj.protocol.Resultset;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class Remove implements ActionListener{
	JFrame frmRemove;
	JLabel lblImg,lblHead,lblId,lblName,sname,lblMob,smob,lblEmail,semail;
	JTextField txtId;
	JButton btnSearch,btnBack,btnRemove,btnCancel;

	Remove()
	{
//		initialize();
		
		frmRemove = new JFrame("Delete Student Details");
		frmRemove.setBackground(Color.WHITE);
		frmRemove.setLayout(null);
		
		frmRemove.getContentPane().setBackground(Color.WHITE);
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/background.png"));
		Image img1 = icon1.getImage().getScaledInstance(400, 385, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(img1);
		lblImg = new JLabel(icon2);
		lblImg.setBounds(0, 0, 400, 385);
		frmRemove.add(lblImg);
		
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
		
		lblName = new JLabel("Name :");
		lblName.setFont(new Font("Times New Roman",Font.PLAIN,16));
		lblName.setBounds(50, 140, 175, 25);
		lblImg.add(lblName);
		
		sname = new JLabel();
		sname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sname.setBounds(177, 140, 175, 25);
		lblImg.add(sname);
		
		lblMob = new JLabel("Mobile No. :");
		lblMob.setFont(new Font("Times New Roman",Font.PLAIN,16));
		lblMob.setBounds(50, 180, 175, 25);
		lblImg.add(lblMob);
		
		smob = new JLabel();
		smob.setFont(new Font("Times New Roman",Font.PLAIN,16));
		smob.setBounds(177, 180, 175, 25);
		lblImg.add(smob);
		
		lblEmail = new JLabel("Email ID :");
		lblEmail.setFont(new Font("Times New Roman",Font.PLAIN,16));
		lblEmail.setBounds(50, 220, 175, 25);
		lblImg.add(lblEmail);
		
		semail = new JLabel();
		semail.setFont(new Font("Times New Roman",Font.PLAIN,16));
		semail.setBounds(177, 220, 175, 25);
		lblImg.add(semail);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.BLACK);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBounds(235, 280, 80, 30);
		btnRemove.setFocusable(false);
		lblImg.add(btnRemove);
		btnRemove.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(135, 280, 80, 30);
		btnCancel.setFocusable(false);
		lblImg.add(btnCancel);
		btnCancel.addActionListener(this);
		
		btnRemove.setVisible(false);
		btnCancel.setVisible(false);
		
		lblName.setVisible(false);
		lblMob.setVisible(false);
		lblEmail.setVisible(false);
		
		
		frmRemove.setVisible(true);
		frmRemove.setSize(400,385);
		frmRemove.setResizable(false);
//		frmRemove.setLocation(450,100);
		frmRemove.setLocationRelativeTo(null);
		frmRemove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
//	private void initialize()
//	{
//		frmRemove = new JFrame("Delete Student Details");
//		frmRemove.setBackground(Color.WHITE);
//		frmRemove.setLayout(null);
//		
//		frmRemove.getContentPane().setBackground(Color.WHITE);
//		
//		lblHead = new JLabel("Delete Student's Detail");
//		lblHead.setFont(new Font("Times New Roman",Font.PLAIN,28));
//		lblHead.setBounds(65, 10, 400, 30);
//		frmRemove.add(lblHead);
//		
//		lblId = new JLabel("Student ID :");
//		lblId.setFont(new Font("Times New Roman",Font.BOLD,16));
//		lblId.setBounds(100, 50, 175, 25);
//		frmRemove.add(lblId);
//		
//		txtId = new JTextField();
//		txtId.setFont(new Font("Times New Roman",Font.BOLD,14));
//		txtId.setBounds(200, 50, 85, 25);
//		frmRemove.add(txtId);
//		
//		btnSearch = new JButton("Search");
//		btnSearch.setBackground(Color.BLACK);
//		btnSearch.setForeground(Color.WHITE);
//		btnSearch.setBounds(235, 90, 80, 30);
//		frmRemove.add(btnSearch);
//		btnSearch.addActionListener(this);
//		
//		btnBack = new JButton("Back");
//		btnBack.setBackground(Color.BLACK);
//		btnBack.setForeground(Color.WHITE);
//		btnBack.setBounds(135, 90, 80, 30);
//		frmRemove.add(btnBack);
//		btnBack.addActionListener(this);
//		
//		lblName = new JLabel("Name :");
//		lblName.setFont(new Font("Times New Roman",Font.PLAIN,16));
//		lblName.setBounds(50, 140, 175, 25);
//		frmRemove.add(lblName);
//		
//		sname = new JLabel(vname);
//		sname.setFont(new Font("Times New Roman",Font.PLAIN,14));
//		sname.setBounds(177, 140, 175, 25);
//		frmRemove.add(sname);
//		
//		lblMob = new JLabel("Mobile No. :");
//		lblMob.setFont(new Font("Times New Roman",Font.PLAIN,16));
//		lblMob.setBounds(50, 180, 175, 25);
//		frmRemove.add(lblMob);
//		
//		smob = new JLabel(vmob);
//		smob.setFont(new Font("Times New Roman",Font.PLAIN,16));
//		smob.setBounds(177, 180, 175, 25);
//		frmRemove.add(smob);
//		
//		lblEmail = new JLabel("Email ID :");
//		lblEmail.setFont(new Font("Times New Roman",Font.PLAIN,16));
//		lblEmail.setBounds(50, 220, 175, 25);
//		frmRemove.add(lblEmail);
//		
//		semail = new JLabel(vemail);
//		semail.setFont(new Font("Times New Roman",Font.PLAIN,16));
//		semail.setBounds(177, 220, 175, 25);
//		frmRemove.add(semail);
//		
//		btnRemove = new JButton("Remove");
//		btnRemove.setBackground(Color.BLACK);
//		btnRemove.setForeground(Color.WHITE);
//		btnRemove.setBounds(235, 280, 80, 30);
//		frmRemove.add(btnRemove);
//		btnRemove.addActionListener(this);
//		
//		btnCancel = new JButton("Calcel");
//		btnCancel.setBackground(Color.BLACK);
//		btnCancel.setForeground(Color.WHITE);
//		btnCancel.setBounds(135, 280, 80, 30);
//		frmRemove.add(btnCancel);
//		btnCancel.addActionListener(this);
//		
//		
//		
//		frmRemove.setVisible(true);
//		frmRemove.setSize(400,385);
//		frmRemove.setLocation(450,100);
//		frmRemove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnSearch)
		{
			try {
				Conn con = new Conn();
				String q = "select stdname,mobile,email from studentdetails where stdid = '"+txtId.getText()+"' and deleted = 'N'";
				ResultSet rs = con.s.executeQuery(q);
				
				
				int flag = 0;
				if(rs.next())
				{
					String vname = rs.getString("stdname");
					String vmobile = rs.getString("mobile");
					String vemail = rs.getString("email");
					
					flag =1;
					
					sname.setVisible(true);
					smob.setVisible(true);
					semail.setVisible(true);
					
					sname.setText(vname);
					smob.setText(vmobile);
					semail.setText(vemail);
					
					lblName.setVisible(true);
					lblMob.setVisible(true);
					lblEmail.setVisible(true);
					
					btnRemove.setVisible(true);
					btnCancel.setVisible(true);
//					btnBack.setVisible(false);
				}
				
				if(flag==0)
				{
					sname.setText("");
					smob.setText("");
					semail.setText("");
					
					lblName.setVisible(false);
					lblMob.setVisible(false);
					lblEmail.setVisible(false);
					
					btnRemove.setVisible(false);
					btnCancel.setVisible(false);
					
					JOptionPane.showMessageDialog(null, "Rocords not found");
					
					txtId.setText("");
					txtId.requestFocus();
					
				}
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		else if(ae.getSource() == btnBack)
		{
			new Details();
			frmRemove.setVisible(false);
		}
		else if(ae.getSource() == btnRemove)
		{
			try {
				Conn con = new Conn();
				String q = "update studentdetails, coursedetails set studentdetails.deleted ='Y', coursedetails.deleted ='Y' where studentdetails.stdid = '"+txtId.getText()+"' and coursedetails.stdid = '"+txtId.getText()+"'";
				
				int response = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					con.s.executeUpdate(q);
					
					sname.setText("");
					smob.setText("");
					semail.setText("");
					
					lblName.setVisible(false);
					lblMob.setVisible(false);
					lblEmail.setVisible(false);
					
					btnRemove.setVisible(false);
					btnCancel.setVisible(false);
					
					txtId.setText("");
					txtId.requestFocus();
					
					JOptionPane.showMessageDialog(null, "Deleted successfully");
					
				}
//				else if(response == JOptionPane.NO_OPTION)
//				{
//					
//				}				
			}
			
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
				
			}
		}
		else if(ae.getSource() == btnCancel)
		{
			sname.setText("");
			smob.setText("");
			semail.setText("");
			
			lblName.setVisible(false);
			lblMob.setVisible(false);
			lblEmail.setVisible(false);
			
			btnRemove.setVisible(false);
			btnCancel.setVisible(false);
			
			txtId.setText("");
			txtId.requestFocus();
		}
		
	}
	
	public static void main(String[] args) {
		new Remove();
	
	}

}
