package student_registration;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Paperresult extends JFrame{
	
	JLabel l;
	public String check;
	
	public String[] ColumnNames= {"Name of Paper","Event Name","Place","Price","Semester"}; 
	public Paperresult(String check)
	{
		this.check=check;
		setLayout(null);
		setVisible(true);
		setTitle("Paper-Result");
		setSize(500,500);
		l=new JLabel("Paper-Result!");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);
		l.setFont(f1);
		l.setBounds(170,25,500,30);
		
		add(l);

		display();
	}
	public void display() {
		// TODO Auto-generated method stub
	  String nam = null;
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(ColumnNames);
		try
		{
			//Load Jdbc Odbc Driver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://E://Java//Student.accdb";
			Connection con = DriverManager.getConnection(url);
			//Statement st1 = con.createStatement();
			 
			//String sql="SELECT * FROM Paper WHERE Name=?";
			PreparedStatement st=con.prepareStatement("SELECT * FROM Paper WHERE RollNo=?");
			st.setString(1,check);
			ResultSet rs=st.executeQuery();
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
			JTextField n1,n2,n3,n4,n5;
			n1=new JTextField(20);
			n2=new JTextField(20);
			n3=new JTextField(20);
			n4=new JTextField(20);
			n5=new JTextField(20);
			n1.setBounds(40,280,160,25);
			n2.setBounds(200,280,160,25);
			n3.setBounds(360,280,160,25);
			n4.setBounds(520,280,160,25);
			n5.setBounds(680,280,160,25);
			
			n1.setText("Name of Paper");
			n2.setText("Event Name");
			n3.setText("Place");
			n4.setText("Price");
			n5.setText("Semester");
			n1.setEditable(false);
			n2.setEditable(false);
			n3.setEditable(false);
			n4.setEditable(false);
			n5.setEditable(false);
			
			add(n1);
			add(n2);
			add(n3);
			add(n4);
			add(n5);
			
	         t2.setText(check);
	         
	         t2.setEditable(false);
	            while ( rs.next() ) {
	            	
	               String na = rs.getString("Name of Paper");
	                 String ev = rs.getString("Event Name");
	               String pl = rs.getString("Place");
	               String pr = rs.getString("Price");
	               String sm=rs.getString("Semester");
	              /* System.out.println(na);
	               System.out.println(ev);
	               System.out.println(pl);
	               System.out.println(pr);*/
	               nam=rs.getString("Name");
		            	
	           model.addRow(new Object[]{na,ev,pl,pr,sm});
	           
		         
					
	           
		       }
	            PreparedStatement st2=con.prepareStatement("SELECT * FROM Details WHERE RollNo=?");
				st2.setString(1,check);
	        
	         ResultSet rs1=st2.executeQuery();
	         String roll=null,na=null,dep = null;
	         String yr=null,se=null;
	         while ( rs1.next() ) {
	         	
		              // roll = rs1.getString("RollNo");
		               na = rs1.getString("Name");
		               dep = rs1.getString("Dept");
		               yr = rs1.getString("Year");
		               se= rs1.getString("Section");
	         }
	         //System.out.println(roll+"\t"+na+"\t"+de+"\t"+yr+"\t"+se);
	           
	            t1.setText(na);
	            t1.setEditable(false);
	            t3.setText(dep);
	            t3.setEditable(false);
	            t4.setText(yr);
	            t4.setEditable(false);
	            t5.setText(se);
	            t5.setEditable(false);
	            
	            JTable t=new JTable(model);
	            t.setModel(model);
	            t.setBounds(40,320,800,800);
	        	ScrollPane sp = new ScrollPane(); 
	    		sp.add(t);
	    		add(t);
	          add(n);
	          add(t1);
	          add(r);
	          add(t2);
	          add(de);
	          add(y);
	          add(sect);
	          add(t3);
	          add(t4);
	          add(t5);
	          
	            
			
			con.close();
			st.close();
			//details();
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
		}
		
	}
	private void details() {
		// TODO Auto-generated method stub
		try {
			String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://E://Java//Student.accdb";
			Connection con = DriverManager.getConnection(url);
         PreparedStatement st1=con.prepareStatement("SELECT * FROM Details WHERE RollNo=?");
			st1.setString(1,check);
        
         ResultSet rs1=st1.executeQuery();
         String roll=null,na=null,de = null;
         String yr=null,se=null;
         while ( rs1.next() ) {
         	
	               roll = rs1.getString("RollNo");
	               na = rs1.getString("Name");
	               de = rs1.getString("Dept");
	               yr = rs1.getString("Year");
	               se= rs1.getString("Section");
         }
         System.out.println(roll+"\t"+na+"\t"+de+"\t"+yr+"\t"+se);
         con.close();
			st1.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
		}
		 
	}
}


