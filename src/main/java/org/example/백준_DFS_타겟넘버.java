package org.example;

public class 백준_DFS_타겟넘버 {
    static int answer;
    static int[] numbers = {1, 1, 1, 1, 1};
    static int target = 3;
    public static void main(String[] args) {
        answer =0;

        dfs(numbers, target, 0, 0);
        System.out.println(answer);
    }

    static void dfs(int[] numbers, int target, int now, int depth){
        if (depth == numbers.length){
            if (now == target){
                answer ++;
            }
            return ; // 중요!!!!!
        }
        dfs(numbers, target, now+numbers[depth], depth+1);
        dfs(numbers, target, now-numbers[depth], depth+1);
    }
}
