package org.example.문자열;

public class 프로그래머스_문자열바꿔서찾기 {

    class Solution {
        public int solution(String myString, String pat) {
            int answer = 0;
            String s = "";
            for (int i = 0; i < myString.length(); i++){
                if("A".equals(myString.substring(i, i+1))) s += "B";
                else s += "A";
            }
            if (s.contains(pat)) return 1;
            else return 0;
        }
    }

    class Solution2 {
        public int solution(String myString, String pat) {
            myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");
            return myString.contains(pat) ? 1 : 0;
        }
    }
}
