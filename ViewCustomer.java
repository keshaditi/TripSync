package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class ViewCustomer extends JFrame implements ActionListener{
    
    JLabel lbusn , lbid ,lbno ,lbnm, lbgd , lbcnty ,lbadd, lbph ,lbem;
    JButton back ;
    String username;
    ViewCustomer(String username){
        this.username = username ;
        setBounds(450,180,870,625);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("VIEW CUSTOMER DETAILS");
	text.setBounds(250, 0, 300, 30);
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setForeground(Color.BLACK);
	add(text);
        
        JLabel lusn = new JLabel("Username ");
	lusn.setBounds(30, 50, 150, 30);
        lusn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lusn);
        
        lbusn = new JLabel();
	lbusn.setBounds(220, 50, 150, 30);
        lbusn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbusn);
        
        JLabel lid = new JLabel("Id Proof ");
	lid.setBounds(30, 110, 150, 30);
        lid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lid);
        
        lbid = new JLabel();
	lbid.setBounds(220, 110, 150, 30);
        lbid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbid);
        
        JLabel lno = new JLabel("Id Number ");
	lno.setBounds(30, 170, 150, 30);
        lno.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lno);
        
        lbno = new JLabel();
	lbno.setBounds(220, 170, 150, 30);
        lbno.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbno);
        
        JLabel lnm = new JLabel("Name ");
	lnm.setBounds(30, 230, 150, 30);
        lnm.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lnm);
        
        lbnm = new JLabel();
	lbnm.setBounds(220, 230, 150, 30);
        lbnm.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbnm);
        
        JLabel lgd = new JLabel("Gender ");
	lgd.setBounds(30, 290, 150, 30);
        lgd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lgd);
        
        lbgd = new JLabel();
	lbgd.setBounds(220, 290, 150, 30);
        lbgd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbgd);
        
        JLabel lcnty = new JLabel("Country ");
	lcnty.setBounds(500, 50, 150, 30);
        lcnty.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lcnty);
        
        lbcnty = new JLabel();
	lbcnty.setBounds(690, 50, 150, 30);
        lbcnty.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbcnty);
        
        JLabel ladd = new JLabel("Address ");
	ladd.setBounds(500, 110, 150, 30);
        ladd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(ladd);
        
        lbadd = new JLabel();
	lbadd.setBounds(690, 110, 150, 30);
        lbadd.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbadd);
        
        JLabel lph = new JLabel("Phone ");
	lph.setBounds(500, 170, 150, 30);
        lph.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lph);
        
        lbph = new JLabel();
	lbph.setBounds(690, 170, 150, 30);
        lbph.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbph);
        
        JLabel lem = new JLabel("Email ");
	lem.setBounds(500, 230, 150, 30);
        lem.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lem);
        
        lbem = new JLabel();
	lbem.setBounds(650, 230, 200, 30);
        lbem.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbem);
        
        back = new JButton("Back");
        back.setBounds(350,350,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/groupview.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(500,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 400, 200);
        add(image);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/groupview.jpeg"));
        Image i5 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(370, 400, 500, 200);
        add(image2);
        
        try{
            Conn c = new Conn();
            String query = " select * from customer where username = '"+username+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                lbusn.setText(rs.getString("username"));
                lbid.setText(rs.getString("id"));
                lbno.setText(rs.getString("number"));
                lbnm.setText(rs.getString("name"));
                lbgd.setText(rs.getString("gender"));
                lbcnty.setText(rs.getString("country"));
                lbadd.setText(rs.getString("address"));
                lbph.setText(rs.getString("phone"));
                lbem.setText(rs.getString("email"));
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
        }   
        }
    
    public static void main(String[] args){
    new ViewCustomer("aditik");
    }
}