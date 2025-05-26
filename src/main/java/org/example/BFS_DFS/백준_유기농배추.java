package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_유기농배추 {
    static int[][] graph;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new int[m][n];
            for (int j = 0; j < c; j++) {
                StringTokenizer xy = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(xy.nextToken());
                int b = Integer.parseInt(xy.nextToken());
                graph[a][b] = 1;
            }

            int answer = 0;
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (graph[x][y] == 1) {
                        bfs(x, y);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a,b});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) {
                    continue;
                }
                if (graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    graph[nx][ny] = 0;
                }
            }
        }
    }
}

