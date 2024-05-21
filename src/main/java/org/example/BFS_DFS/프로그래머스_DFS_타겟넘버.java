package org.example.BFS_DFS;

public class 프로그래머스_DFS_타겟넘버 {
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

    class Solution {
        static int answer;
        public int solution(int[] numbers, int target) {
            answer = 0;
            dfs(0, target, 0, numbers);
            return answer;
        }

        public static void dfs(int now, int target, int depth, int[] numbers){
            if (depth == numbers.length){
                if (now == target){
                    answer++;
                    return ;
                } else {
                    return ;
                }
            }
            dfs(now + numbers[depth], target, depth+1, numbers);
            dfs(now - numbers[depth], target, depth+1, numbers);
        }
    }
}
