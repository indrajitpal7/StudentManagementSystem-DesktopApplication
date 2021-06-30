package student;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
//import java.sql.*;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
//import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class Details implements ActionListener{

	JFrame frmDetails;
	JLabel lblImg, lblHead,lblTime;
	JButton btnAdd, btnView, btnRemove, btnUpdate,btnLogOut,btnBackup;
//	Calendar calender;
//	SimpleDateFormat timeFormat;
	String filename = null,location = null;
	
	
	Details()
	{
		initialize();
	}
	
	private void initialize() {
		frmDetails = new JFrame("Dashboard");
		frmDetails.setBackground(Color.WHITE);
		frmDetails.setLayout(null);
		
		lblImg = new JLabel();
		lblImg.setBounds(0, 0, 700, 500);
		lblImg.setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/details.jpg"));
		lblImg.setIcon(i1);
		frmDetails.add(lblImg);
		
		lblHead = new JLabel("Manage Student");
		lblHead.setBounds(430, 20, 200, 40);
		lblHead.setFont(new Font("serif", Font.BOLD,25));
		lblHead.setForeground(Color.BLACK);
		lblImg.add(lblHead);
		
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/addicon.png"));
		Image ig1 = ic1.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
		btnAdd = new JButton("Add",new ImageIcon(ig1));
		btnAdd.setBounds(400, 80, 120, 40);
		btnAdd.setFont(new Font("serif", Font.BOLD, 15));
		btnAdd.setFocusable(false);
		lblImg.add(btnAdd);
		
		ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("student/icons/view.png"));
		Image ig2 = ic2.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
		btnView = new JButton("View", new ImageIcon(ig2));
		btnView.setBounds(530, 80, 120, 40);
		btnView.setFont(new Font("serif", Font.BOLD, 15));
		btnView.setFocusable(false);
		lblImg.add(btnView);
		
		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("student/icons/remove.png"));
		Image ig3 = ic3.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
		btnRemove = new JButton("Remove", new ImageIcon(ig3));
		btnRemove.setBounds(400, 140, 120, 40);
		btnRemove.setFont(new Font("serif", Font.BOLD, 15));
		btnRemove.setFocusable(false);
		lblImg.add(btnRemove);
		
		ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("student/icons/update.png"));
		Image ig4 = ic4.getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT);
		btnUpdate = new JButton("Update", new ImageIcon(ig4));
		btnUpdate.setBounds(530, 140, 120, 40);
		btnUpdate.setFont(new Font("serif", Font.BOLD, 15));
		btnUpdate.setFocusable(false);
		lblImg.add(btnUpdate);
		
		ImageIcon ic5 = new ImageIcon(ClassLoader.getSystemResource("student/icons/backup.png"));
		Image ig5 = ic5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		btnBackup = new JButton("BackUp", new ImageIcon(ig5));
		btnBackup.setBounds(400, 400, 120, 30);
		btnBackup.setFont(new Font("serif", Font.BOLD, 15));
		btnBackup.setFocusable(false);
		btnBackup.setForeground(Color.BLUE);
		lblImg.add(btnBackup);
		
		ImageIcon ic6 = new ImageIcon(ClassLoader.getSystemResource("student/icons/logout.png"));
		Image ig6 = ic6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		btnLogOut = new JButton("Log Out", new ImageIcon(ig6));
		btnLogOut.setBounds(530, 400, 120, 30);
		btnLogOut.setFont(new Font("serif", Font.BOLD, 15));
		btnLogOut.setFocusable(false);
		btnLogOut.setForeground(Color.RED);
		lblImg.add(btnLogOut);
		
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnView.addActionListener(this);
		btnLogOut.addActionListener(this);
		btnBackup.addActionListener(this);
		

		
		frmDetails.setSize(700,500);
		frmDetails.setResizable(false);
//		frmDetails.setLocation(325,125);
		frmDetails.setLocationRelativeTo(null);
		frmDetails.setVisible(true);
//		settime();
		
		frmDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
//	public void settime()
//	{
//		timeFormat = new SimpleDateFormat("hh:mm:ss a");
//		lblTime = new JLabel();
//		lblTime.setBounds(10, 0, 100, 100);
//		lblImg.add(lblTime);
//		
//		
//		while(true)
//		{
//			time = timeFormat.format(calender.getInstance().getTime());
//			lblTime.setText(time);
//			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
//	}
	
	public void actionPerformed(ActionEvent ae)
	{
			if(ae.getSource() == btnAdd)
			{
				new Add();
				frmDetails.setVisible(false);
			}
			else if(ae.getSource() == btnView)
			{
				new View();
				frmDetails.setVisible(false);
			}
			else if(ae.getSource() == btnRemove)
			{
				new Remove();
				frmDetails.setVisible(false);
			}
			else if(ae.getSource() == btnUpdate)
			{
				new Update();
				frmDetails.setVisible(false);
			}
			else if(ae.getSource() == btnBackup)
			{
				JFileChooser path = new JFileChooser();
				
				String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				int result = path.showSaveDialog(null);
					
					
					if(result == JFileChooser.APPROVE_OPTION)
					{
						
						File f = path.getSelectedFile();
						location = f.getAbsolutePath();
						location = location.replace('\\', '/');
						filename = location + "_" + date + ".sql";

						Process p = null;
						
						try {
								Runtime runtime = Runtime.getRuntime();
								p = runtime.exec("C:/Program Files/MySQL/MySQL Server 8.0/bin/mysqldump.exe -uroot -pRoot@MySQL --add-drop-database -B studentmanagementsystem -r" + filename);
							
								int processComplete = p.waitFor();
							
								if(processComplete == 0)
								{
									JOptionPane.showMessageDialog(null, "Backup Created");
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Error!!");
								}
							}
						catch(Exception e){
								e.printStackTrace();
								JOptionPane.showMessageDialog(null, e);
							}
					}

					else if(result == JFileChooser.CANCEL_OPTION)
					{
						JOptionPane.showMessageDialog(null, "No backup created");
					}
					
			}
			else if(ae.getSource() == btnLogOut)
			{
				int response = JOptionPane.showConfirmDialog(null, "Are you sure to Logout?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(response == JOptionPane.YES_OPTION)
				{
					new Login();
					frmDetails.setVisible(false);
				}
				
			}
			
	}
	
	public static void main(String[] args)
	{
		new Details();
	}
}
