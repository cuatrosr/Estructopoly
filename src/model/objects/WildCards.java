package model.objects;

import java.io.IOException;

public abstract class WildCards extends Square {

    private static final long serialVersionUID = 192875853834156303L;

    protected WildCards(int numSquare) {
        super(numSquare);
    }

    protected WildCards() {super();}

    abstract void action(Board board) throws IOException;

    abstract void setMoney(Board board, int aux) throws IOException;



}
