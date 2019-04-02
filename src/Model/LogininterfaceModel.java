/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MAHNOORAFREEN
 */
public class LogininterfaceModel {
    
    connection c=new connection();
    
    public boolean authenticate(String id,String pass){
        c.connect();
        boolean verified = false;
        try {
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * From Owner");
            c.rs.next();
            
            String dbID=c.rs.getString("email");
            String dbPass=c.rs.getString("password");
            System.out.println(dbID+"   "+dbPass);
            System.out.println(id + "   "+pass);
            if(dbID.equals(id) && dbPass.equals(pass)){
                System.out.println("inside");
                verified = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogininterfaceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(verified);
        return verified;
        
    }
    
    
}
