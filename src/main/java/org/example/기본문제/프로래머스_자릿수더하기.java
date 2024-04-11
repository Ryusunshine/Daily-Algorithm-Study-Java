package org.example.기본문제;

public class 프로래머스_자릿수더하기 {
    public class Solution {
        public int solution(int n) {
            String s = String.valueOf(n);
            int answer = 0;

            for (int i = 0; i < s.length(); i++){
                String a = s.substring(i, i+1);
                answer += Integer.parseInt(a);
            }
            return answer;
        }
    }

    public class Solution2 {
        public int solution(int n) {
            int answer = 0;
            String[] array = String.valueOf(n).split("");
            for(String s : array){
                answer += Integer.parseInt(s);
            }
            return answer;
        }
    }
}
