package org.example.기본문제;

public class 프로그래머스_이웃한칸 {
    class Solution {
        public int solution(String[][] board, int x, int y) {
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, -1, 0, 1};
            int n = board.length;
            int m = board[0].length;
            String color = board[x][y];
            int cnt = 0;
            for (int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx < 0 || ny < 0 || nx > n-1 || ny > m-1) continue;
                if (board[nx][ny].equals(color)) cnt++;
            }
            return cnt;
        }
    }
}
