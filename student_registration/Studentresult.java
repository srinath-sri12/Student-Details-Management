package student_registration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Studentresult extends JFrame{
	
	JLabel l;
	public String[] ColumnNames= {"Name","Roll No","Detp","Year","Section"}; 
	
	public Studentresult()
	{
		
		setLayout(null);
		setVisible(true);
		setTitle("Student Details");
		setSize(500,500);
		l=new JLabel("Students Details!");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);
		l.setFont(f1);
		l.setBounds(130,35,500,30);
		
		add(l);

		display();
	}
	public void display() {
		// TODO Auto-generated method stub
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(ColumnNames);
		
		try
		{
			//Load Jdbc Odbc Driver
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://E://Java//Student.accdb";
			Connection con = DriverManager.getConnection(url);
			Statement st1 = con.createStatement();
			 String sql="SELECT * FROM Details";
			 ResultSet rs=st1.executeQuery(sql);
			 JTextField n1,n2,n3,n4,n5;
				n1=new JTextField(20);
				n2=new JTextField(20);
				n3=new JTextField(20);
				n4=new JTextField(20);
				n5=new JTextField(20);
				n1.setBounds(40,170,160,25);
				n2.setBounds(200,170,160,25);
				n3.setBounds(360,170,160,25);
				n4.setBounds(520,170,160,25);
				n5.setBounds(680,170,160,25);
				n1.setText("Name");
				n2.setText("Roll No.");
				n3.setText("Dept");
				n4.setText("Year");
				n5.setText("Section");
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
			
			// JTextArea a=new JTextArea();
			 //a.setSize(200,200);
	          //a.setBounds(40,100,2000,800);
	          //a.setEditable(false);
	          //String h="Name\t\t\tRoll No\t\t\tDept\t\t\tYear\t\t\tSection\n\n";
	         
	        
	            while ( rs.next() ) {
	            	
	               String roll = rs.getString("RollNo");
	                 String na = rs.getString("Name");
	               String de = rs.getString("Dept");
	               String yr = rs.getString("Year");
	              String  se= rs.getString("Section");
	               
		            	
	              model.addRow(new Object[]{na,roll,de,yr,se});
	           
		           // a.append(na+"\t\t"+roll+"\t\t"+de+"\t\t"+yr+"\t\t"+se);
		            //a.append("\n");
		            	 
	             
						
		       }
	            JTable t=new JTable(model);
	            t.setModel(model);
	            t.setBounds(40,200,800,2000);
	        	ScrollPane sp = new ScrollPane(); 
	    		sp.add(t);
	    		add(t);
	    		
	            //add(a);
	         
	        
	            
			
			con.close();
			st1.close();
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                        JOptionPane.ERROR_MESSAGE);
		}
		
	}
}

