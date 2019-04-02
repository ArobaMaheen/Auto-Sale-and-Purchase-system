/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.*;
import static Controller.NewClass.id;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.BufferedInputStream;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javafx.stage.FileChooser;
/**
 *
 * @author MAHNOORAFREEN
 */
public class CARSINSERTModel {
    
    public CARSINSERTModel(){
        
    }
    connection c=new connection();
    

    public void select(URL url, ResourceBundle rb, TextField id,ComboBox<String> infcombo ) {
    try {
        // TODO
        c=new connection();
        c.connect();
        c.st=c.con.createStatement();
         c.rs=c.st.executeQuery("SELECT TOP 1 * FROM Car ORDER BY ID DESC");
        c.rs.next();
        id.setEditable(false);
       id.setText(Integer.toString(Integer.parseInt(c.rs.getString("ID"))+1));
       id.setDisable(true);
    } catch (SQLException ex) {
        Logger.getLogger(CARSINTERController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
         DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        c.connect();
        LinkedList<String> ll=new LinkedList<String>();
          try {
          c.st=c.con.createStatement();
          c.rs=c.st.executeQuery("Select * from Informers where d='n'");
          while(c.rs.next()){
              ll.add(c.rs.getString("name"));
          }
         } catch (SQLException ex) {
           ex.printStackTrace();
         }
          
          
          
          infcombo.getItems().addAll(ll);
          infcombo.getSelectionModel().selectFirst();
    }    
    //Method 1
    public String save(String com){
              String infID="";
        try {
                             

            c.st=c.con.createStatement();
          c.rs=c.st.executeQuery("Select * from Informers where Name='"+com+"'");
          c.rs.next();
          infID=c.rs.getString("id"); 
              }
             catch (SQLException ex) {
           ex.printStackTrace();
         }
        return infID;
}
public void update(String sName,String pno , String add){
          
       try{       
     //      c.st.executeUpdate("INSERT INTO Car VALUES('"+name+"','"+color+"','"+model+"','"+tank+"','"+feul+"','"+owner+"','"+doip+"','"+mil+"','"+price+"','"+loc+"','"+nplate+"','"+date+"','"+infID+"','Assessed','n')");
      c.ps.executeUpdate();
     c.st=c.con.createStatement();
           c.st.executeUpdate("INSERT INTO Seller VALUES('"+sName+"','"+pno+"','"+add+"',null)");
         }
       catch(SQLException e){
           e.printStackTrace();
       }
}   

public void insertImage(TextField id,File f){
    try{
               
            FileInputStream fis=new FileInputStream(f);
            c.st=c.con.createStatement(); 
            c.rs=c.st.executeQuery("Select * from imagename");
        String   l="0";
            while(c.rs.next()){
                l=c.rs.getString("id");
            }
            System.out.println(l);
            l=Integer.toString(Integer.parseInt(l)+1);
            int cursor;
            String path="resource/"+l+".jpg";
             FileOutputStream fos=new FileOutputStream(path);
              while((cursor = fis.read())!=-1){
            fos.write(cursor);   
          
        }
            fis.close();
            fos.close();
             c.st=c.con.createStatement( );
             System.out.println("After "+l);
            c.st.executeUpdate("INSERT INTO imagename values('"+l+"')");
            System.out.println("Done");
               c.st=c.con.createStatement();
               System.out.println(id.getText());
            c.st.executeUpdate("UPDATE Car SET image='"+l+"' WHERE ID='"+Integer.toString(Integer.parseInt(id.getText()))+"'");
            System.out.println("Done");
            
        }catch(Exception e){
            e.printStackTrace();
        }
}
public void Insertif(String name, String model,String color,String tank ,String feul, String owner, String doip, String mile, String pricee, String location , String sName,String pno,String add,String com,String nplate,String datee,byte[] image,File f,TextField id,String infID){
try{
    c.ps=c.con.prepareStatement("INSERT INTO Car VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, name);
           c.ps.setString(2, color);
           c.ps.setString(3, model);
           c.ps.setString(4, tank);
           c.ps.setString(5, feul);
           c.ps.setString(6, owner);
           c.ps.setString(7, doip);
           c.ps.setString(8, mile);
           c.ps.setString(9, pricee);
           c.ps.setString(10,location);
           c.ps.setString(11, nplate);
           c.ps.setString(12, datee);
          c.ps.setInt(13, Integer.parseInt(infID));
           c.ps.setString(14, "Assessed");
           c.ps.setString(15, "n");
            c.ps.setNull(16, java.sql.Types.VARCHAR);
}
catch(Exception e){
    e.printStackTrace();
}
}
public void insertelse(String name, String model,String color,String tank ,String feul, String owner, String doip, String mile, String pricee, String location , String sName,String pno,String add,String com,String nplate,String datee,byte[] image,File f,TextField id,String infID){
try{
    c.ps=c.con.prepareStatement("INSERT INTO Car VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           c.ps.setString(1, name);
           c.ps.setString(2, color);
           c.ps.setString(3, model);
           c.ps.setString(4, tank);
           c.ps.setString(5, feul);
           c.ps.setString(6, owner);
           c.ps.setString(7, doip);
           c.ps.setString(8, mile);
           c.ps.setString(9, pricee);
           c.ps.setString(10, location);
           c.ps.setString(11, nplate);
           c.ps.setString(12, datee);
           c.ps.setInt(13, Integer.parseInt(infID));
           c.ps.setString(14, "Assessed");
           c.ps.setString(15, "n");
           c.ps.setNull(16, java.sql.Types.NVARCHAR);
          }
catch(Exception e){
    e.printStackTrace();
}   
}
//    public void saveAllQuery(String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String value, String text12, String format, WritableImage toFXImage, File showOpenDialog, TextField id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
          
    }    

