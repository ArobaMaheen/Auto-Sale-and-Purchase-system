/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.*;
import Controller.*;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.IOException;
import java.lang.Thread.State;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.concurrent.Worker;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class OAModel {
    
     connection co = new connection ();

    public void ini(ComboBox<String> c)
    {
       
       
        
        try{
              co.connect();
            co.st=co.con.createStatement();
             co.rs=co.st.executeQuery("Select * from Car where d='n' and status='pur'");
            while(co.rs.next()){
            c.getItems().add(co.rs.getString("ID")+"- "+co.rs.getString("name"));
                    }
        }catch(Exception e){
            e.printStackTrace();
        }
           c.getSelectionModel().selectFirst();
    }
    public void byt1(ImageView img,TextArea teaa,ComboBox<String> c)
    {
             String car="";
        try{
              co.connect();
        Integer.parseInt(Character.toString(c.getValue().charAt(1)));
         car=Character.toString(c.getValue().charAt(0))+Character.toString(c.getValue().charAt(1));
        }catch(Exception e){
         car=Character.toString(c.getValue().charAt(1));}
        
        
        String mes="";
         try{
           
           co.connect();
            co.st=co.con.createStatement();
            co.rs=co.st.executeQuery("Select * from Car where ID='"+car+"'");
            
            co.rs.next();
               try{
            byte[] fileByte=co.rs.getBytes("image");
             ByteArrayInputStream in = new ByteArrayInputStream(fileByte);
             Image i=new Image(in);
             img.setImage(i);
            }catch(Exception e){
                e.printStackTrace();
            }
    }
         catch(Exception e){
                e.printStackTrace();
                System.out.println("Image");
            }
         try{
             
          mes=""
                  
                    + "Car Name   =   "+co.rs.getString("name")+"\n"
                    + "Car Color   =   "+co.rs.getString("color")+"\n"
                    + "Car Model   =   "+co.rs.getString("model")+"\n"
                    + "Car Tank   =   "+co.rs.getString("tank")+"\n"
                    + "Car Feul   =   "+co.rs.getString("feultype")+"\n"
                    + "Car Date Of Purchase   =   "+co.rs.getString("doip")+"\n"
                    + "Car Milleage   =   "+co.rs.getString("mil")+"\n"
                    + "Car Price   =   "+co.rs.getString("price")+"\n"
                    + "Car Location   =   "+co.rs.getString("location")+"\n"
                    + "Car NumberPlate   =   "+co.rs.getString("nplate")+"\n"
                    + "Car Date Added   =   "+co.rs.getString("date")+"\n\n"
                    + "Interested Buyers Please Contact 0331-2823521\nThankYou\n\n"
                    + "/*GENERATED MESSAGE*/";
          
           teaa.setText(mes);
}
         catch(Exception e){
                e.printStackTrace();
            }
}
}
