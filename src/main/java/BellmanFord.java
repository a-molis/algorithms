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

    // looping through all vertices skipping source
    for (int i = 1; i < graph.vertices - 1; i++) {
      for (int[] d : dist) {
        System.out.println(Arrays.toString(d));
      }
      System.out.println();

      // Looping through possible number of edges to use
      for (int v = 0; v < graph.vertices; v++) {
        Edge curNeighbor = graph.getNeighbors(v);

        // Looping through all of the neighbors
        int curNeighborMin = 999;
        while (curNeighbor != null) {
          int neighborValue = curNeighbor.value;
          int neighborWeight = curNeighbor.weight;
          int curNum = dist[i - 1][neighborValue];
          if (curNum == 999) {
            curNum = 0;
          }
          curNeighborMin = Math.min(curNum + neighborWeight, curNeighborMin);
          curNeighbor = curNeighbor.next;
        }
        dist[i][v] = Math.min(dist[i - 1][v], curNeighborMin);
      }
    }
    return dist;
  }
}
