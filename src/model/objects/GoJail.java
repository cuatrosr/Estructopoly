package model.objects;

import java.io.Serializable;

public class GoJail extends CommunSquare implements Serializable {

    public GoJail(int numSquare) {
        super(numSquare);
    }

    @Override
    public boolean action(int index, Board board) {
        board.getJail().action(0, board);

        return true;

    }
}
