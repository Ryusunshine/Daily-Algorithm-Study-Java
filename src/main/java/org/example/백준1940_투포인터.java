package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준1940_투포인터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count = 0;
        // 투포인터 생성
        int i = 0; // 왼쪽 인덱스(처음 인덱스)
        int j = N - 1; //오른쪽 인덱스(마지막 인덱스)
        while (i < j) {
            if (A[i] + A[j] < M ) i++; //합이 적으면 왼쪽인덱스 증가
            else if (A[i] + A[j] > M) j--; // 합이 크면 오른쪽 인덱스 감소
            else {
                count ++;
                i ++;
                j --;
            }
        }
        System.out.println(count);
    }
}
