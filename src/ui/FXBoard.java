package ui;

import com.jfoenix.controls.JFXListView;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class FXBoard implements Initializable {

    /*JAVAFX FIELDS*/
    //Main
    @FXML
    private BorderPane gamePane = new BorderPane();

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

    @FXML
    private JFXListView<String> playersLV = new JFXListView<>();

    @FXML
    private Label turnLBL = new Label();

    @FXML
    private Label timerLBL = new Label();

    //Class Fields
    FXMainController mainController;

    FXSettings fxSettings;

    FXAllProperties fxAll;

    int turn = 0;

    private Timer timer = new Timer();

    private int secs = 0, min = 0, hour = 0;

    private ObservableList<String> players;

    public FXBoard(FXMainController mainController) {
        this.mainController = mainController;
        fxSettings = new FXSettings(mainController, this);
        fxAll = new FXAllProperties(mainController, this);
    }

    /*METHODS*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardIMV.fitHeightProperty().bind(boardPane.heightProperty());
        boardIMV.fitWidthProperty().bind(boardPane.widthProperty());
        boardIMV.maxHeight(1000);
        boardIMV.maxWidth(1000);
        Collections.shuffle(players);
        playersLV.setItems(players);
        startGame();
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

        //RANDOMIZER START
        int max = 6, min = 1;
        int range = max - min + 1;
        int dice1, dice2;
        dice1 = (int) (Math.random() * range) + min;
        dice2 = (int) (Math.random() * range) + min;

        //RANDOMIZER END
        FadeTransition pop = new FadeTransition();
        pop.setDuration(Duration.millis(1000));
        pop.setFromValue(1.0);
        pop.setToValue(0.0);
        pop.setNode(frameRCT);
        dice1IMV.setImage(new Image(String.valueOf(getClass().getResource("images/dice/de" + dice1 + ".png"))));
        dice2IMV.setImage(new Image(String.valueOf(getClass().getResource("images/dice/de" + dice2 + ".png"))));
        pop.play();
    }

    @FXML
    void allProperties(ActionEvent event) {
        try {
            mainController.launchFXMLWindowed("all-properties.fxml", fxAll, "Todas las Propiedades", Modality.WINDOW_MODAL, StageStyle.DECORATED, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newTimer() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                secs++;
                if (secs > 59) {
                    secs = 0;
                    min++;
                }
                if (min > 59) {
                    min = 0;
                    hour++;
                }
                Platform.runLater(() -> timerLBL.setText(String.format("%02d:%02d:%02d", hour, min, secs)));
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    void startGame() {

        //Timer
        hour = 0;
        min = 0;
        secs = 0;
        newTimer();
        turn = 0;
//        turnLBL.setText("It's " + playersLV.getItems().get(turn) + "'s turn!");
        turn++;
    }

    @FXML
    void next(ActionEvent event) {
        int current = turn - 1;
        turn++;
    }

    @FXML
    void settings(MouseEvent event) {
        try {
            if (((Stage) mainController.getMainPane().getScene().getWindow()).isFullScreen()) {
                fxSettings.setGlowApplied(true);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/settings.fxml"));
            fxmlLoader.setController(fxSettings);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.setOnKeyPressed(fxSettings::keyListener);
            stage.setOnCloseRequest(e -> newTimer());
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            stage.initOwner(gamePane.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            double width = mainController.getScreenBounds().getWidth() * 0.8;
            double height = mainController.getScreenBounds().getHeight() * 0.8;
            stage.setMaxHeight(height);
            stage.setMaxWidth(width);
            gamePane.setEffect(new GaussianBlur());
            stage.getIcons().add(new Image(Objects.requireNonNull(FXMain.class.getResourceAsStream("images/logo.png"))));
            stage.show();
            timer.cancel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FXSettings getFxSettings() {
        return fxSettings;
    }

    public Timer getTimer() {
        return timer;
    }

    public String currentTime() {
        return String.format("%02d:%02d:%02d", hour, min, secs);
    }

    public BorderPane getBoardPane() {
        return gamePane;
    }

    public void setPlayers(ObservableList<String> players) {
        this.players = players;
    }
}
