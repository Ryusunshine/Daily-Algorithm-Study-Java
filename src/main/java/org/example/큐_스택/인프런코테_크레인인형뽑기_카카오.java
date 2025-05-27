package org.example.큐_스택;

import java.util.Scanner;
import java.util.Stack;

public class 인프런코테_크레인인형뽑기_카카오 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        //board는 위에서부터 행이 0, 1, 2, 3, 4 이렇게 되어있음
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int pos : moves) { // 열 (뽑는 위치)
            for (int i = 0; i < board.length; i++) { //행 // board.length는 행 길이, i는 행 번호
                int num = board[i][pos - 1];
                if (num != 0) {
                    board[i][pos - 1] = 0; // 0으로 바꿔주기
                    if (!stack.isEmpty() && stack.peek() == num) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(num);
                    }
                    break; // break 정말 중요!!!! 모든 하나뽑으면 또 뽑음연 안됨
                }
            }
        }
        return answer;
    }
}
