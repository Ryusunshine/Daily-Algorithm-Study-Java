package org.example.투포인터;

import java.util.Scanner;

public class 인프런코테_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = i;
        }
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int lt = 1;
        int sum = 0;
        int answer = 0;
        for (int rt = 1; rt < n; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
