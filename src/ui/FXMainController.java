package ui;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FXMainController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private JFXToggleButton fullscreenTGB;

    @FXML
    void toggleFullscreen(ActionEvent event) {
        boolean fs = fullscreenTGB.isSelected();
        ((Stage) fullscreenTGB.getScene().getWindow()).setFullScreen(fs);
        for (Node node : fullscreenTGB.getChildrenUnmodifiable()) {
            if (!(node instanceof Text)) {
                double glowVal = (fs) ? 1 : 0;
                node.setEffect(new Glow(glowVal));
            }
        }
    }

    @FXML
    void play(ActionEvent event) {

    }

    @FXML
    void leaderboards(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }
}
