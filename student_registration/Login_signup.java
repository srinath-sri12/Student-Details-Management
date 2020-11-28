package student_registration;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.EventObject;
public class Login_signup extends JFrame implements ActionListener{
	String s1,s2,s3,s4;
	JButton b1 = null,b2 = null,b3=null;
	JTabbedPane t1;
	JPanel p1,p2;
	JLabel h1,h2,roll,pass,roll1,pass1;
	JTextField r1,r2;
	JPasswordField pas1,pas2;
	JButton login,signup;
	public Login_signup()
	{
		
		setVisible(true);
		setTitle("Login/SignUp");
		setSize(400,400);
		t1=new JTabbedPane();
		p1=new JPanel();
		p2=new JPanel();
		p1.setLayout(null);
		p2.setLayout(null);
		
		h1=new JLabel("Login!");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 20);
		h1.setFont(f1);
		h1.setBounds(180,50,500,30);
		roll=new JLabel("User Name : ");
		pass=new JLabel("Password : ");
		r1=new JTextField(20);
		pas1=new JPasswordField(20);
		pas1.setToolTipText("Password length must be greater than 7");
		
		roll.setBounds(80,80,200,100);
		pass.setBounds(80,140,200,100);
		r1.setBounds(170,120,200,25);
		pas1.setBounds(170,180,200,25);
		
		h2=new JLabel("SignUP!");
		Font  f2 = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 20);
		h2.setFont(f2);
		h2.setBounds(180,50,500,30);
		
		roll1=new JLabel("User Name : ");
		pass1=new JLabel("Password : ");
		r2=new JTextField(20);	   
	    pas2=new JPasswordField(20);
	    pas2.setToolTipText("Password length must be atleast 8");
	    
	    roll1.setBounds(80,80,200,100);
		pass1.setBounds(80,140,200,100);
		r2.setBounds(170,120,200,25);
		pas2.setBounds(170,180,200,25);
		
		
		login=new JButton("Login");
		signup=new JButton("SignUp");
		
		login.addActionListener(this);
		signup.addActionListener(this);
		
		login.setBounds(150,250,100,30);
		signup.setBounds(150,250,100,30);
		
		p1.add(h1);
		p1.add(roll);
		p1.add(r1);
		p1.add(pass);
		p1.add(pas1);
		p1.add(login);
		
		p2.add(h2);
		p2.add(roll1);
		p2.add(r2);
		p2.add(pass1);
		p2.add(pas2);
		p2.add(signup);
		
		
		t1.add("Login",p1);
		t1.add("Sign UP",p2);
		
		add(t1);
		
		
	}
	public  void log()
	
	{
		
		JOptionPane.showMessageDialog(null,"Login Success!");
    	JFrame f=new JFrame("Logged In");
    	f.setLayout(null);
    	f.setVisible(true);
    	f.setSize(350,350);
    
    	b1=new JButton("Insert for New Student");
    	b2=new JButton("Insert for Existing Student");
    	b3=new JButton("View Result");
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	b3.addActionListener(this);
    	b1.setBounds(60,80,250,30);
    	b2.setBounds(60,140,250,30);
    	b3.setBounds(60,200,250,30);
    	f.add(b1);
    	f.add(b2);
    	f.add(b3);
    	r1.setText("");
    	pas1.setText("");
    	
	
	}
	public void addOperation()
	{
		
		try
		{
			//Load Jdbc Odbc Driver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://E://Java//Student.accdb";
			Connection con = DriverManager.getConnection(url);
			Statement st1 = con.createStatement();
			
		String sql = "INSERT INTO Signup VALUES('"+s1+"','"+s2+"')";
					
		
			
			
			st1.executeUpdate(sql);
		
				/*String sql="SELECT * FROM Details";
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
			Home_ui o=new Home_ui();
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Account already exist please Login!" );
                        
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
    	{
    		Home_ui o=new Home_ui();
    		
    	}
		else if(e.getSource()==b2)
    	{
			
			exists();
    		//TabbedPane i=new TabbedPane(null,null);
    		
    		
    	}
    	else if(e.getSource()==b3)
    	{
    		TabbedPane i=new TabbedPane(null,null);
    		i.result();
    		
    	}
    	
		if(e.getSource()==signup)
		{
			s1=r2.getText();
			s2=pas2.getText();
			if(s1.length()!=0 && s2.length()>=8)
			{
				addOperation();
				r2.setText("");
				pas2.setText("");
				
			}
			else
			{
				 JOptionPane.showMessageDialog(null,"Your password length is less than 8,Please give valid Password!"); 
			}
			
			
		}
		else if(e.getSource()==login)
		{
			s3=r1.getText();
			s4=pas1.getText();
			try
			{
				//Load Jdbc Odbc Driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				String url = "jdbc:ucanaccess://E://Java//Student.accdb";
				Connection con = DriverManager.getConnection(url);
				Statement st1 = con.createStatement();
				
			//String sql = "INSERT INTO Signup VALUES('"+s1+"','"+s2+"')";
						
			
				
				
				//st1.executeUpdate(sql);
			
					String sql="SELECT * FROM Signup";
				 ResultSet rs=st1.executeQuery(sql);
				int temp=0;
		            while ( rs.next() ) {
		                String un = rs.getString("UserName");
		                String pas = rs.getString("Password");
		                //System.out.println(s3+"\t"+un);
	                	//System.out.println(s4+"\t"+pas);
		                if(s3.equals(un) && s4.equals(pas))
		                {
		                	//System.out.println(s3+"\t"+un);
		                	//System.out.println(s4+"\t"+pas);
		                	temp=1;
		                	break;
		                }
		              
		            }
		            if(temp==1)
		            {
		            	 log();
		            }
		            if(temp==0)
		            {
		            	 JOptionPane.showMessageDialog(null,"Invalid Username or Password!"); 
		            }
		           
		            
				
				con.close();
				st1.close();
				
			}catch(Exception ae)
			{
				JOptionPane.showMessageDialog(null, ae.getMessage(),"Error",
	                        JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		
		
	}
	public static void exists() {
		String na=null,rol=null;
		try
		{
			//Load Jdbc Odbc Driver
			String rl=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://E://Java//Student.accdb";
			Connection con = DriverManager.getConnection(url);
			Statement st1 = con.createStatement();
			
		//String sql = "INSERT INTO Signup VALUES('"+s1+"','"+s2+"')";
					
		
			
			
			//st1.executeUpdate(sql);
		
				String sql="SELECT * FROM Details";
			 ResultSet rs=st1.executeQuery(sql);
			int temp=0;
	            while ( rs.next() ) {
	                na = rs.getString("Name");
	                rol = rs.getString("RollNo");
	                //System.out.println(s3+"\t"+un);
                	//System.out.println(s4+"\t"+pas);
	                if(rl.equals(rol))
	                {
	                	//System.out.println(s3+"\t"+un);
	                	//System.out.println(s4+"\t"+pas);
	                	temp=1;
	                	break;
	                }
	              
	            }
	            if(temp==1)
	            { 
	            	 JOptionPane.showMessageDialog(null,"Successfully Loged in for Existing Student !");
	            	 TabbedPane tp=new TabbedPane(na,rl);
	            	 
	            }
	            if(temp==0)
	            {
	            	 JOptionPane.showMessageDialog(null,"Student doen't register,Please Go for Insert New Student Data!"); 
	            }
	           
	            
			
			con.close();
			st1.close();
			
			
		}catch(Exception ae)
		{
			JOptionPane.showMessageDialog(null, ae.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
		}
		
			
		} 
}
	
