package model.interface_class;

public interface GraphI<T> {
    void addEdge(T s, T d, int w);
    String BFS(T s);
    String DFS(T s);
    int prim(T s);
    int kruskal();
    String dijkstra(T s);
    String floydWarshall();
}
