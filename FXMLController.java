/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mudasir Hassan
 */
public class FXMLController implements Initializable {

    @FXML
    private JFXButton Login;
    @FXML
    private JFXButton SignUp;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private Label lbl;
    @FXML
    private FontAwesomeIconView min;
    @FXML
    private VBox root;
    @FXML
    private JFXButton min_btn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    Connection c = null;
    Statement s = null;
    Parent fxml;
    @FXML
    private JFXButton close_btn;
    @FXML
    private FontAwesomeIconView min1;
    
    Scene sc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void Control_Login(ActionEvent event) throws Exception, SQLException , NullPointerException {

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src//records.sqlite");
            c.setAutoCommit(false);
            System.out.println("Controller.FXMLController.Control_Login()");
            s = c.createStatement();

//            try (ResultSet r = s.executeQuery("SELECT * from user")) {
//                String uname=r.getString("name");
//                String upass=r.getString("pass");
//                if (name.getText().equals(uname) && pass.getText().equals(upass)) {
//                    lbl.setText("Loged In Successfull");
//            root.getChildren().removeAll();
            fxml = FXMLLoader.load(getClass().getResource("/Gui/editor.fxml"));
            sc = new Scene(fxml);
            Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
            st.setScene(sc);
            st.show();
            st.setFullScreen(true);
            st.setResizable(true);
           
            
//            root.getChildren().setAll(fxml);

            s.close();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }

    }

    @FXML
    private void Control_SignUp(ActionEvent event) {
        lbl.setText("SignUp");
    }

    @FXML
    private void MinimizeWindow(MouseEvent event) {
         ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    private void CloseWindow(MouseEvent event) {
        Stage name = (Stage)((Button)event.getSource()).getScene().getWindow();
        name.close();
        
    }

    @FXML
    private void min_btn_control(ActionEvent event) {
       ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    private void close_btn_control(ActionEvent event) {
        Stage name = (Stage)((Button)event.getSource()).getScene().getWindow();
        name.close();
    }

}
