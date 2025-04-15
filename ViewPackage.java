package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{
    JLabel lbusn , lbpg ,lbp ,lbid ,lbno , lbph  , lbpr ;
    JButton back ;
    String username;
    ViewPackage(String username){
        this.username = username ;
        setBounds(420,200,900,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
	text.setBounds(250, 2, 350, 30);
        text.setFont(new Font("RALEWAY",Font.BOLD,25));
        text.setForeground(Color.BLACK);
	add(text);
        
        JLabel lusn = new JLabel("Username ");
	lusn.setBounds(30, 40, 150, 30);
        lusn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lusn);
        
        lbusn = new JLabel();
	lbusn.setBounds(220, 40, 150, 30);
        lbusn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbusn);
        
        JLabel lpg = new JLabel("Package ");
	lpg.setBounds(30, 80, 150, 30);
        lpg.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lpg);
        
        lbpg = new JLabel();
	lbpg.setBounds(220, 80, 180, 30);
        lbpg.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbpg);
        
        JLabel lp = new JLabel("Persons ");
	lp.setBounds(30, 120, 150, 30);
        lp.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lp);
        
        lbp = new JLabel();
	lbp.setBounds(220, 120, 150, 30);
        lbp.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbp);
        
        JLabel lid = new JLabel("Id Proof ");
	lid.setBounds(30, 160, 150, 30);
        lid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lid);
        
        lbid = new JLabel();
	lbid.setBounds(220, 160, 150, 30);
        lbid.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbid);
        
        JLabel lno = new JLabel("Id Number ");
	lno.setBounds(30, 200, 150, 30);
        lno.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lno);
        
        lbno = new JLabel();
	lbno.setBounds(220, 200, 150, 30);
        lbno.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbno);        
        
        JLabel lph = new JLabel("Phone ");
	lph.setBounds(30, 240, 150, 30);
        lph.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lph);
        
        lbph = new JLabel();
	lbph.setBounds(220, 240, 150, 30);
        lbph.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbph);

        JLabel lpr = new JLabel("Price ");
	lpr.setBounds(30, 280, 150, 30);
        lpr.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lpr);
        
        lbpr = new JLabel();
	lbpr.setBounds(220, 280, 150, 30);
        lbpr.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	add(lbpr);
        
        back = new JButton("Back");
        back.setBounds(180,350,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 40, 420, 350);
        add(image);
         
        try{
            Conn c = new Conn();
            String query = " select * from bookpackage where username = '"+username+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                lbusn.setText(rs.getString("username"));
                lbpg.setText(rs.getString("package"));
                lbp.setText(rs.getString("persons"));
                lbid.setText(rs.getString("id"));
                lbno.setText(rs.getString("number"));
                lbph.setText(rs.getString("phone"));
                lbpr.setText(rs.getString("price"));      
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
    new ViewPackage("aditik");
    } 
}