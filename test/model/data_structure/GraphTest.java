package model.data_structure;

import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {

    public Graph<Integer> g;

    void setup1() {
        g = new Graph<>(5);
        g.addEdge(0, 1, 15);
        g.addEdge(1, 0, 15);
        g.addEdge(0, 2, 11);
        g.addEdge(2, 0, 11);
        g.addEdge(1, 2, 12);
        g.addEdge(2, 1, 12);
        g.addEdge(1, 3, 14);
        g.addEdge(3, 1, 14);
        g.addEdge(1, 4, 1);
        g.addEdge(4, 1, 1);
        g.addEdge(2, 3, 3);
        g.addEdge(3, 2, 3);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 3, 2);
    }

    void setup2() {
        g = new Graph<>(5);
        g.addEdge(0, 1, 15);
        g.addEdge(1, 0, 15);
        g.addEdge(0, 2, 10);
        g.addEdge(2, 0, 10);
        g.addEdge(2, 3, 6);
        g.addEdge(3, 2, 6);
        g.addEdge(2, 1, 7);
        g.addEdge(1, 2, 7);
        g.addEdge(3, 1, 11);
        g.addEdge(1, 3, 11);
        g.addEdge(3, 4, 13);
        g.addEdge(4, 3, 13);
        g.addEdge(1, 4, 4);
        g.addEdge(4, 1, 4);
    }

    void setup3() {
        g = new Graph<>(5);
        g.addEdge(0, 1, 5);
        g.addEdge(1, 0, 5);
        g.addEdge(0, 2, 5);
        g.addEdge(2, 0, 5);
        g.addEdge(0, 3, 5);
        g.addEdge(3, 0, 5);
        g.addEdge(0, 4, 5);
        g.addEdge(4, 0, 5);
        g.addEdge(2, 3, 8);
        g.addEdge(3, 2, 8);
        g.addEdge(3, 4, 8);
        g.addEdge(4, 3, 8);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 1, 2);
    }

    void setup4() {
        g = new Graph<>(4);
        g.addEdge(0, 1, 0);
        g.addEdge(0, 2, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(2, 0, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3, 3, 0);
    }

    void setup5() {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 0);
        g.addEdge(0, 2, 0);
        g.addEdge(1, 2, 0);
        g.addEdge(2, 0, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3, 3, 0);
    }

    @Test
    public void dijkstra() {
        setup1();
        String expected = "[0, 15, 11, 14, 16]";
        String actual = g.dijkstra(0);
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
        int actual = g.prim(0);
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
        String actual = g.BFS(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void DFS() {
        setup5();
        String expected = "2 0 1 3";
        String actual = g.DFS(2);
    }
}
