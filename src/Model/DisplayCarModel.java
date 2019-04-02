/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.*;
import Controller.*;
import com.reportmill.shape.RMDocument;
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
import javafx.event.EventHandler;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 *
 * @author MAHNOORAFREEN
 */
public class DisplayCarModel {
    connection c= new connection();
    Parent root;
 //   ObservableList<tablecar> ol;
    public TableView ini1(TableView tv,ObservableList<tablecar> ol,Parent roott){
               
        root=roott;
        try{
            c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='assessed' and d='n'");
            while(c.rs.next()){
                Button but=new Button("Purchase");
                but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                but.setOnAction(e->{
                    System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  try {
                                      root = FXMLLoader.load(getClass().getResource("/View/CompanyBuying.fxml"));
                                  } catch (IOException ex) {
                                     ex.printStackTrace();
                                  }
                                  Scene s=new Scene(root);
                                  NewClass.p.setScene(s);
                              System.out.println(cc);
                             break;
                          }    
                }});
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tv;
    }
    public void ini2(TableView tv,ObservableList<tablecar> ol){
     //   this.ol=ol;
                        try{
                            c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='assessed' and d='n'");
            
            while(c.rs.next()){
                Button but=new Button("Purchase");
                but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                but.setOnAction(ex->{
                    System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  try {
                                      root = FXMLLoader.load(getClass().getResource("/View/CompanyBuying.fxml"));
                                  } catch (IOException exp) {
                                     exp.printStackTrace();
                                  }
                                  Scene s=new Scene(root);
                                  NewClass.p.setScene(s);
                              System.out.println(cc);
                             break;
                          }
           }});
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
                       
    }
    public void ini3(TableView tv,ObservableList<tablecar> ol)
    {
                      try{
                          c.connect();
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='pur' and d='n'");
            while(c.rs.next()){
                 Button but=new Button("Sell");
                 but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                but.setOnAction(ex->{
                    System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  try {
                                      root = FXMLLoader.load(getClass().getResource("/View/CompanySelling_1.fxml"));
                                  } catch (IOException exp) {
                                     exp.printStackTrace();
                                  }
                                  Scene s=new Scene(root);
                                  NewClass.p.setScene(s);
                              System.out.println(cc);
                             break;
                          }
                 
                
                }});
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void ini4(TableView tv,ObservableList<tablecar> ol)
    {
                         try{
            c.st=c.con.createStatement();
            c.rs=c.st.executeQuery("Select * from Car where Status='sold' and d='n'");
            
            
            while(c.rs.next()){
                 Button but=new Button("Generate Invoice");
            
            but.setStyle("-fx-background-color:  #1F3E50;-fx-text-fill:white;");
                
                but.setOnMouseEntered(ex->{
                    but.setStyle("-fx-background-color:#6CBBD9;-fx-text-fill:white;");
                });
                but.setOnMouseExited(ex->{
                    but.setStyle("-fx-background-color:#1F3E50;-fx-text-fill:white;");
                });
                
                but.setOnAction((event) -> {
                     System.out.println("in");
                    ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                              System.out.println("in loop");
                          if(but==tc.getCellData(i)){
                              System.out.println("in if");
                              TableColumn tcc=oll.get(oll.size()-6);
                            
                             String cc=(String)tcc.getCellData(i);
                             NewClass.id=cc;
                                  //after id
                                  try{
                                      c.st=c.con.createStatement();
                                      c.rs=c.st.executeQuery("Select * from Buyer Full JOIN Car ON Buyer.ID=Car.ID where car.ID='"+NewClass.id+"'");
                                      c.rs.next();
                                      
                                       String bname=c.rs.getString(1);
                                        String bcnic=c.rs.getString(4);
                            String baddr=c.rs.getString(3);
                            String bno=c.rs.getString(2);
                             
                             
                            
                            // c.st=c.con.createStatement();
                             //         c.rs=c.st.executeQuery("Select * from Car where ID='"+NewClass.id+"'");
                            //          c.rs.next();
                                 String cname=c.rs.getString(7);
                                 String ccolor=c.rs.getString("color");
                                 String cmanu=c.rs.getString("tank");
                                 String cmodel=c.rs.getString("model");
                                 String cowner=c.rs.getString("carowner");
                                 String clocation=c.rs.getString("location");
                                     String cfeul=c.rs.getString("feultype");
                                         String ctank="2000";
                                     String doip=c.rs.getString("doip");
                                  String cmil=c.rs.getString("mil");
                                  String date=c.rs.getString("date");
                                 String pricee=c.rs.getString("price");
                                         c.st=c.con.createStatement();
                                         
                                     c.rs=c.st.executeQuery("Select * from Owner");
                                     c.rs.next();;
                                  String sname=c.rs.getString("name");
                                        String scnic=c.rs.getString("cnic");
                            String saddr=c.rs.getString("addr");
                            String sno=c.rs.getString("pno");
                                  
                                 Recipt r=new Recipt( bname, bcnic,baddr, bno,sname,scnic, saddr,  sno,  cname,  ccolor,  cmanu,  cmodel,  cowner,  clocation,  cfeul,  ctank,  doip,  cmil, date, pricee);
                                      RMDocument rm=new RMDocument(getClass().getResource("/autosaleandpurchasemanagmentsystemfull/Myreport.rpt"));
            RMDocument rep=rm.generateReport(r);
        rep.write("C:\\Users\\hp\\documents\\re.jpg");
        NewClass.r=r;
        Stage p=new Stage();
         try {
            root = FXMLLoader.load(getClass().getResource("C:\\Users\\hp\\Desktop\\6th_semester\\sqe\\Project\\AutoSaleAndPurchaseManagmentSystemFull (1)\\AutoSaleAndPurchaseManagmentSystemFull\\src\\repor.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        p.setScene(scene);
        p.show();
        
        
                                  }catch(Exception ex){
                                      ex.printStackTrace();
                                  }
                    break;
                }
                    
                          }
                });
      
                ol.add(new tablecar(c.rs.getString("id"),c.rs.getString("name"),c.rs.getString("model"),c.rs.getString("color"),c.rs.getString("price"),but));
            }
                 }
             catch(Exception ex){
            ex.printStackTrace();
        }
  
    }
}
