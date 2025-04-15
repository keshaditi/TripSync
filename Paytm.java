package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener{
    Paytm(){
        setBounds(400, 200, 800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JEditorPane pane= new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://paytm.com/");
        } catch (Exception e) {
            pane.setContentType("text/html");
            pane .setText("<html>Could not load,Error 404</html>");            
        }
        
        JScrollPane sp = new JScrollPane(pane);
        sp.setBounds(0, 0, 800, 600);
        getContentPane().add(sp);
        
        JButton back = new JButton("Back");
        back.setBounds(610, 20, 80, 30); 
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
    }
    
    public static void main(String[] args) {
        new Paytm();
    }
}
