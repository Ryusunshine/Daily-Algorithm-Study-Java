package org.example.투포인터;

import java.util.Arrays;
import java.util.Scanner;

//3
//1 3 5
//5
//2 3 6 7 9
public class 인프런코테_최대매출 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String[] input1Arr = input1.split(" ");
        int n = Integer.parseInt(input1Arr[0]);
        int k = Integer.parseInt(input1Arr[1]);

        String input2 = in.nextLine();
        int[] window = new int[n];
        String[] input2Arr = input2.split(" ");
        for (int i = 0; i < n; i++) {
            window[i] = Integer.parseInt(input2Arr[i]);
        }
        System.out.println(solution(window, k));
    }

    public static int solution(int[] window, int k) {
        int answer = 0;
        int totalSum = 0;
        // 초기화값 설정
        for (int i = 0; i < k; i++) { // k 까지의 초기 sum 더하기
            totalSum += window[i];
        }
        answer = totalSum;
        for (int i = k; i < window.length; i++) { //i = 오른쪽 인덱스값
            //j = 왼쪽 인덱스값
            int j = i - k;
            totalSum += window[i];
            totalSum -= window[j];
            answer = Math.max(answer, totalSum);
        }
        return answer;
    }
}
