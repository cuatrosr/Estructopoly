package ui;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXToggleButton;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

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

    @FXML
    private JFXListView<String> playersLV;

    @FXML
    private Label turnLBL = new Label();

    @FXML
    private Label timerLBL = new Label();

    FXMainController mainController;

    FXSettings fxSettings;

    int turn = 0;

    private Timer timer = new Timer();

    private int secs = 0, min = 0, hour = 0;


    public FXBoard(FXMainController mainController) {
        this.mainController = mainController;
        fxSettings = new FXSettings(mainController, this);
    }

    /*METHODS*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardIMV.fitHeightProperty().bind(boardPane.heightProperty());
        boardIMV.fitWidthProperty().bind(boardPane.widthProperty());
        boardIMV.maxHeight(1000);
        boardIMV.maxWidth(1000);
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

    private void newTimer() {
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
            if (((Stage) mainController.getMainPane().getScene().getWindow()).isFullScreen()) fxSettings.setGlowApplied(true);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/settings.fxml"));
            fxmlLoader.setController(fxSettings);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setOnCloseRequest(e -> {
                newTimer();
            });
            double width = mainController.getScreenBounds().getWidth() * 0.9;
            double height = mainController.getScreenBounds().getHeight() * 0.9;
            stage.setMinHeight(height);
            stage.setMinWidth(width);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.initOwner(mainController.getMainPane().getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.getIcons().add(new Image(Objects.requireNonNull(FXMain.class.getResourceAsStream("images/logo.png"))));
            stage.show();
            timer.cancel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Timer getTimer() {
        return timer;
    }
}
