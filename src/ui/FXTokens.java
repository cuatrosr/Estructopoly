package ui;

import com.jfoenix.controls.JFXToggleNode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.data_structures.hashTable.DefaultHashTable;
import model.objects.Board;
import model.objects.Properties;

import java.io.IOException;

public class FXTokens {

    @FXML
    private BorderPane tokensPane = new BorderPane();

    @FXML
    private VBox playersVBOX = new VBox();

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

    private Board board;

    public FXTokens(FXMainController mainController) {
        board = new Board();
        this.mainController = mainController;
        fxBoard = new FXBoard(mainController);
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    @FXML
    void back(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
            fxmlLoader.setController(mainController);
            Parent root = fxmlLoader.load();
            mainController.getMainPane().setCenter(root);
            mainController.setCurrentScene("Menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loadBoard(ActionEvent event) {
        ObservableList<String> players = FXCollections.observableArrayList();
        for (Node child : playersVBOX.getChildren()) {
            if (child instanceof HBox) {
                for (Node toggle : ((HBox) child).getChildren()) {
                    boolean add_ = ((JFXToggleNode) toggle).isSelected();
                    String playerName = ((JFXToggleNode) toggle).getText();
                    if (add_) {
                        players.add(playerName.replaceAll("../images/tokens/", ""));
                    }
                }
            }
        }
        fxBoard.setPlayers(players);
        fxBoard.setBoard(board);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/board.fxml"));
            fxmlLoader.setController(fxBoard);
            Parent root = fxmlLoader.load();
            BorderPane mainPane = mainController.getMainPane();
            mainPane.setCenter(root);
            Stage stage = ((Stage) mainPane.getScene().getWindow());
            stage.setMinHeight(750);
            stage.setMinWidth(1400);
            mainController.setCurrentScene("Game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FXBoard getFXBoard() {
        return fxBoard;
    }
}
