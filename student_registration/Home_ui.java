package student_registration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home_ui extends JFrame implements ActionListener,ItemListener{
	public String s1,s2,s3,s4 = null,s5 = null;
	JLabel head,name,roll,dept,year,sec;
	JTextField na,rol;
	String de[]= {"Select","CIVIL","MECH","MTS","AUTO","CSE","IT","ECE","EEE","EIE","CHEM","FT"};
	JRadioButton fi,se,th,fo,a,b,c,d;
	JComboBox dep;
	ButtonGroup bg,bg1;
	JButton next,clear;
	public Home_ui()
	{
		setLayout(null);
		setVisible(true);
		setTitle("Student-Details");
		setSize(450,450);
		head=new JLabel("Please Enter Your Details");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.HANGING_BASELINE, 20);
		head.setFont(f1);
		name=new JLabel("Name : ");
		roll=new JLabel("Roll No. : ");
		dept=new JLabel("Department : ");
		year=new JLabel("Year : ");
		sec=new JLabel("Section : ");
		na=new JTextField(20);
		rol=new JTextField(15);
		dep=new JComboBox<String>(de);
		dep.addItemListener(this);
		dep.setSize(250,250);
		fi=new JRadioButton("I");
		se=new JRadioButton("II");
		th=new JRadioButton("III");
		fo=new JRadioButton("IV");
		a=new JRadioButton("A");
		b=new JRadioButton("B");
		c=new JRadioButton("C");
		d=new JRadioButton("D");
		bg=new ButtonGroup();
		bg1=new ButtonGroup();
		next=new JButton("Next");
		clear=new JButton("Clear");
		head.setBounds(140,25,300,30);
		name.setBounds(75,80, 200, 30); 
		na.setBounds(170,85,150,20);
        roll.setBounds(75,120, 200, 30);
        rol.setBounds(170,120,150,20);
        dept.setBounds(75,160,200,30);
        dep.setBounds(170,165,130,20);
        year.setBounds(75,150,80, 130);
        
        fi.setBounds(170,210,50,20);
        se.setBounds(230,210,50,20);
        th.setBounds(290,210,50,20);
        fo.setBounds(350,210,50,20);
        sec.setBounds(75,250,140,30);
        a.setBounds(170,260,50,20);
        b.setBounds(230,260,50,20);
        c.setBounds(290,260,50,20);
        d.setBounds(350,260,50,20);
        next.setBounds(90,340,90,30);
        clear.setBounds(270,340,90,30);
        add(head);
        add(name);
        add(na);
        add(roll);
        add(rol);
        add(dept);
        add(dep);
        add(year);
        add(sec);
        bg.add(fi);
        bg.add(se);
        bg.add(th);
        bg.add(fo);
        bg1.add(a);
        bg1.add(b);
        bg1.add(c);
        bg1.add(d);
        next.addActionListener(this);
        clear.addActionListener(this);
        fi.addActionListener(this);
        se.addActionListener(this);
        th.addActionListener(this);
        fo.addActionListener(this);
        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        add(fi);
        add(se);
        add(th);
        add(fo);
        add(a);
        add(b);
        add(c);
        add(d);
        add(next);
        add(clear);
        next.setToolTipText("Click Next to give data");
        clear.setToolTipText("Click Clear to give new student details");
	}
	

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String btnres;
		btnres=e.getActionCommand();
		
		if(btnres.equals("Next"))
		{
			s1=na.getText();
			s2=rol.getText();
			s3=(String) dep.getSelectedItem();
			
			
				if(fi.isSelected())
				{
					s4=fi.getText();
				}
				else if(se.isSelected())
				{
					s4= se.getText();
				}
				else if(th.isSelected())
				{
					s4= th.getText();
				}
				else if(fo.isSelected())
				{
					s4= fo.getText();
				}
				if(a.isSelected())
				{
					s5=a.getText();
				}
				else if(b.isSelected())
				{
					s5= b.getText();
				}
				else if(c.isSelected())
				{
					s5= c.getText();
				}
				else if(d.isSelected())
				{
					s5= d.getText();
				}
			
			
			/*System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);
			System.out.println(s5);
			*/
			
		
		if(s1.length()!=0 && s2.length()!=0 && s3!="Select" && s4!=null && s5!=null)
		{
			addOperation();
		}
		else
		{
			   JOptionPane.showMessageDialog(null,"Give Valid Details!");  
			   na.setText("");
				rol.setText("");
				dep.setSelectedIndex(0);
				bg.clearSelection();
				bg1.clearSelection();
		}
				//addOperation();
		}
		else if(btnres.equals("Clear"))
		{
			na.setText("");
			rol.setText("");
			dep.setSelectedIndex(0);
			bg.clearSelection();
			bg1.clearSelection();
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
			
		String sql = "INSERT INTO Details VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
					
		
			
			
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
			TabbedPane tp=new TabbedPane(s1,s2);
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Student record already exists,Please Go for Existing User Mode !");
			dispose();
		}
		
	}
	
}
