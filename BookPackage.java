package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    JTextField tftp;
    JLabel lbusn, lbid, lbno, lbph, lbtpr;
    String username;
    JButton checkprice, bookpackage, back;

    BookPackage(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(110, 20, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 25));
        text.setForeground(Color.BLACK);
        add(text);

        JLabel lusn = new JLabel("Username ");
        lusn.setBounds(40, 70, 150, 20);
        lusn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lusn);

        lbusn = new JLabel();
        lbusn.setBounds(250, 70, 150, 30);
        lbusn.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbusn);

        JLabel lsp = new JLabel("Select Package ");
        lsp.setBounds(40, 110, 150, 25);
        lsp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lsp);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Diamond Package");
        cpackage.add("Platinum Package");
        cpackage.setBounds(250, 110, 150, 35);
        add(cpackage);

        JLabel ltp = new JLabel("Total Persons");
        ltp.setBounds(40, 150, 150, 30);
        ltp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ltp);

        tftp = new JTextField();
        tftp.setBounds(250, 150, 150, 25);
        tftp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(tftp);

        JLabel lid = new JLabel("Id Proof");
        lid.setBounds(40, 190, 150, 30);
        lid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lid);

        lbid = new JLabel();
        lbid.setBounds(250, 190, 150, 30);
        lbid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbid);

        JLabel lno = new JLabel("Id Number ");
        lno.setBounds(40, 230, 150, 30);
        lno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lno);

        lbno = new JLabel();
        lbno.setBounds(250, 230, 150, 30);
        lbno.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbno);

        JLabel lph = new JLabel("Phone ");
        lph.setBounds(40, 270, 150, 30);
        lph.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lph);

        lbph = new JLabel();
        lbph.setBounds(250, 270, 150, 30);
        lbph.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbph);

        JLabel ltpr = new JLabel("Total Price");
        ltpr.setBounds(40, 310, 150, 30);
        ltpr.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ltpr);

        lbtpr = new JLabel();
        lbtpr.setBounds(250, 310, 150, 30);
        lbtpr.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lbtpr);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "' ";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lbusn.setText(rs.getString("username"));
                lbid.setText(rs.getString("id"));
                lbno.setText(rs.getString("number"));
                lbph.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 380, 120, 30);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBorder(new LineBorder(Color.BLACK));
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(200, 380, 120, 30);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBorder(new LineBorder(Color.BLACK));
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBounds(340, 380, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 30, 450, 420);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 12000;
            } else if (pack.equals("Diamond Package")) {
                cost += 22000;
            } else {
                cost += 32000;
            }

            int persons = Integer.parseInt(tftp.getText());
            cost *= persons;
            lbtpr.setText("Rs " + cost);

        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                String query = "insert into bookpackage values ( '" + lbusn.getText() + "','" + cpackage.getSelectedItem() + "' , '" + tftp.getText() + "' ,'" + lbid.getText() + "','" + lbno.getText() + "','" + lbph.getText() + "','" + lbtpr.getText().replace("Rs ", "") + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Package Booking Failed");
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("Utkarshshah");
    }
}