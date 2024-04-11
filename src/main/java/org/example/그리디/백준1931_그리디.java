package org.example.그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 백준1931_그리디 {
    public static void main(String[] args) {
        /**
         * 1. 끝나는 시간으로 배열을 정렬하고 (일찍 끝나야 다음 회의를 또 진행함으로서 회의를 많이 할 수 있음)
         * 2. 첫번째 회의 끝나는 시간 <= 두번째 회의 시작. 이 조건에 해당하는가?
         */

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int endPoint = 0;
        int answer = 0;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        //일찍 끝나는 시간으로 배열을 정렬하고 (일찍 끝나야 다음 회의를 또 진행함으로서 회의를 많이 할 수 있음)
        Arrays.sort(arr, Comparator.comparingInt((int[] x) -> x[1]).thenComparingInt(x -> x[0]));

        for (int[] next : arr) {
            int nextStart = next[0];
            int nextEnd = next[1];
            if (endPoint <= nextStart) {
                answer++;
                endPoint = nextEnd;
            }
        }
        System.out.println(answer);

    }
}
