package org.example.투포인터;

import java.util.Scanner;

/**
 * 인프런 연속부분수열 강의
 * 계속 풀어
 */
public class 인프런코테_연속부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] arr = a.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        String str = sc.nextLine();
        String[] numbers = str.split(" ");
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println(solution(numArr, m));
    }

    /**
     * !!!!!그림으로 생각해!!!!!!!
     * rt 포인터는 계속 더하는거고 lt는 빼는 역할을 하는 포인터야
     * rt 가르키는 값만 더하는거야
     * lt는 빼는 역할 하는거야
     */
    public static int solution(int[] numArr, int m) {
        int lt = 0;
        int sum = 0;
        int answer = 0;
        // rt 갈때마다(하나씩 증가할때마다) left 가 따라오면 되는거다
        for (int rt = 0; rt < numArr.length; rt++) {
            sum += numArr[rt]; // 먼저 rt 을 더하고 sum += numArr[rt] 확인. 그럼 이 부분이 lt right까지
            if (sum == m) // sum += numArr[rt]을 꼭 하고 sum 확인
                answer++; //
            // rt는 sum이 작을때만 증가하고 더하기(rt++);
            // lt는 sum 이 같거나 작을때만 (sum -= numArr[lt]) 빼고 증가하고 더하기(sum += numArr[lt])

            // sum이 더 크면, lt sum에서 빼고 lt rt를 따라오게 만들면 된다.
            // sum이 같거나 큰 경우에만 해당 while 돈다
            while (sum >= m) { //sum이 같아도 빼야지 (11115 같은 예 경우), left가 합이 현재 rt 있는 구간까지 따라오니깐
                sum -= numArr[lt++]; // sum에서 빼고나서 lt + 1를 증가시킨다.
                if (sum == m) answer++; // 현재
            }
        }
        return answer;
    }
}
