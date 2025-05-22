package org.example.큐_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//백준_쇠막대기
// 괄호는 거의 스택 문제
public class 백준10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop(); // 이 시점에서 '('은 이미 pop되어 없어짐
                if (str.charAt(i -1) == '(') // 이전이 (이면 레이저
                    answer += stack.size();
                else answer ++; //아니면 막대기의 끝
            }
        }
        System.out.println(answer);
    }
}
