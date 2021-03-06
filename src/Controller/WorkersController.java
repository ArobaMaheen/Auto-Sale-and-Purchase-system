/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
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
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class WorkersController implements Initializable {

    @FXML
    private Pane dashboard;
    @FXML
    private ComboBox<String> Selectworker;
    @FXML
    private Button addbtn;
    @FXML
    private Button delbtn;
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
    TableView tv;
    connection c;
    @FXML
    private AnchorPane scr;
    @FXML
    private ScrollPane scrr;
    @FXML
    private ImageView img;
    @FXML
    private Label date;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    @FXML
    private ProgressIndicator pb;
    
    WorkersModel obj= new WorkersModel();
    /**
     * Initializes the controller class.
     */
    public void time(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.01), ev -> {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        
                    LocalDateTime now = LocalDateTime.now();
                    date.setText(dtf.format(now));
                   
                    
    }));
    timeline.setCycleCount(1);
    timeline.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
        // TODO
        Selectworker.getItems().addAll("Informers","Mechanic","Agents");
        Selectworker.getSelectionModel().selectFirst();
        
        TableColumn<worktable,String> id=new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<worktable,String> name=new TableColumn<>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<worktable,String> pno=new TableColumn<>("P.No");
        pno.setCellValueFactory(new PropertyValueFactory<>("pno"));
        
        TableColumn<worktable,String> add=new TableColumn<>("Address");
        add.setCellValueFactory(new PropertyValueFactory<>("add"));
        
        TableColumn<worktable,String> email=new TableColumn<>("Email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        TableColumn<worktable,String> zone=new TableColumn<>("Zone");
        zone.setCellValueFactory(new PropertyValueFactory<>("zone"));
        
        TableColumn<worktable,String> date=new TableColumn<>("Date Joined");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        TableColumn<worktable,String> cnic=new TableColumn<>("CNIC");
        cnic.setCellValueFactory(new PropertyValueFactory<>("cnic"));
        c=new connection();
        tv=obj.ini1(tv,id,name,add,cnic,zone,email,date,pno,scrr);
      
        
        Selectworker.setOnAction(e->{
        if(Selectworker.getValue().equals("Informers")){
            obj.ini2(tv);
          
            
            
        }else if(Selectworker.getValue().equals("Agents")){
            obj.ini3(tv);
           
        
        }else if(Selectworker.getValue().equals("Mechanic")){
            
            obj.ini4(tv);
    
        
        }
        
        });
        
        
        tv.setOnMouseClicked(e->{
          obj.ini5(tv, img, Selectworker);
         
            
        
        });
        
        
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
        
    }

    @FXML
    private void wmouseenter(MouseEvent event) {
        
    }


    @FXML
    private void commouseexit(MouseEvent event) {
        transformsize(1, 0.3, commico);
        compane.setStyle("-fx-border-style: none");
    }

    @FXML
    private void commouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, commico);
        compane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
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
    private void del(ActionEvent event) {
       worktable ol=(worktable) tv.getSelectionModel().getSelectedItem();
        try{
            obj.del1(Selectworker, ol);
            //del1();
//            c.st=c.con.createStatement();
//            c.st.executeUpdate("UPDATE "+Selectworker.getValue()+" SET d='y' WHERE id='"+ol.id+"'");
          //  del1();
            if(Selectworker.getValue().equals("Informers")){
             
                 obj.del2(tv, img);
                 //del2()
//            c.st=c.con.createStatement();
//            c.rs=c.st.executeQuery("Select * from Informers where d='n'");
//            ObservableList oll=FXCollections.observableArrayList();
//            while(c.rs.next()){
//                oll.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
//            }
//            tv.setItems(oll);
//            img.setImage(null);
//           
//        }catch(Exception ex){
//            ex.printStackTrace();
        
   //del2()
            
            }  
            
        else if(Selectworker.getValue().equals("Agents")){
            obj.del3(tv);
            //del3()
//             try{
//            c.st=c.con.createStatement();
//            c.rs=c.st.executeQuery("Select * from Agents where d='n'");
//            ObservableList oll=FXCollections.observableArrayList();
//            while(c.rs.next()){
//                oll.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
//            }
//            tv.setItems(oll);
//            
//           
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
        //del3()
        
        }else if(Selectworker.getValue().equals("Mechanic")){
            obj.del4(tv);
            //del4();
//             try{
//            c.st=c.con.createStatement();
//            c.rs=c.st.executeQuery("Select * from Mechanic where d='n'");
//            ObservableList oll=FXCollections.observableArrayList();
//            while(c.rs.next()){
//                oll.add(new worktable(c.rs.getString("name"),c.rs.getString("id"),c.rs.getString("cnic"),c.rs.getString("pno"),c.rs.getString("addr"),c.rs.getString("zone"),c.rs.getString("email"),c.rs.getString("startdate")));
//            }
//            tv.setItems(oll);
//            
//           
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//del4()
        
        
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
Parent root;
    @FXML
    private void ad(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Workerinfoinput.fxml"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scene s=new Scene(root);
        NewClass.p.setScene(s);
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
