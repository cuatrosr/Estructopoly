package model.interface_class;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public interface Move {

    int PIXEL = 8;

    int AUTO_PIXEL = 81;

    int AUTO_PIXEL_HALVED = 61;

    int NORTH_BOUND = 46;

    int SOUTH_BOUND = 706;

    int WEST_BOUND = 36;

    int EAST_BOUND = 686;

    ImageView move(KeyCode event);

    void move();

}
