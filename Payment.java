package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{
    JButton pay , back;
    Payment(){
        setBounds(400, 200, 800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
        
        pay = new JButton("Pay");
        pay.setBounds(200, 15, 80, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBorder(new LineBorder(Color.BLACK));
        pay.setFont(new Font("Tahoma", Font.BOLD, 14));
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(520, 15, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay){
            new Paytm();
            setVisible(false);
        } else{
            setVisible(false);
        }  
    }
    
    public static void main(String[] args) {
        new Payment();
    }
}
