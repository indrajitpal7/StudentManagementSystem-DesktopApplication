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


/**
 *
 * @author INDRAjit
 * indrajitpal777@gmail.com
 */

public class View2 implements ActionListener{
	
	JFrame frmView2;
	
	JLabel lblPhoto,lblImg,lblHead,lblid,sid,name,sname,fname,sfname,dob,sd,sm,sy,sex,ssex,mstatus,smstatus,address,saddress,pin,spin,dist,sdist,state,sstate,religion,sreligion,category,scategory,edu,sedu,aadhar,saadhar,mob,smob,email,semail,course,scourse,duration,sduration,amount,samount,paidamount,spaidamount,join,sjoind,sjoinm,sjoiny;
	
	String vid,vname,vfname,vsd,vsm,vsy,vsex,vmstatus,vaddress,vpin,vdist,vstate,vreligion,vcategory,vedu,vaadhar,vmob,vemail,vcourse,vduration,vamount,vpaidamount,vjoind,vjoinm,vjoiny;
	
	JButton btnOk;

	byte[] img;

	
	View2(String id)
	{
		frmView2 = new JFrame("Add Student Details");
		frmView2.setBackground(Color.WHITE);
		frmView2.setLayout(null);
		
		frmView2.getContentPane().setBackground(Color.WHITE);
		
		ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("student/icons/background.png"));
		Image img1 = icon1.getImage().getScaledInstance(700, 650, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(img1);
		lblImg = new JLabel(icon2);
		lblImg.setBounds(0, 0, 700, 650);
		frmView2.add(lblImg);
		
		lblPhoto = new JLabel();
		lblPhoto.setBounds(350, 100, 85, 107);
		lblImg.add(lblPhoto);
		
		
		try {
			Conn con = new Conn();
			String q = "select studentdetails.stdid, studentdetails.stdname, studentdetails.fname, studentdetails.dte, studentdetails.mnth, studentdetails.yr, studentdetails.gender, studentdetails.mstatus, studentdetails.address, studentdetails.pin, studentdetails.dist, studentdetails.state, studentdetails.religion, studentdetails.category, studentdetails.education, studentdetails.aadhar, studentdetails.mobile, studentdetails.email, studentdetails.pic, coursedetails.coursename, coursedetails.courseduration, coursedetails.courseamount, coursedetails.paidamount, coursedetails.dojd, coursedetails.dojm, coursedetails.dojy from studentdetails,coursedetails where studentdetails.stdid = '"+id+"' and coursedetails.stdid = '"+id+"' and  studentdetails.deleted = 'N' and coursedetails.deleted = 'N'";
			ResultSet rs = con.s.executeQuery(q);
			
			while(rs.next())
			{
				vid = rs.getString("studentdetails.stdid");
				vname = rs.getString("studentdetails.stdname");
				vfname = rs.getString("studentdetails.fname");
				vsd = rs.getString("studentdetails.dte");
				vsm = rs.getString("studentdetails.mnth");
				vsy = rs.getString("studentdetails.yr");
				vsex = rs.getString("studentdetails.gender");
				vmstatus = rs.getString("studentdetails.mstatus");
				vaddress = rs.getString("studentdetails.address");
				vpin = rs.getString("studentdetails.pin");
				vdist = rs.getString("studentdetails.dist");
				vstate = rs.getString("studentdetails.state");
				vreligion = rs.getString("studentdetails.religion");
				vcategory = rs.getString("studentdetails.category");
				vedu = rs.getString("studentdetails.education");
				vaadhar = rs.getString("studentdetails.aadhar");
				vmob = rs.getString("studentdetails.mobile");
				vemail = rs.getString("studentdetails.email");
				vcourse = rs.getString("coursedetails.coursename");
				vduration = rs.getString("coursedetails.courseduration");
				vamount = rs.getString("coursedetails.courseamount");
				vpaidamount = rs.getString("coursedetails.paidamount");
				vjoind = rs.getString("coursedetails.dojd");
				vjoinm = rs.getString("coursedetails.dojm");
				vjoiny = rs.getString("coursedetails.dojy");
				
				lblPhoto.setIcon(ResizeImage(null, rs.getBytes("studentdetails.pic")));
				
				
				
				
//				img = rs.getBytes("studentdetails.pic");	
//				ImageIcon image = new ImageIcon(img);
//				Image im = image.getImage();
//				Image myImg = im.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
//				ImageIcon newImage = new ImageIcon(myImg);
//				
//				lblPhoto.setIcon(newImage);
				
				

			}

		rs.close();
		con.s.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		

		
		
		
		
		
		
		
		
		
		lblHead = new JLabel("Student's Detail");
		lblHead.setFont(new Font("Times New Roman",Font.PLAIN,28));
		lblHead.setBounds(250, 10, 200, 30);
		lblImg.add(lblHead);
		
		
			
		
		lblid = new JLabel("Student ID :");
		lblid.setFont(new Font("Times New Roman",Font.BOLD,18));
		lblid.setBounds(50, 100, 175, 25);
		lblImg.add(lblid);
		
		sid = new JLabel(vid);
		sid.setFont(new Font("Times New Roman",Font.BOLD,14));
		sid.setBounds(177, 100, 175, 25);
		lblImg.add(sid);
		
		
		
		
		name = new JLabel("Name :");
		name.setFont(new Font("Times New Roman",Font.PLAIN,18));
		name.setBounds(50, 128, 175, 25);
		lblImg.add(name);
		
		sname = new JLabel(vname);
		sname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sname.setBounds(177, 128, 175, 25);
		lblImg.add(sname);
		
		fname = new JLabel("Father's Name :");
		fname.setFont(new Font("Times New Roman",Font.PLAIN,18));
		fname.setBounds(50, 155, 175, 25);
		lblImg.add(fname);
		
		sfname = new JLabel(vfname);
		sfname.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sfname.setBounds(177, 155, 175, 25);
		lblImg.add(sfname);
		
		dob = new JLabel("DOB :");
		dob.setFont(new Font("Times New Roman",Font.PLAIN,18));
		dob.setBounds(50, 182, 175, 25);
		lblImg.add(dob);
		
		sd = new JLabel(vsd);
		sd.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sd.setBounds(177, 182, 30, 25);
		lblImg.add(sd);
		
		sm = new JLabel(vsm);
		sm.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sm.setBounds(210, 182, 100, 25);
		lblImg.add(sm);
		
		sy = new JLabel(vsy);
		sy.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sy.setBounds(280, 182, 80, 25);
		lblImg.add(sy);
		
		sex = new JLabel("Sex :");
		sex.setFont(new Font("Times New Roman",Font.PLAIN,18));
		sex.setBounds(50, 209, 175, 25);
		lblImg.add(sex);
		
		ssex = new JLabel(vsex);
		ssex.setFont(new Font("Times New Roman",Font.PLAIN,14));
		ssex.setBounds(177, 209, 100, 25);
		lblImg.add(ssex);
		
		mstatus = new JLabel("Marital status :");
		mstatus.setFont(new Font("Times New Roman",Font.PLAIN,18));
		mstatus.setBounds(350, 209, 175, 25);
		lblImg.add(mstatus);
		
		smstatus = new JLabel(vmstatus);
		smstatus.setFont(new Font("Times New Roman",Font.PLAIN,14));
		smstatus.setBounds(477, 209, 100, 25);
		lblImg.add(smstatus);
		
		address = new JLabel("Address :");
		address.setFont(new Font("Times New Roman",Font.PLAIN,18));
		address.setBounds(50, 236, 175, 25);
		lblImg.add(address);
		
		saddress = new JLabel(vaddress);
		saddress.setFont(new Font("Times New Roman",Font.PLAIN,14));
		saddress.setBounds(177, 236, 400, 25);
		lblImg.add(saddress);
		
		pin = new JLabel("PIN :");
		pin.setFont(new Font("Times New Roman",Font.PLAIN,18));
		pin.setBounds(50, 263, 175, 25);
		lblImg.add(pin);
		
		spin = new JLabel(vpin);
		spin.setFont(new Font("Times New Roman",Font.PLAIN,14));
		spin.setBounds(177, 263, 100, 25);
		lblImg.add(spin);
		
		dist = new JLabel("Dist :");
		dist.setFont(new Font("Times New Roman",Font.PLAIN,18));
		dist.setBounds(350, 263, 175, 25);
		lblImg.add(dist);
		
		sdist = new JLabel(vdist);
		sdist.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sdist.setBounds(477, 263, 175, 25);
		lblImg.add(sdist);
		
		state = new JLabel("State :");
		state.setFont(new Font("Times New Roman",Font.PLAIN,18));
		state.setBounds(50, 290, 175, 25);
		lblImg.add(state);
		
		sstate = new JLabel(vstate);
		sstate.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sstate.setBounds(177, 290, 100, 25);
		lblImg.add(sstate);
		
		religion = new JLabel("Religion :");
		religion.setFont(new Font("Times New Roman",Font.PLAIN,18));
		religion.setBounds(350, 290, 175, 25);
		lblImg.add(religion);
		
		sreligion = new JLabel(vreligion);
		sreligion.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sreligion.setBounds(477, 290, 100, 25);
		lblImg.add(sreligion);
		
		category = new JLabel("Category :");
		category.setFont(new Font("Times New Roman",Font.PLAIN,18));
		category.setBounds(50, 317, 175, 25);
		lblImg.add(category);
		
		scategory = new JLabel(vcategory);
		scategory.setFont(new Font("Times New Roman",Font.PLAIN,14));
		scategory.setBounds(177, 317, 100, 25);
		lblImg.add(scategory);
		
		edu = new JLabel("Educational :");
		edu.setFont(new Font("Times New Roman",Font.PLAIN,18));
		edu.setBounds(350, 318, 175, 25);
		lblImg.add(edu);
		
		sedu = new JLabel(vedu);
		sedu.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sedu.setBounds(477, 318, 100, 25);
		lblImg.add(sedu);
		
		aadhar = new JLabel("Aadhar No. :");
		aadhar.setFont(new Font("Times New Roman",Font.PLAIN,18));
		aadhar.setBounds(50, 344, 175, 25);
		lblImg.add(aadhar);
		
		saadhar = new JLabel(vaadhar);
		saadhar.setFont(new Font("Times New Roman",Font.PLAIN,14));
		saadhar.setBounds(177, 344, 100, 25);
		lblImg.add(saadhar);
		
		mob = new JLabel("Mobile :");
		mob.setFont(new Font("Times New Roman",Font.PLAIN,18));
		mob.setBounds(350, 344, 175, 25);
		lblImg.add(mob);
		
		smob = new JLabel(vmob);
		smob.setFont(new Font("Times New Roman",Font.PLAIN,14));
		smob.setBounds(477, 344, 100, 25);
		lblImg.add(smob);
		
		email = new JLabel("Email :");
		email.setFont(new Font("Times New Roman",Font.PLAIN,18));
		email.setBounds(50, 371, 175, 25);
		lblImg.add(email);
		
		semail = new JLabel(vemail);
		semail.setFont(new Font("Times New Roman",Font.PLAIN,14));
		semail.setBounds(177, 371, 200, 25);
		lblImg.add(semail);
		
		course = new JLabel("Course Name :");
		course.setFont(new Font("Times New Roman",Font.PLAIN,18));
		course.setBounds(50, 398, 175, 25);
		lblImg.add(course);
		
		scourse = new JLabel(vcourse);
		scourse.setFont(new Font("Times New Roman",Font.PLAIN,14));
		scourse.setBounds(177, 398, 100, 25);
		lblImg.add(scourse);
		
		duration = new JLabel("Course Duration :");
		duration.setFont(new Font("Times New Roman",Font.PLAIN,18));
		duration.setBounds(350, 398, 175, 25);
		lblImg.add(duration);
		
		sduration = new JLabel(vduration);
		sduration.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sduration.setBounds(477, 398, 175, 25);
		lblImg.add(sduration);
		
		amount = new JLabel("Course Amount :");
		amount.setFont(new Font("Times New Roman",Font.PLAIN,18));
		amount.setBounds(50, 425, 175, 25);
		lblImg.add(amount);
		
		samount = new JLabel(vamount);
		samount.setFont(new Font("Times New Roman",Font.PLAIN,14));
		samount.setBounds(177, 425, 175, 25);
		lblImg.add(samount);
		
		paidamount = new JLabel("Paid Amount :");
		paidamount.setFont(new Font("Times New Roman",Font.PLAIN,18));
		paidamount.setBounds(350, 425, 175, 25);
		lblImg.add(paidamount);
		
		spaidamount = new JLabel(vpaidamount);
		spaidamount.setFont(new Font("Times New Roman",Font.PLAIN,14));
		spaidamount.setBounds(477, 425, 175, 25);
		lblImg.add(spaidamount);
		
		join = new JLabel("Joining Date :");
		join.setFont(new Font("Times New Roman",Font.PLAIN,18));
		join.setBounds(50, 452, 175, 25);
		lblImg.add(join);
		
		sjoind = new JLabel(vjoind);
		sjoind.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sjoind.setBounds(177, 452, 30, 25);
		lblImg.add(sjoind);
		
		sjoinm = new JLabel(vjoinm);
		sjoinm.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sjoinm.setBounds(210, 452, 100, 25);
		lblImg.add(sjoinm);
		
		sjoiny = new JLabel(vjoiny);
		sjoiny.setFont(new Font("Times New Roman",Font.PLAIN,14));
		sjoiny.setBounds(280, 452, 80, 25);
		lblImg.add(sjoiny);
		
		btnOk = new JButton("Okay");
		btnOk.setBackground(Color.BLACK);
		btnOk.setForeground(Color.WHITE);
		btnOk.setBounds(525, 500, 100, 30);
		btnOk.setFocusable(false);
		lblImg.add(btnOk);
		btnOk.addActionListener(this);


		
		
		frmView2.setSize(700,650);
		frmView2.setResizable(false);
//		frmView2.setLocation(320,30);
		frmView2.setLocationRelativeTo(null);
		frmView2.setVisible(true);
		frmView2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
//	private void initialize(String i)
//	{
//		
//		
//		try {
//			Conn con = new Conn();
//			String q = "select studentdetails.stdid, studentdetails.stdname, studentdetails.fname, studentdetails.dte, studentdetails.mnth, studentdetails.yr, studentdetails.gender, studentdetails.mstatus, studentdetails.address, studentdetails.pin, studentdetails.dist, studentdetails.state, studentdetails.religion, studentdetails.category, studentdetails.education, studentdetails.aadhar, studentdetails.mobile, studentdetails.email, coursedetails.coursename, coursedetails.courseduration, coursedetails.courseamount, coursedetails.paidamount, coursedetails.dojd, coursedetails.dojm, coursedetails.dojy from studentdetails,coursedetails where studentdetails.stdid = '"+i+"' and coursedetails.stdid = '"+i+"' and  studentdetails.deleted = 'N' and coursedetails.deleted = 'N'";
//			ResultSet rs = con.s.executeQuery(q);
//			
//			while(rs.next())
//			{
//				vid = rs.getString("studentdetails.stdid");
//				vname = rs.getString("studentdetails.stdname");
//				vfname = rs.getString("studentdetails.fname");
//				vsd = rs.getString("studentdetails.dte");
//				vsm = rs.getString("studentdetails.mnth");
//				vsy = rs.getString("studentdetails.yr");
//				vsex = rs.getString("studentdetails.gender");
//				vmstatus = rs.getString("studentdetails.mstatus");
//				vaddress = rs.getString("studentdetails.address");
//				vpin = rs.getString("studentdetails.pin");
//				vdist = rs.getString("studentdetails.dist");
//				vstate = rs.getString("studentdetails.state");
//				vreligion = rs.getString("studentdetails.religion");
//				vcategory = rs.getString("studentdetails.category");
//				vedu = rs.getString("studentdetails.education");
//				vaadhar = rs.getString("studentdetails.aadhar");
//				vmob = rs.getString("studentdetails.mobile");
//				vemail = rs.getString("studentdetails.email");
//				vcourse = rs.getString("coursedetails.coursename");
//				vduration = rs.getString("coursedetails.courseduration");
//				vamount = rs.getString("coursedetails.courseamount");
//				vpaidamount = rs.getString("coursedetails.paidamount");
//				vjoind = rs.getString("coursedetails.dojd");
//				vjoinm = rs.getString("coursedetails.dojm");
//				vjoiny = rs.getString("coursedetails.dojy");
//					
//			}
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		
//		frmView2 = new JFrame("Add Student Details");
//		frmView2.setBackground(Color.WHITE);
//		frmView2.setLayout(null);
//		
//		frmView2.getContentPane().setBackground(Color.WHITE);
//		
//		lblHead = new JLabel("Student's Detail");
//		lblHead.setFont(new Font("Arial",Font.PLAIN,28));
//		lblHead.setBounds(250, 10, 200, 30);
//		frmView2.add(lblHead);
//		
//		id = new JLabel("Student ID");
//		id.setFont(new Font("Arial",Font.PLAIN,14));
//		id.setBounds(50, 100, 175, 25);
//		frmView2.add(id);
//		
//		sid = new JLabel(vid);
//		sid.setFont(new Font("Arial",Font.PLAIN,14));
//		sid.setBounds(227, 100, 175, 25);
//		frmView2.add(sid);
//		
//		name = new JLabel("Name");
//		name.setFont(new Font("Arial",Font.PLAIN,14));
//		name.setBounds(50, 128, 175, 25);
//		frmView2.add(name);
//		
//		sname = new JLabel(vname);
//		sname.setFont(new Font("Arial",Font.PLAIN,14));
//		sname.setBounds(227, 128, 175, 25);
//		frmView2.add(sname);
//		
//		fname = new JLabel("Father's Name");
//		fname.setFont(new Font("Arial",Font.PLAIN,14));
//		fname.setBounds(50, 155, 175, 25);
//		frmView2.add(fname);
//		
//		sfname = new JLabel(vfname);
//		sfname.setFont(new Font("Arial",Font.PLAIN,14));
//		sfname.setBounds(227, 155, 175, 25);
//		frmView2.add(sfname);
//		
//		dob = new JLabel("DOB");
//		dob.setFont(new Font("Arial",Font.PLAIN,14));
//		dob.setBounds(50, 182, 175, 25);
//		frmView2.add(dob);
//		
//		sd = new JLabel(vsd);
//		sd.setFont(new Font("Arial",Font.PLAIN,14));
//		sd.setBounds(227, 182, 30, 25);
//		frmView2.add(sd);
//		
//		sm = new JLabel(vsm);
//		sm.setFont(new Font("Arial",Font.PLAIN,14));
//		sm.setBounds(260, 182, 100, 25);
//		frmView2.add(sm);
//		
//		sy = new JLabel(vsy);
//		sy.setFont(new Font("Arial",Font.PLAIN,14));
//		sy.setBounds(350, 182, 80, 25);
//		frmView2.add(sy);
//		
//		sex = new JLabel("Sex");
//		sex.setFont(new Font("Arial",Font.PLAIN,14));
//		sex.setBounds(50, 209, 175, 25);
//		frmView2.add(sex);
//		
//		ssex = new JLabel(vsex);
//		ssex.setFont(new Font("Arial",Font.PLAIN,14));
//		ssex.setBounds(227, 209, 100, 25);
//		frmView2.add(ssex);
//		
//		mstatus = new JLabel("Marital status");
//		mstatus.setFont(new Font("Arial",Font.PLAIN,14));
//		mstatus.setBounds(350, 209, 175, 25);
//		frmView2.add(mstatus);
//		
//		smstatus = new JLabel(vmstatus);
//		smstatus.setFont(new Font("Arial",Font.PLAIN,14));
//		smstatus.setBounds(495, 209, 100, 25);
//		frmView2.add(smstatus);
//		
//		address = new JLabel("Address");
//		address.setFont(new Font("Arial",Font.PLAIN,14));
//		address.setBounds(50, 236, 175, 25);
//		frmView2.add(address);
//		
//		saddress = new JLabel(vaddress);
//		saddress.setFont(new Font("Arial",Font.PLAIN,14));
//		saddress.setBounds(227, 236, 400, 25);
//		frmView2.add(saddress);
//		
//		pin = new JLabel("PIN");
//		pin.setFont(new Font("Arial",Font.PLAIN,14));
//		pin.setBounds(50, 263, 175, 25);
//		frmView2.add(pin);
//		
//		spin = new JLabel(vpin);
//		spin.setFont(new Font("Arial",Font.PLAIN,14));
//		spin.setBounds(227, 263, 100, 25);
//		frmView2.add(spin);
//		
//		dist = new JLabel("Dist");
//		dist.setFont(new Font("Arial",Font.PLAIN,14));
//		dist.setBounds(350, 263, 175, 25);
//		frmView2.add(dist);
//		
//		sdist = new JLabel(vdist);
//		sdist.setFont(new Font("Arial",Font.PLAIN,14));
//		sdist.setBounds(495, 263, 175, 25);
//		frmView2.add(sdist);
//		
//		state = new JLabel("State");
//		state.setFont(new Font("Arial",Font.PLAIN,14));
//		state.setBounds(50, 290, 175, 25);
//		frmView2.add(state);
//		
//		sstate = new JLabel(vstate);
//		sstate.setFont(new Font("Arial",Font.PLAIN,14));
//		sstate.setBounds(227, 290, 100, 25);
//		frmView2.add(sstate);
//		
//		religion = new JLabel("Religion");
//		religion.setFont(new Font("Arial",Font.PLAIN,14));
//		religion.setBounds(350, 290, 175, 25);
//		frmView2.add(religion);
//		
//		sreligion = new JLabel(vreligion);
//		sreligion.setFont(new Font("Arial",Font.PLAIN,14));
//		sreligion.setBounds(495, 290, 100, 25);
//		frmView2.add(sreligion);
//		
//		category = new JLabel("Category");
//		category.setFont(new Font("Arial",Font.PLAIN,14));
//		category.setBounds(50, 317, 175, 25);
//		frmView2.add(category);
//		
//		scategory = new JLabel(vcategory);
//		scategory.setFont(new Font("Arial",Font.PLAIN,14));
//		scategory.setBounds(227, 317, 100, 25);
//		frmView2.add(scategory);
//		
//		edu = new JLabel("Educational");
//		edu.setFont(new Font("Arial",Font.PLAIN,14));
//		edu.setBounds(350, 318, 175, 25);
//		frmView2.add(edu);
//		
//		sedu = new JLabel(vedu);
//		sedu.setFont(new Font("Arial",Font.PLAIN,14));
//		sedu.setBounds(495, 318, 100, 25);
//		frmView2.add(sedu);
//		
//		aadhar = new JLabel("Aadhar No.");
//		aadhar.setFont(new Font("Arial",Font.PLAIN,14));
//		aadhar.setBounds(50, 344, 175, 25);
//		frmView2.add(aadhar);
//		
//		saadhar = new JLabel(vaadhar);
//		saadhar.setFont(new Font("Arial",Font.PLAIN,14));
//		saadhar.setBounds(227, 344, 100, 25);
//		frmView2.add(saadhar);
//		
//		mob = new JLabel("Mobile");
//		mob.setFont(new Font("Arial",Font.PLAIN,14));
//		mob.setBounds(350, 344, 175, 25);
//		frmView2.add(mob);
//		
//		smob = new JLabel(vmob);
//		smob.setFont(new Font("Arial",Font.PLAIN,14));
//		smob.setBounds(495, 344, 100, 25);
//		frmView2.add(smob);
//		
//		email = new JLabel("Email");
//		email.setFont(new Font("Arial",Font.PLAIN,14));
//		email.setBounds(50, 371, 175, 25);
//		frmView2.add(email);
//		
//		semail = new JLabel(vemail);
//		semail.setFont(new Font("Arial",Font.PLAIN,14));
//		semail.setBounds(227, 371, 200, 25);
//		frmView2.add(semail);
//		
//		course = new JLabel("Course Name");
//		course.setFont(new Font("Arial",Font.PLAIN,14));
//		course.setBounds(50, 398, 175, 25);
//		frmView2.add(course);
//		
//		scourse = new JLabel(vcourse);
//		scourse.setFont(new Font("Arial",Font.PLAIN,14));
//		scourse.setBounds(227, 398, 100, 25);
//		frmView2.add(scourse);
//		
//		duration = new JLabel("Course Duration");
//		duration.setFont(new Font("Arial",Font.PLAIN,14));
//		duration.setBounds(350, 398, 175, 25);
//		frmView2.add(duration);
//		
//		sduration = new JLabel(vduration);
//		sduration.setFont(new Font("Arial",Font.PLAIN,14));
//		sduration.setBounds(495, 398, 175, 25);
//		frmView2.add(sduration);
//		
//		amount = new JLabel("Course Amount");
//		amount.setFont(new Font("Arial",Font.PLAIN,14));
//		amount.setBounds(50, 425, 175, 25);
//		frmView2.add(amount);
//		
//		samount = new JLabel(vamount);
//		samount.setFont(new Font("Arial",Font.PLAIN,14));
//		samount.setBounds(227, 425, 175, 25);
//		frmView2.add(samount);
//		
//		paidamount = new JLabel("Paid Amount");
//		paidamount.setFont(new Font("Arial",Font.PLAIN,14));
//		paidamount.setBounds(350, 425, 175, 25);
//		frmView2.add(paidamount);
//		
//		spaidamount = new JLabel(vpaidamount);
//		spaidamount.setFont(new Font("Arial",Font.PLAIN,14));
//		spaidamount.setBounds(495, 425, 175, 25);
//		frmView2.add(spaidamount);
//		
//		join = new JLabel("Joining Date");
//		join.setFont(new Font("Arial",Font.PLAIN,14));
//		join.setBounds(50, 452, 175, 25);
//		frmView2.add(join);
//		
//		sjoind = new JLabel(vjoind);
//		sjoind.setFont(new Font("Arial",Font.PLAIN,14));
//		sjoind.setBounds(227, 452, 30, 25);
//		frmView2.add(sjoind);
//		
//		sjoinm = new JLabel(vjoinm);
//		sjoinm.setFont(new Font("Arial",Font.PLAIN,14));
//		sjoinm.setBounds(260, 452, 100, 25);
//		frmView2.add(sjoinm);
//		
//		sjoiny = new JLabel(vjoiny);
//		sjoiny.setFont(new Font("Arial",Font.PLAIN,14));
//		sjoiny.setBounds(350, 452, 80, 25);
//		frmView2.add(sjoiny);
//		
//		frmView2.setVisible(true);
//		frmView2.setSize(700,650);
//		frmView2.setLocation(320,30);
//		frmView2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	
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
		Image newImg = img.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);

		return image;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnOk)
		{
			frmView2.setVisible(false);
		}
		
	}


	public static void main(String[] args) {
		new View2("");

	}

}
