package ui;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXBoard implements Initializable {

    /*JAVAFX FIELDS*/

    //Main

    @FXML
    private BorderPane boardPane = new BorderPane();

    @FXML
    private VBox rightVBOX = new VBox();

    @FXML
    private VBox leftVBOX = new VBox();

    @FXML
    private ImageView boardIMV = new ImageView();

    @FXML
    private ImageView currentIMV = new ImageView();

    @FXML
    private Rectangle frameRCT = new Rectangle();

    @FXML
    private ImageView dice1IMV = new ImageView();

    @FXML
    private ImageView dice2IMV = new ImageView();

    @FXML
    private JFXListView<String> historyLV = new JFXListView<>();

    //Settings

    @FXML
    private JFXToggleButton fullscreenTGB;

    @FXML
    private VBox settingsPane = new VBox();

    FXMainController mainController;

    private boolean glowApplied;


    public FXBoard(FXMainController mainController) {
        this.mainController = mainController;
        glowApplied = false;
    }

    /*METHODS*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardIMV.fitHeightProperty().bind(boardPane.heightProperty());
        boardIMV.fitWidthProperty().bind(boardPane.widthProperty());
        boardIMV.maxHeight(1000);
        boardIMV.maxWidth(1000);
        if (glowApplied) {
            fullscreenTGB.setSelected(true);
            auxToggleGlow(true);
        }
    }

    @FXML
    void gamble(ActionEvent event) {

    }

    @FXML
    void patrimony(ActionEvent event) {

    }

    @FXML
    void properties(ActionEvent event) {

    }

    @FXML
    void rollDice(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void settings(MouseEvent event) {
        try {
            if (((Stage) mainController.getMainPane().getScene().getWindow()).isFullScreen()) glowApplied = true;
            mainController.launchFXMLWindowed("settings.fxml",this,"Ajustes", Modality.APPLICATION_MODAL, StageStyle.DECORATED, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void close(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
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
}
