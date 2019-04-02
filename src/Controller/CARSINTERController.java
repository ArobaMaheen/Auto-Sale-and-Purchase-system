/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.*;
import Model.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class CARSINTERController implements  Initializable {
connection c=new connection();
  CARSINSERTModel carsmodel = new CARSINSERTModel();     
    @FXML
    public Label idL;
    @FXML
    public Label carownerL;
    @FXML
    public TextField mil;
    @FXML
    public TextField Doip;
    @FXML
    public TextField CarOwner;
    @FXML
    public TextField carname;
    
    @FXML
    public TextField SName;
    @FXML
    public Label snameL;
    @FXML
    public TextField Pno;
    @FXML
    public TextField add;
    @FXML
    public TextField Model;
    @FXML
    public TextField CarColor;
    @FXML
    public Label colorL;
    @FXML
    public Label nameL;
    @FXML
    public Label modelL;
    @FXML
    public Label milL;
    @FXML
    public Label priceL;
    @FXML
    public TextField loc;
    @FXML
    public TextField price;
    @FXML
    public Label locL;
    @FXML
    public TextField TankCapacity;
    @FXML
    public Label capL;
    @FXML
    public TextField FuelType;
    @FXML
    public Label feulT;
    @FXML
    public Label infName;
    @FXML
    public ComboBox<String> infcombo;
    @FXML
    public TextField numberplate;
    @FXML
    public TextField id;
    @FXML
    public Button save;
    @FXML
    public Button cancel;
    @FXML
    public ImageView img;
    @FXML
    public Pane HomePane;
    @FXML
    public Label hometext;
    @FXML
    public Pane homeico;
    @FXML
    public Pane carpane;
    @FXML
    public Label cars;
    @FXML
    public Pane carico;
    @FXML
    public Pane workerpane;
    @FXML
    public Label workers;
    @FXML
    public Pane workerico;
    @FXML
    public Pane marketpane;
    @FXML
    public Label marketing;
    @FXML
    public Pane markico;
    @FXML
    public Pane compane;
    @FXML
    public Label commission;
    @FXML
    public Pane commico;
    @FXML
    public Label nameL1;
    @FXML
    public Button closebtn;
    @FXML
    public Button minbutton;
    @FXML
    public Label date;
  
    public DateFormat df;
    public Date dateobj ;
    public  String datee;  
    public Parent root;
    public byte[] image;
    public File f;

    public FileChooser fc;
    public BufferedImage bufferedImage;
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
         df= new SimpleDateFormat("dd/MM/yy");
         dateobj = new Date();
//       datee=df.format(dateobj);
        try {
       time();
        carsmodel.select(url, rb,id,infcombo);
        }
        catch(Exception e){
            System.out.println("CarInsert ModelANdController Error");
        }
    }
    public void SaveAll(ActionEvent event) {
        
        Boolean isValidated;
        isValidated = validateCarsInter(Model.getText(),TankCapacity.getText(),mil.getText(),price.getText(),Pno.getText());
        
        
        if(isValidated){
        
        
        String name=this.carname.getText();
        String model=this.Model.getText();
        String color=this.CarColor.getText();
        String tank=this.TankCapacity.getText();
        String feul=this.FuelType.getText();
        String owner=this.CarOwner.getText();
        String doip=this.Doip.getText();
        String mile=this.mil.getText();
        String pricee=this.price.getText();
        String location=this.loc.getText();
        String sName=this.SName.getText();
        String pno=this.Pno.getText();
        String address=this.add.getText();
      datee=df.format(dateobj);
      String nplate=numberplate.getText();
          String com=infcombo.getValue(); 
          System.out.println(com);
          String infID="";
     try{
        infID=carsmodel.save(com);
 //carsmodel.save(this.carname.getText(),this.Model.getText(),this.CarColor.getText(),this.TankCapacity.getText(),this.FuelType.getText(),this.CarOwner.getText(),this.Doip.getText(),this.mil.getText(),this.price.getText(),this.loc.getText(),this.SName.getText(),this.Pno.getText(),this.add.getText(),infcombo.getValue(),numberplate.getText(),df.format(dateobj),image,f,id);
     }
     catch(Exception e){
         System.out.println("save Exception");
         e.printStackTrace();
     }
     boolean b=true;
            try {
                 image = new byte[(int) f.length()];
                FileInputStream in = new FileInputStream(f);
                
                in.read(image);
            } 
            catch (Exception ex) {
                b=false;
                ex.printStackTrace();
            }
  
      if(b){
                carsmodel.Insertif(name, model, color, tank, feul, owner, doip, mile, pricee, location, sName, pno, name, com, nplate, datee, image, f, id, infID);
            }
            else{
                carsmodel.insertelse(name, model, color, tank, feul, owner, doip, mile, pricee, location, sName, pno, name, com, nplate, datee, image, f, id,infID); 
            }
          carsmodel.update(sName, pno, address);
   
            carsmodel.insertImage(id,f); 

           try {
            root = FXMLLoader.load(getClass().getResource("/View/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(root);
        NewClass.p.setScene(scene); 
        }
    }
            
    @FXML
    private void imac(MouseEvent event) {
         FileChooser fc=new FileChooser();
         fc.setTitle("Choose image");
         f= fc.showOpenDialog(NewClass.p);
          try {
                BufferedImage bufferedImage = ImageIO.read(f);
                
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                img.setImage(image);
                
            } catch (IOException ex) {
               ex.printStackTrace();
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

    @FXML
    private void cancelAct(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/View/DisplayCars.fxml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
    }
    
    public boolean validateCarsInter(String Model,String TankCapacity,String mil,String price,String PNo){
       
         if(validateForInt(Model) && validateForInt(TankCapacity) && validateForInt(mil) && validateForInt(price) && validateForInt(PNo)){
             return true;
         }else{
             return false;
         }
         
    
        
    }
    
    public Boolean validateForInt(String toBeValidated){
        
        boolean isValid=true;
        
        try{
           Long.parseLong(toBeValidated);
        }catch(Exception e){
            isValid=false;
            JOptionPane.showMessageDialog(null, "The Value You Entered : "+toBeValidated+" Is Not A Valid Value. Please Enter Valid Value");
        }
        return isValid;
    }
    
}
