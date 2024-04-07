package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {

    //우선순위 큐에 정점번호 + 가중치 저장을 위해 만드는 것이다.
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        //정점번호, 가중치 저장
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        //cost(=가중치)  중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
        //다른 방법으로 이를 생략하고 우선순위 큐 아래처럼 선언
        /**PriorityQueue<Node> pq = new PriorityQueue<Node>
         ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
         **/
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public class Main {
        static ArrayList<Node>[] graph;

        //노드의 크기, 출발지
        public static void Dijkstra(int n, int start) {
            //visitied 배열은 정점을 방문했는지 확인하고,
            // dist 배열은 출발지로부터 거리가 얼마나 되는지
            boolean[] visited = new boolean[n + 1];
            int[] dist = new int[n + 1];
            int INF = Integer.MAX_VALUE;

            //dist 배열은 INF(무한대) 값으로 초기화한다.
            Arrays.fill(dist, INF);

            //출발지는 방문으로 표시하고 dist배열 해당 인덱스에 0으로 기록한다.
            // 출발지 정점과 가중치를 우선순위 큐에 넣는다. 이때 우선순위는 가중치가 가장 작은 것이다.
            dist[start] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(start, 0));

            //큐가 빌 때 까지 다음을 반복한다.
            while(!pq.isEmpty()) {
                
                //큐 앞에 있는 값을 가져오고 삭제한다. 이를 now로 하겠다. 
                // 이때 가져온 값은 현재 큐에 있는 값 중 출발지로부터 가장 가까운 거리(=작은 가중치)를 가졌다
                int now = pq.poll().index;

                if(visited[now]) continue;
                visited[now] = true;
                //index의 연결된 정점 비교
                for(Node next : graph[now]) {
                    if(dist[next.index] > dist[now]+ next.cost) {
                        dist[next.index] = dist[now] + next.cost;

                        pq.offer(new Node(next.index, dist[next.index]));
                    }
                }
            }

            //최소거리 출력
            for(int i : dist) {
                if(i == INF) System.out.print(0 + " ");
                else System.out.print(i+" ");
            }
        }

        public static void main(String[] args) throws IOException {

            //그래프 입력 받기
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            //정점의 개수, 간선의 개수
            int n = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());

            graph = new ArrayList[n+1];
            for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

            StringTokenizer st;
            for(int i = 0 ; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph[v].add(new Node(w, cost));
            }

            int start = Integer.parseInt(bf.readLine());

            //다익스트라 알고리즘 수행
            Dijkstra(n, start);

        }
    }
}
