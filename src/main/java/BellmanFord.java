import java.util.Arrays;

public class BellmanFord {

  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(0, 0, 0);
    graph.addEdge(0, 1, -1);
    graph.addEdge(0, 2, 4);
    graph.addEdge(1, 2, 3);
    graph.addEdge(1, 3, 2);
    graph.addEdge(1, 4, 2);
    graph.addEdge(3, 2, 5);
    graph.addEdge(3, 1, 1);
    graph.addEdge(4, 3, -3);
    int[][] dist = bellmanFord(0, graph);
    for (int[] d : dist) {
      System.out.println(Arrays.toString(d));
    }
  }

  public static int[][] bellmanFord(int source, Graph graph) {
    int[][] dist = new int[graph.vertices][graph.vertices];
    for (int[] d : dist) {
      Arrays.fill(d, 999);
    }
    dist[0][source] = 0;

    // looping through the number of edges going vertically down
    for (int i = 1; i < graph.vertices; i++) {
      for (int[] d : dist) {
        System.out.println(Arrays.toString(d));
      }
      System.out.println();

      // Looping through possible number of vertices going horizontally
      for (int v = 0; v < graph.vertices; v++) {
        Edge curNeighbor = graph.getIncoming(v);

        // Looping through all of the neighbors
        int curNeighborMin = 999;
        while (curNeighbor != null) {
          int neighborValue = curNeighbor.value;
          int neighborWeight = curNeighbor.weight;
          int curNum = dist[i - 1][neighborValue];
          curNeighborMin = Math.min(curNum + neighborWeight, curNeighborMin);
          curNeighbor = curNeighbor.next;
        }
        dist[i][v] = Math.min(dist[i - 1][v], curNeighborMin);
      }
    }
    return dist;
  }
}
