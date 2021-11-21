package model.threads;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import model.objects.Board;
import model.objects.Properties;

public class HousesAndHotelThreads extends Thread {

    private ImageView house44;
    private ImageView house43;
    private ImageView house42;
    private ImageView house41;
    private ImageView hotel12;
    private ImageView house48;
    private ImageView house47;
    private ImageView house46;
    private ImageView house45;
    private ImageView hotel13;
    private ImageView house52;
    private ImageView house51;
    private ImageView house50;
    private ImageView house49;
    private ImageView hotel14;
    private ImageView house56;
    private ImageView house55;
    private ImageView house54;
    private ImageView house53;
    private ImageView hotel15;
    private ImageView house60;
    private ImageView house59;
    private ImageView house58;
    private ImageView house57;
    private ImageView hotel16;
    private ImageView house64;
    private ImageView house63;
    private ImageView house62;
    private ImageView house61;
    private ImageView hotel17;
    private ImageView house40;
    private ImageView house39;
    private ImageView house38;
    private ImageView house37;
    private ImageView hotel11;
    private ImageView house36;
    private ImageView house35;
    private ImageView house34;
    private ImageView house33;
    private ImageView hotel10;
    private ImageView house32;
    private ImageView house31;
    private ImageView house30;
    private ImageView house29;
    private ImageView hotel9;
    private ImageView hotel8;
    private ImageView house28;
    private ImageView house27;
    private ImageView house26;
    private ImageView house25;
    private ImageView hotel7;
    private ImageView house24;
    private ImageView house23;
    private ImageView house22;
    private ImageView house21;
    private ImageView hotel6;
    private ImageView house17;
    private ImageView house18;
    private ImageView house19;
    private ImageView house20;
    private ImageView hotel5;
    private ImageView house13;
    private ImageView house14;
    private ImageView house15;
    private ImageView house16;
    private ImageView hotel4;
    private ImageView house9;
    private ImageView house10;
    private ImageView house11;
    private ImageView house12;
    private ImageView hotel3;
    private ImageView house5;
    private ImageView house6;
    private ImageView house7;
    private ImageView house8;
    private ImageView hotel2;
    private ImageView house1;
    private ImageView house2;
    private ImageView house3;
    private ImageView house4;
    private ImageView hotel1;
    private ImageView house81;
    private ImageView house82;
    private ImageView house83;
    private ImageView house84;
    private ImageView hotel22;
    private ImageView house77;
    private ImageView house78;
    private ImageView house79;
    private ImageView house80;
    private ImageView hotel21;
    private ImageView house73;
    private ImageView house74;
    private ImageView house75;
    private ImageView house76;
    private ImageView hotel20;
    private ImageView house69;
    private ImageView house70;
    private ImageView house71;
    private ImageView house72;
    private ImageView hotel19;
    private ImageView house65;
    private ImageView house66;
    private ImageView house67;
    private ImageView house68;
    private ImageView hotel18;
    private ImageView house85;
    private ImageView house86;
    private ImageView house87;
    private ImageView house88;
    private Board board;
    private Properties propertie;
    private boolean type;

    public HousesAndHotelThreads(ImageView house44, ImageView house43, ImageView house42, ImageView house41, ImageView hotel12, ImageView house48, ImageView house47, ImageView house46, ImageView house45, ImageView hotel13, ImageView house52, ImageView house51, ImageView house50, ImageView house49, ImageView hotel14, ImageView house56, ImageView house55, ImageView house54, ImageView house53, ImageView hotel15, ImageView house60, ImageView house59, ImageView house58, ImageView house57, ImageView hotel16, ImageView house64, ImageView house63, ImageView house62, ImageView house61, ImageView hotel17, ImageView house40, ImageView house39, ImageView house38, ImageView house37, ImageView hotel11, ImageView house36, ImageView house35, ImageView house34, ImageView house33, ImageView hotel10, ImageView house32, ImageView house31, ImageView house30, ImageView house29, ImageView hotel9, ImageView hotel8, ImageView house28, ImageView house27, ImageView house26, ImageView house25, ImageView hotel7, ImageView house24, ImageView house23, ImageView house22, ImageView house21, ImageView hotel6, ImageView house17, ImageView house18, ImageView house19, ImageView house20, ImageView hotel5, ImageView house13, ImageView house14, ImageView house15, ImageView house16, ImageView hotel4, ImageView house9, ImageView house10, ImageView house11, ImageView house12, ImageView hotel3, ImageView house5, ImageView house6, ImageView house7, ImageView house8, ImageView hotel2, ImageView house1, ImageView house2, ImageView house3, ImageView house4, ImageView hotel1, ImageView house81, ImageView house82, ImageView house83, ImageView house84, ImageView hotel22, ImageView house77, ImageView house78, ImageView house79, ImageView house80, ImageView hotel21, ImageView house73, ImageView house74, ImageView house75, ImageView house76, ImageView hotel20, ImageView house69, ImageView house70, ImageView house71, ImageView house72, ImageView hotel19, ImageView house65, ImageView house66, ImageView house67, ImageView house68, ImageView hotel18, ImageView house85, ImageView house86, ImageView house87, ImageView house88, Board board, Properties propertie, boolean type) {
        this.house44 = house44;
        this.house43 = house43;
        this.house42 = house42;
        this.house41 = house41;
        this.hotel12 = hotel12;
        this.house48 = house48;
        this.house47 = house47;
        this.house46 = house46;
        this.house45 = house45;
        this.hotel13 = hotel13;
        this.house52 = house52;
        this.house51 = house51;
        this.house50 = house50;
        this.house49 = house49;
        this.hotel14 = hotel14;
        this.house56 = house56;
        this.house55 = house55;
        this.house54 = house54;
        this.house53 = house53;
        this.hotel15 = hotel15;
        this.house60 = house60;
        this.house59 = house59;
        this.house58 = house58;
        this.house57 = house57;
        this.hotel16 = hotel16;
        this.house64 = house64;
        this.house63 = house63;
        this.house62 = house62;
        this.house61 = house61;
        this.hotel17 = hotel17;
        this.house40 = house40;
        this.house39 = house39;
        this.house38 = house38;
        this.house37 = house37;
        this.hotel11 = hotel11;
        this.house36 = house36;
        this.house35 = house35;
        this.house34 = house34;
        this.house33 = house33;
        this.hotel10 = hotel10;
        this.house32 = house32;
        this.house31 = house31;
        this.house30 = house30;
        this.house29 = house29;
        this.hotel9 = hotel9;
        this.hotel8 = hotel8;
        this.house28 = house28;
        this.house27 = house27;
        this.house26 = house26;
        this.house25 = house25;
        this.hotel7 = hotel7;
        this.house24 = house24;
        this.house23 = house23;
        this.house22 = house22;
        this.house21 = house21;
        this.hotel6 = hotel6;
        this.house17 = house17;
        this.house18 = house18;
        this.house19 = house19;
        this.house20 = house20;
        this.hotel5 = hotel5;
        this.house13 = house13;
        this.house14 = house14;
        this.house15 = house15;
        this.house16 = house16;
        this.hotel4 = hotel4;
        this.house9 = house9;
        this.house10 = house10;
        this.house11 = house11;
        this.house12 = house12;
        this.hotel3 = hotel3;
        this.house5 = house5;
        this.house6 = house6;
        this.house7 = house7;
        this.house8 = house8;
        this.hotel2 = hotel2;
        this.house1 = house1;
        this.house2 = house2;
        this.house3 = house3;
        this.house4 = house4;
        this.hotel1 = hotel1;
        this.house81 = house81;
        this.house82 = house82;
        this.house83 = house83;
        this.house84 = house84;
        this.hotel22 = hotel22;
        this.house77 = house77;
        this.house78 = house78;
        this.house79 = house79;
        this.house80 = house80;
        this.hotel21 = hotel21;
        this.house73 = house73;
        this.house74 = house74;
        this.house75 = house75;
        this.house76 = house76;
        this.hotel20 = hotel20;
        this.house69 = house69;
        this.house70 = house70;
        this.house71 = house71;
        this.house72 = house72;
        this.hotel19 = hotel19;
        this.house65 = house65;
        this.house66 = house66;
        this.house67 = house67;
        this.house68 = house68;
        this.hotel18 = hotel18;
        this.house85 = house85;
        this.house86 = house86;
        this.house87 = house87;
        this.house88 = house88;
        this.board = board;
        this.propertie = propertie;
        this.type = type;
    }

    @Override
    public void run() {

        ArrayList<ArrayList<ImageView>> arrayFamily = getArray();

        if (type) {

            int sum = 0;

            for (Properties pr : board.getPlayers().get(board.getTurn()).getProperties().toArray()) {

                if (pr.getFamily() == propertie.getFamily()) {
                    sum++;

                    if (sum == propertie.getAmountFamily()) {
                        break;

                    }

                }

            }

            if (sum == propertie.getAmountFamily()) {

                for (int i = propertie.getHierarchy(); i < propertie.getHierarchy() + 4; i++) {
                    if (!(arrayFamily.get(propertie.getFamily() - 1).get(i).isVisible())) {
                        arrayFamily.get(propertie.getFamily() - 1).get(i).setVisible(true);
                        propertie.setHouses(propertie.getHouses() + 1);
                        break;

                    }

                }

            } else {

                alert("Upss", "Parece que no tienes comprada la familia completa");

            }

        } else {

            arrayFamily.get(propertie.getFamily() - 1).get(propertie.getIdHotel()).setVisible(true);

            propertie.setHotel(true);

            for (int i = propertie.getHierarchy(); i < propertie.getHierarchy() + 4; i++) {
                arrayFamily.get(propertie.getFamily() - 1).get(i).setVisible(false);

            }

        }

    }

    private ArrayList<ArrayList<ImageView>> getArray() {

        ArrayList<ImageView> family1 = new ArrayList<>();
        ArrayList<ImageView> family2 = new ArrayList<>();
        ArrayList<ImageView> family3 = new ArrayList<>();
        ArrayList<ImageView> family4 = new ArrayList<>();
        ArrayList<ImageView> family5 = new ArrayList<>();
        ArrayList<ImageView> family6 = new ArrayList<>();
        ArrayList<ImageView> family7 = new ArrayList<>();
        ArrayList<ImageView> family8 = new ArrayList<>();

        family1.add(house1);
        family1.add(house2);
        family1.add(house3);
        family1.add(house4);
        family1.add(house5);
        family1.add(house6);
        family1.add(house7);
        family1.add(house8);
        family1.add(hotel1);
        family1.add(hotel2);

        family2.add(house9);
        family2.add(house10);
        family2.add(house11);
        family2.add(house12);
        family2.add(house13);
        family2.add(house14);
        family2.add(house15);
        family2.add(house16);
        family2.add(house17);
        family2.add(house18);
        family2.add(house19);
        family2.add(house20);
        family2.add(hotel3);
        family2.add(hotel4);
        family2.add(hotel5);

        family3.add(house21);
        family3.add(house22);
        family3.add(house23);
        family3.add(house24);
        family3.add(house25);
        family3.add(house26);
        family3.add(house27);
        family3.add(house28);
        family3.add(house85);
        family3.add(house86);
        family3.add(house87);
        family3.add(house88);
        family3.add(hotel6);
        family3.add(hotel7);
        family3.add(hotel8);

        family4.add(house29);
        family4.add(house30);
        family4.add(house31);
        family4.add(house32);
        family4.add(house33);
        family4.add(house34);
        family4.add(house35);
        family4.add(house36);
        family4.add(house37);
        family4.add(house38);
        family4.add(house39);
        family4.add(house40);
        family4.add(hotel9);
        family4.add(hotel10);
        family4.add(hotel11);

        family5.add(house41);
        family5.add(house42);
        family5.add(house43);
        family5.add(house44);
        family5.add(house45);
        family5.add(house46);
        family5.add(house47);
        family5.add(house48);
        family5.add(house49);
        family5.add(house50);
        family5.add(house51);
        family5.add(house52);
        family5.add(hotel12);
        family5.add(hotel13);
        family5.add(hotel14);

        family6.add(house53);
        family6.add(house54);
        family6.add(house55);
        family6.add(house56);
        family6.add(house57);
        family6.add(house58);
        family6.add(house59);
        family6.add(house60);
        family6.add(house61);
        family6.add(house62);
        family6.add(house63);
        family6.add(house64);
        family6.add(hotel15);
        family6.add(hotel16);
        family6.add(hotel17);

        family7.add(house65);
        family7.add(house66);
        family7.add(house67);
        family7.add(house68);
        family7.add(house69);
        family7.add(house70);
        family7.add(house71);
        family7.add(house72);
        family7.add(house73);
        family7.add(house74);
        family7.add(house75);
        family7.add(house76);
        family7.add(hotel18);
        family7.add(hotel19);
        family7.add(hotel20);

        family8.add(house77);
        family8.add(house78);
        family8.add(house79);
        family8.add(house80);
        family8.add(house81);
        family8.add(house82);
        family8.add(house83);
        family8.add(house84);
        family8.add(hotel21);
        family8.add(hotel22);

        ArrayList<ArrayList<ImageView>> arrayFamily = new ArrayList<>();

        arrayFamily.add(family1);
        arrayFamily.add(family2);
        arrayFamily.add(family3);
        arrayFamily.add(family4);
        arrayFamily.add(family5);
        arrayFamily.add(family6);
        arrayFamily.add(family7);
        arrayFamily.add(family8);

        return arrayFamily;

    }

    private void alert(String title, String mss) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(mss);
        alert.showAndWait();

    }

}
