package org.example.문자열;

public class 프로그래머스_문자열뒤의n글자 {
    class Solution {
        public String solution(String my_string, int n) {
            return my_string.substring(my_string.length()-n);
        }
    }
}
