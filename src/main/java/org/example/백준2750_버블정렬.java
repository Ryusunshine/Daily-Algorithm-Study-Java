package org.example;

import java.util.Scanner;

public class 백준2750_버블정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i=0;i<N; i++){
            A[i] = sc.nextInt(); // 정렬되지않은 배열
        }
        //버블정렬 구현
        //정렬된 값은 오른쪽에 고정. 따라서 j는 이미 정렬된 i 전까지만 루프돌면된다.
        for (int i = 0; i < N-1; i++) { //루프 도는횟수는 전체 배열의 개수의 -1
            for (int j = 0; j < N-1-i; j++){
                if (A[j] > A[j+1]) {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        // 정렬이 다 되었으면 그 배열 전체 다 돌면서 결과값 반환
        for (int a=0;a < N; a++){
            System.out.println(A[a]);
        }
    }
}
