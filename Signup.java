package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JButton create, back; // declare as instance variables
    JTextField tfusn , tfn ,tfps , tfsa ;
    Choice security ;
            
    Signup(){
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1= new JPanel();
	p1.setBackground(new Color(131,193,233));
	p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("Username : ");
	l1.setBounds(50, 20, 125, 25);
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l1);
        
        tfusn= new JTextField();
	tfusn.setBounds(200,20 ,180, 25);
        tfusn.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfusn);
        
        JLabel l2 = new JLabel("Name : ");
	l2.setBounds(50,80, 125, 25);
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l2);
        
        tfn= new JTextField();
	tfn.setBounds(200,80 ,180, 25);
        tfn.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfn);
        
        JLabel l3 = new JLabel("Password : ");
	l3.setBounds(50, 140, 125, 25);
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l3);
                
        tfps= new JTextField();
	tfps.setBounds(200,140 ,180, 25);
        tfps.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfps);
        
        JLabel l4 = new JLabel("Security Question : ");
	l4.setBounds(50, 195, 150, 30);
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l4);
        
        security = new Choice();
        security.add("Fav Character of Cartoon?");
        security.add("Role Model?");
        security.add("Lucky Number?");
        security.add("Pet Name?");
        security.add("School Name?");
        security.add("BestFriend Name?");
        security.setBounds(200,200 ,180, 150);
	p1.add(security);
        
        JLabel l5 = new JLabel("Answer: ");
	l5.setBounds(50, 240, 125, 25);
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
	p1.add(l5);
        
        tfsa= new JTextField();
	tfsa.setBounds(200,240 ,180, 25);
        tfsa.setBorder(BorderFactory.createEmptyBorder());
	p1.add(tfsa);
        
        create = new JButton("Create");
        create.setBounds(150,300,100,25);
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setBorder(new LineBorder(Color.BLACK));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(300,300,100,25);
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        setVisible(true);
        
    }
 
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String username = tfusn.getText();
            String name = tfn.getText();
            String password = tfps.getText();
            String question = security.getSelectedItem();
            String answer = tfsa.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == back){
            setVisible(false);
            new Login();
        }   
    }
    
    public static void main (String[] args){
        new Signup();
    }

}