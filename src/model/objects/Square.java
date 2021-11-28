package model.objects;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Square implements Serializable {

    private static final long serialVersionUID = -1720566563896120783L;
    private int numSquare;
    private LinkedList<Player> players;

    protected Square() {
        this.players = new LinkedList<>();
    }

    public int getNumSquare() {
        return this.numSquare;
    }

    public void setNumSquare(int numSquare) {
        this.numSquare = numSquare;
    }

    public LinkedList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

}
