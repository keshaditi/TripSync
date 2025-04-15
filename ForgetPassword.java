package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusn , tfn , tfsq , tfans , tfpsw;
    JButton search , retrieve , back ;
    
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);  
        add(image);

        JPanel p1= new JPanel();
	p1.setBounds(30,30,500,280);
        p1.setLayout(null);
        add(p1);
         
        JLabel lbus = new JLabel("Username : ");
	lbus.setBounds(40, 20, 100, 25);
        lbus.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(lbus);
        
        tfusn= new JTextField();
	tfusn.setBounds(220,20 ,150, 25);
        tfusn.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfusn);
        
        search = new JButton("Search");
        search.setBounds(380,20,100,25);
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Tahoma",Font.BOLD,14));
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lbn = new JLabel("Name : ");
	lbn.setBounds(40, 60, 100, 25);
        lbn.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(lbn);
        
        tfn= new JTextField();
	tfn.setBounds(220,60 ,150, 25);
        tfn.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfn);
        
        JLabel lbsq = new JLabel("Security Question : ");
	lbsq.setBounds(40, 100, 150, 25);
        lbsq.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(lbsq);
        
        tfsq= new JTextField();
	tfsq.setBounds(220,100 ,150, 25);
        tfsq.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfsq);
        
        JLabel lbans = new JLabel("Answer : ");
	lbans.setBounds(40, 140, 150, 25);
        lbans.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(lbans);
        
        tfans= new JTextField();
	tfans.setBounds(220,140 ,150, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfans);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380,140,100,25);
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setFont(new Font("Tahoma",Font.BOLD,14));
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel lbpsw = new JLabel("Password : ");
	lbpsw.setBounds(40, 180, 150, 25);
        lbpsw.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(lbpsw);
        
        tfpsw= new JTextField();
	tfpsw.setBounds(220,180 ,150, 25);
        tfpsw.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfpsw);
        
        back = new JButton("Back");
        back.setBounds(150,230,100,25);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            try{
                String query ="select * from account where username = '"+tfusn.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                 if(rs.next()){
                    tfn.setText(rs.getString("name"));
                    tfsq.setText(rs.getString("security"));
                } else{
                    JOptionPane.showMessageDialog(null,"Username not found");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
         
        } else if (ae.getSource() == retrieve){
            try{
                String query ="select * from account where answer = '"+tfans.getText()+"' AND username = '"+tfusn.getText()+"' ";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                 while(rs.next()){
                    tfpsw.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } else{
            setVisible(false);
            new Login();
        }   
    }
    
    public static void main(String [] args){
        new ForgetPassword();
    }
}