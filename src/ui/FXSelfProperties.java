package ui;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FXSelfProperties implements Initializable, Listeners {

    @FXML
    private Label buildingsLBL = new Label();

    @FXML
    private Label hotelPriceLBL = new Label();

    @FXML
    private Label housePriceLBL = new Label();

    @FXML
    private Label mortgagePayLBL = new Label();

    @FXML
    private JFXListView<?> selfPropsLV;

    FXMainController mainController;

    FXBoard fxBoard;

    public FXSelfProperties(FXMainController mainController, FXBoard fxBoard) {
        this.mainController = mainController;
        this.fxBoard = fxBoard;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void doBuild(ActionEvent event) {

    }

    @FXML
    void doMortgage(ActionEvent event) {

    }

    @FXML
    void doPay(ActionEvent event) {

    }

    @FXML
    void doSell(ActionEvent event) {

    }

    @Override
    public void keyListener(KeyEvent event) {

    }

}
