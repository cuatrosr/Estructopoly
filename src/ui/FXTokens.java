package ui;

import com.jfoenix.controls.JFXToggleNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXTokens {

    @FXML
    private BorderPane tokensPane = new BorderPane();

    @FXML
    private JFXToggleNode token1 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token2 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token3 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token4 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token5 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token6 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token7 = new JFXToggleNode();

    @FXML
    private JFXToggleNode token8 = new JFXToggleNode();

    private FXMainController mainController;

    private FXBoard fxBoard;

    public FXTokens(FXMainController mainController) {
        this.mainController = mainController;
        fxBoard = new FXBoard(mainController);
    }

    @FXML
    void back(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
            fxmlLoader.setController(mainController);
            Parent root = fxmlLoader.load();
            mainController.getMainPane().setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadBoard(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/board.fxml"));
            fxmlLoader.setController(fxBoard);
            Parent root = fxmlLoader.load();
            BorderPane mainPane = mainController.getMainPane();
            mainPane.setCenter(root);
            Stage stage = ((Stage) mainPane.getScene().getWindow());
            stage.setMinHeight(750);
            stage.setMinWidth(1400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
