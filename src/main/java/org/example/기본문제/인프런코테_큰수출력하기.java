package org.example.기본문제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 인프런코테_큰수출력하기 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = in.nextInt();
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(numArr[0]);
        for (int i = 1; i < n; i ++) {
            if (numArr[i] > numArr[i-1]) {
                answer.add(numArr[i]);
            }
        }
        for (int a : answer) System.out.print(a + " ");
    }
}
