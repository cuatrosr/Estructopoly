package model.objects;

import model.data_structures.graph.Graph;
import model.data_structures.hashTable.DefaultHashTable;
import model.data_structures.queueAndStack.DefaultQueue;
import model.interface_class.HashTable;
import model.interface_class.Queue;

import java.io.Serializable;

public class Board implements Serializable {

    private Graph<Square> gameBoard; //YA
    private Queue<Token> players;
    private HashTable<String, Token> playersHash; 
    private HashTable<String, Properties> propertiesHash; //YA
    private Queue<FortuneCards> fortuneCards; //YA
    private Queue<CommunityServiceCards> communityServiceCards; //YA
    private Token inTurn;
    private Jail jail;

    public Board(Jail jail) {
        this.gameBoard = new Graph<>(40);
        this.players = new DefaultQueue<>();
        this.playersHash = new DefaultHashTable<>(8);
        this.fortuneCards = new DefaultQueue<>();
        this.communityServiceCards = new DefaultQueue<>();
        this.propertiesHash = new DefaultHashTable<>(28);
        this.inTurn = new Token();
        this.jail = jail;
    }

    public Board() {}

    public Graph<Square> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Graph<Square> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Queue<Token> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Token> players) {
        this.players = players;
    }

    public HashTable<String, Token> getPlayersHash() {
        return playersHash;
    }

    public void setPlayersHash(HashTable<String, Token> playersHash) {
        this.playersHash = playersHash;
    }

    public Queue<FortuneCards> getFortuneCards() {
        return fortuneCards;
    }

    public void setFortuneCards(Queue<FortuneCards> fortuneCards) {
        this.fortuneCards = fortuneCards;
    }

    public Queue<CommunityServiceCards> getCommunityServiceCards() {
        return communityServiceCards;
    }

    public void setCommunityServiceCards(Queue<CommunityServiceCards> communityServiceCards) {
        this.communityServiceCards = communityServiceCards;
    }

    public Token getInTurn() {
        return inTurn;
    }

    public void setInTurn(Token inTurn) {
        this.inTurn = inTurn;
    }

    public Jail getJail() {
        return jail;
    }

    public void setJail(Jail jail) {
        this.jail = jail;
    }

    public HashTable<String, Properties> getPropertiesHash() {
        return propertiesHash;
    }

    public void setPropertiesHash(HashTable<String, Properties> propertiesHash) {
        this.propertiesHash = propertiesHash;
    }
}
