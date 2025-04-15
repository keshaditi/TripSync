package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class ViewBookedHotel extends JFrame implements ActionListener {
    String username;
    JButton back;
    JLabel lbusn, lbtp, lbdy, lbhotel, lbac, lbfood, lbid, lbno, lbph, lbtpr;

    ViewBookedHotel(String username) {
        this.username = username;
        setBounds(400, 200, 1000, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel(" VIEW BOOKED HOTEL");
        text.setBounds(180, 20, 300, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        text.setForeground(Color.BLACK);
        add(text);

        JLabel lusn = new JLabel("Username: ");
        lusn.setBounds(40, 70, 150, 20);
        lusn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lusn);

        lbusn = new JLabel();
        lbusn.setBounds(250, 70, 150, 30);
        lbusn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbusn);

        JLabel lsp = new JLabel("Hotel Name: ");
        lsp.setBounds(40, 110, 150, 25);
        lsp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lsp);

        lbhotel = new JLabel();
        lbhotel.setBounds(250, 100, 150, 50);
        add(lbhotel);

        JLabel ltp = new JLabel("Total Persons: ");
        ltp.setBounds(40, 150, 150, 30);
        ltp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ltp);

        lbtp = new JLabel();
        lbtp.setBounds(250, 150, 150, 25);
        lbtp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbtp);

        JLabel ld = new JLabel("No. of Days:");
        ld.setBounds(40, 190, 150, 30);
        ld.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ld);

        lbdy = new JLabel();
        lbdy.setBounds(250, 190, 150, 25);
        lbdy.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbdy);

        JLabel lac = new JLabel("AC / NON-AC:");
        lac.setBounds(40, 230, 150, 30);
        lac.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lac);

        lbac = new JLabel();
        lbac.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        lbac.setBounds(250, 230, 150, 50);
        add(lbac);

        JLabel lfood = new JLabel("Food Included:");
        lfood.setBounds(40, 270, 150, 30);
        lfood.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lfood);

        lbfood = new JLabel();
        lbfood.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        lbfood.setBounds(250, 270, 150, 50);
        add(lbfood);

        JLabel lid = new JLabel("Id Proof");
        lid.setBounds(40, 310, 150, 30);
        lid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lid);

        lbid = new JLabel();
        lbid.setBounds(250, 310, 150, 30);
        lbid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbid);

        JLabel lno = new JLabel("Id Number ");
        lno.setBounds(40, 350, 150, 30);
        lno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lno);

        lbno = new JLabel();
        lbno.setBounds(250, 350, 150, 30);
        lbno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbno);

        JLabel lph = new JLabel("Phone ");
        lph.setBounds(40, 390, 150, 30);
        lph.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lph);

        lbph = new JLabel();
        lbph.setBounds(250, 390, 150, 30);
        lbph.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbph);

        JLabel ltpr = new JLabel("Total Price:");
        ltpr.setBounds(40, 430, 150, 30);
        ltpr.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ltpr);

        lbtpr = new JLabel();
        lbtpr.setBounds(250, 430, 150, 30);
        lbtpr.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbtpr);

        back = new JButton("Back");
        back.setBounds(250, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
            String query = " SELECT * FROM bookhotel WHERE username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lbusn.setText(rs.getString("username"));
                lbhotel.setText(rs.getString("name"));
                lbtp.setText(rs.getString("persons"));
                lbdy.setText(rs.getString("days"));
                lbac.setText(rs.getString("ac"));
                lbfood.setText(rs.getString("food"));
                lbid.setText(rs.getString("id")); 
                lbno.setText(rs.getString("number"));
                lbph.setText(rs.getString("phone"));
                lbtpr.setText(rs.getString("price"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ViewBookedHotel("aditik");
    }
}