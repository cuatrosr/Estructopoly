package model.objects;

import java.io.Serializable;
import java.util.LinkedList;

public class Jail extends CommunSquare implements Serializable {
    private LinkedList<Player> list;

    public Jail() {
        super();
        this.list = new LinkedList<>();
    }

    @Override
    public boolean action(int index, Board board){

        switch (index){
            case 0:
                board.getInTurn().setJail(true);
                list.add(board.getInTurn());
                return true;

            case 1:
                board.getInTurn().setJail(false);
                list.remove(board.getInTurn());
                return false;

            default:
                return false;
        }



    }

}
