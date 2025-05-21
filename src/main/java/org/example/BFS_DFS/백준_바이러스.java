package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_바이러스 {
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int connections  = Integer.parseInt(br.readLine());

        visited = new boolean[computers + 1]; // 1번 ~ computers번까지

        graph = new ArrayList<>();
        for (int i = 0; i <= computers; i++) { // graph = [[],[],[],[]] 형태로 만들기
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connections; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);

            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향 그래프
        }

        int answer = 0;
        bfs(1);

        for (boolean num : visited) {
            if (num) {
                answer++;
            }
        }
        System.out.println(answer-1);
    }

    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
