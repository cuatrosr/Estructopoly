package model.excepcion;

import javafx.scene.control.CheckBox;

public class PlayerExcepcion extends Exception {

    public static final long serialVersionUID = 11L;
    private final String TITLE = "Excepcion: ";

    public PlayerExcepcion(String mss) {
        super(mss);
    }

    public PlayerExcepcion() {

    }

    public void validateAmountPlayer(CheckBox checkBoat, CheckBox checkBox, CheckBox checkCar, CheckBox checkCat, CheckBox checkDog, CheckBox checkHat, CheckBox checkHole, CheckBox checkShoes) throws PlayerExcepcion {

        int numPlayers = 0;

        if (checkBoat.isSelected()) {
            numPlayers++;

        }

        if (checkBox.isSelected()) {
            numPlayers++;

        }

        if (checkCar.isSelected()) {
            numPlayers++;

        }

        if (checkCat.isSelected()) {
            numPlayers++;

        }

        if (checkDog.isSelected()) {
            numPlayers++;

        }

        if (checkHat.isSelected()) {
            numPlayers++;

        }

        if (checkHole.isSelected()) {
            numPlayers++;

        }

        if (checkShoes.isSelected()) {
            numPlayers++;

        }

        if (numPlayers < 2) {
            throw new PlayerExcepcion(TITLE + "number of players less than 2");

        }

    }

}
