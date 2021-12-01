package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.objects.Properties;
import model.objects.Token;

import java.util.Objects;

public class FXBuyProp implements Listeners {

    @FXML
    private Label priceLBL = new Label();

    @FXML
    private ImageView propCardIMV = new ImageView();

    FXMainController mainController;

    FXBoard fxBoard;

    Properties currentSquare;

    final String[] cards = {
            "1-AvMed", "2-AvBalt", "3-FerRead", "4-AvOrt", "5-AvVerm", "6-AvCtc",
            "7-PlStCrl", "8-Elec", "9-AvEst", "10-AvVirg", "11-FerPenn", "12-PlStJms", "13-AvTnss", "14-AvNY",
            "15-AvKtck", "16-AvIndi", "17-AvIlli", "18-FerB&O", "19-AvAtl", "20-AvVtnr", "21-Agua", "22-Mrvn",
            "23-AvPcfc", "24-AvNC", "25-AvPenn", "26-FerVRap", "27-PlazaPark", "28-TheDock"
    };

    public FXBuyProp(FXMainController mainController, FXBoard fxBoard) {
        this.mainController = mainController;
        this.fxBoard = fxBoard;
    }

    @FXML
    void auction(ActionEvent event) {

    }

    @FXML
    void buy(ActionEvent event) {
        Token player = fxBoard.getBoard().getInTurn();
        if (player.getMoney() >= currentSquare.getCostProperty()) {
            currentSquare.setOwner(player);
            player.setMoney(player.getMoney() - currentSquare.getCostProperty());
            try {
                player.getPropertiesHash().insert(currentSquare.getNumSquare(), currentSquare);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ((Stage) priceLBL.getScene().getWindow()).close();
    }

    public void setCurrentSquare(Properties currentSquare) {
        this.currentSquare = currentSquare;
        String path = currentSquare.getProperty();
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        propCardIMV.setImage(image);
    }

    @Override
    public void keyListener(KeyEvent event) {

    }
}
