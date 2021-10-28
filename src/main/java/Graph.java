import java.util.Comparator;

public class Graph {
    int size;
    Edge[] graph;

    public Graph(int size) {
        this.size = size;
        this.graph = new Edge[size];
    }

    public int getSize() {
        return size;
    }

    public void addEdge(int source, int value, int weight) {
        Edge cur = graph[source];
        if (cur == null) {
            graph[source] = new Edge(value, weight);
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Edge(value, weight);
    }

    public Edge getNeighbors(int source) {
        return graph[source];
    }



}
