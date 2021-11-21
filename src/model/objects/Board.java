package model.objects;

import java.io.Serializable;

import model.data_structure.*;

public class Board implements Serializable {

    private static final long serialVersionUID = 262921139849267465L;
    private MeLinkedLists<Properties> propertiesSquare;
    private MeLinkedLists<Train> trainSquare;
    private MeLinkedLists<PublicServices> publicServicesSquare;
    private MeLinkedLists<WildCards> wildCardsSquare;
    private MeLinkedLists<CommunSquare> communSquare;
    private MeLinkedLists<Token> players;
    private BinaryTreeCommunity communityServiceCards;
    private BinaryTreeFortune fortuneCards;
    private int turn;

    public Board() {
        this.propertiesSquare = new MeLinkedLists<>();
        this.wildCardsSquare = new MeLinkedLists<>();
        this.communSquare = new MeLinkedLists<>();
        this.players = new MeLinkedLists<>();
        this.communityServiceCards = new BinaryTreeCommunity();
        this.fortuneCards = new BinaryTreeFortune();
        this.trainSquare = new MeLinkedLists<>();
        this.publicServicesSquare = new MeLinkedLists<>();
        turn = 0;
    }

    public MeLinkedLists<Properties> getPropertiesSquare() {
        return this.propertiesSquare;
    }

    public void setPropertiesSquare(MeLinkedLists<Properties> propertiesSquare) {
        this.propertiesSquare = propertiesSquare;
    }

    public MeLinkedLists<Train> getTrainSquare() {
        return this.trainSquare;
    }

    public void setTrainSquare(MeLinkedLists<Train> trainSquare) {
        this.trainSquare = trainSquare;
    }

    public MeLinkedLists<PublicServices> getPublicServicesSquare() {
        return this.publicServicesSquare;
    }

    public void setPublicServicesSquare(MeLinkedLists<PublicServices> publicServicesSquare) {
        this.publicServicesSquare = publicServicesSquare;
    }

    public MeLinkedLists<WildCards> getWildCardsSquare() {
        return this.wildCardsSquare;
    }

    public void setWildCardsSquare(MeLinkedLists<WildCards> wildCardsSquare) {
        this.wildCardsSquare = wildCardsSquare;
    }

    public MeLinkedLists<CommunSquare> getCommunSquare() {
        return this.communSquare;
    }

    public void setCommunSquare(MeLinkedLists<CommunSquare> communSquare) {
        this.communSquare = communSquare;
    }

    public MeLinkedLists<Token> getPlayers() {
        return this.players;
    }

    public void setPlayers(MeLinkedLists<Token> players) {
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
