package student;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class Login extends JFrame implements ActionListener{
//	JFrame frmLogin;
	JLabel label1,label2,label3;
	JTextField txtField1;
	JPasswordField passField1;
	JButton btnSignin,btnClear,btnChange;
	
	Login()
	{
		adminLogin();
	}
	
	private void adminLogin()
	{
		setTitle("Login");
//		super("Login...");
		setLayout(null);
		
		
		
		label1 = new JLabel("Username :");
		label1.setFont(new Font("Raleway", Font.BOLD, 14));
		label1.setForeground(Color.WHITE);
		label1.setBounds(40, 20, 100, 30);
		add(label1);
		
		label2 = new JLabel("Password :");
		label2.setFont(new Font("Raleway", Font.BOLD, 14));
		label2.setForeground(Color.WHITE);
		label2.setBounds(40, 70, 100, 30);
		add(label2);
		
		txtField1 = new JTextField(15);
		txtField1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtField1.setBounds(125, 25, 150, 25);
		add(txtField1);
		
		passField1 = new JPasswordField(15);
		passField1.setBounds(125, 75, 150, 25);
		add(passField1);
		
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/login.png"));
		Image ig1 = ic1.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT);
		btnSignin = new JButton("Sign in", new ImageIcon(ig1));
//		btnSignin.setHorizontalAlignment(SwingConstants.LEFT);
		btnSignin.setBackground(Color.BLACK);
		btnSignin.setForeground(Color.WHITE);
		btnSignin.setFont(new Font("Arial", Font.BOLD, 14));
		btnSignin.setBounds(40, 120, 100, 30);
		btnSignin.setFocusable(false);
		add(btnSignin);
		
		
		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("student/icons/clear.png"));
		Image ig2 = ic2.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT);
		btnClear = new JButton("Clear", new ImageIcon(ig2));
		btnClear.setBackground(Color.BLACK);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial", Font.BOLD, 14));
		btnClear.setBounds(175, 120, 100, 30);
		btnClear.setFocusable(false);
		add(btnClear);
		
		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("student/icons/changepass.png"));
		Image ig3 = ic3.getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT);
		btnChange = new JButton("Change Password", new ImageIcon(ig3));
		btnChange.setBackground(Color.BLACK);
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Arial", Font.BOLD, 14));
		btnChange.setBounds(40, 165, 235, 30);
		btnChange.setFocusable(false);
		add(btnChange);	
		btnChange.addActionListener(this);
		
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("student/icons/logo.png"));
		Image img2 = icon3.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT);
		ImageIcon icon4 = new ImageIcon(img2);
		label3 = new JLabel(icon4);
		label3.setBounds(285, 65, 225, 150);
		add(label3);
		

		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/loginbackground.jpg"));
		Image img1 = icon1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(img1);
		label3 = new JLabel(icon2);
		label3.setBounds(0, 0, 600, 300);
		add(label3);
		
		
		
		
		
		
		btnSignin.addActionListener(this);
		btnClear.addActionListener(this);
//		btnSignup.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(600,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		Conn con = new Conn();
		String username = txtField1.getText();
		String pass = passField1.getText();
		String quary = "select * from login where username = '"+username+"' and password = '"+pass+"'";
		
	try {		
		
			
			if(ae.getSource() == btnSignin)
			{
				ResultSet rs = con.s.executeQuery(quary);
				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null, "Database Connected");
					new Details();
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login failed, wrong user credentials");
				}
				rs.close();
			}
			else if(ae.getSource() == btnClear)
			{
				txtField1.setText("");
				passField1.setText("");
				txtField1.requestFocus();
			}
			else if(ae.getSource() == btnChange)
			{
				new ChangePass();
				setVisible(false);
			}
			con.s.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	
	}
	
	
	
	public static void main(String[] args)
	{
		new Login();
	}
}

