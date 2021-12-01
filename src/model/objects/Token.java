package model.objects;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import model.interface_class.Move;

public class Token extends Player implements Move {

    private static final long serialVersionUID = -7576993220422954011L;
    private ImageView token;
    private int id;
    private String direction;

    public Token(int money, ImageView token, String nameToken, int id) {
        super(money, nameToken);
        this.token = token;
        this.id = id;
        direction = "L";
    }

    public Token(int money, String nameToken, int numProperties, String namePlayer) {
        super(money, nameToken, numProperties, namePlayer);
        direction = "L";
    }

    public Token(ImageView token) {
        super();
        this.token = token;
        direction = "L";
    }

    public Token() {
        direction = "L";
    }

    public ImageView getToken() {
        return this.token;
    }

    public void setToken(ImageView token) {
        this.token = token;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ImageView move(KeyCode event) {

        double x = token.getLayoutX();
        double y = token.getLayoutY();

        if (event == KeyCode.A && x - PIXEL >= 22) {
            x = x - PIXEL;
        }

        if (event == KeyCode.D && x + PIXEL <= 953) {
            x = x + PIXEL;
        }

        if (event == KeyCode.W && y - PIXEL >= 16) {
            y = y - PIXEL;
        }

        if (event == KeyCode.S && y + PIXEL <= 936) {
            y = y + PIXEL;
        }

        token.setLayoutX(x);
        token.setLayoutY(y);

        return token;

    }

    @Override
    public void move() {

        double x = token.getLayoutX();
        double y = token.getLayoutY();

        boolean off_south = y + AUTO_PIXEL_HALVED > SOUTH_BOUND;
        boolean off_north = y - AUTO_PIXEL_HALVED < NORTH_BOUND;
        boolean off_west = x - AUTO_PIXEL_HALVED < WEST_BOUND;
        boolean off_east = x + AUTO_PIXEL_HALVED > EAST_BOUND;

        int usage = AUTO_PIXEL_HALVED;

        if (off_south && off_east) {
            direction = "L";
            y = SOUTH_BOUND;
            usage = AUTO_PIXEL;
        }
        else if (off_north && off_west) {
            direction = "R";
            y = NORTH_BOUND;
            usage = AUTO_PIXEL;
        }
        else if (off_west && off_south) {
            direction = "U";
            x = WEST_BOUND;
            usage = AUTO_PIXEL;
        }
        else if (off_east && off_north) {
            direction = "D";
            x = EAST_BOUND;
            usage = AUTO_PIXEL;
        }

        switch (direction) {
            case "L":
                x -= usage;
                break;
            case "U":
                y -= usage;
                break;
            case "R":
                x += usage;
                break;
            case "D":
                y += usage;
                break;
        }

        token.setLayoutX(x);
        token.setLayoutY(y);
        setPosition(getPosition() + 1);

        if (getPosition() > 40) {
            setMoney(getMoney() + 200);
            setPosition(getPosition() - 40);
        }
    }

}
