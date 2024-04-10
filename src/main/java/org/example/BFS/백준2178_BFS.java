package org.example.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준2178_BFS {
    static int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] graph;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0'; // char를 int로 변환
            }
        }
        bfs(0, 0);
        System.out.println(graph[n - 1][m - 1]);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[x][y] + 1; // 이전 위치의 거리 + 1
                        queue.offer(new int[]{nx, ny}); // 방문한 노드를 큐에 추가
                    }
                }
            }
        }
    }
}