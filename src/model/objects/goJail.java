package model.objects;

import java.io.Serializable;

public class goJail extends CommunSquare implements Serializable {

    public goJail() {
        super();
    }

    @Override
    public boolean action(int index, Board board){
        board.getJail().action(0, board);

        return true;

    }
}
