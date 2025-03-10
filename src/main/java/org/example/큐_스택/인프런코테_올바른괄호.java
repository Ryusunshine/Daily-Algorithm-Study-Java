package org.example.큐_스택;

import java.util.Scanner;
import java.util.Stack;

public class 인프런코테_올바른괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c: str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // ) 이면 빼주면돼
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return "YES";
    }
}
