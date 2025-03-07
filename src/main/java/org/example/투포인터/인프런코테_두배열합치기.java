package org.example.투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 인프런코테_두배열합치기 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        int[] a = new int[input1];
        for (int i = 0; i < input1; i++) {
            a[i] = in.nextInt();
        }
        int input2 = in.nextInt();
        int[] b = new int[input2];
        for (int i = 0; i < input2; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> answer = solution(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
            if (i < answer.size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    public static ArrayList<Integer> solution(int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int aPoint = 0;
        int bPoint = 0;
        while (aPoint < a.length && bPoint < b.length){
            if (a[aPoint] < b[bPoint]) {
                answer.add(a[aPoint++]);
            } else if (a[aPoint] > b[bPoint]) {
                answer.add(b[bPoint++]);
            } else {
                answer.add(b[bPoint++]);
                answer.add(a[aPoint++]);
            }
        }

        while (aPoint < a.length){
            answer.add(a[aPoint++]);
        }

        while (bPoint < b.length){
            answer.add(b[bPoint++]);
        }

        return answer;
    }
}
