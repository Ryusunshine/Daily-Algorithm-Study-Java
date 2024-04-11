package org.example.BFS_DFS;

import java.util.*;

public class 프로그래머스_다익스트라_배달 {
    class Solution {
        static ArrayList<Node>[] graph;
        static int[] dist;
        public int solution(int N, int[][] road, int K) {
            graph = new ArrayList[N+1];
            dist = new int[N+1];

            for (int i = 1; i < N+1; i++) {
                graph[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE; // dist 배열 초기화
            }

            // road 는 처음 인덱스부터 돌아야해
            for (int j = 0; j < road.length; j++) {
                int start = road[j][0];
                int end = road[j][1];
                int cost = road[j][2];
                graph[start].add(new Node(end, cost));
                graph[end].add(new Node(start, cost)); // 양방향 그래프이므로 양쪽에 모두 추가
            }

            dijkstra(N, 1);
            int cnt = 0;
            for (int idx = 1; idx <= N; idx++) {
                if (dist[idx] <= K) {
                    cnt++;
                }
            }
            return cnt;
        }

        public static class Node implements Comparable<Node> {
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
            dist[start] = 0;
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                if (visited[now.index]) continue; // 방문한 노드는 건너뜀
                visited[now.index] = true;
                for (Node next : graph[now.index]) {
                    int cost = dist[now.index] + next.cost;
                    if (dist[next.index] > cost) {
                        dist[next.index] = cost;
                        pq.offer(new Node(next.index, cost));
                    }
                }
            }
        }
    }
}
