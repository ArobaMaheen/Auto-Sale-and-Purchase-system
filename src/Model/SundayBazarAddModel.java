/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.*;
import Controller.*;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class SundayBazarAddModel {
    connection c = new connection ();
    public void ini(ComboBox<String> car)
    {
   try{
        c.connect();
   
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where status='pur' and d='n'");
            
            while(c.rs.next()){
                car.getItems().add(c.rs.getString("ID")+"- "+c.rs.getString("name"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void save( String id, String name, String com)
    {
        try{
                   c.st=c.con.createStatement();
             DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        String d=df.format(dateobj);
            c.st.executeUpdate("INSERT INTO SundayBazaar values('"+id+"','"+d+"','"+com+"','n')");
    }
        catch(Exception e )
        {
           e.printStackTrace(); 
        }
        }
}
