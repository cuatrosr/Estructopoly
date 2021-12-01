package model.objects;

public class Properties extends Square {

    private static final long serialVersionUID = -1150550527535536653L;
    public static final String[] PROPS = {
      "Avenida Mediterráneo", "Avenida Báltica", "Ferrocarril Reading",  "Avenida Oriental", "Avenida Vermont", "Avenida Connecticut",
      "Plaza San Carlos", "Compañía Eléctrica", "Avenida Estados", "Avenida Virginia", "Ferrocarril Pennsylvania", "Plaza St. James", "Avenida Tennessee", "Avenida New York",
      "Avenida Kentucky", "Avenida Indiana", "Avenida Illinois", "Ferrocarril B. & O.", "Avenida Atlántico", "Avenida Ventnor", "Compañía de Agua", "Jardines Marvin",
      "Avenida Pacífico", "Avenida Carolina del Norte", "Avenida Pennsylvania", "Ferrocarril Vía Rápida", "Plaza Park", "El Muelle"
    };
    private String property;
    private Player owner;
    private int costProperty;
    private int rentalProperty;
    private int houses;
    private boolean hotel;
    private int costHousesAndHotel;
    private int[] rentalHousesAndHotel;
    private int mortgage;
    private int family;
    private int amountFamily;
    private String name;
    private int id;
    private boolean mortgaged;
    private int mortgagePay;

    public Properties(String property, int costProperty, int rentalProperty, int[] rentalHousesAndHotel, int costHousesAndHotel, int mortgage, int numSquare, int family, int amountFamily, String name) {
        super(numSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.rentalProperty = rentalProperty;
        this.hotel = false;
        this.houses = 0;
        this.rentalHousesAndHotel = rentalHousesAndHotel;
        this.costHousesAndHotel = costHousesAndHotel;
        this.mortgage = mortgage;
        this.owner = null;
        this.family = family;
        this.amountFamily = amountFamily;
        this.name = name;
        this.id = 1;
    }

    public Properties(int numSquare, String property, int costProperty, int rentalProperty, int mortgage, String name) {
        super(numSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.rentalProperty = rentalProperty;
        this.mortgage = mortgage;
        this.name = name;
        this.id = 2;

    }

    public Properties(int numSquare, String property, int costProperty, int mortgage, String name) {
        super(numSquare);
        this.property = property;
        this.costProperty = costProperty;
        this.mortgage = mortgage;
        this.name = name;
        this.id = 3;

    }

    public String getProperty() {
        return this.property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getCostProperty() {
        return this.costProperty;
    }

    public void setCostProperty(int costProperty) {
        this.costProperty = costProperty;
    }

    public int getRentalProperty() {
        return this.rentalProperty;
    }

    public void setRentalProperty(int rentalProperty) {
        this.rentalProperty = rentalProperty;
    }

    public int getHouses() {
        return this.houses;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }

    public boolean isHotel() {
        return this.hotel;
    }

    public boolean getHotel() {
        return this.hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public int getCostHousesAndHotel() {
        return this.costHousesAndHotel;
    }

    public void setCostHousesAndHotel(int costHousesAndHotel) {
        this.costHousesAndHotel = costHousesAndHotel;
    }

    public int[] getRentalHousesAndHotel() {
        return this.rentalHousesAndHotel;
    }

    public void setRentalHousesAndHotel(int[] rentalHousesAndHotel) {
        this.rentalHousesAndHotel = rentalHousesAndHotel;
    }

    public int getMortgage() {
        return this.mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getFamily() {
        return this.family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getAmountFamily() {
        return this.amountFamily;
    }

    public void setAmountFamily(int amountFamily) {
        this.amountFamily = amountFamily;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public int getMortgagePay() {
        return mortgagePay;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Properties propeties(Board board, int index) {
        return (Properties) board.getPropertiesHash().search(index);
    }

    public void action() {

    }
}
