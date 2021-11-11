package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Optional;
import excepcion.ComboBoxExcepcion;
import excepcion.ListExcepcion;
import excepcion.NameWinnerExcepcion;
import excepcion.PlayerExcepcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objects.*;
import threads.*;
  
public class ApoTwoPolyGUI extends AttributesGUI{

    //**************************************************************************
    // Object GUI

    public ApoTwoPolyGUI(Board board) {
        localStage = new Stage();
        this.board = board;
        
    }
    
    public ApoTwoPolyGUI() {
        localStage = new Stage();
        this.board = new Board();
    }

    public void setBoard(Board board) throws IOException{ this.board = board; refresh();}
    public Board getBoard() throws IOException{ return board; }
    public void setLocalStage(Stage stage){ this.localStage = stage;}

    //**************************************************************************
    // Init Screens
    
    @FXML
    public void goTokens(ActionEvent event) throws IOException {
        mainLeave(event);
        show(new FXMLLoader(getClass().getResource("screens/game_screens/tokens_scene/selectPlayers.fxml")), new Stage());

    }

    @FXML
    public void goCharts(ActionEvent event) throws IOException {
        show(new FXMLLoader(getClass().getResource("screens/pop-up/graphic/Graphic.fxml")), new Stage());

        ArrayList<XYChart.Series<String, Number>> arraySeries = new ArrayList<>();
        String[] types = {"Efectivo", "Valor Propiedades", "Poder de Hipoteca"};

        for(int i = 0; i < types.length; i++){
            XYChart.Series<String, Number> serie = new XYChart.Series<>();
            serie.setName(types[i]);

            for(Token tk : board.getPlayers().toArray()){

                if(i == 0){
                    serie.getData().add(new XYChart.Data<>(tk.getNameToken(), tk.getMoney()));

                }else{

                    int value = 0;
                    int mortgage = 0;
        
                    for(Properties pr : tk.getProperties().toArray()){
        
                        value += pr.getCostProperty();
                        mortgage += pr.getMortgage();
        
                    }
        
                    for(Properties pr : tk.getTrains().toArray()){
        
                        value += pr.getCostProperty();
                        mortgage += pr.getMortgage();
        
                    }
        
                    for(Properties pr : tk.getPublicServices().toArray()){
        
                        value += pr.getCostProperty();
                        mortgage += pr.getMortgage();
        
                    }

                    if(i == 1){
                        serie.getData().add(new XYChart.Data<>(tk.getNameToken(), value));

                    }else{
                        serie.getData().add(new XYChart.Data<>(tk.getNameToken(), mortgage));
                    }

                }

            }

            arraySeries.add(serie);

        }

        chartPatrimony.getData().addAll(arraySeries);
        
    }

    @FXML
    public void goBoard(ActionEvent event) throws PlayerExcepcion, IOException{

        playerExcepcion = new PlayerExcepcion();

        try {

            playerExcepcion.validateAmountPlayer(checkBoat, checkBox, checkCar, checkCat, checkDog, checkHat, checkHole, checkShoes);

            mainLeave(event);
            show(new FXMLLoader(getClass().getResource("screens/game_screens/board_scene/board.fxml")), new Stage());
    
            if(checkBoat.isSelected()){
                paneBoat.setOpacity(1);
                tokenBoat.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenBoat, "BOAT", board.getPlayers().size() + 1));
                
            }

            if(checkBox.isSelected()){
                paneBox.setOpacity(1);
                tokenBox.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenBox, "BOX",  board.getPlayers().size() + 1));
                
            }
    
            if(checkCar.isSelected()){
                paneCar.setOpacity(1);
                tokenCar.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenCar, "CAR",  board.getPlayers().size() + 1));
                
            }
    
            if(checkCat.isSelected()){
                paneCat.setOpacity(1);
                tokenCat.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenCat, "CAT",  board.getPlayers().size() + 1));
                
            }
    
            if(checkDog.isSelected()){
                paneDog.setOpacity(1);
                tokenDog.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenDog, "DOG",  board.getPlayers().size() + 1));
                
            }
    
            if(checkHat.isSelected()){
                paneHat.setOpacity(1);
                tokenHat.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenHat, "HAT",  board.getPlayers().size() + 1));
                
            }
    
            if(checkHole.isSelected()){
                paneHole.setOpacity(1);
                tokenHole.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenHole, "HOLE",  board.getPlayers().size() + 1));
                
            }
    
            if(checkShoes.isSelected()){
                paneShoes.setOpacity(1);
                tokenShoes.setVisible(true);
                board.getPlayers().add(new Token(TOTALMONEY, tokenShoes, "SHOES",  board.getPlayers().size() + 1));
                
            }

            threadPanesOrdering = new PanesOrderingThreads(paneBoat, paneBox, paneCar, paneCat, paneDog, paneHat, paneHole, paneShoes, this);
            threadPanesOrdering.start();

            alert("INFORMACION", "*. Con las teclas W,A,S,D el jugador en turno puede mover su token sobre el tablero.\n*. Tecla ENTER para ejecutar la accion de una casilla.\n*. Tecla P para pasar de turno");


            
        } catch (PlayerExcepcion e) {
            System.out.println(e.getMessage());
            alert("ERROR", "La cantidad de jugadores es menor a 2");

            
        }

    }

    @FXML
    public void goAllProperties(ActionEvent event) throws IOException, ClassNotFoundException {

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());

        threadImageOrdering = new ImageOrderingThreads(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, this, board);
        threadImageOrdering.start();
        
       
    }

    @FXML
    public void goDeal(ActionEvent event) throws IOException, ClassNotFoundException {

        show(new FXMLLoader(getClass().getResource("screens/pop-up/deal/Deal.fxml")), new Stage());

        ArrayList<String> arrayPrBidder = new ArrayList<>();
        ArrayList<String> arrayNamePlayers = new ArrayList<>();

        if(!(board.getPlayers().get(board.getTurn()).getProperties().isEmpty())){

            for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){
                arrayPrBidder.add(pr.getName());


            }

        }

        if(!(board.getPlayers().get(board.getTurn()).getPublicServices().isEmpty())){

            for(Properties pr : board.getPlayers().get(board.getTurn()).getPublicServices().toArray()){
                arrayPrBidder.add(pr.getName());


            }

        }

        if(!(board.getPlayers().get(board.getTurn()).getTrains().isEmpty())){

            for(Properties pr : board.getPlayers().get(board.getTurn()).getTrains().toArray()){
                arrayPrBidder.add(pr.getName());


            }

        }

        for(Token pr : board.getPlayers().toArray()){

            if(!(pr.getNameToken().equals(board.getPlayers().get(board.getTurn()).getNameToken()))){
                arrayNamePlayers.add(pr.getNameToken());
            }
            

        }

        ObservableList<String> obPrBidder = FXCollections.observableArrayList(arrayPrBidder);
        ObservableList<String> obNamePlayer = FXCollections.observableArrayList(arrayNamePlayers);
        choisePrBidder.setItems(obPrBidder);
        choicePurchasers.setItems(obNamePlayer);

        alert("Nota", "Manego de propiedades.\n*. Si deseas eliminar un apropiedad agregada a la lista da 3 clicks sobre ella.\n*. Si deseas ver mas informacion sobre una propiedad agregada en una lista da 2 clicks en ella.");
        
       
    }

    @FXML
    public void rollDice(ActionEvent event) throws IOException, ClassNotFoundException, InterruptedException {

        if(validationMove()){
        
            show(new FXMLLoader(getClass().getResource("screens/pop-up/dice/Dice.fxml")), new Stage());
            initDice();

        }else{

            show(new FXMLLoader(getClass().getResource("screens/pop-up/payJail/Jail.fxml")), new Stage());
            labelPayJail.setText("Espera " + (board.getPlayers().get(board.getTurn()).getPenalty() + 1) + " turnos o paga la fianza de $500");
            buttonRollDice.setDisable(true);

        }
         
    }

    @FXML
    public void playerPropertiesBoat(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "BOAT");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesBox(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "BOX");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesCar(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "CAR");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesCat(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "CAT");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesDog(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "DOG");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesHat(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "HAT");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesHole(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "HOLE");
        threadPlayerProperties.start();

    }

    @FXML
    public void playerPropertiesShoes(ActionEvent event) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/allProperties/AllProperties.fxml")), new Stage());
        threadPlayerProperties = new PlayerProperties(imageViewSanLuisN, imageViewSanLuisS, imageViewFormosaE, imageViewFormosaN, imageViewFormosaS, imageViewSanJuanE, imageViewSanJuanS, imageViewSanJuanN, imageViewNeuquenE, imageViewNeuquenS, imageViewNeuquenN, imageViewMendozaE, imageViewMendozaS, imageViewMendozaN, imageViewSantaFeE, imageViewSantaFeS, imageViewSantaFeN, imageViewCordobaE, imageViewCordobaS, imageViewCordobaN, imageViewBuenosAiresN, imageViewBuenosAiresS, imageViewTrenN, imageViewTrenE, imageViewTrenO, imageViewTrenS, imageViewWater, imageViewEnergi, board, "SHOES");
        threadPlayerProperties.start();

    }

    private void show(FXMLLoader fxmlLoader, Stage stage) throws IOException{

        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ApoTwoPoly");
        stage.show();
        localStage = stage;

    }

    //**************************************************************************
    // leave Screens

    @FXML
    public void mainLeave(ActionEvent event) {

        localStage.close();

    }


    //**************************************************************************
    // Move

    @FXML
    public void moveToken(KeyEvent event) throws ClassNotFoundException, IOException {

        switch (board.getPlayers().get(board.getTurn()).getNameToken()) {
            case "BOAT":
                tokenBoat = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;
        
            case "BOX":
                tokenBox = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "CAR":
                tokenCar = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "CAT":
                tokenCat = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "DOG":
                tokenDog = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "HAT":
                tokenHat = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "HOLE":
                tokenHole = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;

            case "SHOES":
                tokenShoes = board.getPlayers().bSearchToken(board.getTurn()).moveUp(event.getCode());
                break;
        }

        if(event.getCode() == KeyCode.ENTER){

            threadCommun = new CommunThreads(board, this);
            threadProperties = new PropertiesThreads(board, this, true);
            threadWildCards = new WildCardsThreads(board, this);
            threadPublicServices = new PublicServicesThreads(board, this, true);
            threadTrain = new TrainThreads(board, this, true);

            threadPublicServices.start();
            threadTrain.start();
            threadCommun.start();
            threadProperties.start();
            threadWildCards.start();

        }

        if(event.getCode() == KeyCode.P){

            interaction();

        }


    }

    //**************************************************************************
    // Dice

    private void initDice() throws IOException, InterruptedException {

        int diceOne = 0;
        int diceTwo = 0;
    
        for(int i = 0; i < TRY; i++){
    
            diceOne = (int) (Math.random()*6)+1;
            diceTwo = (int) (Math.random()*6)+1;

            dice1.setImage(new Image(dice(diceOne), 58, 58, true, true, true));
            dice2.setImage(new Image(dice(diceTwo), 58, 58, true, true, true));
                
        }
    
        numDice.setText(String.valueOf(diceOne + diceTwo));
        buttonRollDice.setDisable(true);
    
        if(registerLabel.getText().equals("")){
            registerLabel.setText(board.getPlayers().get(board.getTurn()).getNameToken() + " saco " + (diceOne + diceTwo) + " en los dados.\n");
    
        }else{
            registerLabel.setText(registerLabel.getText() + board.getPlayers().get(board.getTurn()).getNameToken() + " saco " + (diceOne + diceTwo) + " en los dados.\n");
        }
    
        if(diceOne == diceTwo){  

            board.getPlayers().get(board.getTurn()).setPenalty(board.getPlayers().get(board.getTurn()).getPenalty() + 1);

            if(board.getPlayers().get(board.getTurn()).getPenalty() == 3){
                actionCommunSquare(board.getCommunSquare().get(4));
    
            }else{
                alert("Sacaste un Numero PAR", "Puedes volver a tirar el dado");
                board.getPlayers().get(board.getTurn()).setPar(true);

            }

            registerLabel.setText(registerLabel.getText() + board.getPlayers().get(board.getTurn()).getNameToken() + " saco PAR.\n");
            buttonRollDice.setDisable(false);
    
        }else{
            board.getPlayers().get(board.getTurn()).setPenalty(0);
            board.getPlayers().get(board.getTurn()).setPar(false);
    
        }

        if(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo < 40){
                
            board.getPlayers().get(board.getTurn()).setPosition(board.getPlayers().get(board.getTurn()).getPosition() + diceOne + diceTwo);
    
        }else{
    
            board.getPlayers().get(board.getTurn()).setPosition(((diceOne + diceTwo) - (40 -  board.getPlayers().get(board.getTurn()).getPosition())));
            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() + 200);
                
    
        }

        
    }

    private boolean validationMove(){

        boolean vali = true;
        
        if(board.getCommunSquare().get(2).getJail().getHead() != null){

            for(Token token : board.getCommunSquare().get(2).getJail().toArray()){

                if(board.getPlayers().get(board.getTurn()).getNameToken().equals(token.getNameToken())){
    
                    vali = false;
                    board.getPlayers().get(board.getTurn()).setPenalty(board.getPlayers().get(board.getTurn()).getPenalty() - 1);

                    if(board.getPlayers().get(board.getTurn()).getPenalty() == 0){
                        board.getPlayers().get(board.getTurn()).setJail(false);
                        board.getCommunSquare().get(2).getJail().remove(board.getCommunSquare().get(2).getJail().indexOf(token));
                        vali = true;

                    }

                    break;
    
                }
            }
        }

        return vali;

    }

    private String dice(int value) {

        String url = "/images/dice/";

        switch (value) {
           case 1:
                return url + "de1.jpg";
        
            case 2:
                return url + "de2.jpg";
              
            case 3:
                return url + "de3.jpg";
             
            case 4:
                return url + "de4.jpg";
              
            case 5:
                return url + "de5.jpg";
              
            case 6:
                return url + "de6.jpg";
             
            default:
                return url + "de1.jpg";
             
        }
        
    }

    //**************************************************************************
    // Threads

    public void actionFortuneCard(FortuneCards card) throws IOException{

        show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewWild.fxml")), new Stage());
        imageWild.setImage(new Image(card.getCard()));

    }

    public void actionCommunityCard(CommunityServiceCards card) throws IOException{
        show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewWild.fxml")), new Stage());
        imageWild.setImage(new Image(card.getCard()));

    }

    public void actionCommunSquare(CommunSquare communSquare) throws IOException{

        if(communSquare.getAction() == 2){
            if(board.getPlayers().get(board.getTurn()).getEspecialCards()){
                board.getPlayers().get(board.getTurn()).setEspecialCards(false);
                
            }else{ 
                alert("Mala Suerte", "Dirigete a la carcel para cumplir tu condena");
                board.getPlayers().get(board.getTurn()).setPosition(10);
                board.getPlayers().get(board.getTurn()).setPenalty(3);
                board.getPlayers().get(board.getTurn()).setJail(true);
                board.getCommunSquare().get(2).getJail().add(board.getPlayers().get(board.getTurn()));

            }
            
            
        }else if(communSquare.getAction() == 5){
            alert("Mala Suerte", "Pagas un impuesto de " + communSquare.getTax());

            if(board.getPlayers().get(board.getTurn()).getMoney() >= communSquare.getTax()){
                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - communSquare.getTax());
                refresh();

            }else{
                bankruptcy(communSquare.getTax(), null);

            }

        }

        refresh();
        

    }


    public void actionProperties(Properties propertie) throws IOException{
        
        if(propertie.getOwner() != null && propertie.getOwner() != board.getPlayers().get(board.getTurn())){

            int amout = propertie.getRentalProperty();

            if(propertie.getHouses() != 0 && !(propertie.getHotel())){
                amout = propertie.getRentalHousesAndHotel()[propertie.getHouses() - 1];

            }else if(propertie.getHotel()){
                amout = propertie.getRentalHousesAndHotel()[4];

            }

        
            if (board.getPlayers().get(board.getTurn()).getMoney() >= amout) {
                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - amout);
                propertie.getOwner().setMoney(propertie.getOwner().getMoney() + amout);
                alert("Mala Suerte", "La propiedad tiene dueño y le pagaste $" +  amout + " de arriendo a " + propertie.getOwner().getNameToken());
                refresh();

            }else{
                bankruptcy(amout, propertie.getOwner());

            }

        }else if(propertie.getOwner() == board.getPlayers().get(board.getTurn())){ //compra casas y hoteles

            int sum = 0;
            auxPropertie = propertie;

            for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){

                if(pr.getFamily() == propertie.getFamily()){
                    sum++;

                    if(sum == propertie.getAmountFamily()){
                        break;

                    }

                }

            }

            if(sum == propertie.getAmountFamily()){
                
                show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/sellHouseOrHotel.fxml")), new Stage());
                imageProperti.setImage(new Image(propertie.getProperty()));

            }
            

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));
            costPropertie.setText("$" + propertie.getCostProperty());

        }

        refresh();

    }

    public void actionProperties(Train propertie) throws IOException{
        
        if(propertie.getOwner() != null && propertie.getOwner() != board.getPlayers().get(board.getTurn())){

            int valor = 25;

            if(propertie.getOwner().getTrains().size() == 2){
                valor = 50;

            }else if(propertie.getOwner().getTrains().size() == 3){
                valor = 100;

            }else if(propertie.getOwner().getTrains().size() == 4){
                valor = 200;

            }

            if (board.getPlayers().get(board.getTurn()).getMoney() >= valor) {

                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - valor);
                propertie.getOwner().setMoney(propertie.getOwner().getMoney() + valor);
                alert("Mala Suerte", "La propiedad tiene dueño, se te cobrara segun la cantidad de estaciones que este posea.\n" + "*. Cantidad de estaciones: " +  propertie.getOwner().getTrains().size() + "\n El valor a pagar a " + propertie.getOwner().getNameToken() + " es $" + valor);
                refresh();

            }else{
                bankruptcy(valor, propertie.getOwner());

            }

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));
            costPropertie.setText("$" + propertie.getCostProperty());

        }

        refresh();

    }

    public void actionProperties(PublicServices propertie) throws IOException{
        
        if(propertie.getOwner() != null && propertie.getOwner() != board.getPlayers().get(board.getTurn())){
        
            int multiplier = 4;
          
            if(board.getPlayers().get(board.getTurn()).getPublicServices().size() == 2){
                multiplier = 10;
             
            }

            int diceOne = (int) (Math.random()*6)+1;
            int diceTwo = (int) (Math.random()*6)+1;

            int valor = (diceOne + diceTwo) * multiplier;


            if (board.getPlayers().get(board.getTurn()).getMoney() >= valor) {
                board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - valor);
                propertie.getOwner().setMoney(propertie.getOwner().getMoney() + valor);
                alert("Mala Suerte", "La propiedad tiene dueño, se te cobrara la suma de los valores que arrojen los dados y se multiplicara segun los servicion que posea" + "\n*. Suma de los dados: " + (diceOne + diceTwo) + "\n*. Multiplicidad: " + multiplier + "\nValor total a pagar a " + propertie.getOwner().getNameToken() + " es $" + valor);
                refresh();

            }else{
                bankruptcy(valor, propertie.getOwner());

            }

        }else{
            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(propertie.getProperty()));
            costPropertie.setText("$" + propertie.getCostProperty());

        }

        refresh();
       
    }

    //**************************************************************************************************************************
    // Methods

    private void alert(String title, String mss){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();
        
    }

    private void interaction() throws IOException{

        refresh();

        if(!(board.getPlayers().get(board.getTurn()).getPar()) && !(board.getPlayers().get(board.getTurn()).getJail())){

            tokenOffSide();

            if(board.getTurn() + 1 == board.getPlayers().size()){
                board.setTurn(0);
        
            }else{
                board.setTurn(board.getTurn() + 1);
        
            }

            tokenInGame();
            buttonRollDice.setDisable(false);

        }else{
            board.getPlayers().get(board.getTurn()).setJail(false);

        }

        
     
        
       
    }

    private void refresh(){

        for(Token player : board.getPlayers().toArray()){

            int money = player.getMoney();

            switch(player.getNameToken()){
                case "BOAT":
                    moneyBoat.setText(String.valueOf(money));
                    break;
    
                case "HAT":
                    moneyHat.setText(String.valueOf(money));
                    break;
    
                case "HOLE":
                    moneyHole.setText(String.valueOf(money));
                    break;
    
                case "CAR":
                    moneyCar.setText(String.valueOf(money));
                    break;
    
                case "CAT":
                    moneyCat.setText(String.valueOf(money));
                    break;
    
                case "SHOES":
                    moneyShoes.setText(String.valueOf(money));
                    break;
    
                case "BOX":
                    moneyBox.setText(String.valueOf(money));
                    break;
    
                case "DOG":
                    moneyDog.setText(String.valueOf(money));
                    break;
    
               
    
            }
    
            
        }


    }

    @FXML
    public void buyProperti(ActionEvent event) {
        threadProperties =  new PropertiesThreads(board, this, false);
        threadTrain = new TrainThreads(board, this, false);
        threadPublicServices = new PublicServicesThreads(board, this, false);

        threadPublicServices.start();
        threadTrain.start();
        threadProperties.start();

    }

    @FXML
    public void payJail(ActionEvent event) {

        if(board.getPlayers().get(board.getTurn()).getMoney() >= 500){
            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - 500);
            board.getPlayers().get(board.getTurn()).setPenalty(0);
            alert("Vaya", "Ya estas libre pero tienes que esperar al siguiente turno para jugar");

        }else{
            alert("Estas Pobre", "No tienes el dinero suficiente para pagar la fianza");

        }
        

    }

    private void tokenInGame(){

        String url = "/images/graphic/rectangleGameTurn.jpg";

        switch(board.getPlayers().get(board.getTurn()).getNameToken()){
            case "BOAT":
                imageViewBoat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HAT":
                imageViewHat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HOLE":
                imageViewHole.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAR":
                imageViewCar.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAT":
                imageViewCat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "SHOES":
                imageViewShoes.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "BOX":
                imageViewBox.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "DOG":
                imageViewDog.setImage(new Image(url, 548, 109, true, true, true));
                break;

        }

    }

    private void tokenOffSide(){

        String url = "/images/graphic/rectangleGame.jpg";

        switch(board.getPlayers().get(board.getTurn()).getNameToken()){
            case "BOAT":
                imageViewBoat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HAT":
                imageViewHat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "HOLE":
                imageViewHole.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAR":
                imageViewCar.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "CAT":
                imageViewCat.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "SHOES":
                imageViewShoes.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "BOX":
                imageViewBox.setImage(new Image(url, 548, 109, true, true, true));
                break;

            case "DOG":
                imageViewDog.setImage(new Image(url, 548, 109, true, true, true));
                break;

        }

    }

    public void playerOrdering(ArrayList<Pane> panes){

        for(int i = 0; i < panes.size(); i++){

            GridPane.setConstraints(panes.get(i), 0, i);

        }

        tokenInGame();

    }

    public void propertiesOrdering(ArrayList<ImageView> imageViews) throws IOException{

        int aux = 0;

        for(int i = 0; i < 4; i++){

            for(int l = 0; l < 7; l++){

                GridPane.setConstraints(imageViews.get(aux), l, i);

                aux++;
    
            }

        }

        

    }

    @FXML
    public void buyHouse(ActionEvent event) {

        localStage.close();

        if(board.getPlayers().get(board.getTurn()).getMoney() >= auxPropertie.getCostHousesAndHotel() && auxPropertie.getHouses() < 4){

            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - auxPropertie.getCostHousesAndHotel());
            refresh();
            HousesAndHotelThreads threads = new HousesAndHotelThreads(house44, house43, house42, house41, hotel12, house48, house47, house46, house45, hotel13, house52, house51, house50, house49, hotel14, house56, house55, house54, house53, hotel15, house60, house59, house58, house57, hotel16, house64, house63, house62, house61, hotel17, house40, house39, house38, house37, hotel11, house36, house35, house34, house33, hotel10, house32, house31, house30, house29, hotel9, hotel8, house28, house27, house26, house25, hotel7, house24, house23, house22, house21, hotel6, house17, house18, house19, house20, hotel5, house13, house14, house15, house16, hotel4, house9, house10, house11, house12, hotel3, house5, house6, house7, house8, hotel2, house1, house2, house3, house4, hotel1, house81, house82, house83, house84, hotel22, house77, house78, house79, house80, hotel21, house73, house74, house75, house76, hotel20, house69, house70, house71, house72, hotel19, house65, house66, house67, house68, hotel18, house85, house86, house87, house88, board, auxPropertie, true);
            threads.start();

        }else{
            alert("Upsss", "Parece que no tienes dinero para hacer la compra o ya tienes las 4 casas");
            
        }

        

    }

    @FXML
    public void buyHotel(ActionEvent event) {

        localStage.close();

        int houses = 0;

        for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){

            if(pr.getFamily() == auxPropertie.getFamily()){
                houses += pr.getHouses();

            }

        }

        if(board.getPlayers().get(board.getTurn()).getMoney() >= auxPropertie.getCostHousesAndHotel() && houses == auxPropertie.getAmountFamily() * 4){

            board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() - auxPropertie.getCostHousesAndHotel());
            refresh();
            HousesAndHotelThreads threads = new HousesAndHotelThreads(house44, house43, house42, house41, hotel12, house48, house47, house46, house45, hotel13, house52, house51, house50, house49, hotel14, house56, house55, house54, house53, hotel15, house60, house59, house58, house57, hotel16, house64, house63, house62, house61, hotel17, house40, house39, house38, house37, hotel11, house36, house35, house34, house33, hotel10, house32, house31, house30, house29, hotel9, hotel8, house28, house27, house26, house25, hotel7, house24, house23, house22, house21, hotel6, house17, house18, house19, house20, hotel5, house13, house14, house15, house16, hotel4, house9, house10, house11, house12, hotel3, house5, house6, house7, house8, hotel2, house1, house2, house3, house4, hotel1, house81, house82, house83, house84, hotel22, house77, house78, house79, house80, hotel21, house73, house74, house75, house76, hotel20, house69, house70, house71, house72, hotel19, house65, house66, house67, house68, hotel18, house85, house86, house87, house88, board, auxPropertie, false);
            threads.start();

        }else{
            alert("Upsss", "Parece que no tienes dinero para hacer la compra o no tienes las 4 casas");
            
        }

        
    }

    @FXML
    public void setPrPurcharser(ActionEvent event) {

        ArrayList<String> namePr = new ArrayList<String>();

        for(Token tk : board.getPlayers().toArray()){
            if(tk.getNameToken().equals(choicePurchasers.getSelectionModel().getSelectedItem().toString())){

                if(!(tk.getProperties().isEmpty())){
                    for(Properties pr : tk.getProperties().toArray()){
                        namePr.add(pr.getName());
    
                    }

                }

                if(!(tk.getPublicServices().isEmpty())){
                    for(Properties pr : tk.getPublicServices().toArray()){
                        namePr.add(pr.getName());
    
                    }

                }

                if(!(tk.getTrains().isEmpty())){
                    for(Properties pr : tk.getTrains().toArray()){
                        namePr.add(pr.getName());
    
                    }

                }

                break;

            }

        }

        ObservableList<String> obPr = FXCollections.observableArrayList(namePr);
        choisePrPurchaser.setItems(obPr);

    }

    @FXML
    public void setTableViewPrPurchaser(ActionEvent event) throws ComboBoxExcepcion {

        comboBoxExcepcion = new ComboBoxExcepcion();

        try {

            comboBoxExcepcion.validateComboBox(choisePrBidder);

            for(Token tk : board.getPlayers().toArray()){

                if(tk.getNameToken().equals(choicePurchasers.getSelectionModel().getSelectedItem().toString())){
                    String name = choisePrPurchaser.getSelectionModel().getSelectedItem().toString();
                    setTables(tk, tableViewPrPurchaser, namePrPurchaser, name, new TableColumn<Properties, Integer>());
                    break;
    
                }
    
            }

        } catch (ComboBoxExcepcion e) {
            System.out.println(e.getMessage());
          
        }

       

    }

    @FXML
    public void SetTableViewPrBidder(ActionEvent event) throws ComboBoxExcepcion{

        comboBoxExcepcion = new ComboBoxExcepcion();

        try {

            comboBoxExcepcion.validateComboBox(choisePrBidder);
            String name = choisePrBidder.getSelectionModel().getSelectedItem().toString();
            setTables(board.getPlayers().get(board.getTurn()), tableViewPrBidder, namePrBidder, name, new TableColumn<Properties, Integer>()); 

        } catch (ComboBoxExcepcion e) {
            System.out.println(e.getMessage());
          
        }

    }

    private void setTables(Token player, TableView<Properties> tableView, TableColumn<Properties, String> colum, String combobox, TableColumn<Properties, Integer> colum2){

        boolean vali = true;

        if(vali && !(player.getProperties().isEmpty())){

            for(Properties pr : player.getProperties().toArray()){
                if(pr.getName().equals(combobox)){
                    tableView.getItems().add(pr);
                    vali = false;
                    
                }

            }

        }
        
        if(vali && !(player.getPublicServices().isEmpty())){

            for(Properties pr : player.getPublicServices().toArray()){
                if(pr.getName().equals(combobox)){
                    tableView.getItems().add(pr);
                    vali = false;
                  
                }

            }

        }
        
        if(vali && !(player.getTrains().isEmpty())){

            for(Properties pr : player.getTrains().toArray()){
                if(pr.getName().equals(combobox)){
                    tableView.getItems().add(pr);
                    vali = false;

                }

            }

        }

        colum.setCellValueFactory(new PropertyValueFactory<Properties, String>("name"));
        colum2.setCellValueFactory(new PropertyValueFactory<Properties, Integer>("mortgage"));

        tableView.refresh();


    }

    @FXML
    public void tapTableViewPrBidder (MouseEvent event) throws IOException{

        opTableViews(event, tableViewPrBidder);

        if (event.getClickCount() == 3){

            choisePrBidder.valueProperty().set(null);
            
        }
        

    }

    @FXML
    public void tapTableViewPrPurchaser (MouseEvent event) throws IOException{

        opTableViews(event, tableViewPrPurchaser);
        
        if (event.getClickCount() == 3){

            choicePurchasers.valueProperty().set(null);
            
        }

    }

    @FXML
    public void tapTableViewMortgage (MouseEvent event) throws IOException{

        opTableViews(event, tableViewMortgage);
        
        if (event.getClickCount() == 3){

            labelMortgageTotal.setText(String.valueOf(Integer.parseInt(labelMortgageTotal.getText()) - tableViewMortgage.getItems().get(tableViewMortgage.getSelectionModel().getSelectedIndex()).getMortgage()));
            choicePurchasers.valueProperty().set(null);
            
        }

    }

    private void opTableViews(MouseEvent event, TableView<Properties> tableView) throws IOException{

        int index = tableView.getSelectionModel().getSelectedIndex();

        if (event.getClickCount() == 2){

            show(new FXMLLoader(getClass().getResource("screens/pop-up/properties/viewProperti.fxml")), new Stage());
            imageProperti.setImage(new Image(tableView.getItems().get(index).getProperty()));
            costPropertie.setText("$" + tableView.getItems().get(index).getCostProperty());
            buttomViewPropertie.setVisible(false);
            
        }

        if (event.getClickCount() == 3){

            localStage.close();

            if (index <= -1){
                return;
            }

            tableView.getItems().remove(index);
            
        }

        tableView.refresh();

    }
   
    @FXML
    public void deal (ActionEvent event) {

        comboBoxExcepcion = new ComboBoxExcepcion();

        try {

            comboBoxExcepcion.validateComboBox(choicePurchasers);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Intercambio");
            alert.setHeaderText(null);
            alert.setContentText(choicePurchasers.getSelectionModel().getSelectedItem().toString() + " acceptas el intercambio?");
            Optional<ButtonType> result =  alert.showAndWait();

            if(result.get().getText().equals("Aceptar")){

                threadsDeal = new DealThreads(board, Integer.parseInt(moneyBidder.getText()), Integer.parseInt(moneyPurchaser.getText()), tableViewPrBidder.getItems(), tableViewPrPurchaser.getItems(), choicePurchasers.getSelectionModel().getSelectedItem().toString(), this);
                threadsDeal.start();

            }

            localStage.close(); 

        } catch (ComboBoxExcepcion e) {
            System.out.println(e.getMessage());
            alert("ERROR", "El jugador que recibe la oferta no fue seleccionado");
          
        }

       

        
    }

    public void bankruptcy(int debt, Player player) throws IOException{

        int stock = board.getPlayers().get(board.getTurn()).getMoney();

        for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){
            stock += pr.getMortgage();

        }

        for(Properties pr : board.getPlayers().get(board.getTurn()).getPublicServices().toArray()){
            stock += pr.getMortgage();

        }

        for(Properties pr : board.getPlayers().get(board.getTurn()).getTrains().toArray()){
            stock += pr.getMortgage();

        }

        if(stock >= debt){
            show(new FXMLLoader(getClass().getResource("screens/pop-up/mortgage/Mortgage.fxml")), new Stage());

            ArrayList<String> array = new ArrayList<>();

            if(!(board.getPlayers().get(board.getTurn()).getProperties().isEmpty())){

                for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){
                    array.add(pr.getName());
    
    
                }
    
            }
    
            if(!(board.getPlayers().get(board.getTurn()).getPublicServices().isEmpty())){
    
                for(Properties pr : board.getPlayers().get(board.getTurn()).getPublicServices().toArray()){
                    array.add(pr.getName());
    
    
                }
    
            }
    
            if(!(board.getPlayers().get(board.getTurn()).getTrains().isEmpty())){
    
                for(Properties pr : board.getPlayers().get(board.getTurn()).getTrains().toArray()){
                    array.add(pr.getName());
    
    
                }
    
            }

            ObservableList<String> obPrBidder = FXCollections.observableArrayList(array);
            choisMortgageProperties.setItems(obPrBidder);



        }else{
            alert("Mala Noticia", "No tienes dinero ni puede hipotecar, entras en BANCARROTA");        

            if(player != null){
                player.setMoney(player.getMoney() + board.getPlayers().get(board.getTurn()).getMoney());

            }

            paneOff();
            board.getPlayers().get(board.getTurn()).setMoney(0);
            ArrayList<Token> aux = board.getPlayers().toArray();
            aux.remove(board.getTurn());
            board.getPlayers().arrayToMeList(aux);
            board.getPlayers().setSize(1);

            if(board.getPlayers().size() == 1){

                show(new FXMLLoader(getClass().getResource("screens/pop-up/winner/Winner.fxml")), new Stage());

                alert("Ganador", "El jugador " + board.getPlayers().get(0).getNameToken() + " gano la partida");

            }

        }

        refresh();

    }

    @FXML
    public void addMortgage (ActionEvent  event) {

        setTables(board.getPlayers().get(board.getTurn()), tableViewMortgage, nameProperties, choisMortgageProperties.getSelectionModel().getSelectedItem().toString(), mortgagePropertie);

        if(!(board.getPlayers().get(board.getTurn()).getProperties().isEmpty())){

            for(Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()){
                if(pr.getName().equals(choisMortgageProperties.getSelectionModel().getSelectedItem().toString())){
                    labelMortgageTotal.setText(String.valueOf(Integer.parseInt(labelMortgageTotal.getText()) + pr.getMortgage()));
    
                }
    
            }

        }

        if(!(board.getPlayers().get(board.getTurn()).getTrains().isEmpty())){

            for(Properties pr : board.getPlayers().get(board.getTurn()).getTrains().toArray()){
                if(pr.getName().equals(choisMortgageProperties.getSelectionModel().getSelectedItem().toString())){
                    labelMortgageTotal.setText(String.valueOf(Integer.parseInt(labelMortgageTotal.getText()) + pr.getMortgage()));
    
                }
    
            }

        }

        if(!(board.getPlayers().get(board.getTurn()).getPublicServices()).isEmpty()){

            for(Properties pr : board.getPlayers().get(board.getTurn()).getPublicServices().toArray()){
                if(pr.getName().equals(choisMortgageProperties.getSelectionModel().getSelectedItem().toString())){
                    labelMortgageTotal.setText(String.valueOf(Integer.parseInt(labelMortgageTotal.getText()) + pr.getMortgage()));
    
                }
    
            }

        }
        

    }

    @FXML
    public void mortgage (ActionEvent  event) {
        int index = board.getTurn();

        allNUll(index);

        board.getPlayers().get(index).setMoney(board.getPlayers().get(index).getMoney() + Integer.parseInt(labelMortgageTotal.getText()));

        localStage.close();
        refresh();

    }

    private void allNUll(int index){

        for(Properties pr :  tableViewMortgage.getItems()){

            if(pr.getId() == 1){
                for(int i = board.getPlayers().get(index).getProperties().size() - 1; i >= 0; i--){

                    if(board.getPlayers().get(index).getProperties().get(i).getName().equals(pr.getName())){
                        board.getPlayers().get(index).getProperties().remove(i);
                        pr.setOwner(null);
                        break;

                    }

                }

            }else if(pr.getId() == 2){
                for(int i = board.getPlayers().get(index).getTrains().size() - 1; i >= 0; i--){

                    if(board.getPlayers().get(index).getTrains().get(i).getName().equals(pr.getName())){
                        board.getPlayers().get(index).getTrains().remove(i);
                        pr.setOwner(null);
                        break;

                    }

                }

            }else{
                for(int i = board.getPlayers().get(index).getPublicServices().size() - 1; i >= 0; i--){

                    if(board.getPlayers().get(index).getPublicServices().get(i).getName().equals(pr.getName())){
                        board.getPlayers().get(index).getPublicServices().remove(i);
                        pr.setOwner(null);
                        break;

                    }

                }

            }

        }

    }

    private void paneOff(){

        switch(board.getPlayers().get(board.getTurn()).getNameToken()){
            case "BOAT":
                paneBoat.setOpacity(0);
                break;

            case "HAT":
                paneHat.setOpacity(0);
                break;

            case "HOLE":
                paneHole.setOpacity(0);
                break;

            case "CAR":
                paneCar.setOpacity(0);
                break;

            case "CAT":
                paneCat.setOpacity(0);
                break;

            case "SHOES":
                paneShoes.setOpacity(0);
                break;

            case "BOX":
                paneBox.setOpacity(0);
                break;

            case "DOG":
                paneDog.setOpacity(0);
                break;

        }

    }
    
    @FXML
	public void readLeaderBoard() throws NumberFormatException, IOException, ListExcepcion{

        listExcepcion = new ListExcepcion();

        try {

            BufferedReader br = new BufferedReader(new FileReader("data\\Classification_Board.txt"));
            String vali = br.readLine();
            listExcepcion.validateList(vali);

            show(new FXMLLoader(getClass().getResource("screens/pop-up/leaderBoard/LeaderBoard.fxml")), new Stage());
            ArrayList<Token> arrayToken = new ArrayList<>();
            int index = Integer.parseInt(vali);
            

            for(int i = 0; i < index; i++){

                String[] format = spliter(br.readLine(), new String[5], 0);

                String namePlayer = format[0];
		        String nameToken = format[1];
		        int money = Integer.parseInt(format[2]);
		        int numProperties = Integer.parseInt(format[3]);


                arrayToken.add(new Token(money, nameToken, numProperties, namePlayer));

            }

            br.close();

            tableViewLeaderBoard.getItems().addAll(arrayToken);

            leaderBoardName.setCellValueFactory(new PropertyValueFactory<Token, String>("namePlayer"));
            leaderBoardToken.setCellValueFactory(new PropertyValueFactory<Token, String>("nameToken"));
            leaderBoardMoney.setCellValueFactory(new PropertyValueFactory<Token, Integer>("money"));
            leaderBoardProperties.setCellValueFactory(new PropertyValueFactory<Token, Integer>("numProperties"));

            tableViewLeaderBoard.refresh();
            
        } catch (ListExcepcion e) {
            System.out.println(e.getMessage());
            alert("Nota", e.getMessage());

        }

        
        
    }

    private String[] spliter(String next, String[] format, int contador) {

    	if(contador < 4) {
    		format[contador] =(next.split(" ")[contador]);
    		spliter(next, format, contador + 1);
    	}
    	
		return format;
    
    }

    @FXML
	public void registerWinner() throws NumberFormatException, IOException, NameWinnerExcepcion, ClassNotFoundException{

        BufferedReader br = new BufferedReader(new FileReader("data\\Classification_Board.txt"));
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("data\\Data.txt"));
        nameWinnerExcepcion  = new NameWinnerExcepcion();
        listExcepcion = new ListExcepcion();

        try {

            String vali = br.readLine();

            nameWinnerExcepcion.validateNameWinner(nameRegister.getText());
            listExcepcion.validateList(vali);

            ArrayList<Token> arrayToken = new ArrayList<>();
        

            int index = Integer.parseInt(vali);

            for(int i = 0; i < index; i++){

                String[] format = spliter(br.readLine(), new String[5], 0);

                String namePlayer = format[0];
		        String nameToken = format[1];
		        int money = Integer.parseInt(format[2]);
		        int numProperties = Integer.parseInt(format[3]);


                arrayToken.add(new Token(money, nameToken, numProperties, namePlayer));

            }

            br.close();

            int numProperties = board.getPlayers().get(0).getProperties().size() + board.getPlayers().get(0).getTrains().size() + board.getPlayers().get(0).getPublicServices().size();

            arrayToken.add(new Token (board.getPlayers().get(0).getMoney(), board.getPlayers().get(0).getNameToken(), numProperties, nameRegister.getText()));

            BufferedWriter bw = new BufferedWriter(new FileWriter("data\\Classification_Board.txt"));

            bw.write(arrayToken.size() + "\n");

            for(Token tk : arrayToken){
                bw.write(tk.getNamePlayer() + " " + tk.getNameToken() + " " + tk.getMoney() + " " + tk.getNumProperties() + "\n");

            }

            bw.close();

            localStage.close();
            auxlocalStage.close();
            show(new FXMLLoader(getClass().getResource("screens/main_screen/main.fxml")), new Stage());
            setBoard((Board) ois.readObject());
            ois.close();
            
            
        } catch (NameWinnerExcepcion e) {
            System.out.println(e.getMessage());
            alert("ERROR", e.getMessage());
            
        } catch(ListExcepcion e){
            int numProperties = board.getPlayers().get(0).getProperties().size() + board.getPlayers().get(0).getTrains().size() + board.getPlayers().get(0).getPublicServices().size();

            Token tk = board.getPlayers().get(0);

            BufferedWriter bw = new BufferedWriter(new FileWriter("data\\Classification_Board.txt"));

            bw.write(1 + "\n");
            bw.write(nameRegister.getText() + " " + tk.getNameToken() + " " + tk.getMoney() + " " + numProperties + "\n");
            bw.close();

            localStage.close();
            auxlocalStage.close();
            show(new FXMLLoader(getClass().getResource("screens/main_screen/main.fxml")), new Stage());
            setBoard((Board) ois.readObject());
            ois.close();

        }

    
    }
	
}
