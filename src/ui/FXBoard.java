package ui;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;

public class FXBoard implements Initializable {

    /*JAVAFX FIELDS*/

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

    FXMainController mainController;

    public FXBoard(FXMainController mainController) {
        this.mainController = mainController;
    }

    /*METHODS*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boardIMV.fitHeightProperty().bind(boardPane.heightProperty());
        boardIMV.fitWidthProperty().bind(boardPane.widthProperty());
        boardIMV.maxHeight(1000);
        boardIMV.maxWidth(1000);
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

    }
}
