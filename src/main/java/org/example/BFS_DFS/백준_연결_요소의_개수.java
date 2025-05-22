package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//연결_요소의_개수
public class 백준_연결_요소의_개수 {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[x+1];
        for (int i = 0; i <= x; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int cnt = 0;
        for (int i = 1; i <= x; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }


        System.out.println(cnt);
    }

    private static void bfs(int j) {
        visited[j] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(j);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!graph.get(cur).isEmpty()) {
                for (int x : graph.get(cur)) {
                    if (!visited[x]) {
                        queue.offer(x);
                        visited[x] = true;
                    }
                }
            }
        }
    }
}
