package org.example.그리디;

import java.util.Scanner;

public class 백준11047_그리디 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //현재금액
        int k = sc.nextInt(); // 목표금액
        int[] A = new int[n];
        for (int i = 0; i<n; i++){
            A[i] = sc.nextInt();
        }
        int count = 0;
        for (int j = n-1; j> 0; j--){ // 중요!!! 뒤에서부터 돌아!!!
            if (A[j] <= k){
                count += (k/A[j]);
                k = k%A[j];
            }
        }
        System.out.println(count);
    }
}
