package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class 백준1920_이진탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int m = sc.nextInt();
        // 이진탐색
        for (int i = 0; i <m; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = A.length-1;
            while (start <= end) {
                int mid_index = (start + end) / 2;
                int mid_value = A[mid_index];
                if (mid_value > target) {
                    end = mid_index - 1;
                } else if (mid_value < target) {
                    start = mid_index + 1;
                } else { // 같이 같은경우, 즉 정답을 찾은경우
                    find = true;
                    break;
                }
            }
            if (find) System.out.println(1);
            else System.out.println(0);
        }
    }
}
