import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);
        int[][] dist = bellmanFord(0, graph);
        for(int[] d: dist) {
            System.out.println(Arrays.toString(d));
        }
    }

    public static int[][] bellmanFord(int source, Graph graph) {
        int[][] dist = new int[graph.vertices][graph.vertices];
        for (int[] d: dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][source] = 0;
        for (int i=1; i<graph.vertices - 1; i++)  {
            for(int[] d: dist) {
                System.out.println(Arrays.toString(d));
            }
            System.out.println();
            for (int v=0; v<graph.vertices; v++) {
                Edge curNeighbor = graph.getNeighbors(v);
                while (curNeighbor != null) {
                    int neighborValue = curNeighbor.value;
                    int neighborWeight = curNeighbor.weight;
                    int preNeighborWeight;
                    if (dist[i-1][neighborValue] == Integer.MAX_VALUE) {
                        preNeighborWeight = 0;
                    } else {
                        preNeighborWeight = dist[i-1][neighborValue];
                    }
                    dist[i][v] = Math.min(dist[i-1][v], preNeighborWeight + neighborWeight);
                    curNeighbor = curNeighbor.next;
                }
            }
        }
        return dist;
    }
}
