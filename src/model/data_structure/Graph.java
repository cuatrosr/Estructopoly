package model.data_structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import model.objects.Square;

public class Graph implements GraphI<Square> {
    private int v;
    private LinkedList<Edge<Square>> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public LinkedList<Edge<Square>>[] getAdj() {
        return adj;
    }

    @Override
    public void addEdge(Square s, Square d, int w) {
        Edge e = new Edge(s, d, w);
        adj[s.getNumSquare()].add(e);
    }

    @Override
    public void BFS(Square s) {
        boolean visited[] = new boolean[v];
        LinkedList<Square> queue = new LinkedList<>();
        visited[s.getNumSquare()] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            Iterator<Edge<Square>> i = getAdj()[s.getNumSquare()].listIterator();
            while (i.hasNext()) {
                Square n = i.next().getD();
                if (!visited[n.getNumSquare()]) {
                    visited[n.getNumSquare()] = true;
                    queue.add(n);
                }
            }
        }
    }

    @Override
    public void DFS(Square s) {
        boolean visited[] = new boolean[v];
        DFS(s, visited);
    }

    private void DFS(Square s, boolean visited[]) {
        visited[s.getNumSquare()] = true;
        Iterator<Edge<Square>> i = getAdj()[s.getNumSquare()].listIterator();
        while (i.hasNext()) {
            Square n = i.next().getD();
            if (!visited[n.getNumSquare()]) {
                DFS(n, visited);
            }
        }
    }

    @Override
    public void prim(Square s) {
        Key k[] = new Key[v];
        boolean color[] = new boolean[v];
        int pred[] = new int[v];
        for (int i = 0; i < v; i++) {
            k[i] = new Key(i, Integer.MAX_VALUE);
            color[i] = false;
        }
        k[s.getNumSquare()].setKey(0);
        pred[s.getNumSquare()] = -1;
        PriorityQueue<Key> q = new PriorityQueue(v, new Key());
        for (Key key : k) {
            q.add(key);
        }
        while (!q.isEmpty()) {
            Key u = (Key) q.poll();
            LinkedList<Edge<Square>> adj = getAdj()[u.getI()];
            for (Edge<Square> edge : adj) {
                if (!color[edge.getD().getNumSquare()] && (edge.getW() < k[edge.getD().getNumSquare()].getKey())) {
                    q.remove(k[edge.getD().getNumSquare()]);
                    k[edge.getD().getNumSquare()].setKey(edge.getW());
                    q.add(k[edge.getD().getNumSquare()]);
                    pred[edge.getD().getNumSquare()] = u.getI();
                }
            }
            color[u.getI()] = true;
        }
    }

    @Override
    public void kruskal() {
        LinkedList<Edge<Square>>[] adj = getAdj();
        PriorityQueue<Edge> pq = new PriorityQueue<>(adj.length, new Edge());
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                pq.add(adj[i].get(j));
            }
        }
        int[] parent = new int[v];
        makeSet(v, parent);
        ArrayList<Edge<Square>> mst = new ArrayList<>();
        int index = 0;
        Iterator value = pq.iterator();
        while (value.hasNext()) {
            Edge<Square> edge = (Edge) value.next();
            int x_set = find(parent, edge.getS().getNumSquare());
            int y_set = find(parent, edge.getD().getNumSquare());
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
    public void dijkstra(Square s) {
        int[] dist = new int[v];
        int[] prev = new int[v];
        PriorityQueue<Distance> q = new PriorityQueue(v, new Distance());
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
                if (alt < dist[getAdj()[u].get(i).getD().getNumSquare()]) {
                    Object[] distAr = q.toArray();
                    Distance[] distArr = new Distance[q.size()];
                    for (int j = 0; j < distArr.length; j++) {
                        distArr[j] = (Distance) distAr[j];
                    }
                    Distance temp = new Distance(-1, -1);
                    for (int j = 0; j < distArr.length; j++) {
                        if (distArr[j].getI() == getAdj()[u].get(i).getD().getNumSquare()) {
                            temp = distArr[j];
                        }
                    }
                    q.remove(temp);
                    dist[getAdj()[u].get(i).getD().getNumSquare()] = alt;
                    prev[getAdj()[u].get(i).getD().getNumSquare()] = u;
                    q.add(new Distance(getAdj()[u].get(i).getD().getNumSquare(), alt));
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
        LinkedList<Edge<Square>> adj[] = getAdj();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                arr[adj[i].get(j).getS().getNumSquare()][adj[i].get(j).getD().getNumSquare()] = adj[i].get(j).getW();
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
