package model.binary_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import model.objects.Token;

public class PlayerTest {

    private Token player;
    private ImageView boatTest;

    @Test
    public void test() {

        boatTest = new ImageView();
        player = new Token(boatTest);

        boatTest.setLayoutX(0);
        boatTest.setLayoutY(0);
        double x = boatTest.getLayoutX();
        double y = boatTest.getLayoutY();

        for (int i = 0; i < 5; i++) {

            boatTest = player.moveUp(KeyCode.W);
            boatTest = player.moveUp(KeyCode.D);
            y = y - 8;
            x = x + 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

        for (int i = 0; i < 5; i++) {

            boatTest = player.moveUp(KeyCode.S);
            boatTest = player.moveUp(KeyCode.A);
            y = y + 8;
            x = x - 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

        for (int i = 0; i < 1000; i++) {

            boatTest = player.moveUp(KeyCode.W);
            boatTest = player.moveUp(KeyCode.D);
            y = y - 8;
            x = x + 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

        for (int i = 0; i < 1000; i++) {

            boatTest = player.moveUp(KeyCode.S);
            boatTest = player.moveUp(KeyCode.A);
            y = y + 8;
            x = x - 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

    }

}
