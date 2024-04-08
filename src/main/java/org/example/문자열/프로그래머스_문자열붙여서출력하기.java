package org.example.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 프로그래머스_문자열붙여서출력하기 {

    public class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String b = sc.next();
            System.out.println(a+b);
        }
    }

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(br.readLine().replaceAll(" ", ""));
        }
    }
}
