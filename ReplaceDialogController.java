/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Mudasir Hassan
 */
public class ReplaceDialogController implements Initializable {

    @FXML
    private HBox replaceDialogHBox;
    @FXML
    private TextField replaceTextField;
    @FXML
    private Button replaceButton;
    @FXML
    private Button replaceAllButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void replace(ActionEvent event) {
    }

    @FXML
    private void replaceAll(ActionEvent event) {
    }
    
}
