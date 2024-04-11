package org.example.기본문제;

public class 프로그래머스_최대공약수와_최소공배수 {

    class Solution {
        public int[] solution(int n, int m) {
            int max = Math.max(n, m);
            int min = Math.min(n,m);

            // 최대공약수
            while (min!= 0){
                int r = max % min;
                max = min;
                min = r;
            }

            // 최소 공배수 = 두 수의 곱 / 최대공약수
            int gcd = n * m / max;
            int[] answer = {max, gcd};
            return answer;
        }
    }
}
