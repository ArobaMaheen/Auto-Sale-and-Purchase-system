/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Controller.*;
import com.reportmill.shape.RMDocument;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Furqan Parvaz
 */
public class ReporController implements Initializable {

    @FXML
    private ImageView img;
    @FXML
    private Button pdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        File f=new File(NewClass.path);
        try {
            FileInputStream fis=new FileInputStream(f);
            Image i=new Image(fis);
            img.setImage(i);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReporController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    @FXML
    private void pdfa(ActionEvent event) {
         RMDocument rm=new RMDocument(getClass().getResource(NewClass.repo));
            RMDocument rep=rm.generateReport(NewClass.h);
            FileChooser fs=new FileChooser();
            String a=fs.showSaveDialog(NewClass.p).getPath();
        rep.write(a+".pdf");
    }
    
}
