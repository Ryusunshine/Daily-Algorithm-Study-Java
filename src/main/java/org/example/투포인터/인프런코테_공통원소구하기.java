package org.example.투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 인프런코테_공통원소구하기 {
    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] input1Arr = new int[input1];
        for (int a = 0; a < input1; a++) {
            input1Arr[a] = in.nextInt();
        }
        int input2 = in.nextInt();
        int[] input2Arr = new int[input2];
        for (int b = 0; b < input1; b++) {
            input2Arr[b] = in.nextInt();
        }

        ArrayList<Integer> answer = solution(input1Arr, input2Arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
            if (i < answer.size() - 1) {
                sb.append(" "); // 마지막 요소 뒤에는 공백 추가 안 함
            }
        }

        System.out.println(sb);
    }

    public static ArrayList<Integer> solution(int[] input1Arr, int[] input2Arr) {
        Arrays.sort(input1Arr);
        Arrays.sort(input2Arr);
        int a = 0;
        int b = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (a < input1Arr.length && b < input2Arr.length) {
            if (input1Arr[a] == input2Arr[b]) {
                answer.add(input1Arr[a++]);
                b++;
            } else if (input1Arr[a] < input2Arr[b]){
                a++;
            } else {
                b++;
            }
        }
        return answer;
    }
}
