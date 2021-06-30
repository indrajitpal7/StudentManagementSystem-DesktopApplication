package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
//import javax.security.auth.callback.PasswordCallback;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class ChangePass extends JFrame implements ActionListener{
	
	JLabel lblImg,lblHead,lblOld,lblNew,lblConfirm;
	JPasswordField pasOld,pasConfirm;
	JTextField txtNew;
	JButton btnChange,btnCancel;
	
	ChangePass()
	{
		initialize();
	}
	
	
	private void initialize() 
	{
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/background.png"));
		Image img1 = icon1.getImage().getScaledInstance(385, 280, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(img1);
		lblImg = new JLabel(icon2);
		lblImg.setBounds(0, 0, 385, 280);
		add(lblImg);
		
		
		
		setTitle("Change Password");
		lblHead = new JLabel("Change Password");
		lblHead.setFont(new Font("Times New Roman",Font.BOLD,22));
		lblHead.setBounds(100, 10, 200, 30);
		lblHead.setForeground(Color.RED);
		lblImg.add(lblHead);
		
		lblOld = new JLabel("Old Password");
		lblOld.setFont(new Font("Times New Roman",Font.BOLD,16));
		lblOld.setBounds(50, 70, 150, 30);
		lblImg.add(lblOld);
		
		pasOld = new JPasswordField();
		pasOld.setBounds(185, 70, 150, 25);
		lblImg.add(pasOld);
		
		lblNew = new JLabel("New Password");
		lblNew.setFont(new Font("Times New Roman",Font.BOLD,16));
		lblNew.setBounds(50, 105, 150, 30);
		lblImg.add(lblNew);
		
		txtNew = new JTextField();
		txtNew.setFont(new Font("Times New Roman",Font.BOLD,16));
		txtNew.setBounds(185, 105, 150, 25);
		lblImg.add(txtNew);
		
		lblConfirm = new JLabel("Confirm Password");
		lblConfirm.setFont(new Font("Times New Roman",Font.BOLD,16));
		lblConfirm.setBounds(50, 140, 150, 30);
		lblImg.add(lblConfirm);
		
		pasConfirm = new JPasswordField();
		pasConfirm.setBounds(185, 140, 150, 25);
		lblImg.add(pasConfirm);
		
		btnChange = new JButton("Change");
		btnChange.setBackground(Color.BLACK);
		btnChange.setForeground(Color.WHITE);
		btnChange.setBounds(235, 185, 100, 30);
		btnChange.setFocusable(false);
		lblImg.add(btnChange);
		btnChange.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(100, 185, 100, 30);
		btnCancel.setFocusable(false);
		lblImg.add(btnCancel);
		btnCancel.addActionListener(this);
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setSize(385,280);
		setResizable(false);
//		setLocation(500,150);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		Conn con = new Conn();
		String old = pasOld.getText();
		String newpass = txtNew.getText();
		String confirm = pasConfirm.getText();
		
		
		String q1 = "select * from login where password = '"+old+"'";
		String q2 ="update login set password = '"+confirm+"' where password = '"+old+"'";
		
		try {
			
			if(ae.getSource() == btnChange) 
			{
				if(newpass.equals(confirm))
				{
					ResultSet rs = con.s.executeQuery(q1);
					if(rs.next())
					{
						con.s.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Password changed");
						setVisible(false);
						new Login();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect old password");
					}
					rs.close();
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "New password and Confirm password does not match");
				}
				
				
				
			}
			else if(ae.getSource() == btnCancel)
			{
				new Login();
				setVisible(false);
			}
			con.s.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
		
	}
	
	
	

	public static void main(String[] args) {
		
		new ChangePass();

	}

}
