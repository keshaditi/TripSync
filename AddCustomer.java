package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel lbusn ,lbnm;
    JComboBox comboid;
    JTextField tfno , tfcnty , tfadd , tfph , tfem ;
    JRadioButton rm , rf ,rtg ;
    JButton add ,back ;
    String username ;
    
    AddCustomer(String username){
        this.username = username ;
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("ADD CUSTOMER DETAILS");
	text.setBounds(250, 0, 300, 30);
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setForeground(Color.BLACK);
	add(text);
        
        JLabel lusn = new JLabel("Username ");
	lusn.setBounds(30, 30, 150, 30);
        lusn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lusn);
        
        lbusn = new JLabel();
	lbusn.setBounds(220, 30, 180, 30);
        lbusn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbusn);
        
        JLabel lid = new JLabel("Id Proof ");
	lid.setBounds(30, 70, 150, 30);
        lid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lid);
        
        comboid = new JComboBox(new String[]{"Aadhar Card" ,"Passport" , "Pan Card" , "Driving Licence"});
        comboid.setBounds(220, 70, 180, 30);
        comboid.setBackground(Color.WHITE);
        comboid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(comboid);
        
        JLabel lno = new JLabel("Id Number ");
	lno.setBounds(30, 110, 150, 30);
        lno.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lno);
        
        tfno = new JTextField();
	tfno.setBounds(220, 110, 180, 30);
        tfno.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(tfno);
        
        JLabel lname = new JLabel("Name ");
	lname.setBounds(30, 150, 150, 30);
        lname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lname);
        
        lbnm = new JLabel();
	lbnm.setBounds(220, 150, 180, 30);
        lbnm.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbnm);
        
        JLabel lgd = new JLabel("Gender ");
	lgd.setBounds(30, 190, 150, 30);
        lgd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lgd);
        
        rm = new JRadioButton("Male");
        rm.setBounds(220, 190, 70,30);
        rm.setBackground(Color.WHITE);
        rm.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(rm);
        
        rf = new JRadioButton("Female");
        rf.setBounds(300, 190, 100,30);
        rf.setBackground(Color.WHITE);
        rf.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(rf);
        
        rtg = new JRadioButton("Others");
        rtg.setBounds(400, 190,90,30);
        rtg.setBackground(Color.WHITE);
        rtg.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(rtg);
        
        ButtonGroup bg = new ButtonGroup(); //So that radio button not work independently
        bg.add(rm);
        bg.add(rf);
        bg.add(rtg);
        
        JLabel lcnty = new JLabel("Country ");
	lcnty.setBounds(30, 230, 150, 30);
        lcnty.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lcnty);
        
        tfcnty = new JTextField();
	tfcnty.setBounds(220, 230, 180, 30);
        tfcnty.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(tfcnty);
        
        JLabel ladd = new JLabel("Address ");
	ladd.setBounds(30, 270, 150, 30);
        ladd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(ladd);
        
        tfadd = new JTextField();
	tfadd.setBounds(220, 270, 180, 30);
        tfadd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(tfadd);
        
        JLabel lph = new JLabel("Phone ");
	lph.setBounds(30, 310, 150, 25);
        lph.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lph);
        
        tfph = new JTextField();
	tfph.setBounds(220, 310, 180, 30);
        tfph.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(tfph);
        
        JLabel lem = new JLabel("Email ");
	lem.setBounds(30, 350, 150, 30);
        lem.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lem);
        
        tfem = new JTextField();
	tfem.setBounds(220, 350, 180, 30);
        tfem.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(tfem);
        
        add = new JButton("Add");
        add.setBounds(70,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBorder(new LineBorder(Color.BLACK));
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(220,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"' ");
            while(rs.next()){
                lbusn.setText(rs.getString("username"));
                lbnm.setText(rs.getString("name"));
            }  
        } catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String username = lbusn.getText();
            String id = (String)comboid.getSelectedItem();
            String number = tfno.getText();
            String name = lbnm.getText();
            String gender = null;
            if(rm.isSelected()){
                gender = "Male";
            } else if(rf.isSelected()){
                gender = "Female";
            }else{
                  gender = "Others";  
            }
            String country = tfcnty.getText();
            String address = tfadd.getText();
            String phone = tfph.getText();
            String email = tfem.getText();
           
            try {
                Conn c = new Conn();
                
                String query = "insert into customer(username,id,number,name,gender,country,address,phone,email) values('" + username + "','" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
   
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
    new AddCustomer("aditik");
    }
}