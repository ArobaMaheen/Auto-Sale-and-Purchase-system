/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.*;
import Controller.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
/**
 *
 * @author MAHNOORAFREEN
 */
public class CompanySellng_1Model {
    connection c = new connection ();

    public void ini(Label carname,Label carid,Label carprice,Label manu,Label caryear){
  
    try{
        c.connect(); 
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where ID='"+NewClass.id+"' and d='n'");
            
            c.rs.next();
            
            String name=c.rs.getString("name");
            String year=c.rs.getString("model");
            String price=c.rs.getString("price");
            
            String mil=c.rs.getString("mil");
            
            carname.setText(name);
           carid.setText(NewClass.id);
           carprice.setText(price);
         manu.setText(mil);
           caryear.setText(year);
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void save (String bname,  String bpno,String badd,String bcnic){
                try{
            c.st=c.con.createStatement();
             DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        String date=df.format(dateobj);
            c.st.executeUpdate("UPDATE Car SET Status='sold', date='"+date+"' where ID='"+NewClass.id+"'");
            
             c.st=c.con.createStatement();
            c.st.executeUpdate("INSERT INTO Buyer values('"+bname+"','"+bpno+"','"+badd+"','"+bcnic+"',null,'"+NewClass.id+"')");
    }
                catch(Exception e){
            e.printStackTrace();
        }
    
}
    public void img(File f){
          
        try{
            //img
            FileInputStream fis=new FileInputStream(f);
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from imagename");
            String l="0";
            while(c.rs.next()){
                l=c.rs.getString("id");
            }
            
            l=Integer.toString(Integer.parseInt(l)+1);
            int cursor;
            String path="resource/"+l+".jpg";
             FileOutputStream fos=new FileOutputStream(path);
              while((cursor = fis.read())!=-1){
            fos.write(cursor);
          
        }
                fis.close();
            fos.close();
             c.st=c.con.createStatement();
            c.st.executeUpdate("INSERT INTO imagename values('"+l+"')");
               c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE Buyer SET image='"+l+"' WHERE ID='"+NewClass.id+"'");
            
            
        }catch(Exception exx){
            exx.printStackTrace();
        }
    }
}
