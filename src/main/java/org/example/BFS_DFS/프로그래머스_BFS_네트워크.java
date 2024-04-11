package org.example.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_BFS_네트워크 {
    static boolean visited[];
    static Queue<Integer> que = new LinkedList<>();

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                BFS(i, computers,n); // 현재 노드
                answer++;
            }
        }

        return answer;
    }

    static void BFS(int i, int computers[][], int n) {
        que.offer(i);
        visited[i] = true;

        while(!que.isEmpty() ) {
            int now = que.poll();

            for(int j=0; j<n; j++) {
                if(!visited[j] && computers[now][j] == 1) {
                    visited[j] = true;
                    que.offer(j);
                }
            }

        }
    }
}
