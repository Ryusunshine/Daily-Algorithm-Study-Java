package org.example.기본문제;

public class 프로그래머스_자연수뒤집어_배열로만들기 {
    class Solution {
        public int[] solution(long n) {
            String s = String.valueOf(n);
            int[] answer = new int[s.length()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = Integer.parseInt(s.substring(answer.length-1-i, answer.length-i));
            }
            return answer;
        }
    }
}
