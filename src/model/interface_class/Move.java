package interface_class;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public interface Move {

    public static final int PIXEL = 8;

    public ImageView moveUp(KeyCode event);

}
