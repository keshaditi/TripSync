package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
    String s; 

    About() {
        setBounds(600, 200, 500, 580);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 8, 100, 40);
        l1.setBackground(Color.BLUE);
        l1.setFont(new Font("Tamoha", Font.BOLD, 25));
        add(l1);

        s = "Welcome to Travel & Tourism Management System.\n\n"
            + "A team of dedicated travel enthusiasts, TripSync emerged from a shared love for exploration and a desire to simplify the travel planning process. We recognized the need for a reliable and personalized service that caters to the diverse travel aspirations of individuals and groups alike. Starting small, we have grown into a reputable agency built on trust, expertise, and a genuine commitment to our clients.\n\n"
            + "**Our Mission:**\n"
            + "Our mission is to empower you to explore the world with confidence and ease. We strive to:\n"
            + "  * Provide Travel Solutions\n"
            + "  * Offer Unparalleled Expertise\n"
            + "  * Ensure Seamless Travel Experiences\n"
            + "  * Deliver Exceptional Value\n"
            + "  * Promote Responsible Tourism\n\n"
            + "**What Makes Us Different?**\n"
            + "  * Local Expertise, Global Reach\n"
            + "  * Customer-Centric Approach\n"
            + "  * Passion for Travel\n"
            + "  * Transparency and Trust\n"
            + "  * Commitment to Quality\n\n"
            + "**Our Services Include:**\n"
            + "  * Hotel Bookings\n"
            + "  * Accommodation Arrangements\n"
            + "  * Tour Packages\n"
            + "  * Transportation\n"
            + "  * Visa Assistance\n"
            + "  * Travel Insurance\n"
            + "  * Cruise Bookings\n"
            + "  * Corporate Travel Management\n\n"
            + "Thank you for choosing Us. We look forward to being a part of your unforgettable travel stories!";

        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 60, 450, 400); 
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 480, 80, 30); 
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}