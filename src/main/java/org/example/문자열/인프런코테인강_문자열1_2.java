package org.example.문자열;

import java.util.Arrays;
import java.util.Scanner;

public class 인프런코테인강_문자열1_2 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        char[] arr = input1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (Character.isLowerCase(ch)) {
                arr[i] = Character.toUpperCase(ch);
            } else {
                arr[i] = Character.toLowerCase(ch);
            }
        }
        System.out.println(String.valueOf(arr));
    }
}
