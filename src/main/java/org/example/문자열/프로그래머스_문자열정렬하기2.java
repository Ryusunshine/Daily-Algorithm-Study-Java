package org.example.문자열;

import java.util.Arrays;

public class 프로그래머스_문자열정렬하기2 {
    class Solution {
        public String solution(String my_string) {
            String answer = "";
            String[] strArr = my_string.split("");
            for (int i = 0; i < strArr.length; i++){
                strArr[i] = strArr[i].toLowerCase();
            }
            Arrays.sort(strArr);
            for (int j = 0; j < strArr.length; j++){
                answer += strArr[j];
            }

            return answer;
        }
    }

    class Solution2 {
        public String solution(String my_string) {
            char[] c = my_string.toLowerCase().toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }

}
