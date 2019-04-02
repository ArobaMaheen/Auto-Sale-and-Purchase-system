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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Animation;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author MAHNOORAFREEN
 */
public class DashBoardDesignModel {
    connection c = new connection ();

    public int ini1(){
        int total=0;
       try{
            c.connect();
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("select COUNT(ID) FROM informers where d='n'");
           c.rs.next();
           total=Integer.parseInt(c.rs.getString(1));
           
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("select COUNT(ID) FROM Agents where d='n'");
           c.rs.next();
           total+=Integer.parseInt(c.rs.getString(1));
           
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("select COUNT(ID) FROM mechanic where d='n'");
           c.rs.next();
           total+=Integer.parseInt(c.rs.getString(1));
           
       }catch(Exception e){
           e.printStackTrace();
       }
       return total;
    }
    public int ini2(){
        int cartotal=0;
          try{
             c.connect();
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("select COUNT(ID) FROM Car WHERE Status='pur' AND d='n'");
           c.rs.next();
           cartotal=Integer.parseInt(c.rs.getString(1));
           
       }catch(Exception e){
           e.printStackTrace();
       }
          return cartotal;
    }
    public int ini3(){
        int totall=0;
        try{
            c.connect();
           System.out.println("insise");
           c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select Commission FROM Commission WHERE Status='Not Paid' AND d='n'");
           while(c.rs.next()){
               totall+=Integer.parseInt(c.rs.getString(1));
           }
           
           
       }catch(Exception e){
            e.printStackTrace();
       }
        return totall;
    }
    public int[] ini4(){
        int ass=0;
        int pur=0;
        int sold=0;
        int arr[]=new int[3];
        try{
            c.connect();
            c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select Count(ID) from Car WHERE d='n' and status='Assessed'");
           c.rs.next();
           ass=Integer.parseInt(c.rs.getString(1));
           
            arr[0]=ass;
             c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select Count(ID) from Car WHERE d='n' and status='pur'");
           c.rs.next();
           pur=Integer.parseInt(c.rs.getString(1));
           
            arr[1]=pur;
             c.st=c.con.createStatement();
           c.rs=c.st.executeQuery("Select Count(ID) from Car WHERE d='n' and status='sold'");
            c.rs.next();
           sold=Integer.parseInt(c.rs.getString(1));
           
            arr[2]=sold;
        }catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }
}
