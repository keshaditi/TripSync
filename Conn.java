package travel.management.system;

import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //address of jar file 
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","aditi123");
            s=c.createStatement();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}