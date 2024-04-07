package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice {
    static ArrayList<Integer>[] graph;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int v = Integer.parseInt(s[0]);
            int e = Integer.parseInt(s[1]);
            graph = new ArrayList[v+1];
            for (int j = 1; j < v+1; j++){
                graph[j] = new ArrayList<>();
            }
            for (int a = 0; a < e; a++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                graph[start].add(end);
                graph[end].add(start);
            }
            int cnt = 0;
            for(int x = 1; x < v+1; x++){
                cnt = 0;
                boolean[] visited = new boolean[v+1];
                visited[x] = true;
                for (int next : graph[x]){
                    if (!visited[next]){
                        bfs(next, visited);
                        cnt++;
                    }
                }
            }
            if (cnt==2) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void bfs(int x, boolean[] visited){
        q.offer(x);
        visited[x]= true;
        while (!q.isEmpty()){
            int now = q.poll();
            for (int next : graph[now]){
                if (!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}

