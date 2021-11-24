package model.data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import model.objects.CommunSquare;
import model.objects.WildCards;

public class Graph<T> implements GraphI<T> {
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
        Edge e = new Edge(s, d, w);
        if (s instanceof CommunSquare) {
            CommunSquare x = (CommunSquare) s;
            adj[x.getNumSquare()].add(e);
        } else if (s instanceof WildCards) {
            WildCards x = (WildCards) s;
            adj[x.getNumSquare()].add(e);
        }
    }

    @Override
    public void BFS(T s) {
        boolean visited[] = new boolean[v];
        LinkedList<T> queue = new LinkedList<>();
        visited[(int) s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            Iterator<Edge<T>> i = getAdj()[(int) s].listIterator();
            while (i.hasNext()) {
                T n = i.next().getD();
                if (!visited[(int) n]) {
                    visited[(int) n] = true;
                    queue.add(n);
                }
            }
        }
    }

    @Override
    public void DFS(T s) {
        boolean visited[] = new boolean[v];
        DFS(s, visited);
    }

    private void DFS(T s, boolean visited[]) {
        visited[(int) s] = true;
        Iterator<Edge<T>> i = getAdj()[(int) s].listIterator();
        while (i.hasNext()) {
            T n = i.next().getD();
            if (!visited[(int) n]) {
                DFS(n, visited);
            }
        }
    }

    @Override
    public void prim(T s) {
        Key k[] = new Key[v];
        boolean color[] = new boolean[v];
        int pred[] = new int[v];
        for (int i = 0; i < v; i++) {
            k[i] = new Key(i, Integer.MAX_VALUE);
            color[i] = false;
        }
        k[(int) s].setKey(0);
        pred[(int) s] = -1;
        PriorityQueue<Key> q = new PriorityQueue(v, new Key());
        for (Key key : k) {
            q.add(key);
        }
        while (!q.isEmpty()) {
            Key u = (Key) q.poll();
            LinkedList<Edge<T>> adj = getAdj()[u.getI()];
            for (Edge<T> edge : adj) {
                if (!color[(int) edge.getD()] && (edge.getW() < k[(int) edge.getD()].getKey())) {
                    q.remove(k[(int) edge.getD()]);
                    k[(int) edge.getD()].setKey(edge.getW());
                    q.add(k[(int) edge.getD()]);
                    pred[(int) edge.getD()] = u.getI();
                }
            }
            color[u.getI()] = true;
        }
    }

    @Override
    public void kruskal() {
        LinkedList<Edge<T>>[] adj = getAdj();
        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(adj.length, new Edge());
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
            Edge<T> edge = (Edge) value.next();
            int x_set = find(parent, (int) edge.getS());
            int y_set = find(parent, (int) edge.getD());
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

    @Override
    public void dijkstra(T s) {
        int[] dist = new int[v];
        int[] prev = new int[v];
        PriorityQueue<Distance> q = new PriorityQueue(v, new Distance());
        dist[(int) s] = 0;
        for (int i = 0; i < v; i++) {
            if (i != (int) s) {
                dist[i] = Integer.MAX_VALUE;
            }
            prev[i] = -1;
            q.add(new Distance(i, dist[i]));
        }
        while (!q.isEmpty()) {
            int u = q.remove().getI();
            for (int i = 0; i < getAdj()[u].size(); i++) {
                int alt = dist[u] + getAdj()[u].get(i).getW();
                if (alt < dist[(int) getAdj()[u].get(i).getD()]) {
                    Object[] distAr = q.toArray();
                    Distance[] distArr = new Distance[q.size()];
                    for (int j = 0; j < distArr.length; j++) {
                        distArr[j] = (Distance) distAr[j];
                    }
                    Distance temp = new Distance(-1, -1);
                    for (int j = 0; j < distArr.length; j++) {
                        if (distArr[j].getI() == (int) getAdj()[u].get(i).getD()) {
                            temp = distArr[j];
                        }
                    }
                    q.remove(temp);
                    dist[(int) getAdj()[u].get(i).getD()] = alt;
                    prev[(int) getAdj()[u].get(i).getD()] = u;
                    q.add(new Distance((int) getAdj()[u].get(i).getD(), alt));
                }
            }
        }
    }

    @Override
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
                arr[(int) adj[i].get(j).getS()][(int) adj[i].get(j).getD()] = adj[i].get(j).getW();
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
