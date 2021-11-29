package ui;

import model.data_structures.graph.Graph;
import model.objects.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Load {

    private static ObjectOutputStream oos;

    public Load() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        escribir();
    }

    public static void escribir() throws IOException, ClassNotFoundException {

        Jail jail = new Jail(10);
        Board board = new Board(jail);
        Graph<Square> g = board.getGameBoard();

        int[] valors = {10, 30, 90, 160, 250};
        CommunSquare c = new CommunSquare(0);
        Properties p = new Properties("", 60, 2, valors, 50, 30, 1, 0, 2, "Avenida Mediterraneo");
        g.addEdge(c, p, 1);

        CommunityServiceCards cs = new CommunityServiceCards(2);
        g.addEdge(p, cs, 1);

        valors = new int[]{20, 60, 180, 320, 450};
        p = new Properties("", 60, 4, valors, 50, 30, 3, 0, 2, "Avenida Baltica");
        g.addEdge(cs, p, 1);

        Taxes t = new Taxes(4, 200);
        g.addEdge(p, t, 1);

        Train tr = new Train(5, "", 200, 25, 100, "Ferrocarril Reading");
        g.addEdge(t, tr, 1);

        valors = new int[]{30, 90, 270, 400, 550};
        p = new Properties("", 100, 6, valors, 50, 50, 6, 1, 3, "Avenida Oriental");
        g.addEdge(tr, p, 1);

        FortuneCards f = new FortuneCards(7);
        g.addEdge(p, f, 1);

        p = new Properties("", 100, 6, valors, 50, 50, 8, 1, 3, "Avenida Vermont");
        g.addEdge(f, p, 1);

        valors = new int[]{40, 100, 300, 450, 600};
        Properties auxP = new Properties("", 120, 8, valors, 50, 60, 9, 1, 3, "Avenida Connecticut");
        g.addEdge(p, auxP, 1);

        g.addEdge(auxP, jail, 1);

        valors = new int[]{50, 150, 450, 625, 750};
        p = new Properties("", 140, 10, valors, 100, 70, 11, 2, 3, "Plaza San Carlos");
        g.addEdge(jail, p, 1);

        PublicServices ps = new PublicServices("", 150, 12, 75, "Electricidad");
        g.addEdge(p, ps, 1);

        p = new Properties("", 140, 10, valors, 100, 70, 13, 2, 3, "Avenida Estados");
        g.addEdge(ps, p, 1);

        valors = new int[]{60, 180, 500, 700, 900};
        auxP = new Properties("", 160, 12, valors, 100, 80, 14, 2, 3, "Avenida Virginia");
        g.addEdge(p, auxP, 1);

        tr = new Train(15, "", 200, 25, 100, "Ferrocarril Pennsylvania");
        g.addEdge(auxP, tr, 1);

        valors = new int[]{70, 200, 550, 750, 950};
        p = new Properties("", 180, 14, valors, 100, 90, 16, 3, 3, "Plaza ST. James");
        g.addEdge(tr, p, 1);

        cs = new CommunityServiceCards(17);
        g.addEdge(p, cs, 1);

        p = new Properties("", 180, 14, valors, 100, 90, 18, 3, 3, "Avenida Tennessee");
        g.addEdge(cs, p, 1);

        valors = new int[]{80, 220, 600, 800, 1000};
        auxP = new Properties("", 200, 16, valors, 100, 100, 19, 3, 3, "Avenida Nueva York");
        g.addEdge(p, auxP, 1);

        CommunSquare auxC = new CommunSquare(20);
        g.addEdge(auxP, auxC, 1);

        valors = new int[]{90, 250, 700, 875, 1050};
        p = new Properties("", 220, 18, valors, 150, 100, 21, 4, 3, "Avenida Kentucky");
        g.addEdge(auxC, p, 1);

        f = new FortuneCards(22);
        g.addEdge(p, f, 1);

        p = new Properties("", 220, 18, valors, 150, 100, 23, 4, 3, "Avenida Indiana");
        g.addEdge(f, p, 1);

        valors = new int[]{100, 300, 750, 925, 1100};
        auxP = new Properties("", 240, 20, valors, 150, 120, 24, 4, 3, "Avenida Illinois");
        g.addEdge(p, auxP, 1);

        tr = new Train(25, "", 200, 25, 100, "Ferrocarril B&O");
        g.addEdge(auxP, tr, 1);

        valors = new int[]{110, 330, 800, 975, 1150};
        p = new Properties("", 260, 22, valors, 150, 130, 26, 5, 3, "Avenida Atlantico");
        g.addEdge(tr, p, 1);

        auxP = new Properties("", 260, 22, valors, 150, 130, 27, 5, 3, "Avenida Ventnor");
        g.addEdge(p, auxP, 1);

        ps = new PublicServices("", 150, 28, 75, "Agua");
        g.addEdge(auxP, ps, 1);

        valors = new int[]{120, 360, 850, 1025, 1200};
        p = new Properties("", 280, 24, valors, 150, 140, 29, 5, 3, "Jardines Marvin");
        g.addEdge(ps, p, 1);

        GoJail goJail = new GoJail(30);
        g.addEdge(p, goJail, 1);

        p = new Properties("", 300, 26, valors, 200, 150, 31, 6, 3, "Avenida Pacifico");
        g.addEdge(goJail, p, 1);

        auxP = new Properties("", 300, 26, valors, 200, 150, 32, 6, 3, "Avenida Carolina del Norte");
        g.addEdge(p, auxP, 1);

        cs = new CommunityServiceCards(33);
        g.addEdge(auxP, cs, 1);

        p = new Properties("", 320, 28, valors, 200, 160, 34, 6, 3, "Avenida Pensilvania");
        g.addEdge(cs, p, 1);

        tr = new Train(35, "", 200, 25, 100, "Ferrocarril Via Rapida");
        g.addEdge(p, tr, 1);

        f = new FortuneCards(36);
        g.addEdge(tr, f, 1);

        p = new Properties("", 350, 35, valors, 200, 175, 37, 7, 2, "Plaza Park");
        g.addEdge(f, p, 1);

        t = new Taxes(38, 100);
        g.addEdge(p, t, 1);

        p = new Properties("", 400, 50, valors, 200, 200, 39, 7, 2, "El Muelle");
        g.addEdge(t, p, 1);

        g.addEdge(p, c, 1);

        /*
        oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
        oos.writeObject(board);
        oos.close();

         */
    }

}
