package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FXAllProperties implements Initializable, Listeners {

    @FXML
    private BorderPane allPropertiesPane;

    @FXML
    private ImageView cardIMV = new ImageView();

    @FXML
    private Label availableLBL = new Label();

    @FXML
    private Label ownerLBL = new Label();

    @FXML
    private Label priceLBL = new Label();

    @FXML
    private Label onMortgageLBL = new Label();

    //Class Fields
    FXMainController mainController;

    FXBoard fxBoard;

    int current;

    final String[] cards = {
        "1-AvMed", "2-AvBalt", "3-FerRead", "4-AvOrt", "5-AvVerm", "6-AvCtc",
        "7-PlStCrl", "8-Elec", "9-AvEst", "10-AvVirg", "11-FerPenn", "12-PlStJms", "13-AvTnss", "14-AvNY",
        "15-AvKtck", "16-AvIndi", "17-AvIlli", "18-FerB&O", "19-AvAtl", "20-AvVtnr", "21-Agua", "22-Mrvn",
        "23-AvPcfc", "24-AvNC", "25-AvPenn", "26-FerVRap", "27-PlazaPark", "28-TheDock"
    };

    final int MAX = cards.length - 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        changeCenter(current);
    }

    public FXAllProperties(FXMainController mainController, FXBoard fxBoard) {
        this.mainController = mainController;
        this.fxBoard = fxBoard;
        current = 0;
    }

    @Override
    public void keyListener(KeyEvent event) {
        KeyCode typed = event.getCode();
        if (typed.equals(KeyCode.LEFT)) {
            leftArrow(null);
        } else if (typed.equals(KeyCode.RIGHT)) {
            rightArrow(null);
        } else if (typed.equals(KeyCode.ESCAPE)) {
            ((Stage) allPropertiesPane.getScene().getWindow()).close();
        }
    }

    @FXML
    void leftArrow(MouseEvent event) {
        int next = current - 1;
        next = next < 0 ? MAX : next;
        changeCenter(next);
        current = next;
    }

    @FXML
    void rightArrow(MouseEvent event) {
        int next = current + 1;
        next = next > MAX ? 0 : next;
        changeCenter(next);
        current = next;
    }

    public void changeCenter(int next) {
        String path = "images/properties/" + cards[next] + "Front.png";
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        cardIMV.setImage(image);
    }
}
