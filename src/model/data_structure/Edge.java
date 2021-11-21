package model.data_structure;

import java.util.Comparator;

public class Edge implements Comparator<Edge> {

    private int s;
    private int d;
    private int w;

    Edge() {
    }

    Edge(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    public int getS() {
        return s;
    }

    public int getD() {
        return d;
    }

    public int getW() {
        return w;
    }

    @Override
    public int compare(Edge e1, Edge e2) {
        return e1.getW() - e2.getW();
    }
}
