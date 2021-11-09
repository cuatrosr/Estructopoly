package objects;

import java.io.Serializable;

import data_structure.MeLinkedLists;

public abstract class Square implements Serializable{

	private static final long serialVersionUID = -1720566563896120783L;
	private int numSquare;
    private int typeSquare; // 0 = propiedad, 1 = wild y 2 = commun
    private MeLinkedLists<Player> players;

    protected Square(int numSquare, int typeSquare) {
        this.numSquare = numSquare;
        this.typeSquare = typeSquare;
        this.players = new MeLinkedLists<>();
    }

    protected Square() {}

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

    public MeLinkedLists<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(MeLinkedLists<Player> players) {
        this.players = players;
    }
   
    
}
