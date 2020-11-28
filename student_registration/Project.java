package student_registration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Project extends JFrame implements ActionListener,ItemListener{
	public String name,roll;
	public String s1,s2,s3,s4,s5;
	JLabel head,title,event,place,prize,sem;
	JTextField ti,eve,pl;
	JComboBox won,semester;
	JButton insert,cancel;
	String pz[]= {"Select","1st","2nd","3rd","None"};
	String se[]= {"Select","I","II","III","IV","V","VI","VII","VIII"};
	public Project(String name,String roll)
	{
		this.name=name;
		this.roll=roll;
		setLayout(null);
		setVisible(true);
		setTitle("Project Presentation");
		setSize(500,500);
		head=new JLabel("Enter Project Presentation Details");
		Font  f1  = new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 15);
		head.setFont(f1);
		title=new JLabel("Title of the Project : ");
		event=new JLabel("Name of Event : ");
		place=new JLabel("Presented at Where? :");
		prize=new JLabel("Prize won : ");
		sem=new JLabel("Presented in Which Sem : ");
		
		ti=new JTextField(50);
		pl=new JTextField(50);
		eve=new JTextField(40);
		won=new JComboBox<String>(pz);
		semester=new JComboBox<String>(se);
		
		head.setBounds(70,35,500,30);
		title.setBounds(35,125,200,30);
		ti.setBounds(185,130,200,25);
		event.setBounds(35,165,200,30);
		eve.setBounds(185,170,200,25);
		place.setBounds(35,210,200,30);
		pl.setBounds(185,215,200,25);
		prize.setBounds(35,260,200,30);
		won.setBounds(185,265,100,20);
		sem.setBounds(35,310,200,30);
		semester.setBounds(185,315,100,20);
		won.addItemListener(this);
		semester.addItemListener(this);
		insert=new JButton("Insert");
		cancel=new JButton("Cancel");
		insert.addActionListener(this);
		cancel.addActionListener(this);
		insert.setBounds(80,400,100,30);
		cancel.setBounds(280,400,100,30);
		add(head);
		add(title);
		add(ti);
		add(event);
		add(eve);
		add(place);
		add(pl);
		add(prize);
		
		add(won);
		add(sem);
		add(semester);
		add(insert);
		add(cancel);
		insert.setToolTipText("Insert one or more data by clicking Insert Button");
		cancel.setToolTipText("Cancel the Insertion by clicking Cancel Button");
		
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String res=e.getActionCommand();
		
		if(res.contentEquals("Insert"))
		{
			s1=ti.getText();
			s2=pl.getText();
			s3=eve.getText();
			s4=(String)won.getSelectedItem();
			s5=(String)semester.getSelectedItem();
			/*System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);*/
			
			if(s1.length()!=0 && s2.length()!=0 && s3.length()!=0 && s4!="Select" && s5!="Select")
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
		else if(res.contentEquals("Cancel"))
		{
			dispose();
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
			
		String sql = "INSERT INTO Project VALUES('"+name+"','"+roll+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')";
					
		
			
			
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
	public void clear()
	{
		ti.setText("");
		pl.setText("");
		eve.setText("");
		won.setSelectedIndex(0);
		semester.setSelectedIndex(0);
	}
		
}