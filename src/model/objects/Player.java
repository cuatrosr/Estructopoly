package objects;

import java.io.Serializable;
import data_structure.MeLinkedLists;

public abstract class Player implements Serializable{
  
	private static final long serialVersionUID = 5780182730822343543L;
	private MeLinkedLists<Properties> properties;
    private MeLinkedLists<Train> trains;
    private MeLinkedLists<PublicServices> publicServices;
    private boolean especialCards;
    private int money;
    private int position;
    private String nameToken;
    private int penalty;
    private boolean par;
    private boolean jail;
    private int numProperties;
    private String namePlayer;

    protected Player(int money,  String nameToken) {
        this.properties = new MeLinkedLists<>();
        this.trains = new MeLinkedLists<>();
        this.publicServices = new MeLinkedLists<>();
        this.especialCards = false;
        this.money = money;
        this.position = 0;
        this.nameToken = nameToken;
        this.penalty = 0;
        this.par = false;
        this.jail = false;
    }

    protected Player(int money,  String nameToken, int numProperties, String namePlayer) {

        this.money = money;
        this.nameToken = nameToken;
        this.namePlayer = namePlayer;
        this.numProperties = numProperties;
        
    }
    
    protected Player() {}


    public MeLinkedLists<Properties> getProperties() {
        return this.properties;
    }

    public void setProperties(MeLinkedLists<Properties> properties) {
        this.properties = properties;
    }

    public MeLinkedLists<Train> getTrains() {
        return this.trains;
    }

    public void setTrains(MeLinkedLists<Train> trains) {
        this.trains = trains;
    }

    public MeLinkedLists<PublicServices> getPublicServices() {
        return this.publicServices;
    }

    public void setPublicServices(MeLinkedLists<PublicServices> publicServices) {
        this.publicServices = publicServices;
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
