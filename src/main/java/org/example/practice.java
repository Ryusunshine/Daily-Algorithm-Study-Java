import java.util.*;


public class Solution {
    static int N;
    static int[][] road;
    static int K;

    static int[] dist;
    public static void main(String[] args) {
        ArrayList<Node>[] graph = new ArrayList[N+1];

        for (int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int j = 0; j < N+1; j++){
            int start = road[j][0];
            int end= road[j][1];
            int cost = road[j][2];
            graph[start].add(new Node(end, cost));
        }

        dijkstra(N, 1, graph);
        int cnt = 0;
        for (int idx = 1; idx < N+1; idx++){
            if (dist[idx] <= K){
                cnt++;
            }
        }
        return cnt;


    }

    public static class Node {
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void dijkstra(int n, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        visited[start] = true;
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if (!visited[now.index]) visited[now.index] = true;
            for (Node next : graph[now.index]){
                int cost = dist[now.index] + next.cost;
                if (dist[next.index] > cost){
                    dist[next.index] = cost;
                    pq.offer(new Node(next.index, cost));
                }
            }
        }
        Collections.min();
    }
}