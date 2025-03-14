package org.example.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//백준2012_등수매기기
public class 백준2012_등수매기기 {
    // 그리디 문제
    // 원하는 등수에 넣어주면 불만족이 최소가 된다!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long sum = 0; // 불만도는 long 타입으로 해준다!! 왜냐하면 5십만은 int 범위를 넘어간다!!
        // 되도록 숫자합은 long 타입으로 선언해주기
        for (int i = 0; i < n; i++) {
            int rank = i + 1; // 등수는 1번부터
            // 구하는 값은 원하는 원하는 등수(arr[i])에서 현재 등수(rank) 빼는거야
            sum += Math.abs(arr[i] - rank);
        }
        System.out.println(sum);
    }
}
