import java.util.Arrays;

public class FloydWarshall {
    public static int INF = 999;

    public static void main(String[] args) {
        int graph[][] = { {0,   5,  INF, 10},
                          {INF, 0,   3, INF},
                          {INF, INF, 0,   1},
                          {INF, INF, INF, 0}
        };
       int[][] dist = floydWarshall(graph);
        for(int[] d: dist) {
            System.out.println(Arrays.toString(d));
        }
    }

    private static int[][] floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k=0; k<V; k++) {
            for (int i=0; i<V; i++) {
                for (int j=0; j<V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

}
