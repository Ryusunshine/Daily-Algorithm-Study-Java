package org.example.기본문제;

public class 프로그래머스_정수제곱근판별 {
    // 타입이 0 이어야해!!!!1

    class Solution {
        public long solution(long n) {
            long answer = 0;
            long num = (long)Math.sqrt(n);
            if (Math.pow(num, 2) == n){
                answer = (long)Math.pow(num+1, 2);
            } else {
                answer = -1;
            }
            return answer;
        }
    }
}
