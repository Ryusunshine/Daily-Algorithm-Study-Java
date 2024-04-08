package org.example.문자열;

public class 프로그래머스_문자열뒤집기 {
    class Solution {
        public String solution(String my_string) {

            StringBuffer str = new StringBuffer(my_string);

            return str.reverse().toString();
        }
    }
}


