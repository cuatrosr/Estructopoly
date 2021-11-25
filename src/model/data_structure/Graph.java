package model.data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph<T> {

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

    public void addEdge(T s, T d, T w) {
        Edge<T> e = new Edge(s, d, w);
        adj[Integer.parseInt(String.valueOf(s))].add(e);
    }

    public void BFS(T s) {
        boolean visited[] = new boolean[v];
        LinkedList<T> queue = new LinkedList<>();
        visited[Integer.parseInt(String.valueOf(s))] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            Iterator<Edge<T>> i = getAdj()[Integer.parseInt(String.valueOf(s))].listIterator();
            while (i.hasNext()) {
                T n = i.next().getD();
                if (!visited[Integer.parseInt(String.valueOf(n))]) {
                    visited[Integer.parseInt(String.valueOf(n))] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(T s) {
        boolean visited[] = new boolean[v];
        DFS(Integer.parseInt(String.valueOf(s)), visited);
    }

    private void DFS(int s, boolean visited[]) {
        visited[s] = true;
        Iterator<Edge<T>> i = getAdj()[s].listIterator();
        while (i.hasNext()) {
            T n = i.next().getD();
            if (!visited[Integer.parseInt(String.valueOf(n))]) {
                DFS(Integer.parseInt(String.valueOf(n)), visited);
            }
        }
    }

    public void prim(T s) {
        Key<Integer> k[] = new Key[v];
        boolean color[] = new boolean[v];
        int pred[] = new int[v];
        for (int i = 0; i < v; i++) {
            k[i] = new Key(i, Integer.MAX_VALUE);
            color[i] = false;
        }
        k[Integer.parseInt(String.valueOf(s))].setKey(0);
        pred[Integer.parseInt(String.valueOf(s))] = -1;
        PriorityQueue<Key<Integer>> q = new PriorityQueue(v, new Key<Integer>());
        for (Key key : k) {
            q.add(key);
        }
        while (!q.isEmpty()) {
            Key<Integer> u = (Key<Integer>) q.poll();
            LinkedList<Edge<T>> adj = getAdj()[u.getI()];
            for (Edge<T> edge : adj) {
                if (!color[Integer.parseInt(String.valueOf(edge.getD()))] && (Integer.parseInt(String.valueOf(edge.getW())) < k[Integer.parseInt(String.valueOf(edge.getD()))].getKey())) {
                    q.remove(k[Integer.parseInt(String.valueOf(edge.getD()))]);
                    k[Integer.parseInt(String.valueOf(edge.getD()))].setKey(Integer.parseInt(String.valueOf(edge.getW())));
                    q.add(k[Integer.parseInt(String.valueOf(edge.getD()))]);
                    pred[Integer.parseInt(String.valueOf(edge.getD()))] = u.getI();
                }
            }
            color[u.getI()] = true;
        }
    }

    public void kruskal() {
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
            Edge edge = (Edge) value.next();
            int x_set = find(parent, Integer.parseInt(String.valueOf(edge.getS())));
            int y_set = find(parent, Integer.parseInt(String.valueOf(edge.getD())));
            if (x_set != y_set) {
                mst.add(edge);
                index++;
                union(parent, x_set, y_set);
            }
        }
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

    public void dijkstra(T s) {
        int[] dist = new int[v];
        int[] prev = new int[v];
        PriorityQueue<Distance<T>> q = new PriorityQueue(v, new Distance<T>());
        dist[Integer.parseInt(String.valueOf(s))] = 0;
        for (int i = 0; i < v; i++) {
            if (i != Integer.parseInt(String.valueOf(s))) {
                dist[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;
            q.add(new Distance(i, dist[i]));
        }
        while (!q.isEmpty()) {
            int u = Integer.parseInt(String.valueOf(q.remove().getI()));
            for (int i = 0; i < getAdj()[u].size(); i++) {
                int alt = dist[u] + Integer.parseInt(String.valueOf(getAdj()[u].get(i).getW()));
                if (alt < dist[Integer.parseInt(String.valueOf(getAdj()[u].get(i).getD()))]) {
                    Object[] distAr = q.toArray();
                    Distance<T>[] distArr = new Distance[q.size()];
                    for (int j = 0; j < distArr.length; j++) {
                        distArr[j] = (Distance<T>) distAr[j];
                    }
                    Distance<T> temp = new Distance(-1, -1);
                    for (int j = 0; j < distArr.length; j++) {
                        if (distArr[j].getI() == getAdj()[u].get(i).getD()) {
                            temp = distArr[j];
                        }
                    }
                    q.remove(temp);
                    dist[Integer.parseInt(String.valueOf(getAdj()[u].get(i).getD()))] = alt;
                    prev[Integer.parseInt(String.valueOf(getAdj()[u].get(i).getD()))] = u;
                    q.add(new Distance(getAdj()[u].get(i).getD(), alt));
                }
            }
        }
    }

    public void floydWarshall() {
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
                arr[Integer.parseInt(String.valueOf(adj[i].get(j).getS()))][Integer.parseInt(String.valueOf(adj[i].get(j).getD()))] = Integer.parseInt(String.valueOf(adj[i].get(j).getW()));
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
    }
}
