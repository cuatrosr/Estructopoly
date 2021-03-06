package model.data_structures.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import model.objects.Square;

public class Graph<T> implements model.interface_class.GraphI<T>, Serializable {

    private int v;
    private LinkedList<Edge<T>> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public LinkedList<Edge<T>>[] getAdj() {
        return adj;
    }

    @Override
    public void addEdge(T s, T d, int w) {
        Edge<T> e = new Edge(s, d, w);
        adj[((Square) s).getNumSquare()].add(e);
    }

    @Override
    public String BFS(T s) {
        String msg = "";
        boolean visited[] = new boolean[v];
        LinkedList<T> queue = new LinkedList<>();
        visited[((Square) s).getNumSquare()] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            msg += ((Square) s).getNumSquare() + " ";
            Iterator<Edge<T>> i = getAdj()[((Square) s).getNumSquare()].listIterator();
            while (i.hasNext()) {
                T n = i.next().getD();
                if (!visited[((Square) n).getNumSquare()]) {
                    visited[((Square) n).getNumSquare()] = true;
                    queue.add(n);
                }
            }
        }
        return msg;
    }

    @Override
    public String DFS(T s) {
        boolean visited[] = new boolean[v];
        String msg = "";
        return DFS(msg, ((Square) s).getNumSquare(), visited);
    }

    private String DFS(String msg, int s, boolean visited[]) {
        visited[s] = true;
        msg += s + " ";
        Iterator<Edge<T>> i = getAdj()[s].listIterator();
        while (i.hasNext()) {
            T n = i.next().getD();
            if (!visited[((Square) n).getNumSquare()]) {
                msg = DFS(msg, ((Square) n).getNumSquare(), visited);
            }
        }
        return msg;
    }

    @Override
    public int prim(T s) {
        Key<Integer> k[] = new Key[v];
        boolean color[] = new boolean[v];
        int pred[] = new int[v];
        for (int i = 0; i < v; i++) {
            k[i] = new Key(i, Integer.MAX_VALUE);
            color[i] = false;
        }
        k[((Square) s).getNumSquare()].setKey(0);
        pred[((Square) s).getNumSquare()] = -1;
        PriorityQueue<Key<Integer>> q = new PriorityQueue(v, new Key<Integer>());
        for (Key key : k) {
            q.add(key);
        }
        while (!q.isEmpty()) {
            Key<Integer> u = (Key<Integer>) q.poll();
            LinkedList<Edge<T>> adj = getAdj()[u.getI()];
            for (Edge<T> edge : adj) {
                if (!color[((Square) edge.getD()).getNumSquare()] && (edge.getW()) < k[((Square) edge.getD()).getNumSquare()].getKey()) {
                    q.remove(k[((Square) edge.getD()).getNumSquare()]);
                    k[((Square) edge.getD()).getNumSquare()].setKey(edge.getW());
                    q.add(k[((Square) edge.getD()).getNumSquare()]);
                    pred[((Square) edge.getD()).getNumSquare()] = u.getI();
                }
            }
            color[u.getI()] = true;
        }
        int keySum = 0;
        for (Key<Integer> k1 : k) {
            keySum += k1.getKey();
        }
        return keySum;
    }

    @Override
    public int kruskal() {
        LinkedList<Edge<T>>[] adj = getAdj();
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(adj.length, new Edge<>());
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                pq.add(adj[i].get(j));
            }
        }
        int[] parent = new int[v];
        makeSet(v, parent);
        ArrayList<Edge<T>> mst = new ArrayList<>();
        int index = 0;
        Iterator value = pq.iterator();
        while (value.hasNext()) {
            Edge<T> edge = (Edge<T>) value.next();
            int x_set = find(parent, ((Square) edge.getS()).getNumSquare());
            int y_set = find(parent, ((Square) edge.getD()).getNumSquare());
            if (x_set != y_set) {
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }
        int kruskal = 0;
        for (int i = 0; i < mst.size(); i++) {
            kruskal += mst.get(i).getW();
        }
        return kruskal;
    }

    private static void makeSet(int n, int[] parent) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            return find(parent, parent[vertex]);
        }
        return vertex;
    }

    private static void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        parent[y_set_parent] = x_set_parent;
    }

    @Override
    public String dijkstra(T sa) {
        int[] dist = new int[v];
        int[] prev = new int[v];
        Square s = (Square) sa;
        PriorityQueue<Distance<Integer>> q = new PriorityQueue(v, new Distance<Integer>());
        dist[s.getNumSquare()] = 0;
        for (int i = 0; i < v; i++) {
            if (i != s.getNumSquare()) {
                dist[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;
            q.add(new Distance(i, dist[i]));
        }
        while (!q.isEmpty()) {
            int u = q.remove().getI();
            for (int i = 0; i < getAdj()[u].size(); i++) {
                int alt = dist[u] + getAdj()[u].get(i).getW();
                if (alt < dist[((Square) getAdj()[u].get(i).getD()).getNumSquare()]) {
                    Object[] distAr = q.toArray();
                    Distance<Integer>[] distArr = new Distance[q.size()];
                    for (int j = 0; j < distArr.length; j++) {
                        distArr[j] = (Distance<Integer>) distAr[j];
                    }
                    Distance<Integer> temp = new Distance(-1, -1);
                    for (int j = 0; j < distArr.length; j++) {
                        if (distArr[j].getI() == ((Square) getAdj()[u].get(i).getD()).getNumSquare()) {
                            temp = distArr[j];
                        }
                    }
                    q.remove(temp);
                    dist[((Square) getAdj()[u].get(i).getD()).getNumSquare()] = alt;
                    prev[((Square) getAdj()[u].get(i).getD()).getNumSquare()] = u;
                    q.add(new Distance(((Square) getAdj()[u].get(i).getD()).getNumSquare(), alt));
                }
            }
        }
        return Arrays.toString(dist);
    }

    @Override
    public String floydWarshall() {
        int[][] arr = new int[v][v];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        LinkedList<Edge<T>> adj[] = getAdj();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                arr[((Square) adj[i].get(j).getS()).getNumSquare()][((Square) adj[i].get(j).getD()).getNumSquare()] = adj[i].get(j).getW();
            }
        }
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i][j] > (arr[i][k] + arr[k][j]) && ((arr[i][k]) != Integer.MAX_VALUE && ((arr[k][j]) != Integer.MAX_VALUE))) {
                        arr[i][j] = (arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        return soutMatrix(arr);
    }

    public static String soutMatrix(int[][] arr) {
        String msg = "";
        for (int x = 0; x < arr.length; x++) {
            msg += "|";
            for (int y = 0; y < arr[x].length; y++) {
                if (arr[x][y] != Integer.MAX_VALUE) {
                    msg += arr[x][y];
                } else {
                    msg += "???";
                }
                if (y != arr[x].length - 1) {
                    msg += "\t";
                }
            }
            msg += "|\n";
        }
        return msg;
    }
}
