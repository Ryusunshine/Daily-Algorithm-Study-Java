package org.example.BFS_DFS;

import java.util.*;

public class 프로그래머스_카카오컬러링북 {
    class Solution {
        static boolean[][] visited;
        static int[] dx = {1, 0, -1, 0};
        static int[] dy = {0, -1, 0, 1};
        static int max_cnt;
        public int[] solution(int m, int n, int[][] picture) {
            visited = new boolean[m][n];
            int cnt = 0;
            max_cnt = 0;
            for (int i =0 ; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (picture[i][j] != 0){
                        bfs(i, j, m, n, picture);
                        cnt++;
                    }
                }
            }
            int[] answer = {cnt, max_cnt};
            return answer;
        }

        private static void bfs(int a, int b, int m, int n, int[][] picture){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {a,b});
            visited[a][b] = true;
            int num = picture[a][b];
            int num_cnt = 1;
            picture[a][b] = 0;

            while (!queue.isEmpty()){
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                for (int i = 0; i< 4; i++){
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    if (nx < 0 || ny < 0 || nx > m-1 || ny > n-1) continue;
                    if (visited[nx][ny]) continue;
                    if (picture[nx][ny] == 0 || picture[nx][ny] != num) continue;
                    visited[nx][ny] = true;
                    picture[nx][ny] = 0;
                    queue.offer(new int[] {nx,ny});
                    num_cnt++;
                }
            }
            max_cnt = Math.max(max_cnt, num_cnt);

        }
    }
}

// 풀이 2
//class Solution2 {
//    static int[] dx = {1, 0, -1, 0};
//    static int[] dy = {0, -1, 0, 1};
//    static Queue<int[]> q;
//    static int max_num;
//    static int total_cnt;
//
//    public int[] solution(int m, int n, int[][] picture) {
//        max_num = 0;
//        total_cnt = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (picture[i][j] != 0) {
//                    bfs(i, j, picture, m, n);
//                    total_cnt++;
//                }
//            }
//        }
//        return new int[]{total_cnt, max_num};
//    }
//
//    public void bfs(int a, int b, int[][] picture, int m, int n) {
//        q = new LinkedList<>();
//        q.offer(new int[]{a, b});
//        int cnt = 1;
//        int num = picture[a][b];
//        picture[a][b] = 0;
//
//        while (!q.isEmpty()) {
//            int[] now = q.poll();
//            int x = now[0];
//            int y = now[1];
//
//            for (int i = 0; i < 4; i++) {
//                int nx = dx[i] + x;
//                int ny = dy[i] + y;
//
//                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
//                    if (picture[nx][ny] == num) {
//                        cnt++;
//                        q.offer(new int[]{nx, ny});
//                        picture[nx][ny] = 0;
//                    }
//                }
//            }
//        }
//        if (cnt > max_num) {
//            max_num = cnt;
//        }
//    }
//}
