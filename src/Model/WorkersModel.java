/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.*;
import Controller.*;
import Controller.NewClass;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class WorkersModel {
    connection c = new connection ();
    public TableView ini1(TableView tv,TableColumn<worktable,String> id,TableColumn<worktable,String> name,TableColumn<worktable,String> add,TableColumn<worktable,String> cnic,TableColumn<worktable,String> zone,TableColumn<worktable,String> email,TableColumn<worktable,String> date,TableColumn<worktable,String> pno,ScrollPane scrr)
    {
     c.connect();
        tv=new TableView();
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Informers where d='n'");
            ObservableList ol=FXCollections.observableArrayList();
            while(c.rs.next()){
ol.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(ol);
            tv.getColumns().setAll(id,name,add,cnic,zone,email,date,pno);
            scrr.setContent(tv);
        }catch(Exception e){
            e.printStackTrace();
        }
        return tv;
    }
    public void ini2(TableView tv){
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Informers where d='n'");
            ObservableList ol=FXCollections.observableArrayList();
            while(c.rs.next()){
                ol.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(ol);
            
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
   public void  ini3(TableView tv)
    {
         try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Agents where d='n'");
            ObservableList ol=FXCollections.observableArrayList();
            while(c.rs.next()){
                ol.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(ol);
            
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
   public void ini4(TableView tv){
                    try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic where d='n'");
            ObservableList ol=FXCollections.observableArrayList();
            while(c.rs.next()){
                ol.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(ol);
            
           
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
   }
   
   public void ini5(TableView tv,ImageView img,ComboBox<String> Selectworker){
        try {
                worktable wt=(worktable)tv.getSelectionModel().getSelectedItem();
                c.st=c.con.createStatement();
                c.rs=c.st.executeQuery("Select * from "+Selectworker.getValue()+" Where id='"+wt.id+"'");    //ERROR 
                
                c.rs.next();
                byte[] imgbyte=c.rs.getBytes("image");
                ByteArrayInputStream in = new ByteArrayInputStream(imgbyte);
             Image i=new Image(in);
             img.setImage(i);
            } catch (Exception ex) {
                System.out.println("No image");
                img.setImage(null);
            }
   }
    public void del1(ComboBox<String> Selectworker,worktable ol){
        try{
        c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE "+Selectworker.getValue()+" SET d='y' WHERE id='"+ol.id+"'");
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void del2(TableView tv,ImageView img){
        try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Informers where d='n'");
            ObservableList oll=FXCollections.observableArrayList();
            while(c.rs.next()){
                oll.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(oll);
            img.setImage(null);
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void del3(TableView tv){
         try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Agents where d='n'");
            ObservableList oll=FXCollections.observableArrayList();
            while(c.rs.next()){
                oll.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(oll);
            
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void del4(TableView tv){
                     try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic where d='n'");
            ObservableList oll=FXCollections.observableArrayList();
            while(c.rs.next()){
                oll.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
            }
            tv.setItems(oll);
            
           
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
