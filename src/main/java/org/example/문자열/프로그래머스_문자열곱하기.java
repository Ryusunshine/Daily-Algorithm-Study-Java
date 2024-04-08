package org.example.문자열;

public class 프로그래머스_문자열곱하기 {
    class Solution1 {
        public String solution(String my_string, int k) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0;i < k;i++)
                sb.append(my_string);
            return sb.toString();
        }
    }

    class Solution2 {
        public String solution(String my_string, int k) {
            return my_string.repeat(k);
        }
    }

    class Solution3 {
        public String solution(String my_string, int k) {
            String answer = "";
            for (int i = 0; i < k; i++){
                answer += my_string;
            }

            return answer;
        }
    }

}
