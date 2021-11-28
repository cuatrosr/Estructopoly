package model.data_structures.graph;

import java.util.Comparator;

public class Key<T> implements Comparator<Key<T>> {

    private T i;
    private T key;

    Key() {
    }

    Key(T i, T key) {
        this.i = i;
        this.key = key;
    }

    public T getI() {
        return i;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public int compare(Key<T> k1, Key<T> k2) {
        return Integer.parseInt(String.valueOf(k1.getKey())) - Integer.parseInt(String.valueOf(k2.getKey()));
    }
}
