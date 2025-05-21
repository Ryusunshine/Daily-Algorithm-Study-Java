package org.example.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_다리만들기 {
    static int[][] graph;
    static Queue<int[]> queue;
    static List<int[]> zeroQueue; // 수정: Queue → List
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int cnt;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        graph = new int[cnt][cnt];
        queue = new LinkedList<>();

        int min_cnt = Integer.MAX_VALUE;

        for (int i = 0; i < cnt; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < cnt; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        boolean[][] visitedAll = new boolean[cnt][cnt];
        int islandId = 2;

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                if (!visitedAll[i][j] && graph[i][j] == 1) {
                    // 섬마다 구분
                    zeroQueue = new ArrayList<>();
                    bfs_1(i, j, visitedAll, islandId);

                    for (int[] cur : zeroQueue) {
                        min_cnt = Math.min(min_cnt, bfs_2(cur[0], cur[1], islandId));
                    }
                    islandId++;
                }
            }
        }

        System.out.println(min_cnt);
    }

    private static void bfs_1(int a, int b, boolean[][] visitedAll, int islandId) {
        visited = new boolean[cnt][cnt];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        visited[a][b] = true;
        visitedAll[a][b] = true;
        graph[a][b] = islandId;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= cnt || ny >= cnt) continue;

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    visitedAll[nx][ny] = true;
                    graph[nx][ny] = islandId;
                    queue.offer(new int[]{nx, ny});
                } else if (!visited[nx][ny] && graph[nx][ny] == 0) {
                    zeroQueue.add(new int[]{cur[0], cur[1]});
                }
            }
        }
    }

    private static int bfs_2(int a, int b, int islandId) {
        boolean[][] visited = new boolean[cnt][cnt];
        Queue<int[]> findQueue = new LinkedList<>();
        findQueue.offer(new int[]{a, b, 0});
        visited[a][b] = true;

        while (!findQueue.isEmpty()) {
            int[] cur = findQueue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= cnt || ny >= cnt || visited[nx][ny]) continue;

                if (graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    findQueue.offer(new int[]{nx, ny, dist + 1});
                } else if (graph[nx][ny] != islandId) {
                    return dist;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
