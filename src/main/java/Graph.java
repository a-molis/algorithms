public class Graph {
    int numEdges;
    int vertices;
    int size;
    Edge[] graph;

    /**
     * new graph
     * @param size number of nodes in graph
     */
    public Graph(int size) {
        this.size = size;
        this.graph = new Edge[size];
        this.numEdges = 0;
        this.vertices = size;
    }

    public void addEdge(int from, int to, int weight) {
        this.numEdges++;
        Edge cur = graph[from];
        if (cur == null) {
            graph[from] = new Edge(to, weight);
            return;
        }
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Edge(to, weight);
    }

    public Edge getNeighbors(int source) {
        return graph[source];
    }



}
