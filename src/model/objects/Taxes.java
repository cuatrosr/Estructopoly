package model.objects;

import java.io.Serializable;

public class Taxes extends CommunSquare implements Serializable {

    private int amount;

    public Taxes(int numSquare, int amount) {
        super(numSquare);
        this.amount = amount;
    }

    @Override
    public boolean action(int index, Board board){
        if (board.getInTurn().getMoney() >= amount){
            board.getInTurn().setMoney(board.getInTurn().getMoney() - amount);
            return true;

        }else {
            return false;

        }
    }


    public int getAmount() {
        return amount;
    }
}
