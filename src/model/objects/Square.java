package model.objects;

import java.io.Serializable;
import java.util.LinkedList;

public class Square implements Serializable {

    private static final long serialVersionUID = -1720566563896120783L;
    private int numSquare;
    private int typeSquare; // 0 = propiedad, 1 = wild y 2 = commun
    private LinkedList<Player> players;

    protected Square(int numSquare, int typeSquare) {
        this.numSquare = numSquare;
        this.typeSquare = typeSquare;
        this.players = new LinkedList<>();
    }

    protected Square() {
    }

    public int getNumSquare() {
        return this.numSquare;
    }

    public void setNumSquare(int numSquare) {
        this.numSquare = numSquare;
    }

    public int getTypeSquare() {
        return this.typeSquare;
    }

    public void setTypeSquare(int typeSquare) {
        this.typeSquare = typeSquare;
    }

    public LinkedList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

}
