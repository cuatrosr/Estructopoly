package ui;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.excepcion.*;
import model.objects.*;
import model.threads.*;

public abstract class AttributesGUI {

    //**************************************************************************
    // FXML
    @FXML
    protected Pane paneBoat;
    @FXML
    protected Pane paneBox;
    @FXML
    protected Pane paneCar;
    @FXML
    protected Pane paneCat;
    @FXML
    protected Pane paneDog;
    @FXML
    protected Pane paneHat;
    @FXML
    protected Pane paneHole;
    @FXML
    protected Pane paneShoes;
    @FXML
    protected CheckBox checkBoat;
    @FXML
    protected CheckBox checkBox;
    @FXML
    protected CheckBox checkCar;
    @FXML
    protected CheckBox checkCat;
    @FXML
    protected CheckBox checkDog;
    @FXML
    protected CheckBox checkHat;
    @FXML
    protected CheckBox checkHole;
    @FXML
    protected CheckBox checkShoes;
    @FXML
    protected ImageView tokenHat;
    @FXML
    protected ImageView tokenShoes;
    @FXML
    protected ImageView tokenHole;
    @FXML
    protected ImageView tokenBox;
    @FXML
    protected ImageView tokenCar;
    @FXML
    protected ImageView tokenBoat;
    @FXML
    protected ImageView tokenDog;
    @FXML
    protected ImageView tokenCat;
    @FXML
    protected ImageView imageWild;
    @FXML
    protected ImageView imageProperti;
    @FXML
    protected ImageView dice1;
    @FXML
    protected ImageView dice2;
    @FXML
    protected ImageView imageViewBox;
    @FXML
    protected ImageView imageViewCar;
    @FXML
    protected ImageView imageViewCat;
    @FXML
    protected ImageView imageViewDog;
    @FXML
    protected ImageView imageViewHat;
    @FXML
    protected ImageView imageViewHole;
    @FXML
    protected ImageView imageViewShoes;
    @FXML
    protected ImageView imageViewBoat;
    @FXML
    protected ImageView imageViewSanLuisN;
    @FXML
    protected ImageView imageViewSanLuisS;
    @FXML
    protected ImageView imageViewFormosaE;
    @FXML
    protected ImageView imageViewFormosaN;
    @FXML
    protected ImageView imageViewFormosaS;
    @FXML
    protected ImageView imageViewSanJuanE;
    @FXML
    protected ImageView imageViewSanJuanS;
    @FXML
    protected ImageView imageViewSanJuanN;
    @FXML
    protected ImageView imageViewNeuquenE;
    @FXML
    protected ImageView imageViewNeuquenS;
    @FXML
    protected ImageView imageViewNeuquenN;
    @FXML
    protected ImageView imageViewMendozaE;
    @FXML
    protected ImageView imageViewMendozaS;
    @FXML
    protected ImageView imageViewMendozaN;
    @FXML
    protected ImageView imageViewSantaFeE;
    @FXML
    protected ImageView imageViewSantaFeS;
    @FXML
    protected ImageView imageViewSantaFeN;
    @FXML
    protected ImageView imageViewCordobaE;
    @FXML
    protected ImageView imageViewCordobaS;
    @FXML
    protected ImageView imageViewCordobaN;
    @FXML
    protected ImageView imageViewBuenosAiresN;
    @FXML
    protected ImageView imageViewBuenosAiresS;
    @FXML
    protected ImageView imageViewTrenN;
    @FXML
    protected ImageView imageViewTrenE;
    @FXML
    protected ImageView imageViewTrenO;
    @FXML
    protected ImageView imageViewTrenS;
    @FXML
    protected ImageView imageViewWater;
    @FXML
    protected ImageView imageViewEnergi;
    @FXML
    protected ImageView house44;
    @FXML
    protected ImageView house43;
    @FXML
    protected ImageView house42;
    @FXML
    protected ImageView house41;
    @FXML
    protected ImageView hotel12;
    @FXML
    protected ImageView house48;
    @FXML
    protected ImageView house47;
    @FXML
    protected ImageView house46;
    @FXML
    protected ImageView house45;
    @FXML
    protected ImageView hotel13;
    @FXML
    protected ImageView house52;
    @FXML
    protected ImageView house51;
    @FXML
    protected ImageView house50;
    @FXML
    protected ImageView house49;
    @FXML
    protected ImageView hotel14;
    @FXML
    protected ImageView house56;
    @FXML
    protected ImageView house55;
    @FXML
    protected ImageView house54;
    @FXML
    protected ImageView house53;
    @FXML
    protected ImageView hotel15;
    @FXML
    protected ImageView house60;
    @FXML
    protected ImageView house59;
    @FXML
    protected ImageView house58;
    @FXML
    protected ImageView house57;
    @FXML
    protected ImageView hotel16;
    @FXML
    protected ImageView house64;
    @FXML
    protected ImageView house63;
    @FXML
    protected ImageView house62;
    @FXML
    protected ImageView house61;
    @FXML
    protected ImageView hotel17;
    @FXML
    protected ImageView house40;
    @FXML
    protected ImageView house39;
    @FXML
    protected ImageView house38;
    @FXML
    protected ImageView house37;
    @FXML
    protected ImageView hotel11;
    @FXML
    protected ImageView house36;
    @FXML
    protected ImageView house35;
    @FXML
    protected ImageView house34;
    @FXML
    protected ImageView house33;
    @FXML
    protected ImageView hotel10;
    @FXML
    protected ImageView house32;
    @FXML
    protected ImageView house31;
    @FXML
    protected ImageView house30;
    @FXML
    protected ImageView house29;
    @FXML
    protected ImageView hotel9;
    @FXML
    protected ImageView hotel8;
    @FXML
    protected ImageView house28;
    @FXML
    protected ImageView house27;
    @FXML
    protected ImageView house26;
    @FXML
    protected ImageView house25;
    @FXML
    protected ImageView hotel7;
    @FXML
    protected ImageView house24;
    @FXML
    protected ImageView house23;
    @FXML
    protected ImageView house22;
    @FXML
    protected ImageView house21;
    @FXML
    protected ImageView hotel6;
    @FXML
    protected ImageView house17;
    @FXML
    protected ImageView house18;
    @FXML
    protected ImageView house19;
    @FXML
    protected ImageView house20;
    @FXML
    protected ImageView hotel5;
    @FXML
    protected ImageView house13;
    @FXML
    protected ImageView house14;
    @FXML
    protected ImageView house15;
    @FXML
    protected ImageView house16;
    @FXML
    protected ImageView hotel4;
    @FXML
    protected ImageView house9;
    @FXML
    protected ImageView house10;
    @FXML
    protected ImageView house11;
    @FXML
    protected ImageView house12;
    @FXML
    protected ImageView hotel3;
    @FXML
    protected ImageView house5;
    @FXML
    protected ImageView house6;
    @FXML
    protected ImageView house7;
    @FXML
    protected ImageView house8;
    @FXML
    protected ImageView hotel2;
    @FXML
    protected ImageView house1;
    @FXML
    protected ImageView house2;
    @FXML
    protected ImageView house3;
    @FXML
    protected ImageView house4;
    @FXML
    protected ImageView hotel1;
    @FXML
    protected ImageView house81;
    @FXML
    protected ImageView house82;
    @FXML
    protected ImageView house83;
    @FXML
    protected ImageView house84;
    @FXML
    protected ImageView hotel22;
    @FXML
    protected ImageView house77;
    @FXML
    protected ImageView house78;
    @FXML
    protected ImageView house79;
    @FXML
    protected ImageView house80;
    @FXML
    protected ImageView hotel21;
    @FXML
    protected ImageView house73;
    @FXML
    protected ImageView house74;
    @FXML
    protected ImageView house75;
    @FXML
    protected ImageView house76;
    @FXML
    protected ImageView hotel20;
    @FXML
    protected ImageView house69;
    @FXML
    protected ImageView house70;
    @FXML
    protected ImageView house71;
    @FXML
    protected ImageView house72;
    @FXML
    protected ImageView hotel19;
    @FXML
    protected ImageView house65;
    @FXML
    protected ImageView house66;
    @FXML
    protected ImageView house67;
    @FXML
    protected ImageView house68;
    @FXML
    protected ImageView house85;
    @FXML
    protected ImageView house86;
    @FXML
    protected ImageView house87;
    @FXML
    protected ImageView house88;
    @FXML
    protected ImageView hotel18;
    @FXML
    protected Label numDice;
    @FXML
    protected Label moneyBox;
    @FXML
    protected Label moneyCat;
    @FXML
    protected Label moneyDog;
    @FXML
    protected Label moneyHole;
    @FXML
    protected Label moneyBoat;
    @FXML
    protected Label moneyCar;
    @FXML
    protected Label moneyHat;
    @FXML
    protected Label moneyShoes;
    @FXML
    protected Label labelPayJail;
    @FXML
    protected Label costPropertie;
    @FXML
    protected TextArea registerLabel;
    @FXML
    protected Button buttonRollDice;
    @FXML
    protected Button buttomViewPropertie;
    @FXML
    protected GridPane gridPaneGame;
    @FXML
    protected ComboBox<String> choicePurchasers;
    @FXML
    protected ComboBox<String> choisePrBidder;
    @FXML
    protected TextField moneyBidder;
    @FXML
    protected ComboBox<String> choisePrPurchaser;
    @FXML
    protected TextField moneyPurchaser;
    @FXML
    protected TextField nameRegister;
    @FXML
    protected TableView<Properties> tableViewPrBidder;
    @FXML
    protected TableColumn<Properties, String> namePrBidder;
    @FXML
    protected TableView<Properties> tableViewPrPurchaser;
    @FXML
    protected TableColumn<Properties, String> namePrPurchaser;
    @FXML
    protected TableView<Properties> tableViewMortgage;
    @FXML
    protected TableColumn<Properties, String> nameProperties;
    @FXML
    protected TableColumn<Properties, Integer> mortgagePropertie;
    @FXML
    protected Label labelMortgageTotal;
    @FXML
    protected ComboBox<String> choisMortgageProperties;
    @FXML
    protected BarChart<String, Number> chartPatrimony;
    @FXML
    protected CategoryAxis axisNameToken;
    @FXML
    protected NumberAxis axisMoney;
    @FXML
    protected TableView<Token> tableViewLeaderBoard;
    @FXML
    protected TableColumn<Token, String> leaderBoardName;
    @FXML
    protected TableColumn<Token, String> leaderBoardToken;
    @FXML
    protected TableColumn<Token, Integer> leaderBoardMoney;
    @FXML
    protected TableColumn<Token, Integer> leaderBoardProperties;

    //**************************************************************************
    // Attributes
    protected final int TOTALMONEY = 1500;
    protected final int TRY = 10;
    protected Stage localStage;
    protected Stage auxlocalStage;
    protected Board board;
    protected Properties auxPropertie;
    protected WildCardsThreads threadWildCards;
    protected PropertiesThreads threadProperties;
    protected CommunThreads threadCommun;
    protected PanesOrderingThreads threadPanesOrdering;
    protected PublicServicesThreads threadPublicServices;
    protected TrainThreads threadTrain;
    protected ImageOrderingThreads threadImageOrdering;
    protected PlayerProperties threadPlayerProperties;
    protected DealThreads threadsDeal;
    protected boolean valiAction = true;
    protected ComboBoxExcepcion comboBoxExcepcion;
    protected PlayerExcepcion playerExcepcion;
    protected NameWinnerExcepcion nameWinnerExcepcion;
    protected ListExcepcion listExcepcion;

}
