package ui;

import com.jfoenix.controls.JFXToggleButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.objects.Board;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FXMainController implements Initializable, Listeners {

    @FXML
    private BorderPane mainPane = new BorderPane();
    private Board board;

    @FXML
    private JFXToggleButton fullscreenTGB = new JFXToggleButton();

    boolean glowApplied;

    FXTokens fxTokens;

    private Rectangle2D screenBounds;

    String currentScene;

    public FXMainController() {
        board = new Board();
        fxTokens = new FXTokens(this);
        glowApplied = false;
        screenBounds = Screen.getPrimary().getVisualBounds();
        currentScene = "Menu";
    }

    public void setBoard(Board board) {
        this.board = board;
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
            fxTokens.setBoard(board);
            fxmlLoader.setController(fxTokens);
            Parent root = fxmlLoader.load();
            mainPane.setCenter(root);
            currentScene = "Tokens";
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

    public <T extends Listeners> void launchFXMLWindowed(String fxml, T controller, String title, Modality modality, StageStyle style, boolean resizable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/" + fxml));
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(controller::keyListener);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(style);
        stage.setTitle(title);
        stage.setResizable(resizable);
        stage.initOwner(mainPane.getScene().getWindow());
        stage.initModality(modality);
        stage.getIcons().add(new Image(Objects.requireNonNull(FXMain.class.getResourceAsStream("images/logo.png"))));
        stage.show();
    }

    public FXBoard getFXBoard() {
        return fxTokens.getFXBoard();
    }

    public Rectangle2D getScreenBounds() {
        return screenBounds;
    }

    @Override
    public void keyListener(KeyEvent event) {
        KeyCode typed = event.getCode();
        if (typed.equals(KeyCode.J)) {
            if (currentScene.equals("Menu")) {
                play(null);
            } else if (currentScene.equals("Tokens")) {
                fxTokens.loadBoard(null);
            }
        } else if (typed.equals(KeyCode.M)) {
            leaderboards(null);
        } else if (typed.equals(KeyCode.ESCAPE)) {
            switch (currentScene) {
                case "Menu":
                    exit(null);
                    break;
                case "Tokens":
                    fxTokens.back(null);
                    break;
                case "Game":
                    getFXBoard().settings(null);
                    break;
            }
        } else if (typed.equals(KeyCode.F)) {
            boolean select = fullscreenTGB.isSelected();
            fullscreenTGB.setSelected(!select);
            toggleFullscreen(null);
        }
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

    public void endGame(ActionEvent event) {
        //<- HERE ->

        //TODO: Extract all data from game before here
        fxTokens.back(event);
        fxTokens = new FXTokens(this);
    }
}
