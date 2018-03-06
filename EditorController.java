/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import com.sun.speech.freetts.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Array;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import login.Login;
import models.AlertMaker;
import org.controlsfx.control.HyperlinkLabel;

/**
 * FXML Controller class
 *
 * @author Mudasir Hassan
 */
public class EditorController implements Initializable {


    @FXML
    private VBox root;
    @FXML
    private JFXButton ico;
    @FXML
    private JFXButton New;
    @FXML
    private JFXButton Save;
    @FXML
    private JFXButton Save_as;
    @FXML
    private JFXButton Export;
    @FXML
    private JFXButton Close;
    @FXML
    private Menu File;
    @FXML
    private Menu Edit;
    @FXML
    private Menu View;
    @FXML
    private Menu Tools;
    @FXML
    private MenuItem Help;
    @FXML
    private JFXButton minimize;
    @FXML
    private JFXButton maximize;
    @FXML
    private JFXButton Exit;
    @FXML
    private JFXButton Speak;
    @FXML
    private JFXToggleButton Listen;
    @FXML
    private MenuItem Open;
    @FXML
    private MenuItem Recent;
    @FXML
    private MenuItem preferences;
    @FXML
    private MenuItem newfile;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem Undo;
    @FXML
    private MenuItem Find;
    @FXML
    private MenuItem Replace;
    @FXML
    private MenuItem Format;
    @FXML
    private MenuItem Sound_Settings;
    @FXML
    private MenuItem Updates;
    @FXML
    private MenuItem About;
    @FXML
    private MenuItem About_Us;
    @FXML
    private MenuItem Print;
    @FXML
    private JFXButton Open_icon;
    @FXML
    private JFXButton Bold;
    @FXML
    private JFXButton Italic;
    @FXML
    private JFXButton UnderLine;
    @FXML
    private JFXComboBox<String> Font_Size;
    @FXML
    private JFXComboBox<?> Font_Select;
    @FXML
    private TabPane Tab_Pane;
    @FXML
    private MenuBar menu_bar;
    @FXML
    private JFXColorPicker color_picker;
    @FXML
    private Label File_Path;
    @FXML
    private Label label_jobs;
    
    private double lastX = 0.0d;
    private double lastY = 0.0d;
    private double lastWidth = 0.0d;
    private double lastHeight = 0.0d;
    private double x,y;
    FileChooser fc;
    List<String> filList;
    ObservableList<String> size_list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18");
    private NewTab aTab = new NewTab();
    TextArea text_area = new TextArea();
    @FXML
    private CheckMenuItem Dark_Theme;
    @FXML
    private CheckMenuItem Light_Them;
    private String DarkTheme = null;
    private String LightTheme = null;
    @FXML
    private HyperlinkLabel Recent1;
    @FXML
    private void newfile_Action(ActionEvent event) throws IOException {
        fc = new FileChooser();
//        fc.getExtensionFilters().add(new ExtensionFilter("Word File",fileList));
        File f = fc.showSaveDialog(null);
        if (f != null) {
            File_Path.setText(f.getAbsolutePath());
        }
        File file = new File(fc.getInitialFileName());
        try (FileWriter fw = new FileWriter(file)) {
            
            fw.write(text_area.getText());
            fw.close();
        }  
    }

    @FXML
    private void save_Action(ActionEvent event) {
    }

    @FXML
    private void Dark_Theme_Apply(ActionEvent event) {
        if(Light_Them.isSelected()){
            Light_Them.setSelected(false);
            Login.setUserAgentStylesheet(Login.STYLESHEET_CASPIAN);
            root.getStylesheets().remove(LightTheme);
            root.getStylesheets().add(DarkTheme);
        }
    }

    @FXML
    private void Light_Theme_Apply(ActionEvent event) {
        if(Dark_Theme.isSelected())
        {
            Dark_Theme.setSelected(false);
            Login.setUserAgentStylesheet(Login.STYLESHEET_MODENA);
            root.getStylesheets().remove(DarkTheme);
            root.getStylesheets().add(LightTheme);
        }
    }

    class NewTab{
    private final Tab newTab;
        public void Highlight(String text){
            boolean isTrue =   text_area.getText().matches(text);
            if(isTrue == true){
                text_area.getSelectedText();
                
            }
        }
        public NewTab(){
            newTab = new Tab();
//            Highlight(text_area.getSelectedText());
        }
        public Tab createTab(){
            newTab.setText("New Tab");
            int a[];
           newTab.setContent(text_area = new TextArea());
//            text_area.setOnContextMenuRequested(new EventHandler<Event>()
//        {
//            @Override
//            public void handle(Event arg0)
//            {
//                
//               text_area.getSelectedText();
//            }
//        });
            newTab.setOnCloseRequest((Event arg) -> {
               
            });
           
            return newTab;
        }
        public Tab getCurrentTab(){
            return newTab;
        }
        public TextArea getTextArea(){
            return text_area;
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Speak.setDisable(true);
        LightTheme = "Styles/editor.css";
        DarkTheme = "Styles/DarkTheme.css";
        
        Font_Size.setItems(size_list);
            menu_bar.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            menu_bar.setOnMouseDragged((MouseEvent event) -> {
                Stage stagee = (Stage)((MenuBar)event.getSource()).getScene().getWindow();
                stagee.setX(event.getScreenX() -x);
                stagee.setY(event.getScreenY() -y);
            }); 
    }

    @FXML
    private void ico_control(ActionEvent event) {
    }
    
    
    @FXML
    private void New_control(ActionEvent event) {
        NewTab ntab = new NewTab();
          Tab tab = ntab.createTab();
          Tab_Pane.getTabs().add(tab);
          Tab_Pane.getSelectionModel().select(tab); //take this tab to front
    }

    @FXML
    private void Save_control(ActionEvent event) {
         fc = new FileChooser();
//        fc.getExtensionFilters().add(new ExtensionFilter(fileList));
        File f = fc.showSaveDialog(null);
        if (f != null) {
            File_Path.setText(f.getAbsolutePath());
        }
    }

    @FXML
    private void Save_as_control(ActionEvent event) throws IOException {
             fc = new FileChooser();
//        fc.getExtensionFilters().add(new ExtensionFilter("Word File",fileList));
        File f = fc.showSaveDialog(null);
        if (f != null) {
            File_Path.setText(f.getAbsolutePath());
        }
        File file = new File(fc.getInitialFileName());
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(text_area.getText());
            fw.close();
        }
    }

    @FXML
    private void Export_control(ActionEvent event) {
        
    }

    @FXML
    private void Close_control(ActionEvent event) {
        Stage name = (Stage)((Button)event.getSource()).getScene().getWindow();
        name.close();
    }

    @FXML
    private void mininize_control(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    private void maximize_control(ActionEvent event) {
          Node n = (Node)event.getSource();

  Window w = n.getScene().getWindow();

  double currentX = w.getX();
  double currentY = w.getY();
  double currentWidth = w.getWidth();
  double currentHeight = w.getHeight();

  Screen screen = Screen.getPrimary();
  Rectangle2D bounds = screen.getVisualBounds();

  if( currentX != bounds.getMinX() &&
    currentY != bounds.getMinY() &&
    currentWidth != bounds.getWidth() &&
    currentHeight != bounds.getHeight() ) {

    w.setX(bounds.getMinX());
    w.setY(bounds.getMinY());
    w.setWidth(bounds.getWidth());
    w.setHeight(bounds.getHeight());

    lastX = currentX; // save old dimensions
    lastY = currentY;
    lastWidth = currentWidth;
    lastHeight = currentHeight;

  } else {

    // de-maximize the window (not same as minimize)

    w.setX(lastX);
    w.setY(lastY);
    w.setWidth(lastWidth);
    w.setHeight(lastHeight);
  }

  event.consume(); // don't bubble up to title bar
    }

    @FXML
    private void Exit_control(ActionEvent event) {
    Stage name = (Stage)((Button)event.getSource()).getScene().getWindow();
        name.close();
    }

    @FXML
    private void Speak_Action(ActionEvent event) {
        final String VOICENAME = "kevin16";
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice(VOICENAME);
        voice.allocate();
        try {
            System.out.println(voice.getPitchRange());
            NewTab t = new NewTab();
            Tab current = t.getCurrentTab();
//            current.getClass().
            TextArea ta = t.getTextArea();
            voice.speak(ta.getText());
        } catch (Exception e) {
        }
    }

    @FXML
    private void Listen_Action(ActionEvent event) {

    }

    private String readFile(File file) {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {

            }
        }
        return stringBuffer.toString();
    }
   

    @FXML
    private void Open_control(ActionEvent event) throws FileNotFoundException, IOException ,Exception ,NullPointerException{
        fc = new FileChooser();
        Window ownerWindow = null;
        File f = fc.showOpenDialog(ownerWindow);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        if (f!= null) {
            Tab_Pane.getSelectionModel().getSelectedItem().setText(f.getName());
            File_Path.setText(f.getAbsolutePath());
            //FileReader fr = new FileReader(f);
            //BufferedReader br = new BufferedReader(fr);
            String s;
            while((s=br.readLine())!=null)
            {
            aTab.getTextArea().appendText(s+"\n");
            }
        }
    }

    @FXML
    private void Recent_control(ActionEvent event) {
        
    }

    @FXML
    private void About_Us_Control(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("/Gui/About.fxml"));
        Scene scene = new Scene(p);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       
    }

    @FXML
    private void preferences_control(ActionEvent event) {
    }

    @FXML
    private void Undo_control(ActionEvent event) {
        text_area.undo();
    }

    @FXML
    private void Find_control(ActionEvent event) {
       
    }

    @FXML
    private void Replace_control(ActionEvent event) throws IOException {
        FXMLLoader toor = FXMLLoader.load(getClass().getResource("/Gui/ReplaceDialog.fxml"));
        
    }

    @FXML
    private void Format_control(ActionEvent event) {
    }
    
    @FXML
    private void Sound_Settings_Control(ActionEvent event) {
        
    }

    @FXML
    private void Help_Control(ActionEvent event) {
        AlertMaker am ;
        AlertMaker.showErrorMessage("help", "help");
        
    }

    @FXML
    private void Check_updates(ActionEvent event) {
    }

    @FXML
    private void About_Control(ActionEvent event) throws IOException {
      Parent parent = FXMLLoader.load(getClass().getResource("Gui/About.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(false);
    }

    @FXML
    private void Print_Control(ActionEvent event) {
        
    }

    @FXML
    private void Speak_key_released() throws NoSuchFieldException {
    String text = text_area.getText();
    boolean db = text.isEmpty() || text.trim().isEmpty();
    Speak.setDisable(db);
    }

    @FXML
    private void Bold_action(ActionEvent event) {
    text_area.setFont(Font.font(text_area.getFont().getFamily(), FontWeight.BOLD, text_area.getFont().getSize()));
    }

    @FXML
    private void Italic_Action(ActionEvent event) {
       
    text_area.setFont(Font.font(text_area.getFont().getFamily(), FontPosture.ITALIC, text_area.getFont().getSize()));
    }

    @FXML
    private void UnderLine_Action(ActionEvent event) {
     text_area.setFont(Font.font(text_area.getFont().getFamily(), FontPosture.REGULAR, text_area.getFont().getSize()));
        
    }
    @FXML
    private void Font_Size_Action(ActionEvent event) {
        text_area.setFont(Font.font(Font_Size.getSelectionModel().getSelectedItem()));
//        text_area.setFont(Font.font(Font_Size.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    private void Font_Action(ActionEvent event) {
        
    }

    @FXML
    private void Color_picker_Action(ActionEvent event) {
        Color color = color_picker.getValue();
        
        text_area.setStyle(color_picker.toString());
    }

}
