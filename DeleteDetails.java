package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class DeleteDetails extends JFrame implements ActionListener {
    JLabel lbusn, lbid, lbno, lbnm, lbgd, lbcnty, lbadd, lbph, lbem;
    JButton del;
    String username;

    DeleteDetails(String username) {
        this.username = username;
        setBounds(400, 200, 1000, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("DELETE CUSTOMER DETAILS");
        text.setBounds(260, 15, 350, 30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setForeground(Color.BLACK);
        add(text);

        JLabel lusn = new JLabel("Username ");
        lusn.setBounds(30, 70, 150, 30);
        lusn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lusn);

        lbusn = new JLabel();
        lbusn.setBounds(220, 70, 150, 30);
        lbusn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbusn);

        JLabel lid = new JLabel("Id Proof ");
        lid.setBounds(30, 140, 150, 30);
        lid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lid);

        lbid = new JLabel();
        lbid.setBounds(220, 140, 150, 30);
        lbid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbid);

        JLabel lno = new JLabel("Id Number ");
        lno.setBounds(30, 210, 150, 30);
        lno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lno);

        lbno = new JLabel();
        lbno.setBounds(220, 210, 150, 30);
        lbno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbno);

        JLabel lnm = new JLabel("Name ");
        lnm.setBounds(30, 280, 150, 30);
        lnm.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lnm);

        lbnm = new JLabel();
        lbnm.setBounds(220, 280, 150, 30);
        lbnm.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbnm);

        JLabel lgd = new JLabel("Gender ");
        lgd.setBounds(30, 350, 150, 30);
        lgd.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lgd);

        lbgd = new JLabel();
        lbgd.setBounds(220, 350, 150, 30);
        lbgd.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbgd);

        JLabel lcnty = new JLabel("Country ");
        lcnty.setBounds(500, 70, 150, 30);
        lcnty.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lcnty);

        lbcnty = new JLabel();
        lbcnty.setBounds(690, 70, 150, 30);
        lbcnty.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbcnty);

        JLabel ladd = new JLabel("Address ");
        ladd.setBounds(500, 140, 150, 30);
        ladd.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ladd);

        lbadd = new JLabel();
        lbadd.setBounds(690, 140, 250, 30); // Increased width for address
        lbadd.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbadd);

        JLabel lph = new JLabel("Phone ");
        lph.setBounds(500, 210, 150, 30);
        lph.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lph);

        lbph = new JLabel();
        lbph.setBounds(690, 210, 150, 30);
        lbph.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbph);

        JLabel lem = new JLabel("Email ");
        lem.setBounds(500, 280, 150, 30);
        lem.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lem);

        lbem = new JLabel();
        lbem.setBounds(650, 280, 300, 30); // Increased width for email
        lbem.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbem);

        del = new JButton("Delete");
        del.setBounds(400, 450, 100, 30); // Adjusted Y-coordinate of the button
        del.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        del.setBorder(new LineBorder(Color.BLACK));
        del.setFont(new Font("Tahoma", Font.BOLD, 14));
        del.addActionListener(this);
        add(del);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png")); // Changed to a more relevant icon
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Reduced image size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 350, 200, 200); // Adjusted position and size of the image
        add(image);

        try {
            Conn c = new Conn();
            String query = " select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
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

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '" + username + "'");
            c.s.executeUpdate("delete from customer where username = '" + username + "'");
            c.s.executeUpdate("delete from bookpackage where username = '" + username + "'");
            c.s.executeUpdate("delete from bookhotel where username = '" + username + "'");

            JOptionPane.showMessageDialog(null, "Deleted Customer Details Successfully");

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DeleteDetails("aditik");
    }
}
