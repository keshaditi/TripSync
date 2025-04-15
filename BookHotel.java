package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class BookHotel extends JFrame implements ActionListener {
    String username;
    Choice chotel , cac , cfood ;
    JTextField tftp , tfdy ;
    JButton checkprice, bookhotel, back;
    JLabel lbusn , lbid ,lbno, lbph , lbtpr;
    
    BookHotel(String username) {
        
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(210, 20, 200, 30);
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

        JLabel lsp = new JLabel("Select Hotel: ");
        lsp.setBounds(40, 110, 150, 25);
        lsp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lsp);

        chotel = new Choice();
        chotel.setBounds(250, 110, 150, 60);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        JLabel ltp = new JLabel("Total Persons: ");
        ltp.setBounds(40, 150, 150, 30);
        ltp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ltp);

        tftp = new JTextField();
        tftp.setBounds(250, 150, 150, 25);
        tftp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(tftp);

        JLabel ld = new JLabel("No. of Days:");
        ld.setBounds(40, 190, 150, 30);
        ld.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(ld);

        tfdy = new JTextField();
        tfdy.setBounds(250, 190, 150, 25);
        tfdy.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(tfdy);
        
        JLabel lac = new JLabel("AC / NON-AC:");
        lac.setBounds(40, 230, 150, 30);
        lac.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 150, 50);
        add(cac);
        
        JLabel lfood = new JLabel("Food Included:");
        lfood.setBounds(40, 270, 150, 30);
        lfood.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 150, 50);
        add(cfood);
        
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

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '"+ username +"'";
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
        checkprice.setBounds(80, 500, 120, 30);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBorder(new LineBorder(Color.BLACK));
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkprice.addActionListener(this);
        add(checkprice);

        bookhotel= new JButton("Book Hotel");
        bookhotel.setBounds(220, 500, 120, 30);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBorder(new LineBorder(Color.BLACK));
        bookhotel.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBounds(360, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 450, 420);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name =  '"+ chotel.getSelectedItem() + "'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                
                int persons = Integer.parseInt(tftp.getText());
                int days = Integer.parseInt(tfdy.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(persons * days > 0 ){
                    int total = 0;
                    total += acselected.equals("AC") ? ac : 0 ;
                    total += foodselected.equals("Yes") ? food : 0 ;
                    total += cost ;
                    total = total * persons * days ;
                    lbtpr.setText("Rs " + total);
                } else{
                    JOptionPane.showMessageDialog(null,"Please Enter a Valid Number");
                }
            } 
            }catch (Exception e) {
                e.printStackTrace();
            }    
        } else if (ae.getSource() == bookhotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('" +lbusn.getText()+ "','" + chotel.getSelectedItem() + "' , '" + tftp.getText() + "' ,'"+tfdy.getText()+"','" + cac.getSelectedItem() + "' ,'" + cfood.getSelectedItem() + "' ,'" + lbid.getText() + "','" + lbno.getText() + "','" + lbph.getText() + "','" + lbtpr.getText()+ "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: Hotel Booking Failed");
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookHotel("aditik");
    }
}