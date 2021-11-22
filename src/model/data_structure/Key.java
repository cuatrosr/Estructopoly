package model.data_structure;

import java.util.Comparator;

public class Key implements Comparator<Key> {

    private int i;
    private int key;

    Key() {
    }

    Key(int i, int key) {
        this.i = i;
        this.key = key;
    }

    public int getI() {
        return i;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public int compare(Key k1, Key k2) {
        return k1.getKey() - k2.getKey();
    }
}
