package org.example.문자열;

public class 프로그래머스_문자열다루기 {
    class Solution {
        public boolean solution(String s) {
            if(s.length() != 4 && s.length() != 6) return false;
            for (int i=0;i<s.length();i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean solution(String s) {
            if(s.length() == 4 || s.length() == 6){
                try{
                    int x = Integer.parseInt(s);
                    return true;
                } catch(NumberFormatException e){
                    return false;
                }
            }
            else return false;
        }
    }
}
