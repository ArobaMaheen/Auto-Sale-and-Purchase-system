/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
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
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class DisplaycarController implements Initializable {

    @FXML
     ScrollPane scroo;
    @FXML
     AnchorPane anc;
    @FXML
     Button Upbtn;
    @FXML
     Button Addbtn;
    @FXML
     Button Deletebtn;
TableView tv=new TableView<>();
     connection c;
    @FXML
     ComboBox<String> cat;
    @FXML
     Pane HomePane;
    @FXML
     Label hometext;
    @FXML
     Pane homeico;
    @FXML
     Pane carpane;
    @FXML
     Label cars;
    @FXML
     Pane carico;
    @FXML
     Pane workerpane;
    @FXML
     Label workers;
    @FXML
     Pane workerico;
    @FXML
     Pane marketpane;
    @FXML
     Label marketing;
    @FXML
     Pane markico;
    @FXML
     Pane compane;
    @FXML
     Label commission;
    @FXML
     Pane commico;
    @FXML
     Button closebtn;
    @FXML
     Button minbutton;
    @FXML
     Label date;
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
        // TODO
        System.gc();
        time();
        c=new connection();
       c.connect();
          
        TableColumn<tablecar,String> name=new TableColumn<tablecar, String>("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(110);
        TableColumn<tablecar,String> id=new TableColumn<tablecar, String>("ID");
      id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setMinWidth(110);
        TableColumn<tablecar,String> year=new TableColumn<tablecar, String>("Year");
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        year.setMinWidth(110);
        TableColumn<tablecar,String> color=new TableColumn<tablecar, String>("Color");
       color.setCellValueFactory(new PropertyValueFactory<>("color"));
        color.setMinWidth(110);
        TableColumn<tablecar,String> price=new TableColumn<tablecar, String>("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        price.setMinWidth(110);
        TableColumn<tablecar,Button> b=new TableColumn<tablecar, Button>("Purchase");
       b.setCellValueFactory(new PropertyValueFactory<>("b"));
       b.setMinWidth(115);
        ObservableList<tablecar> ol= FXCollections.observableArrayList();
        DisplayCarModel  obj=new DisplayCarModel ();
        tv=obj.ini1(tv, ol, root);
     
        tv.setItems(ol);
        tv.getColumns().addAll(id,name,year,color,price,b);
        tv.setMinWidth(707);
        scroo.setContent(tv);
        cat.getItems().addAll("Assessed Cars","Purchased Cars","Sold Cars");
        
        cat.getSelectionModel().selectFirst();
        cat.setOnAction(e -> 
        {
            if(cat.getValue().equals("Assessed Cars")){
                tv.getItems().clear();
          
            obj.ini2(tv,ol);
        tv.setItems(ol);
            }
            else if(cat.getValue().equals("Purchased Cars")){
                tv.getItems().clear();
                
                obj.ini3(tv, ol);
            
        tv.setItems(ol);
            }else if(cat.getValue().equals("Sold Cars")){
                tv.getItems().clear();
      
        obj.ini4(tv, ol);
        tv.setItems(ol);
            }
        });
        TablePosition pos;
        tv.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
    
    public void handle(MouseEvent event) {
        if (event.getClickCount() == 2){
            NewClass.ol=tv.getItems();
           NewClass.a=tv.getSelectionModel().getSelectedIndex();
            System.out.println(tv.getSelectionModel().getSelectedIndex());
            tablecar tc=(tablecar)tv.getSelectionModel().getSelectedItem();
            Controller.NewClass.id=tc.id;
            try{
                if(cat.getValue().equals("Sold Cars"))
                root = FXMLLoader.load(getClass().getResource("/View/CarDetails2.fxml"));
                else
                    root = FXMLLoader.load(getClass().getResource("/View/CarDetails.fxml"));
            }catch(Exception e){
                e.printStackTrace();
            }
            Scene s=new Scene(root);
            NewClass.p.setScene(s);
        }
      
          }
        });
        
    }    

    @FXML
     void upbtnaction(ActionEvent event) {
        tablecar tcc=(tablecar)tv.getSelectionModel().getSelectedItem();
        NewClass.id=tcc.id;
        try {
            root = FXMLLoader.load(getClass().getResource("/View/CarUpdate.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }
Parent root;
    @FXML
     void addbtnaction(ActionEvent event) { 
        
        try {
            root = FXMLLoader.load(getClass().getResource("/View/CARSINTER.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
     void Delbtnaction(ActionEvent event) {
        tablecar ee=(tablecar)tv.getSelectionModel().getSelectedItem();
        String id=ee.id;
        
        
        try{
            c.st=c.con.createStatement();
            c.st.executeUpdate("UPDATE Car SET d='y' where ID='"+id+"'");
            
              
        
        
            
        }catch(Exception e){
            e.printStackTrace();
        }
         try {
            root = FXMLLoader.load(getClass().getResource("/View/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
        
    }

   public void build(){
       
       
   }
   
    @FXML
     void homepaneexit(MouseEvent event) {
       transformsize(1, 0.3, homeico);
         HomePane.setStyle("-fx-border-style: none");
    }

    @FXML
     void homepaneenter(MouseEvent event) {
        transformsize(1.5, 0.3, homeico);
        HomePane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
     void carpmouseexit(MouseEvent event) {
        
    }

    @FXML
     void carpmouseenter(MouseEvent event) {
        
    }

    public void transformsize(double size,double duration,Node node){
        ScaleTransition st=new ScaleTransition(Duration.seconds(duration),node);
        st.setToX(size);
        st.setToY(size);
        st.play();
    }
    @FXML
     void wmouseexit(MouseEvent event) {
        transformsize(1, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: none");
    }

    @FXML
     void wmouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, workerico);
        workerpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }


    @FXML
     void commouseexit(MouseEvent event) {
        transformsize(1, 0.3, commico);
        compane.setStyle("-fx-border-style: none");
    }

    @FXML
     void commouseenter(MouseEvent event) {
        transformsize(1.5, 0.3, commico);
        compane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
     void homepaneclick(MouseEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("/View/DashbaordDesign.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }
    
    @FXML
     void carpaneclick(MouseEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        
    }

    @FXML
     void workerpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/worker.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
     void markpaneexit(MouseEvent event) {
        transformsize(1, 0.3, markico);
        marketpane.setStyle("-fx-border-style: none");
    }

    @FXML
     void markpaneenter(MouseEvent event) {
         transformsize(1.5, 0.3, markico);
        marketpane.setStyle("-fx-border-style: solid; -fx-border-radius:5; -fx-border-color:     #539ec9");
    }

    @FXML
     void marketpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Advertisment.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
     void commissionpaneclick(MouseEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/Commission.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
     void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
     void minbutact(ActionEvent event) {
        NewClass.p.setIconified(true);
    }
  
    
}
