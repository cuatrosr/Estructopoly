package model.objects;

import model.data_structure.MeLinkedLists;

public class CommunSquare extends Square {

    private static final long serialVersionUID = -5814743446433770091L;
    private int action;
    private int tax;
    private int goJail;
    private MeLinkedLists<Token> jail;

    //1 = go, 2 = go carcel, 3 = carcel, 4 = free, 5 = impuestos
    public CommunSquare(int numSquare, int typeSquare, int action, int tax) {
        super(numSquare, typeSquare);
        this.action = action;
        this.goJail = 10;
        this.tax = tax;
        this.jail = new MeLinkedLists<>();
    }

    public CommunSquare() {
        super();
    }

    public int getAction() {
        return this.action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getTax() {
        return this.tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getGoJail() {
        return this.goJail;
    }

    public void setGoJail(int goJail) {
        this.goJail = goJail;
    }

    public MeLinkedLists<Token> getJail() {
        return this.jail;
    }

    public void setJail(MeLinkedLists<Token> jail) {
        this.jail = jail;
    }

    public void selectAction() {

    }

}
