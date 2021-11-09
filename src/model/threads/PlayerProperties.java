package threads;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import objects.Board;
import objects.Properties;
import objects.PublicServices;
import objects.Train;

public class PlayerProperties extends Thread{
    
    private ImageView imageViewSanLuisN;
    private ImageView imageViewSanLuisS;
    private ImageView imageViewFormosaE;
    private ImageView imageViewFormosaN;
    private ImageView imageViewFormosaS;
    private ImageView imageViewSanJuanE;
    private ImageView imageViewSanJuanS;
    private ImageView imageViewSanJuanN;
    private ImageView imageViewNeuquenE;
    private ImageView imageViewNeuquenS;
    private ImageView imageViewNeuquenN;
    private ImageView imageViewMendozaE;
    private ImageView imageViewMendozaS;
    private ImageView imageViewMendozaN;
    private ImageView imageViewSantaFeE;
    private ImageView imageViewSantaFeS;
    private ImageView imageViewSantaFeN;
    private ImageView imageViewCordobaE;
    private ImageView imageViewCordobaS;
    private ImageView imageViewCordobaN;
    private ImageView imageViewBuenosAiresN;
    private ImageView imageViewBuenosAiresS;
    private ImageView imageViewTrenN;
    private ImageView imageViewTrenE;
    private ImageView imageViewTrenO;
    private ImageView imageViewTrenS;
    private ImageView imageViewWater;
    private ImageView imageViewEnergi;
    private Board board;
    private String player;

    public PlayerProperties(ImageView imageViewSanLuisN, ImageView imageViewSanLuisS, ImageView imageViewFormosaE, ImageView imageViewFormosaN, ImageView imageViewFormosaS, ImageView imageViewSanJuanE, ImageView imageViewSanJuanS, ImageView imageViewSanJuanN, ImageView imageViewNeuquenE, ImageView imageViewNeuquenS, ImageView imageViewNeuquenN, ImageView imageViewMendozaE, ImageView imageViewMendozaS, ImageView imageViewMendozaN, ImageView imageViewSantaFeE, ImageView imageViewSantaFeS, ImageView imageViewSantaFeN, ImageView imageViewCordobaE, ImageView imageViewCordobaS, ImageView imageViewCordobaN, ImageView imageViewBuenosAiresN, ImageView imageViewBuenosAiresS, ImageView imageViewTrenN, ImageView imageViewTrenE, ImageView imageViewTrenO, ImageView imageViewTrenS, ImageView imageViewWater, ImageView imageViewEnergi,Board board, String player) {
        this.imageViewSanLuisN = imageViewSanLuisN;
        this.imageViewSanLuisS = imageViewSanLuisS;
        this.imageViewFormosaE = imageViewFormosaE;
        this.imageViewFormosaN = imageViewFormosaN;
        this.imageViewFormosaS = imageViewFormosaS;
        this.imageViewSanJuanE = imageViewSanJuanE;
        this.imageViewSanJuanS = imageViewSanJuanS;
        this.imageViewSanJuanN = imageViewSanJuanN;
        this.imageViewNeuquenE = imageViewNeuquenE;
        this.imageViewNeuquenS = imageViewNeuquenS;
        this.imageViewNeuquenN = imageViewNeuquenN;
        this.imageViewMendozaE = imageViewMendozaE;
        this.imageViewMendozaS = imageViewMendozaS;
        this.imageViewMendozaN = imageViewMendozaN;
        this.imageViewSantaFeE = imageViewSantaFeE;
        this.imageViewSantaFeS = imageViewSantaFeS;
        this.imageViewSantaFeN = imageViewSantaFeN;
        this.imageViewCordobaE = imageViewCordobaE;
        this.imageViewCordobaS = imageViewCordobaS;
        this.imageViewCordobaN = imageViewCordobaN;
        this.imageViewBuenosAiresN = imageViewBuenosAiresN;
        this.imageViewBuenosAiresS = imageViewBuenosAiresS;
        this.imageViewTrenN = imageViewTrenN;
        this.imageViewTrenE = imageViewTrenE;
        this.imageViewTrenO = imageViewTrenO;
        this.imageViewTrenS = imageViewTrenS;
        this.imageViewWater = imageViewWater;
        this.imageViewEnergi = imageViewEnergi;
        this.board = board;
        this.player = player;
    }

    @Override
    public void run(){

        ArrayList<Properties> pr = board.getPropertiesSquare().toArray();

        for(Train train : board.getTrainSquare().toArray()){
            pr.add(train);

        }

        for(PublicServices ser : board.getPublicServicesSquare().toArray()){
            pr.add(ser);

        }

        for(Properties propertie : pr){
            if(propertie.getOwner() != null && propertie.getOwner().getNameToken() == player){
                onImage(propertie.getImageView());

            }
            
        }

    }

    public void onImage(String index){
        switch(index){
            case "imageViewSanLuisN":
                imageViewSanLuisN.setOpacity(1);
                break;

            case "imageViewSanLuisS":
                imageViewSanLuisS.setOpacity(1);
                break;

            case "imageViewFormosaE":
                imageViewFormosaE.setOpacity(1);
                break;

            case "imageViewFormosaN":
                imageViewFormosaN.setOpacity(1);
                break;

            case "imageViewFormosaS":
                imageViewFormosaS.setOpacity(1);
                break;

            case "imageViewSanJuanE":
                imageViewSanJuanE.setOpacity(1);
                break;

            case "imageViewSanJuanS":
                imageViewSanJuanS.setOpacity(1);
                break;

            case "imageViewSanJuanN":
                imageViewSanJuanN.setOpacity(1);
                break;

            case "imageViewNeuquenE":
                imageViewNeuquenE.setOpacity(1);
                break;

            case "imageViewNeuquenS":
                imageViewNeuquenS.setOpacity(1);
                break;

            case "imageViewNeuquenN":
                imageViewNeuquenN.setOpacity(1);
                break;

            case "imageViewMendozaE":
                imageViewMendozaE.setOpacity(1);
                break;

            case "imageViewMendozaS":
                imageViewMendozaS.setOpacity(1);
                break;

            case "imageViewMendozaN":
                imageViewMendozaN.setOpacity(1);
                break;

            case "imageViewSantaFeE":
                imageViewSantaFeE.setOpacity(1);
                break;

            case "imageViewSantaFeS":
                imageViewSantaFeS.setOpacity(1);
                break;

            case "imageViewSantaFeN":
                imageViewSantaFeN.setOpacity(1);
                break;

            case "imageViewCordobaE":
                imageViewCordobaE.setOpacity(1);
                break;

            case "imageViewCordobaS":
                imageViewCordobaS.setOpacity(1);
                break;

            case "imageViewCordobaN":
                imageViewCordobaN.setOpacity(1);
                break;

            case "imageViewBuenosAiresS":
                imageViewBuenosAiresS.setOpacity(1);
                break;

            case "imageViewBuenosAiresN":
                imageViewBuenosAiresN.setOpacity(1);
                break;

            case "imageViewTrenN":
                imageViewTrenN.setOpacity(1);
                break;

            case "imageViewTrenE":
                imageViewTrenE.setOpacity(1);
                break;

            case "imageViewTrenO":
                imageViewTrenO.setOpacity(1);
                break;

            case "imageViewTrenS":
                imageViewTrenS.setOpacity(1);
                break;

            case "imageViewWater":
                imageViewWater.setOpacity(1);
                break;

            case "imageViewEnergi":
                imageViewEnergi.setOpacity(1);
                break;
                
        }
    }



}
