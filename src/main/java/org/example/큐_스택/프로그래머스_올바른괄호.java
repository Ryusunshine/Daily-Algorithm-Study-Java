package org.example.큐_스택;

public class 프로그래머스_올바른괄호 {
    // 어렵게 생각하지 말고 우선 천천히 하나씩 조건문을 적어보자
    class Solution {
        boolean solution(String s) {
            boolean answer = true;
            int left = 0;
            int right = 0;
            for (int i = 0; i<s.length(); i++){
                if (s.charAt(i)== '('){
                    left++;
                } else if (s.charAt(i) == ')'){
                    right++;
                }
                if (left < right) return false;
            }
            if (left == right) return true;
            else return false; // 이 부분 안쓰면 오류남
        }
    }
}
