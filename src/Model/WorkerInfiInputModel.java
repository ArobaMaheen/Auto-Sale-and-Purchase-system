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
public class WorkerInfiInputModel {
    connection c = new connection ();
    public void ifstatement(ComboBox<String> worktypemenu, String n, String no, String cnic, String ad,  String em, String z,String date,  byte[] image){
        try{
            c.connect();
       c.st=c.con.createStatement();
            System.out.println("inside executing");
            c.ps=c.con.prepareStatement("INSERT INTO "+worktypemenu.getValue()+" VALUES(?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, n);
           c.ps.setString(2, no);
           c.ps.setString(3, cnic);
           c.ps.setString(4, ad);
           c.ps.setString(5, em);
           c.ps.setString(6, z);
           c.ps.setString(7, date);
           c.ps.setString(8, "n");
        
           c.ps.setBytes(9, image);
           c.ps.executeUpdate();
            System.out.println("done");
}
        catch(Exception e )
        {
            e.printStackTrace();
        }
        }
    public void elsestatement(ComboBox<String> worktypemenu, String n, String no, String cnic, String ad,  String em, String z,String date,  byte[] image)
    {
        try{
            c.connect();
                        c.st=c.con.createStatement();
            c.ps=c.con.prepareStatement("INSERT INTO "+worktypemenu.getValue()+" VALUES(?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, n);
           c.ps.setString(2, no);
           c.ps.setString(3, cnic);
           c.ps.setString(4, ad);
           c.ps.setString(5, em);
           c.ps.setString(6, z);
           c.ps.setString(7, date);
            c.ps.setString(8, "n");
                c.ps.setNull(9, java.sql.Types.BINARY);
            
           c.ps.executeUpdate();
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }
}
