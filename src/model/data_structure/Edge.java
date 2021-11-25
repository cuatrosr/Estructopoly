package model.data_structure;

import java.util.Comparator;

public class Edge<T> implements Comparator<Edge<T>> {

    private T s;
    private T d;
    private T w;

    public Edge() {
    }

    public Edge(T s, T d, T w) {
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

    public T getW() {
        return w;
    }

    @Override
    public int compare(Edge<T> e1, Edge<T> e2) {
        return Integer.parseInt(String.valueOf(e1.getW())) - Integer.parseInt(String.valueOf(e2.getW()));
    }
}
