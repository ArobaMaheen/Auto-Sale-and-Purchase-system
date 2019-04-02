/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Controller.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class CarDetails implements Initializable {

    @FXML
    private Label idL;
    @FXML
    private Label carownerL;
    @FXML
    private Label colorL;
    @FXML
    private Label nameL;
    @FXML
    private Label modelL;
    @FXML
    private Label milL;
    @FXML
    private Label priceL;
    @FXML
    private Label locL;
    @FXML
    private Label capL;
    @FXML
    private Label feulT;
    @FXML
    private Label infName;
    @FXML
    private Button Edit;
    @FXML
    private Button Maintain;
    @FXML
    private Label snameL;
    @FXML
    private Label CarId;
    @FXML
    private Label Name;
    @FXML
    private Label Model;
    @FXML
    private Label CarColor;
    @FXML
    private Label TankCapacity;
    @FXML
    private Label FuelType;
    @FXML
    private Label CarsOwner;
    @FXML
    private Label NumberPlate;
    @FXML
    private Label Date;
    @FXML
    private Label Mileage;
    @FXML
    private Label Price;
    @FXML
    private Label Location;
    @FXML
    private Label SellerName;
    @FXML
    private Label PhoneNo;
    @FXML
    private Label Address;
    @FXML
    private Label InformerName;
    @FXML
    private Button Delete;
connection c;
    @FXML
    private AnchorPane img;
    @FXML
    private ImageView imgg;
    @FXML
    private Button prev;
    @FXML
    private Button next;
    @FXML
    private Label dadd;
    @FXML
    private ImageView imgs;
    @FXML
    private Label daa;
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
    private Label date;
    @FXML
    private Button closebtn;
    @FXML
    private Button minbutton;
    /**
     * Initializes the controller class.
     */
    CarDetailsModel obj=new CarDetailsModel();
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
        time();
        c=new connection();
        c.connect();
        String asss="";
        obj.ini1(daa, imgg, dadd, asss, CarId, Name, Model, CarColor, TankCapacity, FuelType, CarsOwner, NumberPlate, Date, Mileage, Location, Price, imgs, SellerName, PhoneNo, Address, InformerName);

       if(asss.equals("Assessed")|| asss.equals("sold") ){
           Maintain.setVisible(false);
       }
       
    
        
    }    

    @FXML
    private void SaveAll(ActionEvent event) {
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
    private void maint(ActionEvent event) {
         try {
            root = FXMLLoader.load(getClass().getResource("/View/Mantainance.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void del(ActionEvent event) {
        obj.del1();

         try {
            root = FXMLLoader.load(getClass().getResource("/View/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }

    @FXML
    private void prevv(ActionEvent event) {
           try{ 
           
          
           NewClass.a--;
           NewClass.id=NewClass.getid();
           
         try{
                root = FXMLLoader.load(getClass().getResource("/View/CarDetails.fxml"));
            }catch(Exception e){
                e.printStackTrace();
            }
            Scene s=new Scene(root);
            NewClass.p.setScene(s);
       }catch(Exception e){
           e.printStackTrace();
           NewClass.a++;
       }
        
    }

    @FXML
    private void nextt(ActionEvent event) {
        
       try{ 
           
          
           NewClass.a++;
           NewClass.id=NewClass.getid();
           
         try{
                root = FXMLLoader.load(getClass().getResource("/View/CarDetails.fxml"));
            }catch(Exception e){
                e.printStackTrace();
            }
            Scene s=new Scene(root);
            NewClass.p.setScene(s);
       }catch(Exception e){
           e.printStackTrace();
            NewClass.a--;
       }
    }

    @FXML
    private void first(ActionEvent event) {
        try{ 
           
          
           NewClass.a=0;
           NewClass.id=NewClass.getid();
           
         try{
                root = FXMLLoader.load(getClass().getResource("/View/CarDetails.fxml"));
            }catch(Exception e){
                e.printStackTrace();
            }
            Scene s=new Scene(root);
            NewClass.p.setScene(s);
       }catch(Exception e){
           e.printStackTrace();
            NewClass.a--;
       }
    }

    @FXML
    private void last(ActionEvent event) {
         try{ 
           
          
           NewClass.a=NewClass.ol.size()-1;
           NewClass.id=NewClass.getid();
           
         try{
                root = FXMLLoader.load(getClass().getResource("/View/CarDetailsCarDetails2.fxml"));
            }catch(Exception e){
                e.printStackTrace();
            }
            Scene s=new Scene(root);
            NewClass.p.setScene(s);
       }catch(Exception e){
           e.printStackTrace();
            NewClass.a--;
       }
    }

    @FXML
    private void imgss(MouseEvent event) {
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
        
    }

    @FXML
    private void carpmouseenter(MouseEvent event) {
        
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
    private void closebtnac(ActionEvent event) {
        NewClass.p.close();
    }

    @FXML
    private void minbutact(ActionEvent event) {
        NewClass.p.setIconified(true);
    }
    
    
    
}
