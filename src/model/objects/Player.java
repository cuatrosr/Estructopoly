package model.objects;

import java.io.Serializable;

import model.data_structures.hashTable.DefaultHashTable;
import model.interface_class.HashTable;

public abstract class Player implements Serializable {

    private static final long serialVersionUID = 5780182730822343543L;
    private HashTable<String, Properties> propertiesHash;
    private boolean especialCards;
    private int money;
    private int position;
    private String nameToken;
    private int penalty;
    private boolean par;
    private boolean jail;
    private int numProperties;
    private String namePlayer;

    protected Player(int money, String nameToken) {
        this.propertiesHash = new DefaultHashTable<>(28);
        this.especialCards = false;
        this.money = money;
        this.position = 0;
        this.nameToken = nameToken;
        this.penalty = 0;
        this.par = false;
        this.jail = false;
    }

    protected Player(int money, String nameToken, int numProperties, String namePlayer) {
        this.propertiesHash = new DefaultHashTable<>(28);
        this.money = money;
        this.nameToken = nameToken;
        this.namePlayer = namePlayer;
        this.numProperties = numProperties;

    }

    protected Player() {
    }

    public HashTable<String, Properties> getPropertiesHash() {
        return propertiesHash;
    }

    public void setPropertiesHash(HashTable<String, Properties> propertiesHash) {
        this.propertiesHash = propertiesHash;
    }

    public boolean isEspecialCards() {
        return this.especialCards;
    }

    public boolean getEspecialCards() {
        return this.especialCards;
    }

    public void setEspecialCards(boolean especialCards) {
        this.especialCards = especialCards;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNameToken() {
        return this.nameToken;
    }

    public void setNameToken(String nameToken) {
        this.nameToken = nameToken;
    }

    public int getPenalty() {
        return this.penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public boolean isPar() {
        return this.par;
    }

    public boolean getPar() {
        return this.par;
    }

    public void setPar(boolean par) {
        this.par = par;
    }

    public boolean isJail() {
        return this.jail;
    }

    public boolean getJail() {
        return this.jail;
    }

    public void setJail(boolean jail) {
        this.jail = jail;
    }

    public int getNumProperties() {
        return this.numProperties;
    }

    public void setNumProperties(int numProperties) {
        this.numProperties = numProperties;
    }

    public String getNamePlayer() {
        return this.namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

}
