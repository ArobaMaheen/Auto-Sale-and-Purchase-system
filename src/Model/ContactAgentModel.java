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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author MAHNOORAFREEN
 */
public class ContactAgentModel {
    
connection c= new connection();
    public void ini1(ObservableList ol)
    {
        
          c.connect();
       
       try{
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Agents");
           
           while(c.rs.next()){
               ol.add(new contacttable(c.rs.getString("name"),c.rs.getString("ID"),c.rs.getString("cnic"),c.rs.getString("addr"),c.rs.getString("pno"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
           }
        
    }
       catch(Exception e){
           e.printStackTrace();
       }
    
}
    public void ini2(ComboBox<String> selectcar,ComboBox<String> selectpurpose)
    {
            c.connect();
       
       try{
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select * from Car where Status='pur' and d='n'");
           
           while(c.rs.next()){
               selectcar.getItems().add(c.rs.getString("ID")+"- "+c.rs.getString("name"));
           }
           selectcar.getSelectionModel().selectFirst();
           
           selectpurpose.getItems().addAll("Send Details Of Car","Request");
           selectpurpose.getSelectionModel().selectFirst();
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    public String[] sendbtnclick(String oemail,String opass,ObservableList<contacttable> ol)
    {
        String arr[] = new String[2];
              try{
                  c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Owner");
            c.rs.next();
            
            oemail=c.rs.getString("email");
            arr[0]=oemail;
            opass=c.rs.getString("password");
            arr[1]=opass;
            System.out.println(opass);
            System.out.println(oemail);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
       return arr; 
    }
    public void bb1( String car)
    {
        try{
            
        c.connect();
           
          c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where ID='"+car+"'");
            
            c.rs.next();
        }
        catch(Exception e)
        {
            e.printStackTrace();
    }
}
    public String bb2(String mes)
    {
        try{
            mes="/*GENERATED MESSAGE*/\n\n"
                    + "Car ID   =   "+c.rs.getString("ID")+"\n"
                    + "Car Name   =   "+c.rs.getString("name")+"\n"
                    + "Car Color   =   "+c.rs.getString("color")+"\n"
                    + "Car Model   =   "+c.rs.getString("model")+"\n"
                    + "Car Tank   =   "+c.rs.getString("tank")+"\n"
                    + "Car Feul   =   "+c.rs.getString("feultype")+"\n"
                    + "Car Date Of Purchase   =   "+c.rs.getString("doip")+"\n"
                    + "Car Milleage   =   "+c.rs.getString("mil")+"\n"
                    + "Car Price   =   "+c.rs.getString("price")+"\n"
                    + "Car Location   =   "+c.rs.getString("location")+"\n"
                    + "Car NumberPlate   =   "+c.rs.getString("nplate")+"\n"
                    + "Car Date Added   =   "+c.rs.getString("date")+"\n\n"
                    + "Please Find Buyer For This Car\nThankYou\n\n"
                    + "/*GENERATED MESSAGE*/";
        }
        catch(Exception e)
        {
          e.printStackTrace();
                
        }
        return mes;
    }
    public String bb3(String mes)
    {
        try{
                  mes="/*GENERATED MESSAGE*/\n\n"
                    + "Car ID   =   "+c.rs.getString("ID")+"\n"
                    + "Car Name   =   "+c.rs.getString("name")+"\n"
                    + "Car Color   =   "+c.rs.getString("color")+"\n"
                    + "Car Model   =   "+c.rs.getString("model")+"\n\n"
                    + "Any Buyer Found For This Car?\n\n"
                    + "/*GENERATED MESSAGE*/";
        }
        catch(Exception e)
        {
            e.printStackTrace();
    }
        System.out.println(mes);
        return mes;
    }
}
