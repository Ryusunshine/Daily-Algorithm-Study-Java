package org.example;
import java.util.*;

public class 프로그래머스_다익스트라_합승택시요금 {
    class Solution {
        static ArrayList<Node>[] graph;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] fare : fares) {
                int start = fare[0];
                int end = fare[1];
                int cost = fare[2];
                graph[start].add(new Node(end, cost));
                graph[end].add(new Node(start, cost));
            }

            int[] S = dijkstra(s, n); //함께 타는 거 계산
            int[] A = dijkstra(a, n); //a 혼자
            int[] B = dijkstra(b, n); //b 혼자

            int answer = Integer.MAX_VALUE;

            //for문 돌리면서 (1~n) i까지 합승, 혼자 i부터 a까지 감 + 혼자 i부터 b까지 감
            //A[i] = a에서 출발 ~ i까지 = i에서 출발 ~ a까지(양방향 노드라서 어디서 출발하든 노드가 똑같으면 거리가 똑같음)
            //를 계산해주고 answer 갱신해주면 된다
            //머리속에서 그림을 그려!~!
            for(int i=1; i<=n; i++) {
                if(answer > S[i] + A[i] + B[i]) {
                    answer = S[i] + A[i] + B[i];
                }
            }

            return answer;
        }

        public static int[] dijkstra(int start, int n) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n+1];
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 초기화
            dist[start] = 0;
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int idx = now.index;

                if (visited[idx]) continue;
                visited[idx] = true;

                for (Node next : graph[idx]) {
                    int cost = dist[idx] + next.cost;
                    if (dist[next.index] > cost) {
                        dist[next.index] = cost;
                        pq.offer(new Node(next.index, cost));
                    }
                }
            }

            return dist;
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
    }
}
