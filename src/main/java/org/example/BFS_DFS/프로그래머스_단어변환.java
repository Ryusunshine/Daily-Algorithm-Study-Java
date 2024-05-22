package org.example.BFS_DFS;

public class 프로그래머스_단어변환 {
    class Solution {
        static boolean[] visited;
        static int answer = 0;

        public int solution(String begin, String target, String[] words) {
            visited = new boolean[words.length];

            dfs(begin, target, words, 0);
            return answer;
        }

        public static void dfs(String begin, String target, String[] words, int cnt) {
            if (begin.equals(target)) {
                answer = cnt;
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue; //게속 돌면 안되니깐 이미 방문한 단어 인덱스는 패스

                int k = 0;
                for (int j = 0; j < begin.length(); j++) { // 알파벳끼리 확인
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        k++;
                    }
                }

                if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                    visited[i] = true;
                    dfs(words[i], target, words, cnt + 1);// dfs 끝나면
                    visited[i] = false; // 다시 방문처리 원상복구
                    //visited[i] = false는 DFS에서 경로를 탐색할 때 한 번 방문한 노드를 다른 경로에서도 사용할 수 있도록 해주는 역할
                }
            }
        }
    }
}
