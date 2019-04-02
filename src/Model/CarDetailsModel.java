/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.*;
import Controller.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class CarDetailsModel {
    connection c = new connection();
public void ini1(Label daa,ImageView imgg, Label dadd,String asss,Label CarId,Label Name,Label Model,Label CarColor,Label TankCapacity,Label FuelType,Label CarsOwner,Label NumberPlate,Label Date,Label Mileage,Label Location,Label Price,ImageView imgs,Label SellerName,Label PhoneNo,Label Address,Label InformerName)
    {
                try{
                    c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car INNER JOIN Seller On Seller.id=car.id INNER JOIN Informers ON Car.informerid=Informers.id where car.ID='"+NewClass.id+"' and car.d='n'");
            c.rs.next();
            if(c.rs.getString("status").equals("pur")){
                daa.setText("Date Purchased");
            }
            try{
            String imgn=c.rs.getString(16);
             File ff=new File("resource/"+imgn+".jpg");
             FileInputStream fis=new FileInputStream(ff);
             Image i=new Image(fis);
             imgg.setImage(i);
            }catch(Exception e){
                System.out.println("No Image");
            }
            dadd.setText(c.rs.getString("date"));
            asss=c.rs.getString("Status");
            CarId.setText(NewClass.id);
            Name.setText(c.rs.getString(1));
            Model.setText(c.rs.getString("model"));
            CarColor.setText(c.rs.getString("color"));
            TankCapacity.setText(c.rs.getString("tank"));
            FuelType.setText(c.rs.getString("feultype"));
            CarsOwner.setText(c.rs.getString("carowner"));
            NumberPlate.setText(c.rs.getString("nplate"));
            Date.setText(c.rs.getString("doip"));
            Mileage.setText(c.rs.getString("mil"));
            Location.setText(c.rs.getString("location"));
            Price.setText(c.rs.getString("price"));
            String a=c.rs.getString("informerid");
            //c.st=c.con.createStatement();
           // c.rs=c.st.executeQuery("Select * from Seller where ID='"+NewClass.id+"'");
          //  c.rs.next();
             try{
            String imgn=c.rs.getString(21);
             File ff=new File("resource/"+imgn+".jpg");
             FileInputStream fis=new FileInputStream(ff);
             Image i=new Image(fis);
             imgs.setImage(i);
            }catch(Exception e){
                e.printStackTrace();
            }
            SellerName.setText(c.rs.getString(18));
            PhoneNo.setText(c.rs.getString(19));
            Address.setText(c.rs.getString(20));
          //  c.st=c.con.createStatement();
         //   c.rs=c.st.executeQuery("Select * from Informers where ID='"+a+"'");
         //   c.rs.next();
            
            InformerName.setText(c.rs.getString(23));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
public void del1(){
        try{
            c.connect();
            c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE Car SET d='y' where ID='"+NewClass.id+"'");

        }catch(Exception e){
            e.printStackTrace();
        }
}
}
