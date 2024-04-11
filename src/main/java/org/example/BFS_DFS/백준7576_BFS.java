package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준7576_BFS {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] graph;
    static int n, m;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) { // 값이 1이면 바로 큐에 넣기
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs();
        int max = 0;
        boolean fail = false;
        for (int i = 0; i< n; i++){
            for (int j = 0; j<m; j++){
                int num = graph[i][j];
                if (num == 0){
                    fail = true;
                }
                max= Math.max(max, num);
            }
        }
        if (fail) System.out.println(-1);
        else System.out.println(max-1);
    }


    private static void bfs(){
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int a = 0; a <4; a++){
                int x = now[0] + dx[a];
                int y = now[1] + dy[a];
                if (x >= 0 && y >= 0 && x < n && y < m){
                    if (graph[x][y] == 0){
                        q.add(new int[]{x,y});
                        graph[x][y]  =graph[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
