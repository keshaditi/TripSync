package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Dashboard extends JFrame implements ActionListener{
    JButton addpd ,upd ,vd ,dpd , cp ,bp , vp, vh , bh, vbh , des ,pay ,map, chatb ,abt ;
    String username;
    Dashboard(String username){
        this.username = username ;
        setExtendedState(JFrame.MAXIMIZED_BOTH); //default full screen
        setLayout(null);
        
        JPanel p1= new JPanel();
        p1.setBackground(new Color(100,100,255));
        p1.setBounds(0,0,1600,65);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(3,2,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2= new JPanel();
	p2.setBackground(new Color(100,100,255));
	p2.setBounds(0,65,300,900);
        p2.setLayout(null);
        add(p2);
        
        addpd = new JButton("Add Personal Details");
        addpd.setBounds(0,0,300,50);
        addpd.setBackground(new Color(100,100,255));
        addpd.setForeground(Color.WHITE);
        addpd.setFont(new Font("Tahoma",Font.PLAIN,20));
        addpd.setBorder(new LineBorder(new Color(133,193,233)));
        addpd.addActionListener(this);
        p2.add(addpd);
        
        upd = new JButton("Update Personal Details");
        upd.setBounds(0,50,300,50);
        upd.setBackground(new Color(100,100,255));
        upd.setForeground(Color.WHITE);
        upd.setFont(new Font("Tahoma",Font.PLAIN,20));
        upd.setBorder(new LineBorder(new Color(133,193,233)));
        upd.addActionListener(this);
        p2.add(upd);
        
        vd = new JButton("View Details");
        vd.setBounds(0,100,300,50);
        vd.setBackground(new Color(100,100,255));
        vd.setForeground(Color.WHITE);
        vd.setFont(new Font("Tahoma",Font.PLAIN,20));
        vd.setBorder(new LineBorder(new Color(133,193,233)));
        vd.addActionListener(this);
        p2.add(vd);
        
        dpd = new JButton("Delete Personal Details");
        dpd.setBounds(0,150,300,50);
        dpd.setBackground(new Color(100,100,255));
        dpd.setForeground(Color.WHITE);
        dpd.setFont(new Font("Tahoma",Font.PLAIN,20));
        dpd.setBorder(new LineBorder(new Color(133,193,233)));
        dpd.addActionListener(this);
        p2.add(dpd);
        
        cp = new JButton("Check Packages");
        cp.setBounds(0,200,300,50);
        cp.setBackground(new Color(100,100,255));
        cp.setForeground(Color.WHITE);
        cp.setFont(new Font("Tahoma",Font.PLAIN,20));
        cp.setBorder(new LineBorder(new Color(133,193,233)));
        cp.addActionListener(this);
        p2.add(cp);
        
        bp = new JButton("Book Package");
        bp.setBounds(0,250,300,50);
        bp.setBackground(new Color(100,100,255));
        bp.setForeground(Color.WHITE);
        bp.setFont(new Font("Tahoma",Font.PLAIN,20));
        bp.setBorder(new LineBorder(new Color(133,193,233)));
        bp.addActionListener(this);
        p2.add(bp);
        
        vp = new JButton("View Package");
        vp.setBounds(0,300,300,50);
        vp.setBackground(new Color(100,100,255));
        vp.setForeground(Color.WHITE);
        vp.setFont(new Font("Tahoma",Font.PLAIN,20));
        vp.setBorder(new LineBorder(new Color(133,193,233)));
        vp.addActionListener(this);
        p2.add(vp);
        
                
        vh = new JButton("View Hotel");
        vh.setBounds(0,350,300,50);
        vh.setBackground(new Color(100,100,255));
        vh.setForeground(Color.WHITE);
        vh.setFont(new Font("Tahoma",Font.PLAIN,20));
        vh.setBorder(new LineBorder(new Color(133,193,233)));
        vh.addActionListener(this);
        p2.add(vh);
        
        bh = new JButton("Book Hotel");
        bh.setBounds(0,400,300,50);
        bh.setBackground(new Color(100,100,255));
        bh.setForeground(Color.WHITE);
        bh.setFont(new Font("Tahoma",Font.PLAIN,20));
        bh.setBorder(new LineBorder(new Color(133,193,233)));
        bh.addActionListener(this);
        p2.add(bh);
        
        vbh = new JButton("View Book Hotel");
        vbh.setBounds(0,450,300,50);
        vbh.setBackground(new Color(100,100,255));
        vbh.setForeground(Color.WHITE);
        vbh.setFont(new Font("Tahoma",Font.PLAIN,20));
        vbh.setMargin(new Insets(0,0,0,60));
        vbh.setBorder(new LineBorder(new Color(133,193,233)));
        vbh.addActionListener(this);
        p2.add(vbh);
        
        des = new JButton("Destination");
        des.setBounds(0,500,300,50);
        des.setBackground(new Color(100,100,255));
        des.setForeground(Color.WHITE);
        des.setFont(new Font("Tahoma",Font.PLAIN,20));
        des.setBorder(new LineBorder(new Color(133,193,233)));
        des.addActionListener(this);
        p2.add(des);
        
        pay = new JButton("Payment");
        pay.setBounds(0,550,300,50);
        pay.setBackground(new Color(100,100,255));
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tahoma",Font.PLAIN,20));
        pay.setMargin(new Insets(0,0,0,300));
        pay.setBorder(new LineBorder(new Color(133,193,233)));
        pay.addActionListener(this);
        p2.add(pay);
        
        map= new JButton("Map");
        map.setBounds(0, 600, 300, 50); 
        map.setBackground(new Color(100,100,255));
        map.setForeground(Color.WHITE);
        map.setFont(new Font("Tahoma",Font.PLAIN,20));
        map.setMargin(new Insets(0,0,0,300));
        map.setBorder(new LineBorder(new Color(133,193,233)));
        map.addActionListener(this);
        p2.add(map);
        
        chatb = new JButton("ChatBot");
        chatb.setBounds(0, 650, 300, 40); 
        chatb.setBackground(new Color(100,100,255));
        chatb.setForeground(Color.WHITE);
        chatb.setFont(new Font("Tahoma",Font.PLAIN,20));
        chatb.setMargin(new Insets(0,0,0,300));
        chatb.setBorder(new LineBorder(new Color(133,193,233)));
        chatb.addActionListener(this);
        p2.add(chatb);
        
        abt= new JButton("About");
        abt.setBounds(0, 690, 300, 40); 
        abt.setBackground(new Color(100,100,255));
        abt.setForeground(Color.WHITE);
        abt.setFont(new Font("Tahoma",Font.PLAIN,20));
        abt.setMargin(new Insets(0,0,0,300));
        abt.setBorder(new LineBorder(new Color(133,193,233)));
        abt.addActionListener(this);
        p2.add(abt);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel("Travel & Tourism System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image.add(text);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addpd){
            new AddCustomer(username);
        }else if (ae.getSource() == upd){
            new UpdateCustomer(username);
        }else if (ae.getSource() == dpd){
            new DeleteDetails(username);
        }else if (ae.getSource() == vd){
            new ViewCustomer(username);
        }else if (ae.getSource() == cp){
            new CheckPackage();
        }else if (ae.getSource() == bp){
            new BookPackage(username);
        }else if (ae.getSource() == vp){
            new ViewPackage(username);
        }else if (ae.getSource() == vh){
            new ViewHotels();
        }else if (ae.getSource() == des){
            new Destinations();
        }else if (ae.getSource() == bh){
            new BookHotel(username);
        }else if (ae.getSource() == vbh){
            new ViewBookedHotel(username);
        }else if (ae.getSource() == pay){
            new Payment();
        }else if (ae.getSource() == map){
            new Map();
        }else if (ae.getSource() == chatb){
            new ChatBot("");
        }else if (ae.getSource() == abt){
            new About();
        }
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}