/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
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
import javafx.scene.control.Label;
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
public class CompnyBuyingModel {
    connection c = new connection();
    
    public void ini1(Label name,Label id ,Label price,Label mil,Label year,Label sid,Label sname,Label pno,Label addr){
    // public void ini1(){
         try{
             c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where ID='"+NewClass.id+"' and d='n'");
            
            c.rs.next();
            
            String Sname=c.rs.getString("name");
            String syear=c.rs.getString("model");
            String sprice=c.rs.getString("price");
            
            String smil=c.rs.getString("mil");
             
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Seller where ID='"+NewClass.id+"'");
            System.out.println(NewClass.id);
             c.rs.next();
            
            String names=c.rs.getString("name");
            String pnoo=c.rs.getString("pno");
            String addrs=c.rs.getString("addr");
            
             name.setText(Sname);
            id.setText(NewClass.id);
            price.setText(sprice);
            mil.setText(smil);
            year.setText(syear);
            sid.setText(NewClass.id);
            sname.setText(names);
            pno.setText(pnoo);
            addr.setText(addrs);
        }catch(Exception e){
            e.printStackTrace();
            
        }
    
}
    public void save1(String date){
        try{
        c.st=c.con.createStatement();
                    c.st.executeUpdate("UPDATE Car SET Status='pur', date='"+date+"' where ID='"+NewClass.id+"'");

    }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    public void save2(File f){
               try{
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
            c.st.executeUpdate("UPDATE Seller SET image='"+l+"' WHERE ID='"+NewClass.id+"'");
            
            
        }catch(Exception exx){
            exx.printStackTrace();
        }
            System.out.println("Done Updating");
    }
}
