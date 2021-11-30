package ui;

import model.data_structures.graph.Graph;
import model.objects.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import model.interface_class.HashTable;
import model.interface_class.Queue;

public class Load {

    private static ObjectOutputStream oos;

    public Load() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
        escribir();
    }

    public static void escribir() throws IOException, ClassNotFoundException, Exception {

        Jail jail = new Jail(10);
        Board board = new Board(jail);
        Graph<Square> g = board.getGameBoard();
        HashTable<String, Properties> ht = board.getPropertiesHash();

        int[] valors = {10, 30, 90, 160, 250};
        CommunSquare c = new CommunSquare(0);
        Properties p = new Properties("ui/images/properties/1-AvMedFront.png", 60, 2, valors, 50, 30, 1, 0, 2, "Avenida Mediterraneo");
        g.addEdge(c, p, 1);
        ht.insert("Avenida Mediterraneo", p);

        CommunityServiceCards cs = new CommunityServiceCards(2);
        g.addEdge(p, cs, 1);

        valors = new int[]{20, 60, 180, 320, 450};
        p = new Properties("ui/images/properties/2-AvBaltFront.png", 60, 4, valors, 50, 30, 3, 0, 2, "Avenida Baltica");
        g.addEdge(cs, p, 1);
        ht.insert("Avenida Baltica", p);

        Taxes t = new Taxes(4, 200);
        g.addEdge(p, t, 1);

        Train tr = new Train(5, "ui/images/properties/3-FerReadFront.png", 200, 25, 100, "Ferrocarril Reading");
        g.addEdge(t, tr, 1);

        valors = new int[]{30, 90, 270, 400, 550};
        p = new Properties("ui/images/properties/4-AvOrtFront.png", 100, 6, valors, 50, 50, 6, 1, 3, "Avenida Oriental");
        g.addEdge(tr, p, 1);
        ht.insert("Avenida Oriental", p);

        FortuneCards f = new FortuneCards(7);
        g.addEdge(p, f, 1);

        p = new Properties("ui/images/properties/5-AvVermFront.png", 100, 6, valors, 50, 50, 8, 1, 3, "Avenida Vermont");
        g.addEdge(f, p, 1);
        ht.insert("Avenida Vermont", p);

        valors = new int[]{40, 100, 300, 450, 600};
        Properties auxP = new Properties("ui/images/properties/6-AvCtcFront.png", 120, 8, valors, 50, 60, 9, 1, 3, "Avenida Connecticut");
        g.addEdge(p, auxP, 1);
        ht.insert("Avenida Connecticut", auxP);

        g.addEdge(auxP, jail, 1);

        valors = new int[]{50, 150, 450, 625, 750};
        p = new Properties("ui/images/properties/7-PlStCrlFront.png", 140, 10, valors, 100, 70, 11, 2, 3, "Plaza San Carlos");
        g.addEdge(jail, p, 1);
        ht.insert("Plaza San Carlos", p);

        PublicServices ps = new PublicServices("ui/images/properties/8-ElecFront.png", 150, 12, 75, "Electricidad");
        g.addEdge(p, ps, 1);

        p = new Properties("ui/images/properties/9-AvEstFront.png", 140, 10, valors, 100, 70, 13, 2, 3, "Avenida Estados");
        g.addEdge(ps, p, 1);
        ht.insert("Avenida Estados", p);

        valors = new int[]{60, 180, 500, 700, 900};
        auxP = new Properties("ui/images/properties/10-AvVirgFront.png", 160, 12, valors, 100, 80, 14, 2, 3, "Avenida Virginia");
        g.addEdge(p, auxP, 1);
        ht.insert("Avenida Virginia", auxP);

        tr = new Train(15, "ui/images/properties/11-FerPennFront.png", 200, 25, 100, "Ferrocarril Pennsylvania");
        g.addEdge(auxP, tr, 1);

        valors = new int[]{70, 200, 550, 750, 950};
        p = new Properties("ui/images/properties/12-PlStJmsFront.png", 180, 14, valors, 100, 90, 16, 3, 3, "Plaza ST. James");
        g.addEdge(tr, p, 1);
        ht.insert("Plaza ST. James", p);

        cs = new CommunityServiceCards(17);
        g.addEdge(p, cs, 1);

        p = new Properties("ui/images/properties/13-AvTnssFront.png", 180, 14, valors, 100, 90, 18, 3, 3, "Avenida Tennessee");
        g.addEdge(cs, p, 1);
        ht.insert("Avenida Tennessee", p);

        valors = new int[]{80, 220, 600, 800, 1000};
        auxP = new Properties("ui/images/properties/14-AvNYFront.png", 200, 16, valors, 100, 100, 19, 3, 3, "Avenida Nueva York");
        g.addEdge(p, auxP, 1);
        ht.insert("Avenida Nueva York", auxP);

        CommunSquare auxC = new CommunSquare(20);
        g.addEdge(auxP, auxC, 1);

        valors = new int[]{90, 250, 700, 875, 1050};
        p = new Properties("ui/images/properties/15-AvKtckFront.png", 220, 18, valors, 150, 100, 21, 4, 3, "Avenida Kentucky");
        g.addEdge(auxC, p, 1);
        ht.insert("Avenida Kentucky", p);

        f = new FortuneCards(22);
        g.addEdge(p, f, 1);

        p = new Properties("ui/images/properties/16-AvIndiFront.png", 220, 18, valors, 150, 100, 23, 4, 3, "Avenida Indiana");
        g.addEdge(f, p, 1);
        ht.insert("Avenida Indiana", p);

        valors = new int[]{100, 300, 750, 925, 1100};
        auxP = new Properties("ui/images/properties/17-AvIlliFront.png", 240, 20, valors, 150, 120, 24, 4, 3, "Avenida Illinois");
        g.addEdge(p, auxP, 1);
        ht.insert("Avenida Illinois", auxP);

        tr = new Train(25, "ui/images/properties/18-FerB&OFront.png", 200, 25, 100, "Ferrocarril B&O");
        g.addEdge(auxP, tr, 1);

        valors = new int[]{110, 330, 800, 975, 1150};
        p = new Properties("ui/images/properties/19-AvAtlFront.png", 260, 22, valors, 150, 130, 26, 5, 3, "Avenida Atlantico");
        g.addEdge(tr, p, 1);
        ht.insert("Avenida Atlantico", p);

        auxP = new Properties("ui/images/properties/20-AvVtnrFront.png", 260, 22, valors, 150, 130, 27, 5, 3, "Avenida Ventnor");
        g.addEdge(p, auxP, 1);
        ht.insert("Avenida Ventnor", auxP);

        ps = new PublicServices("ui/images/properties/21-AguaFront.png", 150, 28, 75, "Agua");
        g.addEdge(auxP, ps, 1);

        valors = new int[]{120, 360, 850, 1025, 1200};
        p = new Properties("ui/images/properties/22-MrvnFront.png", 280, 24, valors, 150, 140, 29, 5, 3, "Jardines Marvin");
        g.addEdge(ps, p, 1);
        ht.insert("Jardines Marvin", p);

        GoJail goJail = new GoJail(30);
        g.addEdge(p, goJail, 1);

        valors = new int[]{130, 390, 900, 1100, 1275};
        p = new Properties("ui/images/properties/23-AvPcfcFront.png", 300, 26, valors, 200, 150, 31, 6, 3, "Avenida Pacifico");
        g.addEdge(goJail, p, 1);
        ht.insert("Avenida Pacifico", p);

        auxP = new Properties("ui/images/properties/24-AvNCFront.png", 300, 26, valors, 200, 150, 32, 6, 3, "Avenida Carolina del Norte");
        g.addEdge(p, auxP, 1);
        ht.insert("Avenida Carolina del Norte", auxP);

        cs = new CommunityServiceCards(33);
        g.addEdge(auxP, cs, 1);

        valors = new int[]{150, 450, 1000, 1200, 1400};
        p = new Properties("ui/images/properties/25-AvPennFront.png", 320, 28, valors, 200, 160, 34, 6, 3, "Avenida Pensilvania");
        g.addEdge(cs, p, 1);
        ht.insert("Avenida Pensilvania", p);

        tr = new Train(35, "ui/images/properties/26-FerVRapFront.png", 200, 25, 100, "Ferrocarril Via Rapida");
        g.addEdge(p, tr, 1);

        f = new FortuneCards(36);
        g.addEdge(tr, f, 1);

        valors = new int[]{175, 500, 1100, 1300, 1500};
        p = new Properties("ui/images/properties/27-PlazaParkFront.png", 350, 35, valors, 200, 175, 37, 7, 2, "Plaza Park");
        g.addEdge(f, p, 1);
        ht.insert("Plaza Park", p);

        t = new Taxes(38, 100);
        g.addEdge(p, t, 1);

        valors = new int[]{200, 600, 1400, 1700, 2000};
        p = new Properties("ui/images/properties/28-TheDockFront.png", 400, 50, valors, 200, 200, 39, 7, 2, "El Muelle");
        g.addEdge(t, p, 1);
        ht.insert("El Muelle", p);

        g.addEdge(p, c, 1);

        Queue<CommunityServiceCards> csc = board.getCommunityServiceCards();
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/1.png", 1));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/2.png", 2));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/3.png", 3));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/4.png", 4));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/5.png", 5));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/6.png", 6));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/7.png", 7));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/8.png", 8));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/9.png", 9));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/10.png", 10));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/11.png", 11));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/12.png", 12));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/13.png", 13));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/14.png", 14));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/15.png", 15));
        csc.enqueue(new CommunityServiceCards("ui/images/cards/community/16.png", 16));

        Queue<FortuneCards> fc = board.getFortuneCards();
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/1.png", 1));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/2.png", 2));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/3.png", 3));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/4.png", 4));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/5.png", 5));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/6.png", 6));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/7.png", 7));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/8.png", 8));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/9.png", 9));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/10.png", 10));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/11.png", 11));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/12.png", 12));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/13.png", 13));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/14.png", 14));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/15.png", 15));
        fc.enqueue(new FortuneCards("ui/images/cards/fortune/16.png", 16));

        

        oos = new ObjectOutputStream(new FileOutputStream("data/Data.txt"));
        oos.writeObject(board);
        oos.close();


    }

}
