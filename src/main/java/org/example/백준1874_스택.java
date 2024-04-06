package org.example;

import java.util.Scanner;
import java.util.Stack;

public class 백준1874_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i  < N; i++){
            A[i] = sc.nextInt(); // 숫자를 우선 배열에 넣기
        }

        boolean result = true;
        Stack<Integer> stack = new Stack<>();
        int stack_num = 1;// 처음 스택을 시작할 자연수값 , 스택은 계속 쌓이는거얌
        StringBuffer bf = new StringBuffer(); // 결과값

        for (int i = 0; i<N; i++){
            int target = A[i];
            if (target >= stack_num){
                while (target >= stack_num){ // 값이 같아질때까지 스택에 넣기
                    stack.push(stack_num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else { // 작은경우
                int n = stack.pop(); //데이터 일단 제거
                if (n > target) { //스택 pop결과값 > 수열의 수
                    System.out.println("NO");
                    result = false;
                    break;
                } else { // 만약 크지 않다면
                    bf.append("-\n");
                }
            }
        }
        if (result) System.out.println(bf.toString());
    }
}
