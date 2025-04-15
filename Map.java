package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Map extends JFrame implements ActionListener {

    JButton back;

    public Map() { 
        setBounds(550, 200, 600, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/map.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 10, 600, 600); 
        add(image);

        back = new JButton("Back");
        back.setBounds(280, 20, 80, 30); 
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        new Map(); 
    }
}