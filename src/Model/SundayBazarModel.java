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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.ScaleTransition;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class SundayBazarModel {
    connection c = new connection();
    
    public void ini1(TableView tv,ScrollPane scr , TableColumn<sundaytable,String> carid,  TableColumn<sundaytable,String> carname,  TableColumn<sundaytable,String> date,  TableColumn<sundaytable,String> charges)
    {
            
        try{
                c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from SundayBazaar INNER JOIN Car ON Car.id=SundayBazaar.carid where SundayBazaar.d='n'");
            ObservableList<sundaytable> ol=FXCollections.observableArrayList();
            while(c.rs.next()){
                ol.add(new sundaytable(c.rs.getString("carid"),c.rs.getString("name"),c.rs.getString("date"),c.rs.getString("charge")));
            }
            tv=new TableView();
            tv.setItems(ol);
            tv.getColumns().addAll(carid,carname,date,charges);
           scr.setContent(tv);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delete1(String id,String a,String d)
            
    {
               try{
                   c.connect();
            c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE SundayBazaar SET d='y' where carid='"+id+"' and charge='"+a+"' and date='"+d+"'");
     
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
