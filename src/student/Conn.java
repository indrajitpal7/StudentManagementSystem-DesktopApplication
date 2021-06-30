package student;

import java.sql.*;

import javax.swing.JOptionPane;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class Conn {
	Connection c;
	Statement s;
	
	public Conn()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentmanagementsystem","root","Root@MySQL");
			s = c.createStatement();
			
//			JOptionPane.showMessageDialog(null, "Database Connected");
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
}
