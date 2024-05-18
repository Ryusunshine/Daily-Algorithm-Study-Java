package org.example.복습;

import java.util.Stack;

public class 프로그래머스_괄호회전하기 {

    class Solution { //https://ittrue.tistory.com/518
        public int solution(String s) {
            // 올바른 괄호 문자열의 개수를 저장할 변수
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                // 주어진 문자열이 올바른 괄호 문자열인지 검사
                if (verification(s)) answer++;

                // 문자열을 한 칸씩 회전
                s = s.substring(1) + s.charAt(0);
            }

            return answer;
        }

        // 올바른 괄호인지 검사하는 함수
        private boolean verification(String s) {
            // 괄호를 저장할 스택
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                // 여는 괄호면 스택에 push
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else {
                    // 스택이 비어있는 경우
                    if (stack.isEmpty()) {
                        return false;
                    }

                    // 짝이 맞는 괄호면 스택에서 pop
                    if (stack.peek() == '(' && s.charAt(i) == ')')  {
                        stack.pop();
                    } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                        stack.pop();
                        // 짝이 맞지 않는 경우 false
                    } else return false;
                }
            }

            return stack.isEmpty();
        }
    }

    class Solution2 {
        public int solution(String s) {
            int answer = 0;
            String new_s = s;
            for(int i = 0; i < s.length(); i++){
                if(checkString(new_s)) answer++;
                new_s = new_s.substring(1, s.length()) + new_s.charAt(0);
            }

            return answer;
        }

        boolean checkString(String s){
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                try{
                    switch(s.charAt(i)){
                        case '[':
                            stack.add('[');
                            break;
                        case ']':
                            if(stack.peek() != '[') return false;
                            stack.pop();
                            break;
                        case '{':
                            stack.add('{');
                            break;
                        case '}':
                            if(stack.peek() != '{') return false;
                            stack.pop();
                            break;
                        case '(':
                            stack.add('(');
                            break;
                        case ')':
                            if(stack.peek() != '(') return false;
                            stack.pop();
                            break;
                    }
                } catch(Exception e){
                    return false;
                }
            }
            return stack.isEmpty() ? true : false;
        }
    }
}

