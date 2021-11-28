package model.data_structures.graph;

import model.objects.CommunSquare;
import model.objects.Square;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {

    public Graph<Square> g;

    void setup1() {
        g = new Graph<>(5);
        g.addEdge(new CommunSquare(0), new CommunSquare(1), 15);
        g.addEdge(new CommunSquare(1), new CommunSquare(0), 15);
        g.addEdge(new CommunSquare(0), new CommunSquare(2), 11);
        g.addEdge(new CommunSquare(2), new CommunSquare(0), 11);
        g.addEdge(new CommunSquare(1), new CommunSquare(2), 12);
        g.addEdge(new CommunSquare(2), new CommunSquare(1), 12);
        g.addEdge(new CommunSquare(1), new CommunSquare(3), 14);
        g.addEdge(new CommunSquare(3), new CommunSquare(1), 14);
        g.addEdge(new CommunSquare(1), new CommunSquare(4), 1);
        g.addEdge(new CommunSquare(4), new CommunSquare(1), 1);
        g.addEdge(new CommunSquare(2), new CommunSquare(3), 3);
        g.addEdge(new CommunSquare(3), new CommunSquare(2), 3);
        g.addEdge(new CommunSquare(3), new CommunSquare(4), 2);
        g.addEdge(new CommunSquare(4), new CommunSquare(3), 2);
    }

    void setup2() {
        g = new Graph<>(5);
        g.addEdge(new CommunSquare(0), new CommunSquare(1), 15);
        g.addEdge(new CommunSquare(1), new CommunSquare(0), 15);
        g.addEdge(new CommunSquare(0), new CommunSquare(2), 10);
        g.addEdge(new CommunSquare(2), new CommunSquare(0), 10);
        g.addEdge(new CommunSquare(2), new CommunSquare(3), 6);
        g.addEdge(new CommunSquare(3), new CommunSquare(2), 6);
        g.addEdge(new CommunSquare(2), new CommunSquare(1), 7);
        g.addEdge(new CommunSquare(1), new CommunSquare(2), 7);
        g.addEdge(new CommunSquare(3), new CommunSquare(1), 11);
        g.addEdge(new CommunSquare(1), new CommunSquare(3), 11);
        g.addEdge(new CommunSquare(3), new CommunSquare(4), 13);
        g.addEdge(new CommunSquare(4), new CommunSquare(3), 13);
        g.addEdge(new CommunSquare(1), new CommunSquare(4), 4);
        g.addEdge(new CommunSquare(4), new CommunSquare(1), 4);
    }

    void setup3() {
        g = new Graph<>(5);
        g.addEdge(new CommunSquare(0), new CommunSquare(1), 5);
        g.addEdge(new CommunSquare(1), new CommunSquare(0), 5);
        g.addEdge(new CommunSquare(0), new CommunSquare(2), 5);
        g.addEdge(new CommunSquare(2), new CommunSquare(0), 5);
        g.addEdge(new CommunSquare(0), new CommunSquare(3), 5);
        g.addEdge(new CommunSquare(3), new CommunSquare(0), 5);
        g.addEdge(new CommunSquare(0), new CommunSquare(4), 5);
        g.addEdge(new CommunSquare(4), new CommunSquare(0), 5);
        g.addEdge(new CommunSquare(2), new CommunSquare(3), 8);
        g.addEdge(new CommunSquare(3), new CommunSquare(2), 8);
        g.addEdge(new CommunSquare(3), new CommunSquare(4), 8);
        g.addEdge(new CommunSquare(4), new CommunSquare(3), 8);
        g.addEdge(new CommunSquare(1), new CommunSquare(2), 2);
        g.addEdge(new CommunSquare(2), new CommunSquare(1), 2);
    }

    void setup4() {
        g = new Graph<>(4);
        g.addEdge(new CommunSquare(0), new CommunSquare(1), 0);
        g.addEdge(new CommunSquare(0), new CommunSquare(2), 0);
        g.addEdge(new CommunSquare(1), new CommunSquare(2), 0);
        g.addEdge(new CommunSquare(2), new CommunSquare(0), 0);
        g.addEdge(new CommunSquare(2), new CommunSquare(3), 0);
        g.addEdge(new CommunSquare(3), new CommunSquare(3), 0);
    }

    @Test
    public void dijkstra() {
        setup1();
        String expected = "[0, 15, 11, 14, 16]";
        String actual = g.dijkstra(new CommunSquare(0));
        assertEquals(expected, actual);
    }

    @Test
    public void floydWarshall() {
        setup1();
        String expected = "|0	15	11	14	16|\n"
                + "|15	0	6	3	1|\n"
                + "|11	6	0	3	5|\n"
                + "|14	3	3	0	2|\n"
                + "|16	1	5	2	0|\n";
        String actual = g.floydWarshall();
        assertEquals(expected, actual);
    }

    @Test
    public void prim() {
        setup2();
        int expected = 27;
        int actual = g.prim(new CommunSquare(0));
        assertEquals(expected, actual);
    }

    @Test
    public void kruskal() {
        setup3();
        int expected = 17;
        int actual = g.kruskal();
        assertEquals(expected, actual);
    }

    @Test
    public void BFS() {
        setup4();
        String expected = "2 0 3 1 ";
        String actual = g.BFS(new CommunSquare(2));
        assertEquals(expected, actual);
    }

    @Test
    public void DFS() {
        setup4();
        String expected = "2 0 1 3 ";
        String actual = g.DFS(new CommunSquare(2));
        assertEquals(expected, actual);
    }
}
