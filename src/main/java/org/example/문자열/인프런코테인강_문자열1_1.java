package org.example.문자열;

import java.util.Scanner;

public class 인프런코테인강_문자열1_1 {

    //    public class Main {
    public static int solution(String str, char ch) {
        int answer = 0;
        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        System.out.println(solution(str, ch));
    }
}

