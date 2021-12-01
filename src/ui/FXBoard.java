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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
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
import model.data_structures.queueAndStack.DefaultQueue;
import model.objects.Board;
import model.objects.Token;

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

    //Tokens

    @FXML
    private ImageView boatIMV = new ImageView();

    @FXML
    private ImageView carIMV = new ImageView();

    @FXML
    private ImageView catIMV = new ImageView();

    @FXML
    private ImageView dogIMV = new ImageView();

    @FXML
    private ImageView hatIMV = new ImageView();

    @FXML
    private ImageView ironIMV = new ImageView();

    @FXML
    private ImageView micIMV = new ImageView();

    @FXML
    private ImageView shoeIMV = new ImageView();

    //Class Fields
    FXMainController mainController;

    FXSettings fxSettings;

    FXAllProperties fxAll;

    FXSelfProperties fxSelf;

    int turn = 0;

    private Timer timer = new Timer();

    private int secs = 0, min = 0, hour = 0;

    private ObservableList<String> players;

    private Board board;

    public FXBoard(FXMainController mainController) {
        this.mainController = mainController;
        board = new Board();
        fxSettings = new FXSettings(mainController, this);
        fxAll = new FXAllProperties(mainController, this);
        fxSelf = new FXSelfProperties(mainController, this);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    /*METHODS*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Collections.shuffle(players);
        playersLV.setItems(players);
        playersLV.setOnMouseClicked(null);
        carIMV.setVisible(false);
        catIMV.setVisible(false);
        dogIMV.setVisible(false);
        boatIMV.setVisible(false);
        hatIMV.setVisible(false);
        micIMV.setVisible(false);
        ironIMV.setVisible(false);
        shoeIMV.setVisible(false);
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
        try {
            mainController.launchFXMLWindowed("self-properties.fxml", fxSelf, "Propiedades", Modality.WINDOW_MODAL, StageStyle.DECORATED, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void rollDice(ActionEvent event) {

        //RANDOMIZER START
        int max = 6, min = 1;
        int range = max - min + 1;
        int dice1, dice2;
        dice1 = (int) (Math.random() * range) + min;
        dice2 = (int) (Math.random() * range) + min;

        String curr = playersLV.getItems().get(0);
        for (int i = 0; i < dice1 + dice2; i++) {
            moveToken(curr);
        }

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

    void moveToken(String curr) {
        board.getPlayers().front().move();
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

        DefaultQueue<Token> playerQ = new DefaultQueue<>();
        for (String player: players) {
            Token new_ = new Token(1500, player, 0, player);
            switch (player) {
                case "Perro":
                    dogIMV.setVisible(true);
                    new_.setToken(dogIMV);
                    break;
                case "Gato":
                    catIMV.setVisible(true);
                    new_.setToken(catIMV);
                    break;
                case "Barco":
                    boatIMV.setVisible(true);
                    new_.setToken(boatIMV);
                    break;
                case "Carro":
                    carIMV.setVisible(true);
                    new_.setToken(carIMV);
                    break;
                case "Sombrero":
                    hatIMV.setVisible(true);
                    new_.setToken(hatIMV);
                    break;
                case "Plancha":
                    ironIMV.setVisible(true);
                    new_.setToken(ironIMV);
                    break;
                case "Micrófono":
                    micIMV.setVisible(true);
                    new_.setToken(micIMV);
                    break;
                case "Bota":
                    shoeIMV.setVisible(true);
                    new_.setToken(shoeIMV);
                    break;
            }
            playerQ.enqueue(new_);
        }
        System.out.println(playerQ.toString());
        board.setPlayers(playerQ);

        //Timer
        hour = 0;
        min = 0;
        secs = 0;
        newTimer();
        advancePlayer();
    }

    private void advancePlayer() {
        turnLBL.setText("Es turno de " + playersLV.getItems().get(0) + "!");
        Token prev = board.getPlayers().dequeue();
        board.setInTurn(prev);
        board.getPlayers().enqueue(prev);
        players.clear();
        for (Token pl : ((DefaultQueue<Token>) board.getPlayers()).toArrayList()) {
            players.add(pl.getNameToken());
        }
        playersLV.setItems(players);
    }

    @FXML
    void next(ActionEvent event) {
        advancePlayer();
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

    public Board getBoard() {
        return board;
    }
}
