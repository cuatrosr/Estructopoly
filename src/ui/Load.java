package ui;

import model.objects.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Load {

    private ObjectOutputStream oos;
    private Board board;

    public Load() {
    }

    public void escribir() throws IOException, ClassNotFoundException {

        board = new Board();
        board.getCommunSquare().add(new CommunSquare(0, 2, 1, 0));
        int[] valors1 = {10, 30, 90, 160, 250};
        board.getPropertiesSquare().add(new Properties("/images/properties/SanLuisNorte.jpg", 60, 2, valors1, 50, 30, 1, 0, "imageViewSanLuisN", 1, 2, 0, "San Luis Norte", 8));
        board.getWildCardsSquare().add(new WildCards(2, 1, true));
        int[] valors3 = {20, 60, 180, 320, 450};
        board.getPropertiesSquare().add(new Properties("/images/properties/SanLuisSur.jpg", 60, 4, valors3, 50, 30, 3, 0, "imageViewSanLuisS", 1, 2, 4, "San Luis Sur", 9));
        board.getCommunSquare().add(new CommunSquare(4, 2, 5, 200));
        board.getTrainSquare().add(new Train("/images/properties/TrenNorte.jpg", 200, 25, 5, 0, 100, "imageViewTrenN", "Tren del Norte"));
        int[] valors6 = {30, 90, 270, 400, 550};
        board.getPropertiesSquare().add(new Properties("/images/properties/FormosaEste.jpg", 100, 6, valors6, 50, 50, 6, 0, "imageViewFormosaE", 2, 3, 0, "Formosa Este", 12));
        board.getWildCardsSquare().add(new WildCards(7, 1, false));
        board.getPropertiesSquare().add(new Properties("/images/properties/FormosaNorte.jpg", 100, 6, valors6, 50, 50, 8, 0, "imageViewFormosaN", 2, 3, 4, "Formosa Norte", 13));
        int[] valors7 = {40, 100, 300, 450, 600};
        board.getPropertiesSquare().add(new Properties("/images/properties/FormosaSur.jpg", 120, 8, valors7, 50, 60, 9, 0, "imageViewFormosaS", 2, 3, 8, "Formosa Sur", 14));
        board.getCommunSquare().add(new CommunSquare(10, 2, 3, 0));
        int[] valors8 = {50, 150, 450, 625, 750};
        board.getPropertiesSquare().add(new Properties("/images/properties/SanJuanEste.jpg", 140, 10, valors8, 100, 70, 11, 0, "imageViewSanJuanE", 3, 3, 0, "San Juan Este", 12));
        board.getPublicServicesSquare().add(new PublicServices("/images/properties/Electricidad.jpg", 150, 12, 0, 75, "imageViewEnergi", "Electricidad"));
        board.getPropertiesSquare().add(new Properties("/images/properties/SanJuanSur.jpg", 140, 10, valors8, 100, 70, 13, 0, "imageViewSanJuanS", 3, 3, 4, "San Juan Sur", 13));
        int[] valors10 = {60, 80, 500, 700, 900};
        board.getPropertiesSquare().add(new Properties("/images/properties/SanJuanNorte.jpg", 160, 12, valors10, 100, 80, 14, 0, "imageViewSanJuanN", 3, 3, 8, "San Juan Norte", 14));
        board.getTrainSquare().add(new Train("/images/properties/TrenOeste.jpg", 200, 25, 15, 0, 100, "imageViewTrenO", "Tren del Oeste"));
        int[] valors11 = {70, 200, 550, 750, 950};
        board.getPropertiesSquare().add(new Properties("/images/properties/NeuquenEste.jpg", 180, 14, valors11, 100, 90, 16, 0, "imageViewNeuquenE", 4, 3, 0, "Neuquen Este", 12));
        board.getWildCardsSquare().add(new WildCards(17, 1, true));
        board.getPropertiesSquare().add(new Properties("/images/properties/NeuquenSur.jpg", 180, 14, valors11, 100, 90, 18, 0, "imageViewNeuquenS", 4, 3, 4, "Neuquen Sur", 13));
        int[] valors12 = {80, 220, 600, 800, 1000};
        board.getPropertiesSquare().add(new Properties("/images/properties/NeuquenNorte.jpg", 200, 16, valors12, 100, 100, 19, 0, "imageViewNeuquenN", 4, 3, 8, "Neuquen Norte", 14));
        board.getCommunSquare().add(new CommunSquare(20, 2, 4, 0));
        int[] valors13 = {90, 250, 700, 875, 1050};
        board.getPropertiesSquare().add(new Properties("/images/properties/MendozaEste.jpg", 220, 18, valors13, 150, 110, 21, 0, "imageViewMendozaE", 5, 3, 0, "Mendoza Este", 12));
        board.getWildCardsSquare().add(new WildCards(22, 1, false));
        board.getPropertiesSquare().add(new Properties("/images/properties/MendozaSur.jpg", 220, 18, valors13, 150, 110, 23, 0, "imageViewMendozaS", 5, 3, 4, "Mendoza Sur", 13));
        int[] valors15 = {100, 300, 750, 925, 1100};
        board.getPropertiesSquare().add(new Properties("/images/properties/MendozaNorte.jpg", 240, 20, valors15, 150, 120, 24, 0, "imageViewMendozaN", 5, 3, 8, "Mendoza Norte", 14));
        board.getTrainSquare().add(new Train("/images/properties/TrenEste.jpg", 200, 25, 25, 0, 100, "imageViewTrenE", "Tren del Este"));
        int[] valors16 = {110, 330, 800, 975, 1150};
        board.getPropertiesSquare().add(new Properties("/images/properties/SantaFeEste.jpg", 260, 22, valors16, 150, 130, 26, 0, "imageViewSantaFeE", 6, 3, 0, "Santa Fe Este", 12));
        board.getPropertiesSquare().add(new Properties("/images/properties/SantaFeSur.jpg", 260, 22, valors16, 150, 130, 27, 0, "imageViewSantaFeS", 6, 3, 4, "Santa Fe Sur", 13));
        board.getPublicServicesSquare().add(new PublicServices("/images/properties/Agua.jpg", 150, 28, 0, 75, "imageViewWater", "Agua"));//ajustar
        int[] valors17 = {120, 360, 850, 1025, 1200};
        board.getPropertiesSquare().add(new Properties("/images/properties/SantaFeNorte.jpg", 280, 24, valors17, 150, 140, 29, 0, "imageViewSantaFeN", 6, 3, 8, "Santa Fe Norte", 14));
        board.getCommunSquare().add(new CommunSquare(30, 2, 2, 0));
        int[] valors18 = {130, 390, 900, 1100, 1275};
        board.getPropertiesSquare().add(new Properties("/images/properties/CordobaEste.jpg", 300, 26, valors18, 200, 150, 31, 0, "imageViewCordobaE", 7, 3, 0, "Cordoba Este", 12));
        board.getPropertiesSquare().add(new Properties("/images/properties/CordobaSur.jpg", 300, 26, valors18, 200, 150, 32, 0, "imageViewCordobaS", 7, 3, 4, "Cordoba Sur", 13));
        board.getWildCardsSquare().add(new WildCards(33, 1, true));
        int[] valors20 = {150, 450, 1000, 1200, 1400};
        board.getPropertiesSquare().add(new Properties("/images/properties/CordobaNorte.jpg", 320, 28, valors20, 200, 160, 34, 0, "imageViewCordobaN", 7, 3, 8, "Cordoba Norte", 14));
        board.getTrainSquare().add(new Train("/images/properties/TrenSur.jpg", 200, 25, 5, 0, 100, "imageViewTrenS", "Tren del Sur"));
        board.getWildCardsSquare().add(new WildCards(36, 1, false));
        int[] valors21 = {175, 500, 1100, 1300, 1500};
        board.getPropertiesSquare().add(new Properties("/images/properties/BuenosAiresNorte.jpg", 350, 35, valors21, 200, 175, 37, 0, "imageViewBuenosAiresN", 8, 2, 0, "Buenos Aires Norte", 8));
        board.getCommunSquare().add(new CommunSquare(38, 2, 5, 75));
        int[] valors22 = {200, 600, 1400, 1700, 2000};
        board.getPropertiesSquare().add(new Properties("/images/properties/BuenosAiresSur.jpg", 400, 50, valors22, 200, 200, 39, 0, "imageViewBuenosAiresS", 8, 2, 4, "Buenos Aires Sur", 9));

        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/7.jpg", 7));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/1.jpg", 1));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/2.jpg", 2));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/5.jpg", 5));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/3.jpg", 3));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/4.jpg", 4));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/6.jpg", 6));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/9.jpg", 9));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/8.jpg", 8));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/10.jpg", 10));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/11.jpg", 11));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/13.jpg", 13));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/14.jpg", 14));
        board.getCommunityServiceCards().add(new CommunityServiceCards("/images/cards/community/12.jpg", 12));

        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/7.jpg", 7));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/1.jpg", 1));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/2.jpg", 2));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/13.jpg", 13));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/5.jpg", 5));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/10.jpg", 10));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/6.jpg", 6));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/8.jpg", 8));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/4.jpg", 4));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/9.jpg", 9));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/11.jpg", 11));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/12.jpg", 12));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/3.jpg", 3));
        board.getFortuneCards().add(new FortuneCards("/images/cards/fortune/14.jpg", 14));

        oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
        oos.writeObject(board);
        oos.close();

    }

}
