package org.example;

import java.util.Scanner;

public class 백준1541_그리디 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        int answer = 0;
        String[] str_list = example.split("-");
        for (int i = 0; i < str_list.length; i++){
            int temp = mySum(str_list[i]);
            if (i == 0) answer = answer + temp;
            else answer = answer - temp;
        }
        System.out.println(answer);
    }

    private static int mySum(String s) {
        int sum = 0;
        String[] temp = s.split("\\+");
        for (int i = 0; i<temp.length; i++){
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
