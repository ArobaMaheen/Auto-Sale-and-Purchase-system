/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Controller.*;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class CommissionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    TableView tv=new TableView<>();
     connection c;
    @FXML
    private ScrollPane scr;
    @FXML
    private ComboBox<String> cb;                          ///njnijkmijkmlmibikmklmlomiomkkp;
     
     connection c2;
     connection c3;
   TableColumn<tablecomm,String> date;
     TableColumn<tablecomm,String> name;
    TableColumn<tablecomm,String> carname;
            TableColumn<tablecomm,String> carID;
    TableColumn<tablecomm,String> comm;
    
    
    TableColumn<tablecomm,CheckBox> box;
  //  TableColumn<tablecomm,Button> b;
    @FXML
    private ComboBox<String> cb2;
    @FXML
    private Button ad;
    @FXML
    private Button del;
    @FXML
    private Pane HomePane;
    @FXML
    private Label hometext;
    @FXML
    private Pane homeico;
    @FXML
    private Pane carpane;
    @FXML
    private Label cars;
    @FXML
    private Pane carico;
    @FXML
    private Pane workerpane;
    @FXML
    private Label workers;
    @FXML
    private Pane workerico;
    @FXML
    private Pane marketpane;
    @FXML
    private Label marketing;
    @FXML
    private Pane markico;
    @FXML
    private Pane compane;
    @FXML
    private Label commission;
    @FXML
    private Pane commico;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    @FXML
    private Label dat;
    CommisionModel obj = new CommisionModel();
            
     public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    dat.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        time();
        
        name=new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        carname=new TableColumn<>("Car Name");
        carname.setCellValueFactory(new PropertyValueFactory<>("carname"));
        
         carID=new TableColumn<>("Car ID");
        carID.setCellValueFactory(new PropertyValueFactory<>("carid"));
        
       comm=new TableColumn<>("Commission");
      comm.setCellValueFactory(new PropertyValueFactory<>("comm"));
        
        date=new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        
        
        box=new TableColumn<>("Paid");
        box.setCellValueFactory(new PropertyValueFactory<>("box"));
        
         //b=new TableColumn<>("Invoice");
       // b.setCellValueFactory(new PropertyValueFactory<>("b"));
        
        ObservableList<tablecomm> ol=FXCollections.observableArrayList();
        
        c=new connection();
        c.connect();
         c2=new connection();
        c2.connect();
        
         c3=new connection();
        c3.connect();
       String array[]=new String [2];
        try{
            obj.ini1();
           
              
            String cname="";
            String mname="";
//  //whileMethod()
            while(obj.whileMethod()){
                array=obj.withinWhile(mname,cname,array);
                mname =array[0];
                cname=array[1];
                
            
                   CheckBox cb=new CheckBox();                  //nojijmikmn;


                   cb.setOnAction(e->{
                       
//                     
                      ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                          if(cb==tc.getCellData(i)){
                              
                              TableColumn tcc=oll.get(oll.size()-2);
                             String a=(String)tcc.getCellData(i);
                              tcc=oll.get(oll.size()-3);
                             String b=(String)tcc.getCellData(i);
                              tcc=oll.get(oll.size()-4);
                             String cc=(String)tcc.getCellData(i);
                             
                             obj.withinwhile2(a, b, cc);
// withinWhile2();
// try{
// c.st=c.con.createStatement();
// c.st.executeUpdate("UPDATE Commission SET status='Paid' WHERE date='"+a+"' AND commission='"+b+"' AND carID='"+cc+"'" );
// System.out.println("Done Updating");                   
//withinWhile2();
                              try{
                                ddd();
                                
                                 
                             }catch(Exception ex){
                                 ex.printStackTrace();
                             }
                             break;
                        
//                      
                 }
                          }
                    });
                   System.out.println(mname+" Current "+cname);
                   obj.withinWhile3(ol, mname, cname, cb);
            }
//   withinWhile3();
//    ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),cb));
//    withiWhile();
//            }
            
            tv.setItems(ol);
            
            tv.getColumns().addAll(name,carname,carID,comm,date,box);
            scr.setContent(tv);      
            cb.getItems().addAll("Informers","Agents");
            cb2.getItems().addAll("Not Paid","Paid");
            cb.getSelectionModel().selectFirst();
            cb2.getSelectionModel().selectFirst();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
    @FXML
    private void cba(ActionEvent event) {
       ddd();
    }
    @FXML
    private void cb2a(ActionEvent event) {
       ddd();
    }
    public void ddd(){
        if(cb2.getValue().equals("Paid")){
        if(cb.getSelectionModel().getSelectedItem().equals("Informers")){
            ObservableList<tablecomm> ol=FXCollections.observableArrayList();
              try{
                  obj.ddd1();
              
            String arr[]=new String [2];
            String cname="";
            String mname="";
            //whil1();
            while(obj.whil1()){
                //whil1();
                
                obj.ddd2(mname, cname, ol,arr);
                mname=arr[0];
                cname=arr[1];
                
                
              
            }
            TableColumn<tablecomm,CheckBox> box=new TableColumn<>("Paid");
        box.setCellValueFactory(new PropertyValueFactory<>("box"));
         tv.getColumns().clear();
            tv.setItems(ol);
            
            tv.getColumns().addAll(name,carname,carID,comm,date);
       
        }catch(Exception e){
            e.printStackTrace();
        }
          
        }
        else if(cb.getSelectionModel().getSelectedItem().equals("Agents")){
            ObservableList<tablecomm> ol=FXCollections.observableArrayList();
              try{
                  obj.ddd3();
                  
                  //ddd3()
//            c.st=c.con.createStatement();
//            c.rs=c.st.executeQuery("Select * from Commission where type='agent' and status='Paid' and d='n'");
            //ddd3();
            
            String cname="";
            String mname="";
           String arr[]=new String[2];
            while(obj.whil1()){
                
                obj.ddd4(mname, cname, ol,arr);
                mname=arr[0];
               cname =arr[1];
              
            }
             tv.getColumns().clear();
            tv.setItems(ol);
          tv.getColumns().addAll(name,carname,carID,comm,date);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
            
        }
    }
        else if(cb2.getValue().equals("Not Paid")){
        if(cb.getSelectionModel().getSelectedItem().equals("Informers")){
            ObservableList<tablecomm> ol=FXCollections.observableArrayList();
              try{
                  obj.ddd5();
               
            String cname="";
            String mname="";
            String arr[]=new String [2];
            while(obj.whil1()){
                //ddd6();
                
                obj.ddd6(mname, cname,arr);
               mname=arr[0];
               cname=arr[1];
            
//             
//                    
                   CheckBox cb=new CheckBox();
                   cb.setOnAction(e->{
                        
                      ObservableList<TableColumn> oll=tv.getColumns();
                      
                     
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                          if(cb==tc.getCellData(i)){
                             
                              TableColumn tcc=oll.get(oll.size()-2);
                             String a=(String)tcc.getCellData(i);
                              tcc=oll.get(oll.size()-3);
                             String b=(String)tcc.getCellData(i);
                              tcc=oll.get(oll.size()-4);
                             String cc=(String)tcc.getCellData(i);
                             
                             try{
                                 ///ddd7()
                             
                                 obj.ddd7(a, b, cc);
//                                 c.st=c.con.createStatement();
//                                 c.st.executeUpdate("UPDATE Commission SET status='Paid' WHERE date='"+a+"' AND commission='"+b+"' AND carID='"+cc+"'" );
//                                 System.out.println("Done Updating");
                           ///ddd7
                                 ddd();
                             }catch(Exception ec){
                                 ec.printStackTrace();
                             }
//                             
                            break;
                          }}});
                   obj.ddd8(ol, mname, cname, cb);
                   ///ddd8()
// ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),cb));
                
            //ddd8()
             tv.getColumns().clear();
            tv.setItems(ol);
          tv.getColumns().addAll(name,carname,carID,comm,date,box);
                      
        }
              }
                          catch(Exception e){
            e.printStackTrace();
        }
                      
        }
        else if(cb.getSelectionModel().getSelectedItem().equals("Agents")){
            ObservableList<tablecomm> ol=FXCollections.observableArrayList();
              try{
                  obj.ddd9();
                  
                  //ddd9()
          //  c.st=c.con.createStatement();
          //  c.rs=c.st.executeQuery("Select * from Commission where type='agent' AND status='Not Paid' and d='n'");
            //ddd9();
            
            String cname="";
            String mname="";
            String arr[]=new String [2];
            while(obj.whil1()){
                
                obj.ddd10(mname, cname,arr);
                mname=arr[0];
                cname=arr[1];
                
                
            
                    
                    CheckBox cb=new CheckBox();
                    cb.setOnAction(e->{
                        
                      ObservableList<TableColumn> oll=tv.getColumns();
                                    
                          TableColumn tc=oll.get(oll.size()-1);
                          
                          for(int i=0;i<tv.getItems().size();i++){
                          if(cb==tc.getCellData(i)){
                              
                              TableColumn tcc=oll.get(oll.size()-2);
                             String a=(String)tcc.getCellData(i);
                              tcc=oll.get(oll.size()-3);
                             String b=(String)tcc.getCellData(i);
                              tcc=oll.get(oll.size()-4);
                             String cc=(String)tcc.getCellData(i);
                             
                             try{
                                 obj.ddd11(a, b, cc);
                                 //ddd11()
//                                 c.st=c.con.createStatement();
//                                 c.st.executeUpdate("UPDATE Commission SET status='Paid' WHERE date='"+a+"' AND commission='"+b+"' AND carID='"+cc+"'" );
//                                 System.out.println("Done Updating"); 
                  ///ddd11
                                 ddd();
                             }catch(Exception ec){
                                 ec.printStackTrace();
                             }
                            break;
                          }}});
                    //ddd12()
                    obj.ddd12(ol, mname, cname, cb);
     //  ol.add(new tablecomm(mname, cname, c.rs.getString("commission"), c.rs.getString("date"), c.rs.getString("Status"),c.rs.getString("carID"),cb));
               //ddd12() 
            }
            tv.setItems(ol);
            tv.getColumns().clear();
          tv.getColumns().addAll(name,carname,carID,comm,date,box);
                        
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }
    }
                           }
    
                           
            

    @FXML
    private void adw(ActionEvent event) {
        Stage pp=new Stage();
        //pp.initStyle(StageStyle.UNDECORATED);
        TextField tf=new TextField();
        tf.setPromptText("Enter Commission");
         FlowPane hb=new FlowPane();
        hb.setMinWidth(20);
        hb.setHgap(8);
        hb.setVgap(8);
        hb.setPadding(new Insets(40, 28, 40, 28));
        ComboBox<String> cb3=new ComboBox<String>();
        ComboBox<String> cb2=new ComboBox<String>();
        ComboBox<String> cb=new ComboBox<String>();
        cb.setPromptText("Agent/Informer");
        cb.getItems().addAll("Informer","Agent");
        hb.getChildren().add(cb);
        Scene p=new Scene(hb,350,150);
        pp.setScene(p);
        pp.initModality(Modality.APPLICATION_MODAL);
         cb.setOnAction(e->{
            System.out.println("in");
        if(cb.getValue().equals("Agent")){
            try{
                obj.adw1();
                //adw1();
//                c.st=c.con.createStatement();
//                c.rs=c.st.executeQuery("Select * from Agents");
                //adw1()
                while(obj.whil1()){
                    obj.insideWhile(cb2);
                    
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
            hb.getChildren().add(cb2);
       }else if(cb.getValue().equals("Informer")){
            try{
                obj.adw2();
                //adw2()
//                c.st=c.con.createStatement();
//                c.rs=c.st.executeQuery("Select * from Informers");
                //adw2()
                
                obj.adw3(cb2);
                
                //adw3()
//                while(c.rs.next()){
//                    cb2.getItems().add(c.rs.getString("id")+"  "+c.rs.getString("name"));
//                    
//                }
                //adw3()
            }catch(Exception ex){
                ex.printStackTrace();
            }
            hb.getChildren().add(cb2);
       }
                
        });
         
         cb2.setOnAction(e->{
             
             obj.adw4(hb, cb3);
       //adw4()
//            try{
//                c.st=c.con.createStatement();
//                c.rs=c.st.executeQuery("Select * from Car WHERE d='n'");
//                
//                while(c.rs.next()){
//                    cb3.getItems().add(c.rs.getString("ID")+" "+c.rs.getString("name"));
//                    
//                }
//                hb.getChildren().add(cb3);
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
          //adw4()      
        });
         
         cb3.setOnAction(e->{
        hb.getChildren().add(tf);
        
        });
         
         Button b=new Button("Save");
         tf.setOnMouseClicked(e->{
        hb.getChildren().add(b);
        
        });
         
          b.setOnMouseClicked(e->{
        try{
           char i=cb2.getValue().charAt(0);
           String id= Character.toString(i);
           i=cb3.getValue().charAt(0);
           String car= Character.toString(i);
            String com=tf.getText();
             DateFormat df = new SimpleDateFormat("dd/MM/yy");
Date dateobj = new Date();
        String dat=df.format(dateobj);
        obj.adw5(id, cb, car, com, dat);
        //adw5()
//        c.st=c.con.createStatement();
//        c.st.executeUpdate("INSERT INTO Commission values('"+id+"','"+cb.getValue().toLowerCase()+"','"+car+"','"+com+"','Not Paid','"+dat+"','n')");
           //adw5();
ddd();
            pp.close();
        }catch(Exception ec){
            ec.printStackTrace();
        }
        
        });
         
        pp.showAndWait();      
        
    }
Parent root;
    @FXML
    private void del(ActionEvent event) {
        tablecomm tcc=(tablecomm)tv.getSelectionModel().getSelectedItem();
        
        
        try{
            obj.del(tcc);
//            c.st=c.con.createStatement();
//            String.format("UPDATE Commission SET d='y' WHERE carID='%s', commission='%s', date='%s', d='n'", tcc.carid,tcc.comm,tcc.date);
//            c.st.executeUpdate(String.format("UPDATE Commission SET d='y' WHERE carID='%s' and commission='%s' and date='%s' and d='n'", tcc.carid,tcc.comm,tcc.date));
             try {
            root = FXMLLoader.load(getClass().getResource("/View/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @FXML
    private void homepaneexit(MouseEvent event) {
       transformsize(1, 0.3, homeico);
         HomePane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void homepaneenter(MouseEvent event) {
         transformsize(1.5, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
    private void carpmouseexit(MouseEvent event) {
        transformsize(1, 0.3, carico);
         carpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void carpmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, carico);
        carpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    public void transformsize(double size,double duration,Node node){
        ScaleTransition st=new ScaleTransition(Duration.seconds(duration),node);
        st.setToX(size);
        st.setToY(size);
        st.play();
    }
    @FXML
    private void wmouseexit(MouseEvent event) {
        transformsize(1, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void wmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
    private void commouseexit(MouseEvent event) {
        
    }

    @FXML
    private void commouseenter(MouseEvent event) {
        
    }

    @FXML
    private void homepaneclick(MouseEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/View/DashbaordDesign.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
  
    @FXML
    private void carpaneclick(MouseEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);       
    }
    @FXML
    private void workerpaneclick(MouseEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/View/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
    @FXML
    private void markpaneexit(MouseEvent event) {
        transformsize(1, 0.3, markico);
        marketpane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void markpaneenter(MouseEvent event) {
         transformsize(1.5, 0.3, markico);
        marketpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }
    @FXML
    private void marketpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Advertisment.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
    @FXML
    private void commissionpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
    private void minbutact(ActionEvent event) {
        NewClass.p.setIconified(true);
    }

    
}
