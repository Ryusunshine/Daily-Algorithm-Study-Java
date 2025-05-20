package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_단지번호붙이기 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine(); // 한 줄 전체 읽기
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0'; // 문자 → 숫자
            }
        }

        int answer = 0;
        List<Integer> answerList = new ArrayList<>();
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (graph[a][b] == 1) {
                    answer++;
                    int cnt = bfs(a, b);
                    answerList.add(cnt);
                }
            }
        }

        System.out.println(answer);
        Collections.sort(answerList); // 오름차순 정렬
        answerList.forEach(System.out::println);
    }

    private static int bfs(int i, int j) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        graph[i][j] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k], ny = cur[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < graph.length && ny < graph[0].length) {
                    if (graph[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        graph[nx][ny] = 0;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
