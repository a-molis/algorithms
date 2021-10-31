public class Graph {
  int numEdges;
  int vertices;
  int size;
  Edge[] graph;
  Edge[] incomingGraph;

  /**
   * new graph
   *
   * @param size number of nodes in graph
   */
  public Graph(int size) {
    this.size = size;
    this.graph = new Edge[size];
    this.incomingGraph = new Edge[size];
    this.numEdges = 0;
    this.vertices = size;
  }

  public void addEdge(int from, int to, int weight) {
    this.numEdges++;
    Edge cur;
    cur = graph[from];
    if (cur == null) {
      graph[from] = new Edge(to, weight);
    } else {
      while (cur.next != null) {
        cur = cur.next;
      }
      cur.next = new Edge(to, weight);
    }

    // add to incoming edge graph
    Edge in = incomingGraph[to];
    if (in == null) {
      incomingGraph[to] = new Edge(from, weight);
    } else {
      while (in.next != null) {
        in = in.next;
      }
      in.next = new Edge(from, weight);
    }
  }

  public Edge getNeighbors(int source) {
    return graph[source];
  }

  public Edge getIncoming(int source) {
    return incomingGraph[source];
  }
}
