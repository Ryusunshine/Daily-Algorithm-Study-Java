package org.example.큐_스택;

import java.util.Stack;

import static org.example.큐_스택.프로그래머스_괄호회전하기.Solution.solution;

public class 프로그래머스_괄호회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
    }

    public class Solution {
        static public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                // 만 앞의 문자열을 맨 뒤로 옮겨 회전
                String rotation = sb.substring(0, i);
                sb.delete(0,i);
                sb.append(rotation);

                Stack<Character> stack = new Stack<>();
                for (int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(j);
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
                if (stack.isEmpty()) {
                    answer++;
                }
            }
            return answer;
        }
    }
}

//StringBuffer:
//  동기화로 인해 오버헤드가 발생하여 싱글 쓰레드 환경에서는 성능이 조금 떨어질 수 있습니다.
//  동기화(synchronized)되어 있습니다. 즉, 멀티쓰레드 환경에서 안전(thread-safe)하게 사용할 수 있습니다.
//  각 메소드가 synchronized로 구현되어 있어서 여러 쓰레드가 동시에 접근할 때 안전합니다.
//StringBuilder:
//  동기화가 없기 때문에 싱글 쓰레드 환경에서 더 빠르게 작동합니다.
// 싱글 쓰레드 환경에서는 StringBuffer보다 성능이 우수합니다.

// 동기화는 시스템을 동시에 작동시키기 위해 여러 사건들을 조화시키는 것을 의미한다.

