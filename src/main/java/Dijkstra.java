import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 0, 4);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(2, 0, 3);
        graph.addEdge(3, 1, 2);
        graph.addEdge(3, 2, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 2, 3);
        graph.addEdge(4, 3, 2);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 4, 6);
        graph.addEdge(5, 3, 1);

        int source = 0;
        int target = 5;
        System.out.println(dijkstra(source, target, graph));
    }

    private static int dijkstra(int source, int target, Graph graph) {
        Comparator<Edge> comparator = new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        };

        boolean[] visited = new boolean[graph.size];
        Arrays.fill(visited, false);
        int[] dist = new int[graph.size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(comparator);
        pq.add(new Edge(source, 0));

        while (pq.size() > 0) {
            Edge cur = pq.poll();
            visited[cur.value] = true;
            Edge next = graph.getNeighbors(cur.value);
            while(next != null) {
                if (visited[next.value]) {
                    next = next.next;
                    continue;
                }
                int currentDist = dist[cur.value] + next.weight;
                if (currentDist < dist[next.value]) {
                    dist[next.value] = currentDist;
                    pq.add(new Edge(next.value, currentDist));
                }
                next = next.next;
            }
        }
        return dist[target];
    }
}
