package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준1697_BFS
public class 백준1697_BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, -1); // 방문하지 않은 곳은 -1로 초기화
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = 0; // 초기 위치 방문 처리

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == m) { // 목표 위치 도달 시 종료
                System.out.println(visited[cur]);
                return;
            }

            int[] nextPos = {cur - 1, cur + 1, cur * 2}; // 이동할 수 있는 세 방향
            for (int next : nextPos) {
                if (next >= 0 && next <= 100000 && visited[next] == -1) { // 범위 체크
                    visited[next] = visited[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }
}