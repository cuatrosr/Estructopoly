package ui;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class FXSettings implements Initializable, Listeners {

    @FXML
    private JFXToggleButton fullscreenTGB;

    @FXML
    private Label pauseLBL = new Label();

    @FXML
    private VBox settingsPane = new VBox();

    FXMainController mainController;

    FXBoard fxBoard;

    private boolean glowApplied;


    public FXSettings(FXMainController mainController, FXBoard fxBoard) {
        this.mainController = mainController;
        this.fxBoard = fxBoard;
        glowApplied = false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (glowApplied) {
            fullscreenTGB.setSelected(true);
            auxToggleGlow(true);
        }
        pauseLBL.setText(fxBoard.currentTime());
    }



    @FXML
    void restart(ActionEvent event) {

    }

    @FXML
    void mainMenu(ActionEvent event) {
        fxBoard.getBoardPane().setEffect(null);
        ((Stage) settingsPane.getScene().getWindow()).close();
        mainController.endGame(event);
    }

    @FXML
    void exit(ActionEvent event) {
        fxBoard.newTimer();
        fxBoard.getBoardPane().setEffect(null);
        ((Stage) settingsPane.getScene().getWindow()).close();
    }

    @FXML
    void toggleFullscreen(ActionEvent event) {
        boolean fullscreen = fullscreenTGB.isSelected();
        glowApplied = fullscreen;
        Stage curr = ((Stage) mainController.getMainPane().getScene().getWindow());
        curr.setFullScreen(fullscreen);
        auxToggleGlow(fullscreen);
    }

    void auxToggleGlow(boolean fullscreen) {
        for (Node node : fullscreenTGB.getChildrenUnmodifiable()) {
            if (!(node instanceof Text)) {
                double glowVal = (fullscreen) ? 1 : 0;
                node.setEffect(new Glow(glowVal));
            }
        }
    }

    public void setGlowApplied(boolean glowApplied) {
        this.glowApplied = glowApplied;
    }

    @Override
    public void keyListener(KeyEvent event) {
        KeyCode typed = event.getCode();
        if (typed.equals(KeyCode.F)) {
            boolean select = fullscreenTGB.isSelected();
            fullscreenTGB.setSelected(!select);
            toggleFullscreen(null);
        }
        else if (typed.equals(KeyCode.ESCAPE) || typed.equals(KeyCode.SPACE)) exit(null);
        else if (typed.equals(KeyCode.M)) mainMenu(null);
        else if (typed.equals(KeyCode.R)) restart(null);
    }
}
