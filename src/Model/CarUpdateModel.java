/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.*;
import Controller.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author MAHNOORAFREEN
 */
public class CarUpdateModel {
    
    connection c;
    public CarUpdateModel(){
        
    }

        
    public void ini1(URL url, ResourceBundle rb,TextField id,ComboBox<String> infcombo){
         c=new connection();
        c.connect();
            try{
        
             c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Informers Where d='n'");
           while(c.rs.next()){
               infcombo.getItems().add(c.rs.getString("name"));
           }  
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car INNER JOIN Informers on Car.Informerid = Informers.ID INNER JOIN Seller ON Car.ID = Seller.ID where Car.ID='"+NewClass.id+"' AND car.d='n'");
            c.rs.next();
            }
            catch(Exception e){
            e.printStackTrace();
        }
    }
            public String ini2(ImageView img , TextField id , TextField carname,TextField Model ,TextField CarColor ,TextField TankCapacity,TextField FuelType,TextField CarOwner,TextField numberplate,TextField Doip,TextField mil , TextField price , TextField loc,String odate,String status , ComboBox<String> infcombo, TextField SName,TextField Pno,TextField add){
             try{
            String imgn=c.rs.getString("image");
             File ff=new File("resource/"+imgn+".jpg");
             FileInputStream fis=new FileInputStream(ff);
             Image i=new Image(fis);
             img.setImage(i);
            }catch(Exception e){
                System.out.println("No Image");
            }   
             try{
            String iid=c.rs.getString("informerid");
            id.setText(c.rs.getString("ID"));
            carname.setText(c.rs.getString("name"));
            Model.setText(c.rs.getString("model"));
            CarColor.setText(c.rs.getString("color"));
            TankCapacity.setText(c.rs.getString("tank"));
            FuelType.setText(c.rs.getString("feultype"));
            CarOwner.setText(c.rs.getString("carowner"));
            numberplate.setText(c.rs.getString("nplate"));
            Doip.setText(c.rs.getString("doip"));
            mil.setText(c.rs.getString("mil"));
            price.setText(c.rs.getString("price"));
            loc.setText(c.rs.getString("location"));
           odate=c.rs.getString("date");
           status=c.rs.getString("Status");
            
           //  c.st=c.con.createStatement();
           // c.rs=c.st.executeQuery("Select * from Informers where ID='"+iid+"'");
          //  c.rs.next();
            infcombo.getSelectionModel().select(c.rs.getString(18));
            // c.st=c.con.createStatement();
           // c.rs=c.st.executeQuery("Select * from Seller where ID='"+id.getText()+"'");
           //  c.rs.next();
             SName.setText(c.rs.getString(28));
             Pno.setText(c.rs.getString(29));
             add.setText(c.rs.getString(30));
             }
             catch(Exception e){
                System.out.println("No Image");
            } 
             return status;
            }
            public void ini3(String cname,String ccolor,String cmodel,String ctank ,String cfuel,String cowner,String cdoip,String cmil,String cprice,String cloc,String cplate,String odate,String status,String sname,String spno,String sadd,String inf,Boolean b,File f,TextField id){
                 try {
            c.st=c.con.createStatement();
          c.rs=c.st.executeQuery("Select * from Informers where Name='"+inf+"'");
          c.rs.next();
          String infID=c.rs.getString("id");
          c.st=c.con.createStatement();
                     System.out.println("ID: "+NewClass.id);
                     System.out.println("DOing");
           c.st.executeUpdate("UPDATE Car SET name='"+cname+"' ,color='"+ccolor+"', model='"+cmodel+"', tank='"+ctank+"', feultype='"+cfuel+"', carowner='"+cowner+"', doip='"+cdoip+"', mil='"+cmil+"', price='"+cprice+"', location='"+cloc+"', nplate='"+cplate+"', date='"+odate+"', informerid="+infID+", Status='"+status+"' WHERE ID='"+NewClass.id+"'");
           c.st=c.con.createStatement();
                     System.out.println("Done");
           c.st.executeUpdate("UPDATE Seller SET name='"+sname+"', pno='"+spno+"', addr='"+sadd+"' WHERE ID='"+NewClass.id+"'");
                     System.out.println("dd");
           if(b){
           
           
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
            c.st.executeUpdate("UPDATE Car SET image='"+l+"' WHERE ID='"+Integer.toString(Integer.parseInt(id.getText()))+"'");
            
            
        }catch(Exception exx){
            exx.printStackTrace();
        }
           }
         } catch (SQLException ex) {
           ex.printStackTrace();
         }
                
            }
    }

