package model.objects;

import java.io.Serializable;
import java.util.LinkedList;

public class Board implements Serializable {

    private static final long serialVersionUID = 262921139849267465L;
    private LinkedList<Properties> propertiesSquare;
    private LinkedList<Train> trainSquare;
    private LinkedList<PublicServices> publicServicesSquare;
    private LinkedList<WildCards> wildCardsSquare;
    private LinkedList<CommunSquare> communSquare;
    private LinkedList<Token> players;
    private BinaryTreeCommunity communityServiceCards;
    private BinaryTreeFortune fortuneCards;
    private int turn;

    public Board() {
        this.propertiesSquare = new LinkedList<>();
        this.wildCardsSquare = new LinkedList<>();
        this.communSquare = new LinkedList<>();
        this.players = new LinkedList<>();
        this.communityServiceCards = new BinaryTreeCommunity();
        this.fortuneCards = new BinaryTreeFortune();
        this.trainSquare = new LinkedList<>();
        this.publicServicesSquare = new LinkedList<>();
        turn = 0;
    }

    public LinkedList<Properties> getPropertiesSquare() {
        return this.propertiesSquare;
    }

    public void setPropertiesSquare(LinkedList<Properties> propertiesSquare) {
        this.propertiesSquare = propertiesSquare;
    }

    public LinkedList<Train> getTrainSquare() {
        return this.trainSquare;
    }

    public void setTrainSquare(LinkedList<Train> trainSquare) {
        this.trainSquare = trainSquare;
    }

    public LinkedList<PublicServices> getPublicServicesSquare() {
        return this.publicServicesSquare;
    }

    public void setPublicServicesSquare(LinkedList<PublicServices> publicServicesSquare) {
        this.publicServicesSquare = publicServicesSquare;
    }

    public LinkedList<WildCards> getWildCardsSquare() {
        return this.wildCardsSquare;
    }

    public void setWildCardsSquare(LinkedList<WildCards> wildCardsSquare) {
        this.wildCardsSquare = wildCardsSquare;
    }

    public LinkedList<CommunSquare> getCommunSquare() {
        return this.communSquare;
    }

    public void setCommunSquare(LinkedList<CommunSquare> communSquare) {
        this.communSquare = communSquare;
    }

    public LinkedList<Token> getPlayers() {
        return this.players;
    }

    public void setPlayers(LinkedList<Token> players) {
        this.players = players;
    }

    public BinaryTreeCommunity getCommunityServiceCards() {
        return this.communityServiceCards;
    }

    public void setCommunityServiceCards(BinaryTreeCommunity communityServiceCards) {
        this.communityServiceCards = communityServiceCards;
    }

    public BinaryTreeFortune getFortuneCards() {
        return this.fortuneCards;
    }

    public void setFortuneCards(BinaryTreeFortune fortuneCards) {
        this.fortuneCards = fortuneCards;
    }

    public int getTurn() {
        return this.turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

}
