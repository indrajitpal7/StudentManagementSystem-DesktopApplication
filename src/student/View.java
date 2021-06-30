package student;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import net.proteanit.sql.DbUtils;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class View implements ActionListener{
	
	JFrame frmView;
	JTable table;
	JScrollPane pane;
	JLabel lblHead;
	JTextField txtId;
	JButton btnSearch,btnBack;
	DefaultTableModel model;
	
	View()
	{
		initialize();
		table_update();
		txtId.requestFocus();

	}
	
	private void initialize() {
		
		frmView = new JFrame("View Details");
		frmView.setBackground(Color.WHITE);
		frmView.setLayout(null);
		
		frmView.getContentPane().setBackground(Color.WHITE);
		
		
		lblHead = new JLabel("Student's Detail");
		lblHead.setFont(new Font("Arial",Font.PLAIN,28));
		lblHead.setBounds(550, 10, 200, 30);
		frmView.add(lblHead);
		
		
		txtId = new JTextField(10);
		txtId.setFont(new Font("Times New Roman",Font.PLAIN,16));
		txtId.setBounds(1090, 50, 100, 25);
		frmView.add(txtId);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(1200, 50, 90, 25);
		btnSearch.setFocusable(false);
		frmView.add(btnSearch);
		btnSearch.addActionListener(this);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(5, 50, 90, 25);
		btnBack.setFocusable(false);
		frmView.add(btnBack);
		btnBack.addActionListener(this);
		
		
		table = new JTable();
		Object[] columns = {"ID","NAME","FATHER'S NAME","BIRTH DAY","BIRTH MONTH","BIRTH YEAR","GENDER","MARITAL STATUS","ADDRESS","PIN","DIST","STATE","RELIGION","CATEGORY","EDUCATIONAL QUALIFICATION","AADHAR NOUMBER","MOBILE NO","EMAIL ID","COURSE NAME","COURSE DURATION","COURSE AMOUNT","PAID AMOUNT","COURSE JOINING DAY","COURSE JOINING MONTH","COURSE JOINING YEAR"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.gray);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Arial",Font.PLAIN,12));
//		Font font = new Font("",1,22);
//		table.setFont(font);
		table.setRowHeight(30);
		
		pane = new JScrollPane(table);
		pane.setBounds(5, 100, 1334, 600);
		frmView.add(pane);

		
		
		
		frmView.setSize(1360,750);
		frmView.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frmView.setUndecorated(true);
//		frmView.setResizable(false);
//		frmView.setLocation(5,5);
		frmView.setLocationRelativeTo(null);
		frmView.setVisible(true);
		frmView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	
private void table_update() {
		
		int c;
		try {
			Conn con = new Conn();
			String q1 = "select studentdetails.stdid, studentdetails.stdname, studentdetails.fname, studentdetails.dte, studentdetails.mnth, studentdetails.yr, studentdetails.gender, studentdetails.mstatus, studentdetails.address, studentdetails.pin, studentdetails.dist, studentdetails.state, studentdetails.religion, studentdetails.category, studentdetails.education, studentdetails.aadhar, studentdetails.mobile, studentdetails.email, coursedetails.coursename, coursedetails.courseduration, coursedetails.courseamount, coursedetails.paidamount, coursedetails.dojd, coursedetails.dojm, coursedetails.dojy from studentdetails,coursedetails where studentdetails.stdid = coursedetails.stdid and studentdetails.deleted = 'N' and coursedetails.deleted = 'N' order by studentdetails.stdid asc";
			ResultSet rs = con.s.executeQuery(q1);
			
			ResultSetMetaData rss = rs.getMetaData();
			c = rss.getColumnCount();
			
			DefaultTableModel df = (DefaultTableModel)table.getModel();
			df.setRowCount(0);
			
			while(rs.next())
			{
				Vector v = new Vector();
				
				for(int a = 1; a<= c; a++)
				{
					v.add(rs.getString("studentdetails.stdid"));
					v.add(rs.getString("studentdetails.stdname"));
					v.add(rs.getString("studentdetails.fname"));
					v.add(rs.getString("studentdetails.dte"));
					v.add(rs.getString("studentdetails.mnth"));
					v.add(rs.getString("studentdetails.yr"));
					v.add(rs.getString("studentdetails.gender"));
					v.add(rs.getString("studentdetails.mstatus"));
					v.add(rs.getString("studentdetails.address"));
					v.add(rs.getString("studentdetails.pin"));
					v.add(rs.getString("studentdetails.dist"));
					v.add(rs.getString("studentdetails.state"));
					v.add(rs.getString("studentdetails.religion"));
					v.add(rs.getString("studentdetails.category"));
					v.add(rs.getString("studentdetails.education"));
					v.add(rs.getString("studentdetails.aadhar"));
					v.add(rs.getString("studentdetails.mobile"));
					v.add(rs.getString("studentdetails.email"));
					v.add(rs.getString("coursedetails.coursename"));
					v.add(rs.getString("coursedetails.courseduration"));
					v.add(rs.getString("coursedetails.courseamount"));
					v.add(rs.getString("coursedetails.paidamount"));
					v.add(rs.getString("coursedetails.dojd"));
					v.add(rs.getString("coursedetails.dojm"));
					v.add(rs.getString("coursedetails.dojy"));

					
				}
				df.addRow(v);
			}
			rs.close();
			con.s.close();
					
//			table.setModel(DbUtils.resultSetToTableModel(rs));
					
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		
		String stdId = txtId.getText();
		
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
					new View2(stdId);
					
				}
				
				if(flag==0)
				{
					
					txtId.setText("");
					txtId.requestFocus();
					
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
			frmView.setVisible(false);
		}
	
	}
	public static void main(String[] args)
	{
		new View();
	}

}
