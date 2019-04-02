/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.LogininterfaceModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MAHNOORAFREEN
 */
public class LogininterfaceController implements Initializable {

    @FXML
    private TextField uname;
    @FXML
    private TextField pass;
    @FXML
    private Button login;
    
    LogininterfaceModel LoginModel=new LogininterfaceModel();
    
    /**
     * Initializes the controller class.
     */
    Parent root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void Loginn(ActionEvent event) {
        String id=uname.getText();
        String password=pass.getText();
        System.out.println(id);
        System.out.println(password);
        if(LoginModel.authenticate(id,password)){
            System.out.println("inside iff");
            try {
            root = FXMLLoader.load(getClass().getResource("/View/SplashScreen.fxml"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         Scene scene = new Scene(root);
        NewClass.p.setScene(scene);
        NewClass.p.setX(350);
                    NewClass.p.setY(70);
        }else{
            login.setStyle("-fx-background-color:red");
        }
    }
    
}
