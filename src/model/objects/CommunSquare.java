package model.objects;

import java.io.Serializable;

public class CommunSquare extends Square implements Serializable {

    private static final long serialVersionUID = -5814743446433770091L;
    private final int MONEY = 200;

    public CommunSquare() {
        super();

    }

    public boolean action(int index, Board board) {

        switch (index){
            case 0:
                board.getInTurn().setMoney(board.getInTurn().getMoney() + MONEY);
                return true;

            default:
                return false;

        }


    }

}
