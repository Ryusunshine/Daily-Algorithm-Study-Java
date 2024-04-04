package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준2164_큐 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();
        int N = sc.nextInt();
        for (int i= 1; i<= N; i++){ //카드가 1부터 되어있으므로 시작인덱스를 1로한다.
            myQueue.add(i);
        }
        while (myQueue.size() > 1){ //큐의 사이즈가 1보다 클때까지 반복하고 카드가 한장 남으면 stop
            myQueue.poll(); //처음 카드는 버림
            myQueue.add(myQueue.poll()); //두번째 카드는 맨마지막에 다시 넣어줌
        }
        System.out.println(myQueue.poll()); //while 문을 벗어난거면 마지막 한장 남았을때임
    }
}
