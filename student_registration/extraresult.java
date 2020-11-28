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

public class extraresult extends JFrame{
	
	JLabel l;
	public String check;
	public static int h=0;
	public String[] ColumnNames= {"Extra-Curricular","Level","Year at which Involved"}; 
	public extraresult(String check)
	{
		this.check=check;
		setLayout(null);
		setVisible(true);
		setTitle("Extra-Curricular Activities");
		setSize(500,500);
		l=new JLabel("Extra-Curricular Activities!");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);
		l.setFont(f1);
		l.setBounds(120,35,500,30);
		
		add(l);

		display();
	}
	public void display() {
		// TODO Auto-generated method stub
	  String nam = null;
		String check=JOptionPane.showInputDialog(null,"Enter Student Roll No.!");
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
			PreparedStatement st=con.prepareStatement("SELECT * FROM Extra WHERE RollNo=?");
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
			JTextField n1,n2,n3;
			n1=new JTextField(20);
			n2=new JTextField(20);
			n3=new JTextField(20);
			
			n1.setBounds(40,280,200,25);
			n2.setBounds(240,280,200,25);
			n3.setBounds(440,280,200,25);
			
			
			n1.setText("Name of Activity");
			n2.setText("Level");
			n3.setText("Year");
			
			n1.setEditable(false);
			n2.setEditable(false);
			n3.setEditable(false);
			
			add(n1);
			add(n2);
			add(n3);
			
			
			
	         t2.setText(check);
	         t2.setEditable(false);
	            while ( rs.next() ) {
	            	
	               String ex = rs.getString("Extra-Curricular");
	                 String lvl = rs.getString("Level");
	                 String yi = rs.getString("Year at which Involved");
	              /* System.out.println(na);
	               System.out.println(ev);
	               System.out.println(pl);
	               System.out.println(pr);*/
	             //  nam=rs.getString("Name");
		            	
	           model.addRow(new Object[]{ex,lvl,yi});
	           h++;
	           
		       }
	            
	            
	            PreparedStatement st2=con.prepareStatement("SELECT * FROM Details WHERE RollNo=?");
				st2.setString(1,check);
	        
	         ResultSet rs1=st2.executeQuery();
	         String roll=null,na=null,dep = null;
	         String yrr=null,se=null;
	         while ( rs1.next() ) {
	         	
		              // roll = rs1.getString("RollNo");
		               na = rs1.getString("Name");
		               dep = rs1.getString("Dept");
		               yrr = rs1.getString("Year");
		               se= rs1.getString("Section");
	         }
	            t1.setText(na);
	            t1.setEditable(false);
	            t3.setText(dep);
	            t3.setEditable(false);
	            t4.setText(yrr);
	            t4.setEditable(false);
	            t5.setText(se);
	            t5.setEditable(false);

	            
	            JTable t=new JTable(model);
	            t.setModel(model);
	            t.setBounds(40,310,600,700);
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
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
		}
		
	}
}


