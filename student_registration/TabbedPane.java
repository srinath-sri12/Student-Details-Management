package student_registration;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class TabbedPane extends JFrame implements ActionListener,ItemListener{
	JMenuBar mb;
	public String s1,s2,s3,name,roll;
	JMenu file,edit,co,re;
	JMenuItem pa,pr,ex,sr,par,prr,exr,psr,ma,exit;
	JTabbedPane t;
	JPanel p1,p2,p3;
	JLabel l1,l2,act,lvl,year;
	JComboBox cb,yr;
	JTextField t1;
	String po[]= {"Select","Zone","District","State","None"};
	String y[]= {"Select","I","II","III","IV"};
	JButton p1b1,p1b2,p2b1,p2b2,p3b1,p3b2,p3b3,p3b4,p3b5;	//p1b1=panel1-button1,p1b2=panel1-button2
	
	 JMenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9;
	   static JPopupMenu pm;
	 
	   JLabel l;
	public TabbedPane(String name,String roll)
	{
		JSeparator k1,k2,k3;
		k1=new JSeparator();
		k2=new JSeparator();
		k3=new JSeparator();
		
		 setLocationRelativeTo(null);
		   pm=new JPopupMenu();
		   m1 = new JMenuItem("New Paper"); 
	       m2 = new JMenuItem("New Project"); 
	       m3 = new JMenuItem("New Extra-Curricular"); 
	       m4 = new JMenuItem("Sudents-Results"); 
	       m5 = new JMenuItem("Paper-Results"); 
	       m6 = new JMenuItem("Project-Results"); 
	       m7 = new JMenuItem("Extra-Curricular-Results"); 
	       m8 = new JMenuItem("New Student Data"); 
	       m9=new JMenuItem("Existing Student Data");
	       pm.add(m1);
	       pm.add(m2);
	       pm.add(k1);
	       pm.add(m3);
	       pm.add(k2);
	       pm.add(m4);
	       pm.add(m5);
	       pm.add(m6);
	       pm.add(m7);
	       pm.add(k3);
	       pm.add(m8);
	       pm.add(m9);
	       m1.addActionListener(this);
	       m2.addActionListener(this);
	       m3.addActionListener(this);
	       m4.addActionListener(this);
	       m5.addActionListener(this);
	       m6.addActionListener(this);
	       m7.addActionListener(this);
	       m8.addActionListener(this);
	       m9.addActionListener(this);
	       
	    
		this.name=name;
		this.roll=roll;
		//System.out.println(name);
		setTitle("Student Registration");
		t=new JTabbedPane();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		l1=new JLabel("Select Corresponding Event");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);
		l1.setFont(f1);
		l1.setBounds(85,50, 400, 30);
		p1b1=new JButton("Paper Presentation");
		p1b2=new JButton("Project Presentation");
		p1b1.setBounds(130,120,200,30);
		p1b2.setBounds(130,220,200,30);
		p1b1.addActionListener(this);
		p1b2.addActionListener(this);
		p1.add(l1);
		p1.add(p1b1);
		p1.add(p1b2);
		//p1.add(pm);
		l2=new JLabel("Enter Your Extra-Curricular Activities!");
		Font  f2  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);
		l2.setFont(f2);
		p2b1=new JButton("Insert");
		p2b2=new JButton("Cancel");
		act=new JLabel("Name of Activity : ");
		lvl=new JLabel("Level : ");
		year=new JLabel("Year at which you Involved in this Activity : ");
		t1=new JTextField(40);
		cb=new JComboBox<String>(po);
		yr=new JComboBox<String>(y);
		cb.addItemListener(this);
		yr.addItemListener(this);
		l2.setBounds(70,35,800,30);
		act.setBounds(35,125,200,30);
		t1.setBounds(300,130,200,25);
		lvl.setBounds(35,185,200,30);
		cb.setBounds(300,190,200,25);
		year.setBounds(35,240,200,30);
		yr.setBounds(300,245,100,25);
		p2b1.addActionListener(this);
		p2b2.addActionListener(this);
		p2b1.setBounds(80,320,100,30);
		p2b2.setBounds(280,320,100,30);
		p2b1.setToolTipText("Insert one or more data by clicking Insert Button");
		p2b2.setToolTipText("Cancel the Insertion by clicking Cancel Button");
		p2.add(l2);
		p2.add(act);
		p2.add(t1);
		p2.add(lvl);
		p2.add(cb);
		p2.add(year);
		p2.add(yr);
		p2.add(p2b1);
		p2.add(p2b2);
		//p2.add(pm);
		p3b1=new JButton("Students Detials");
		p3b1.setToolTipText("Click this button to see all the students details who are all entered their details");
		p3b1.addActionListener(this);
		
		p3b2=new JButton("Paper Details");
		p3b2.setToolTipText("Click this button to see the students who are all entered their details for Paper Presentation");
		p3b2.addActionListener(this);
		
		
		p3b3=new JButton("Project Details");
		p3b3.setToolTipText("Click this button to see the students who are all entered their details for Project Presentation");
		p3b3.addActionListener(this);
	
		
		p3b4=new JButton("Extra-Curricular Details");
		p3b4.setToolTipText("Click this button to see the students who are all entered their details for Extra-Curricular Activities");
		p3b4.addActionListener(this);
		
		p3b5=new JButton("Particular Student's Details");
		p3b5.setToolTipText("Click this button to see the particular Student's Details");
		p3b5.addActionListener(this);
		
		p3b1.setBounds(130,70,200,30);
		p3b2.setBounds(130,130,200,30);
		p3b3.setBounds(130,190,200,30);
		p3b4.setBounds(130,250,200,30);
		p3b5.setBounds(130,310,200,30);
		
		p3.add(p3b1);
		p3.add(p3b2);
		p3.add(p3b3);
		p3.add(p3b4);
		p3.add(p3b5);
	//	p3.add(pm);
		
		t.add("Co-Curricular", p1);
		
		t.add(p2, "Extra-Curricular");
		t.add(p3,"Result");
		t.setSize(300,300);
		
		getContentPane().add(t);
	   // b.addActionListener(this);
	    //b.setBackground(Color.red);
		setSize(550,550);
		setVisible(true);
		addMenu();
		addSSMenu();
		setJMenuBar(mb);
		 t.addMouseListener(new PopupListener());
	      
		
		
	}
	 private static class PopupListener extends MouseAdapter
	    {
	        public void mousePressed(MouseEvent e)
	        {
	            checkForPopup(e);
	        }
	        public void mouseReleased(MouseEvent e)
	        {
	            checkForPopup(e);
	        }
	        public void mouseClicked(MouseEvent e)
	        {
	            checkForPopup(e);
	        }
	        private void checkForPopup(MouseEvent e)
	        {
	            if(e.isPopupTrigger())
	            {
	                Component c = e.getComponent();
	                pm.show(c, e.getX(), e.getY());
	            }
	        }
	    }

	public void clear()
	{
		t1.setText("");
		cb.setSelectedIndex(0); 
		yr.setSelectedIndex(0);
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void addMenu()
	{

		 JSeparator s = new JSeparator(); 
		 JSeparator s1 = new JSeparator(); 
		mb=new JMenuBar();
		file=new JMenu("File");
		edit=new JMenu("Edit");
		re=new JMenu("View Results");
		
		edit.setMnemonic(KeyEvent.VK_E);
		file.setMnemonic(KeyEvent.VK_F);
		re.setMnemonic(KeyEvent.VK_R);
		
		co=new JMenu("Co-Curricular");
		
		co.setMnemonic(KeyEvent.VK_C);
		
		
		//co.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK));
		//ex_cr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,KeyEvent.CTRL_MASK));
		
		file.add(co);
		file.add(s);
		
		mb.add(file);
		mb.add(edit);
		edit.add(re);
		
		
	}
	public void addSSMenu()
	{
		pa=new JMenuItem("New Paper");
		pr=new JMenuItem("New Project");
		ex=new JMenuItem("New Ex-Crr Act...");
		sr=new JMenuItem("Sudents");
		par=new JMenuItem("Paper");
		prr=new JMenuItem("Project");
		exr=new JMenuItem("ExtraCurricular");
		psr=new JMenuItem("Particular Student result...");
		ma=new JMenuItem("Insert for New Student...");
		exit=new JMenuItem("Exit!");
		
		
		pa.setToolTipText("Insert new Paper Details");
		pr.setToolTipText("Insert new Project Details");
		ex.setToolTipText("Insert new Extra-Curricular Activities Details");
		sr.setToolTipText("View Students Details who are all entered their details");
		par.setToolTipText("View Paper Details who have presented Paper(s)");
		prr.setToolTipText("View Project Details who have presented Project(s)");
		exr.setToolTipText("View Extra-Curricular Activities of Students");
		pa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_MASK));
		pa.setMnemonic(KeyEvent.VK_A);
		pr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_MASK));
		pr.setMnemonic(KeyEvent.VK_R);
		ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.SHIFT_MASK|KeyEvent.CTRL_MASK));
		ex.setMnemonic(KeyEvent.VK_E);
		
		sr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.CTRL_MASK|KeyEvent.ALT_MASK));
		sr.setMnemonic(KeyEvent.VK_U);

		par.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK|KeyEvent.ALT_MASK));
		par.setMnemonic(KeyEvent.VK_R);

		prr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK|KeyEvent.ALT_MASK));
		prr.setMnemonic(KeyEvent.VK_J);

		exr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_MASK|KeyEvent.ALT_MASK));
		exr.setMnemonic(KeyEvent.VK_X);
		
		psr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_MASK|KeyEvent.ALT_MASK));
		psr.setMnemonic(KeyEvent.VK_I);

		ma.setMnemonic(KeyEvent.VK_H);
		ma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,KeyEvent.CTRL_MASK|KeyEvent.SHIFT_MASK));
	
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_MASK|KeyEvent.SHIFT_MASK));
		
		
		 JSeparator s = new JSeparator(); 
		 JSeparator s1 = new JSeparator(); 
		 JSeparator s2 = new JSeparator(); 
			
		 JSeparator s3 = new JSeparator(); 
			
		 JSeparator s4 = new JSeparator(); 
			
		co.add(pa);
		co.add(s);
		co.add(pr);
		
		re.add(sr);
		re.add(s2);
		re.add(par);
		re.add(prr);
		re.add(s3);
		re.add(exr);
		re.add(psr);
		edit.add(ma);
		ma.addActionListener(this);
		
		file.add(ex);
		pa.addActionListener(this);
		pr.addActionListener(this);
		ex.addActionListener(this);
		psr.addActionListener(this);
		file.add(s4);
		file.add(exit);
		
		exit.addActionListener(this);
		sr.addActionListener(this);
		par.addActionListener(this);
		prr.addActionListener(this);
		exr.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		String res=e.getActionCommand();
		
		if(res.contentEquals("Paper Presentation")||e.getSource()==pa)
		{
			Paper pa=new Paper(name,roll);
		}
		else if(res.contentEquals("Project Presentation")||e.getSource()==pr)
		{
			Project pr=new Project(name,roll);
		}
		else if(res.equals("Insert"))
		{
			s1=t1.getText();
			s2=(String) cb.getSelectedItem();
			s3=(String) yr.getSelectedItem();
			/*System.out.println(s1);
			System.out.println(s2);*/
			
			if(s1.length()!=0 && s2!="Select" && s3!="Select")
			{
				addOperation();
				clear();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Give Valid Details!");  
				clear();
			}
		}
		else if(e.getSource()==ex)
		{
			 t.setSelectedIndex(1);
		}
		else if(e.getSource()==p3b1||e.getSource()==sr)
		{
			
			Studentresult sd=new Studentresult();
		}
		else if(e.getSource()==p3b2||e.getSource()==par)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			Paperresult r=new Paperresult(check);
		}
		else if(e.getSource()==p3b3||e.getSource()==prr)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			Projectresult pr=new Projectresult(check);
		}
		else if(e.getSource()==p3b4||e.getSource()==exr)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			extraresult pr=new extraresult(check);
		}
		else if(e.getSource()==p3b5||e.getSource()==psr)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			try
			{
				//Load Jdbc Odbc Driver
				int pac=0,prc=0,ec=0;
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String url = "jdbc:ucanaccess://E://Java//Student.accdb";
				Connection con = DriverManager.getConnection(url);
				 PreparedStatement st2=con.prepareStatement("SELECT * FROM Paper WHERE RollNo=?");
				st2.setString(1,check);
		        
		         ResultSet rs1=st2.executeQuery();
		       //  System.out.println(rs1);
		         String roll=null;
		         while ( rs1.next() ) {
		         	
			              roll = rs1.getString("place");
			            //  System.out.println(roll);
			              pac++;
		         }
		         
		        // System.out.println(pac);
		         
		         PreparedStatement st3=con.prepareStatement("SELECT * FROM Project WHERE RollNo=?");
		         st3.setString(1,check); 
		         ResultSet rs2=st3.executeQuery();
		         String roll1=null;
		         while ( rs2.next() ) {
		         	
			              roll1 = rs2.getString("RollNo");
			              prc++;
		         }
		         
		         PreparedStatement st4=con.prepareStatement("SELECT * FROM Extra WHERE RollNo=?");
		         st4.setString(1,check); 
		         ResultSet rs3=st4.executeQuery();
		         String roll2=null;
		         while ( rs3.next() ) {
		         	
			              roll2 = rs3.getString("RollNo");
			              ec++;
		         }
		         
		         
		         PreparedStatement st5=con.prepareStatement("SELECT * FROM Details WHERE RollNo=?");
					st5.setString(1,check);
		        
		         ResultSet rs5=st5.executeQuery();
		         String roll5=null,na=null,dep = null;
		         String yr=null,se=null;
		         while ( rs5.next() ) {
		         	
			              // roll = rs1.getString("RollNo");
			               na = rs5.getString("Name");
			               dep = rs5.getString("Dept");
			               yr = rs5.getString("Year");
			               se= rs5.getString("Section");
		         }
		         
		         JFrame f=new JFrame(check+"'s Details");
		         f.setVisible(true);
		         f.setSize(500,500);
		         f.setLayout(null);
		         
		         
		         JLabel n=new JLabel("Name of the Student : ");
					JLabel r=new JLabel("Roll No. of the Student : ");
					JLabel de=new JLabel("Dept of the Student : ");
					JLabel y=new JLabel("Year of the Student : ");
					JLabel sect=new JLabel("Section of the Student : ");
					n.setBounds(90,70,200,30);
					r.setBounds(90,110,200,30);
					de.setBounds(90,150,200,30);
					y.setBounds(90,190,200,30);
					sect.setBounds(90,230,200,30);
					JTextField t1=new JTextField(20);
					JTextField t2=new JTextField(20);
					JTextField t3=new JTextField(20);
					JTextField t4=new JTextField(20);
					JTextField t5=new JTextField(20);
					t1.setBounds(280,75,150,25);
					t2.setBounds(280,115,150,25);
					t3.setBounds(280,155,150,25);
					t4.setBounds(280,195,150,25);
					t5.setBounds(280,235,150,25);
					  t1.setText(na);
			            t1.setEditable(false);
			            t2.setText(check);
				         t2.setEditable(false);
			            t3.setText(dep);
			            t3.setEditable(false);
			            t4.setText(yr);
			            t4.setEditable(false);
			            t5.setText(se);
			            t5.setEditable(false);
			            f.add(n);
				          f.add(t1);
				         f.add(r);
				        f.add(t2);
				         f.add(de);
				          f.add(y);
				          f.add(sect);
				          f.add(t3);
				          f.add(t4);
				          f.add(t5);
		         
		         JLabel ppc,prpc,exc;
		         JTextField c1,c2,c3;
		         ppc=new JLabel("No. of Papers Presented : ");
		         prpc=new JLabel("No. of Project Presented : ");
		         exc=new JLabel("No. of Extra-Curricular Activities : ");
		         c1=new JTextField(10);
		         c2=new JTextField(10);
		         c3=new JTextField(10);
		         
		         c1.setText(String.valueOf(pac));
		         c2.setText(String.valueOf(prc));
		         c3.setText(String.valueOf(ec));
		         
		         c1.setEditable(false);
		         c2.setEditable(false);
		         c3.setEditable(false);
		         
		         ppc.setBounds(90,300,300,30);
		         c1.setBounds(350,305,100,20);

		         
		         prpc.setBounds(90,350,300,30);
		         c2.setBounds(350,355,100,20);

		         
		         exc.setBounds(90,400,300,30);
		         c3.setBounds(350,405,100,20);

		         f.add(ppc);
		         f.add(c1);
		         f.add(prpc);
		         f.add(c2);
		         f.add(exc);
		         f.add(c3);
		         
		         
		         
				          con.close();
		         
		         
			}catch(Exception po)
			{
				JOptionPane.showMessageDialog(null,"Student details not found !" );
			}
			
			
		}
		
		else if(e.getSource()==re)
		{
			t.setSelectedIndex(2);
		}
		else if(e.getSource()==ma)
		{
			
			Home_ui h=new Home_ui();
		
		}
		else if(res.equals("Cancel"))
		{
			dispose();
		}
		else if(e.getSource()==exit)
		{
			   int a=JOptionPane.showConfirmDialog(null,"Do you wantto Exit?");  
			   if(a==JOptionPane.YES_OPTION){  
			       dispose();
			       
			       } 
			   else if(a==JOptionPane.NO_OPTION)
			   {
				   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   }
			   else if(a==JOptionPane.CANCEL_OPTION)
			   {
				   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   }
		}
		else if(e.getSource()==m1)
		{
			Paper pr=new Paper(name,roll);
		}
		else if(e.getSource()==m2)
		{
			Project pr=new Project(name,roll);
		}
		else if(e.getSource()==m3)
		{
			 t.setSelectedIndex(1);
		}
		else if(e.getSource()==m4)
		{
			Studentresult pr=new Studentresult();
		}
		else if(e.getSource()==m5)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			Paperresult pr=new Paperresult(check);
		}
		else if(e.getSource()==m6)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			Projectresult pr=new Projectresult(check);
		}
		else if(e.getSource()==m7)
		{
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			extraresult pr=new extraresult(check);
		}
		else if(e.getSource()==m8)
		{
			Home_ui h=new Home_ui();
			
		}
		else if(e.getSource()==m9)
		{
			Login_signup.exists();
			
			
		}
	}
	
	public void addOperation()
	{
		//ResultSet rs;
		Statement st;
		try
		{
			//Load Jdbc Odbc Driver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://E://Java//Student.accdb";
			Connection con = DriverManager.getConnection(url);
			Statement st1 = con.createStatement();
			
		String sql = "INSERT INTO Extra VALUES('"+name+"','"+roll+"','"+s1+"','"+s2+"','"+s3+"')";
					
		
			
			
			st1.executeUpdate(sql);
		
			/*	String sql="SELECT * FROM Details";
			 ResultSet rs=st1.executeQuery(sql);
			
	            while ( rs.next() ) {
	                String roll = rs.getString("Roll No");
	                String na = rs.getString("Name");
	                String de = rs.getString("Dept");
	                String yr = rs.getString("Year");
	                String se= rs.getString("Section");
	                
	                System.out.println(roll);
	                System.out.println(na);
	                System.out.println(de);
	                System.out.println(yr);
	                System.out.println(se);
	            }*/
			JOptionPane.showMessageDialog(null, "Record Added Succesfully.","Record Added",
                        JOptionPane.INFORMATION_MESSAGE);
			con.close();
			st1.close();
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void result() {
		// TODO Auto-generated method stub
		
		t.setSelectedIndex(2);
		t.setEnabledAt(0, false);
		t.setEnabledAt(1, false);
		co.setEnabled(false);
		ex.setEnabled(false);
		edit.setEnabled(false);
		m1.setEnabled(false);
		m2.setEnabled(false);
		m3.setEnabled(false);
		m8.setEnabled(false);
		m9.setEnabled(false);
	}
	
}
