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
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class CarDetails2Model {
    connection c = new connection ();
    public String ini1(ImageView imgg,Label dadd,String asss,Label CarId,Label Name,Label Model,Label CarColor,Label TankCapacity,Label FuelType ,Label CarsOwner,Label NumberPlate,Label Date ,Label Mileage,Label Location,Label Price)
    {
        String a=null;
        try{
            c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car  INNER JOIN Buyer ON Car.ID=Buyer.ID INNER JOIN Informers ON Car.informerid= Informers.id INNER JOIN Seller on Car.id=Seller.ID where car.ID='"+NewClass.id+"' and car.d='n'");
            c.rs.next();
        
       
           try{
            String imgn=c.rs.getString(16);
             File ff=new File("resource/"+imgn+".jpg");
               System.out.println(imgn);
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
            a=c.rs.getString("informerid");
        }
     catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    
    public void ini2(ImageView imgs,Label SellerName,Label PhoneNo,Label Address)
    {
        try{
        //  c.connect();
        // c.st=c.con.createStatement();
       //     c.rs=c.st.executeQuery("Select * from Seller where ID='"+NewClass.id+"'");
       //     c.rs.next();

        
       
               try{
            String imgn=c.rs.getString(37);
             File ff=new File("resource/"+imgn+".jpg");
             FileInputStream fis=new FileInputStream(ff);
             Image i=new Image(fis);
             imgs.setImage(i);
            }catch(Exception e){
                e.printStackTrace();
            }
            SellerName.setText(c.rs.getString(34));
            PhoneNo.setText(c.rs.getString(35));
            Address.setText(c.rs.getString(36));
        }
         catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void ini3(Label InformerName,String a)
    {
        try{
            c.connect();
        //c.st=c.con.createStatement();
       //     c.rs=c.st.executeQuery("Select * from Informers where ID='"+a+"'");
       //     c.rs.next();
            
            InformerName.setText(c.rs.getString(24));
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void ini4(ImageView imgs1,Label SellerName1,Label PhoneNo1,Label Address1)
    {
        try{
          // c.st=c.con.createStatement();
         //   c.rs=c.st.executeQuery("Select * from Buyer where ID='"+NewClass.id+"'");
          //  c.rs.next();
                try{
            String imgn=c.rs.getString(22);
             File ff=new File("resource/"+imgn+".jpg");
             FileInputStream fis=new FileInputStream(ff);
             Image i=new Image(fis);
             imgs1.setImage(i);
            }catch(Exception e){
                e.printStackTrace();
            }
            SellerName1.setText(c.rs.getString(18));
            PhoneNo1.setText(c.rs.getString(19));
            Address1.setText(c.rs.getString(20));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
