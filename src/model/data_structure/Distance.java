package model.data_structure;

import java.util.Comparator;

public class Distance implements Comparator<Distance> {

    private int i;
    private int dist;

    Distance() {
    }

    Distance(int i, int dist) {
        this.i = i;
        this.dist = dist;
    }

    public int getI() {
        return i;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public String toString() {
        return i + "";
    }

    @Override
    public int compare(Distance d1, Distance d2) {
        return d1.getDist() - d2.getDist();
    }
}
