package org.example.기본문제;

public class 프로그래머스_나머지가1이_되는수_찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int i = 2; i< n; i++){ //매개변수를 2부터 나누어 나머지가 1인 수를 리턴하게 하였다.
                if (n % i == 1){
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
