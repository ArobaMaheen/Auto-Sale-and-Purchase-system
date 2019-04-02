/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import autosaleandpurchasemanagmentsystemfull.FullReport;
import com.reportmill.shape.RMDocument;
import java.io.IOException;
import java.util.Date;

import java.util.HashMap;
import java.util.LinkedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.Address;
import static sun.plugin.javascript.navig.JSType.Location;

/**
 *
 * @author MAHNOORAFREEN
 */
public class ReporModel {
    connection c=new connection();
    
    public void aa(Label Name,Label  CarColor,Label  TankCapacity,Label FuelType,Label Model,Label CarsOwner,Label Date,Label Mileage,Label NumberPlate,Label Location,Label SellerName1,Label Address1,Label PhoneNo,Label Address,Label SellerName,Label PhoneNo1,Label Price,Label dadd){
         System.out.println("inside");
         c.connect();
        try{
            
           c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+Controller.NewClass.id+"'");
            LinkedList<String> ll=new LinkedList<String>();
            while(c.rs.next()){
                ll.add(c.rs.getString("mechid"));
            }
            LinkedList<String> l2=new LinkedList<String>();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic");
            
                for(int i=0;i<ll.size();i++){
                    c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Mechanic where ID='"+ll.get(i)+"'");
                    c.rs.next();
                l2.add(c.rs.getString("name"));
               
                }
              c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+Controller.NewClass.id+"'");
            LinkedList<FullReport> fR=new LinkedList<>();
            int o=0;
            while(c.rs.next()){
                fR.add(new FullReport(c.rs.getString("type"), c.rs.getString("part"), l2.get(o), c.rs.getString("task"), c.rs.getString("comm")));
                o++;
            }
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Buyer where ID='"+Controller.NewClass.id+"'");
            c.rs.next();
           String bn="";
            
            c.rs=c.st.executeQuery("Select * from Seller where ID='"+Controller.NewClass.id+"'");
            c.rs.next();
           String sn="";
            
            
            
              HashMap m=new HashMap();
         
              
       m.put("list",fR);
       m.put("id",Name.getText() );
       m.put("color", CarColor.getText());
       m.put("tank", TankCapacity.getText());
        m.put("feul", FuelType.getText());
       m.put("model", Model.getText());
       m.put("manu", CarsOwner.getText());
        m.put("doip", Date.getText());
       m.put("mil", Mileage.getText());
       m.put("nplate", NumberPlate.getText());
        m.put("loc", Location.getText());
       m.put("bid", bn);
       m.put("bname", SellerName1.getText());
        m.put("badd", Address1.getText());
       m.put("bno", PhoneNo.getText());
       m.put("sid", Address.getText());
        m.put("sname", SellerName.getText());
       m.put("scnic", "sn");
       m.put("spno",  PhoneNo1.getText());
       
        
        
        c.rs=c.st.executeQuery("Select * from Commission where carID='"+Controller.NewClass.id+"' and type='informer'");
           int inf=0;
           while(c.rs.next()){
               inf+=Integer.parseInt(c.rs.getString("commission"));
           }
            m.put("inf", Integer.toString(inf));
            
             c.rs=c.st.executeQuery("Select * from Commission where carID='"+Controller.NewClass.id+"' and type='agent'");
           int agn=0;
           while(c.rs.next()){
               agn+=Integer.parseInt(c.rs.getString("commission"));
           }
       m.put("agnt", Integer.toString(agn));
       c.st=c.con.createStatement();
       c.rs=c.st.executeQuery("Select * from SundayBazaar where carID='"+Controller.NewClass.id+"'");
           int sb=0;
           while(c.rs.next()){
               sb+=Integer.parseInt(c.rs.getString("charge"));
           }
       
       
       m.put("sunday", Integer.toString(sb));
       
       
       String total=Integer.toString(agn+inf+sb+Integer.parseInt(Price.getText()));
        c.st=c.con.createStatement();
       c.rs=c.st.executeQuery("Select * from Maintanance where ID='"+Controller.NewClass.id+"'");
       int mprice=0;
       while(c.rs.next()){
           mprice+=Integer.parseInt(c.rs.getString("comm"));
       }
       total+=mprice;
       
        m.put("total", total);
       m.put("datesold", dadd.getText());
       m.put("price", Price.getText());
       
        RMDocument rm=new RMDocument(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/fullreport.rpt"));
            RMDocument rep=rm.generateReport(m);
        rep.write("F:\\pic.png");
        Controller.NewClass.path="F:\\pic.png";
        Controller.NewClass.repo="/autosaleandpurchasemanagmentsystemfull/fullreport.rpt";
            
        
       Controller.NewClass.h=m;
        Stage p=new Stage();
         try {
            root = FXMLLoader.load(getClass().getResource("/View/repor.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        p.setScene(scene);
        p.show();
                   
       }catch(Exception e){
            e.printStackTrace();
        }
    }
    Parent root;
}
