package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run (){
        try{
            for(int i =1; i <= 101; i++){
                int max = bar.getMaximum();     //100
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel & Tourism Application");
	text.setBounds(50, 20, 600, 100);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        text.setForeground(new Color(100,100,255));
	add(text);
                
        bar = new JProgressBar();
        bar.setBounds(150,130, 300, 35);
        bar.setStringPainted(true);
	add(bar);
        
        JLabel loading = new JLabel("Loading , Please Wait...");
	loading.setBounds(150, 160, 500, 60);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
	add(loading);
        
        JLabel user = new JLabel(" Welcome "+username);
	user.setBounds(20, 310, 400, 40);
        user.setFont(new Font("Raleway",Font.BOLD,16));
	add(user);
        
        t.start();
        setVisible(true);
    }
    
    public static void main (String[] args){
        new Loading("aditik");
    }

}
