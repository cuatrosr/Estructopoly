package ui;

import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXToggleNode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.libs.WindowStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FXMainController implements Initializable {

    @FXML
    private BorderPane mainPane = new BorderPane();

    @FXML
    private JFXToggleButton fullscreenTGB = new JFXToggleButton();

    boolean glowApplied;

    FXTokens fxTokens;

    public FXMainController() {
        fxTokens = new FXTokens(this);
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
    void toggleFullscreen(ActionEvent event) {
        boolean fullscreen = fullscreenTGB.isSelected();
        glowApplied = fullscreen;
        Stage curr = ((Stage) fullscreenTGB.getScene().getWindow());
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

    @FXML
    void play(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/select-players.fxml"));
            fxmlLoader.setController(fxTokens);
            Parent root = fxmlLoader.load();
            mainPane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void leaderboards(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    public BorderPane getMainPane() {
        return mainPane;
    }

    public void launchFXMLWindowed(String fxml, Object controller, String title, Modality modality, StageStyle style, boolean resizable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/" + fxml));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(style);
        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.initOwner(mainPane.getScene().getWindow());
        stage.initModality(modality);
        stage.getIcons().add(new Image(Objects.requireNonNull(FXMain.class.getResourceAsStream("images/logo.png"))));
        stage.show();
        WindowStyle.allowDrag(root, stage);
        WindowStyle.stageDimension(stage.getWidth(), stage.getHeight());
    }
}
