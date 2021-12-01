package model.binary_test;

import org.junit.Test;
import static org.junit.Assert.*;
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

            boatTest = player.move(KeyCode.W);
            boatTest = player.move(KeyCode.D);
            y = y - 8;
            x = x + 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

        for (int i = 0; i < 5; i++) {

            boatTest = player.move(KeyCode.S);
            boatTest = player.move(KeyCode.A);
            y = y + 8;
            x = x - 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

        for (int i = 0; i < 1000; i++) {

            boatTest = player.move(KeyCode.W);
            boatTest = player.move(KeyCode.D);
            y = y - 8;
            x = x + 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

        for (int i = 0; i < 1000; i++) {

            boatTest = player.move(KeyCode.S);
            boatTest = player.move(KeyCode.A);
            y = y + 8;
            x = x - 8;

            assertEquals(y, boatTest.getLayoutY());
            assertEquals(x, boatTest.getLayoutX());

        }

    }

}
