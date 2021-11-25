package model.data_structure;

public interface GraphI<T> {
    void addEdge(T s, T d, T w);
    String BFS(T s);
    void DFS(T s);
    int prim(T s);
    int kruskal();
    String dijkstra(T s);
    String floydWarshall();
}
