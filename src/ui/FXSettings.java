package ui;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class FXSettings implements Initializable {

    @FXML
    private JFXToggleButton fullscreenTGB;

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
    }



    @FXML
    void restart(ActionEvent event) {

    }

    @FXML
    void mainMenu(ActionEvent event) {

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
}
