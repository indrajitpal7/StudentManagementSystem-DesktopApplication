package student;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Thread;

/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */
public class Front_Page implements ActionListener{
    JFrame frmFront;
    JLabel lblImg, lblHead, lbl1;
    JButton btnContinue;
    
    Front_Page()
    {
    	initialize();    
    }
    
    private void initialize() {
        frmFront = new JFrame("Student Management System");
        frmFront.setBackground(Color.RED);
        frmFront.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/frontpage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblImg = new JLabel(i3);
        lblImg.setBounds(0, 150, 1360, 530);
        frmFront.add(lblImg);
        
        btnContinue = new JButton("CLICK HERE TO CONTINUE");
        btnContinue.setFont(new Font("Aerial",Font.BOLD, 18));
        btnContinue.setBackground(Color.DARK_GRAY);
        btnContinue.setForeground(Color.WHITE);
        btnContinue.setBounds(500, 600, 300, 70);
        btnContinue.setFocusable(false);
        btnContinue.addActionListener(this);
        
        lbl1 = new JLabel();
        lbl1.setBounds(0, 0, 1360, 750);
        lbl1.setLayout(null);
        
        lblHead = new JLabel("STUDENT MANAGEMENT SYSTEM");
        lblHead.setBounds(80, 30, 1500, 100);
        lblHead.setFont(new Font("serif", Font.PLAIN, 70));
        lblHead.setForeground(Color.RED);
        
        lbl1.add(lblHead);
        lbl1.add(btnContinue);
        frmFront.add(lbl1);
        
        frmFront.getContentPane().setBackground(Color.WHITE);
        
        
        frmFront.setSize(1360,750);
        frmFront.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frmFront.setUndecorated(true);
        frmFront.setLocationRelativeTo(null);
        
        frmFront.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFront.setVisible(true);
        
        while(true)
        {
            lblHead.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null, e);
                
            }
            lblHead.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            	JOptionPane.showMessageDialog(null, e);
                
            }
        }
    }
    
    
    
    public void actionPerformed(ActionEvent  ae)
    {
        if(ae.getSource()==btnContinue)
        {
        	new Login();
            frmFront.setVisible(false);
            
        }
    }
    public static void main(String[] args)
    {
    	new Front_Page();
    }
}
