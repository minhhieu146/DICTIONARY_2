package ALL.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ALL.MainApp;
import ALL.Model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private MainApp mainApp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    private TextField text = new TextField();
    @FXML
    private Button nhap;
    @FXML
    private Label nghia;

    public void Nhapvao (ActionEvent event) {
        String a = text.getText();
        nghia.setText(a);
    }
    public void Nhap_vao (ActionEvent event) {
        String a = text.getText();
        nghia.setText(a);
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void showDetails(ActionEvent event) {
        String a = text.getText();
        String b = mainApp.getWordlist().dictionaryLookup(a);
        nghia.setText(b);
    }
}
