package model.data_structure;

public interface GraphI {
    void addEdge(int s, int d, int w);
    void BFS(int s);
    void DFS(int s);
    void prim(int s);
    void kruskal();
    void dijkstra(int s);
    void floydWarshall();
}
