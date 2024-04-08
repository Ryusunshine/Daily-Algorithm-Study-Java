package org.example.문자열;

public class 프로그래머스_문자열_편지 {
    class Solution {
        public int solution(String message) {
            StringBuffer sb = new StringBuffer(message);
            int answer = 0;
            return sb.length()*2;
        }
    }
}
