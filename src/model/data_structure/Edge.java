package model.data_structure;

import java.util.Comparator;

public class Edge<T> implements Comparator<Edge> {

    private T s;
    private T d;
    private int w;

    Edge() {
    }

    Edge(T s, T d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    public T getS() {
        return s;
    }

    public T getD() {
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
