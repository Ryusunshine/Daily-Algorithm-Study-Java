package org.example.투포인터;

import java.util.Scanner;

public class 백준2018_투포인터 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;
        while (end_index != N) { // 마지막 인덱스가 아닐떄까지
            if (sum == N) {
                count ++;
                end_index++;
                sum = sum+end_index; // count 증가해줬으니깐 end_index를 증가해서 sum에다가  end_index를 더해준다.
            } else if (sum > N){
                sum = sum - start_index;
                start_index ++;
            } else {
                end_index++; sum = sum+end_index;
            }
        }
        System.out.println(count);
    }
}
