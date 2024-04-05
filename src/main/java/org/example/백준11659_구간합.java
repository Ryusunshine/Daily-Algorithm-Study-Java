package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준11659_구간합 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(buff.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken()); // 구간의 개수
        int b = Integer.parseInt(stringTokenizer.nextToken()); // 쿼리의 개수

        long[] s = new long[a + 1]; // 합배열 초기화

        stringTokenizer = new StringTokenizer(buff.readLine()); // 다음 줄에 구간 값들이 주어지므로 다시 읽어야 함
        for (int i = 1; i <= a; i++) {
            // 값을 받자마자 전의 합에다가 더해준다.
            s[i] = s[i - 1] + Integer.parseInt(stringTokenizer.nextToken()); // 합배열 구성
        }

        for (int q = 0; q < b; q++) { // q <= b 에서 q < b로 수정
            stringTokenizer = new StringTokenizer(buff.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i - 1]); // 구간 합 출력
            }
    }
}
