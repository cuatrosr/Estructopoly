package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FXAux implements Listeners, Initializable {
    @FXML
    private Label messageLBL = new Label();

    @FXML
    private Label titleLBL = new Label();

    String title, message;

    public FXAux(String title, String message) {
        this.message = message;
        this.title = title;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleLBL.setText(title);
        messageLBL.setText(message);
    }

    @Override
    public void keyListener(KeyEvent event) {

    }

}
