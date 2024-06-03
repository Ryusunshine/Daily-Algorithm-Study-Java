package org.example.BFS_DFS;
import java.util.*;

public class 프로그래머스_게임맵최단거리 {
    class Solution {
        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, -1, 0, 1};
        public int solution(int[][] maps) {
            int answer = bfs(maps);
            return answer;
        }

        public static int bfs(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {0, 0});
            maps[0][0] = 0; // !!!!!!!!!!!이 부분 중요!!!!!!!!!!!
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                if (x == n-1 && y == m-1) return maps[x][y] + 1;  // 시작부분을 0으로 바꿔줬으니깐 마지막 도착에서 +1 해줘야함.
                for (int i = 0; i < 4; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m){
                        if (maps[nx][ny] == 1) {
                            maps[nx][ny] = maps[x][y] + 1;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
            return -1;
        }
    }
}
