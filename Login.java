package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login , signup , fpass;
    JTextField tfusn, tfps;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1= new JPanel();
	p1.setBackground(new Color(131,193,233));
	p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2= new JPanel();
	p2.setBounds(400,30,450,300);
        p2.setLayout(null);
        add(p2);
        
        JLabel usn = new JLabel("Username : ");
	usn.setBounds(60, 30, 150, 30);
        usn.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	p2.add(usn);
        
        tfusn= new JTextField();
	tfusn.setBounds(60,70 ,300, 30);
        tfusn.setBorder(BorderFactory.createEmptyBorder());
	p2.add(tfusn);

        
	JLabel psw = new JLabel("Password : ");
	psw.setBounds(60, 120, 350, 30);
        psw.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
	p2.add(psw);
                
        tfps= new JTextField();
	tfps.setBounds(60,150 ,300, 30);
        tfps.setBorder(BorderFactory.createEmptyBorder());
	p2.add(tfps);
        
        login = new JButton("LogIn");
        login.setBounds(100,200,100,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("SignUP");
        signup.setBounds(240,200,100,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        fpass = new JButton("Forget Password");
        fpass.setBounds(150,250,150,30);
        fpass.setBackground(new Color(133,193,233));
        fpass.setForeground(Color.WHITE);
        fpass.setBorder(new LineBorder(new Color(133,193,233)));
        fpass.addActionListener(this);
        p2.add(fpass);
        
        JLabel text = new JLabel("Trouble in LogIn...");
        text.setBounds(310,250,150,30);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() ==  login){
            try {
                String username = tfusn.getText();
                String password = tfps.getText(); 
                
                String query ="select * from account where username = '"+username+"' AND password = '"+password+"' ";
                
                Conn c = new Conn();
                ResultSet rs =c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                } else{
                    JOptionPane.showMessageDialog(null,"Incorrect UserName or Password");
                }
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource() == signup){
            setVisible(false);
            new Signup();
        } else{
            setVisible(false);
            new ForgetPassword();
        }   
    }
    
    public static void main(String[] args){
        new Login();  // anonymous object
    }
}
