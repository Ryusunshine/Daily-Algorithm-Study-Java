package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준12847_슬라이딩윈도우 {
    static int n,m;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] pay = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            pay[i] = Integer.parseInt(st.nextToken());
        }

        long sum_num = 0;
        for (int a = 0; a < m; a++){
            sum_num += pay[a];
        }

        max = sum_num;
        for (int i = m; i < n; i++){ // i는 맨 오른쪽 인덱스
            int j = i-m; // j 는 맨 왼쪽 인덱스
            sum_num += pay[i];
            sum_num -= pay[j];
            max = Math.max(max, sum_num);
        }
        System.out.println(max);
    }
}
