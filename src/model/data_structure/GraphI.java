package model.data_structure;

public interface GraphI<T> {
    void addEdge(T s, T d, int w);
    void BFS(T s);
    void DFS(T s);
    void prim(T s);
    void kruskal();
    void dijkstra(T s);
    void floydWarshall();
}
