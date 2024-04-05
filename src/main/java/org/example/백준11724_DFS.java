package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준11724_DFS {
    static boolean visited[]; // 방문 기록 저장 배열
    static ArrayList<Integer>[] A; // 그래프 데이터 저장 인접 리스트
    public static void main(String[] args) throws IOException {
        //그냥 외워!!!!!!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1]; // 노드가 1부터 시작하니깐
        A = new ArrayList[N+1]; // 1부터 노드가 시작하니깐 1
        
        // 이제 각 노드에서 인접리스트 생성해주기
        for (int i = 1; i < N+1; i++){
            A[i] = new ArrayList<Integer>();
        }

        for (int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

         int count = 0;
        // dfs
        for (int now = 1; now < N+1; now++){ // 방문하지 않은 노드가 있으면 count++;
            if (!visited[now]){
                count++;
                DFS(now);//이어진 깊은곳까지 탐색해서 방문안했으면 방문하고 visited로 바꿔주기
            }
        }
        System.out.println(count);
    }

    private static void DFS(int now) { //현재 노드가 방문노드이면 더이상 탐색x
        if (visited[now]){
            return;
        }
        visited[now] = true;
        for(int next: A[now]){
            if (!visited[next]){
                DFS(next);
            }
        }
    }
}
