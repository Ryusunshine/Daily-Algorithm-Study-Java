package org.example.문자열;

public class 프로그래머스_배열에서_문자열_대소문자_변환하기 {
    class Solution {
        public String[] solution(String[] strArr) {
            String[] answer = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++){
                if (i%2 == 1){
                    answer[i] = strArr[i].toUpperCase();
                } else {
                    answer[i] = strArr[i].toLowerCase();
                }
            }
            return answer;
        }
    }

}
