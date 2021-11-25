package model.data_structure;

import java.util.Comparator;

public class Distance<T> implements Comparator<Distance<T>> {

    private T i;
    private T dist;

    Distance() {
    }

    Distance(T i, T dist) {
        this.i = i;
        this.dist = dist;
    }

    public T getI() {
        return i;
    }

    public T getDist() {
        return dist;
    }

    @Override
    public String toString() {
        return i + "";
    }

    @Override
    public int compare(Distance<T> d1, Distance<T> d2) {
        return d1.compare(d1, d2);
    }
}
