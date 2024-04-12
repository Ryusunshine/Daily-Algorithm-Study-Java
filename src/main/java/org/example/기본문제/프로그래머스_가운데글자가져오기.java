package org.example.기본문제;

public class 프로그래머스_가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            int mid_index = 0;
            if (s.length()%2 != 0){
                mid_index = (s.length()/2);
                answer += s.charAt(mid_index);
            } else {
                mid_index = (s.length()/2);
                answer += s.charAt(mid_index-1);
                answer += s.charAt(mid_index);
            }

            return answer;
        }
    }
}
