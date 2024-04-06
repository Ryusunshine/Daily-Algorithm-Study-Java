package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class practice {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int[] answer = {};
        for (int i = 1; i < arr.length; i++){
            //같으면 패스
            //서로 다르면 stack 에 push
            int now = arr[i];
            if (stack.peek() != now){
                stack.push(now);
            }
        }
        answer = new int[stack.size()];
        for (int j = stack.size()-1; j >= 0; j--){
            answer[j] = stack.pop();
            System.out.println(answer[j]);
        }
    }
}

