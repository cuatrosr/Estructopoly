package model.data_structures.graph;

import java.io.Serializable;
import java.util.Comparator;

public class Edge<T> implements Comparator<Edge<T>>, Serializable {

    private T s;
    private T d;
    private int w;

    public Edge() {
    }

    public Edge(T s, T d, int w) {
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
    public int compare(Edge<T> e1, Edge<T> e2) {
        return Integer.parseInt(String.valueOf(e1.getW())) - Integer.parseInt(String.valueOf(e2.getW()));
    }
}
