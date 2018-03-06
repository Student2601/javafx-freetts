/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mudasir Hassan
 */
public class AboutController implements Initializable {

    @FXML
    private TextArea Text_About;
    @FXML
    private BorderPane root;
    @FXML
    private JFXButton Contact;
    @FXML
    private JFXButton Close_btn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Text_About.setText("This Software is developed for KIU semester project by \n");
//        Text_About.appendText("Wazir Mudasir Hassan & Asif Hussain \n");
//        Text_About.appendText("Submitted to Respected Teacher Sir Sabit Rahim (Phd) \n");
//        Text_About.appendText("Speach To Text and Text To Speach output  \n");
//        Text_About.appendText("Special thanks to Google tts,stt api \n");
    }    

    @FXML
    private void Contact_Action(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION, "mudasir", ButtonType.OK);
       
    }

    @FXML
    private void Close_btn_Action(ActionEvent event) {
        Stage name = (Stage)((Button)event.getSource()).getScene().getWindow();
        name.close();
    }
    
}
