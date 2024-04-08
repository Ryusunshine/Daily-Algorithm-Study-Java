package org.example.문자열;

public class 프로그래머스_부분문자열이어붙여문자열만들기 {
    class Solution {
        public String solution(String[] my_strings, int[][] parts) {
            String answer = "";
            for (int i = 0; i < my_strings.length; i++){
                int start = parts[i][0];
                int end = parts[i][1];
                String s = my_strings[i];
                String result = s.substring(start, end+1);
                answer += result;
            }
            return answer;
        }
    }

    class Solution2 {
        public String solution(String[] my_strings, int[][] parts) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < my_strings.length; i++) {
                sb.append(my_strings[i].substring(parts[i][0], parts[i][1] + 1));
            }

            return sb.toString();
        }
    }
}
