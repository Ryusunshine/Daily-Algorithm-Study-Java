package org.example.해시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 인프런코테_매출액의종류 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] intArr = new int[n];
        for (int i = 0; i< n; i++ ) {
            intArr[i] = sc.nextInt();
        }
        List<Integer> result = solution(n, m, intArr);

        // 결과를 공백으로 구분하여 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> solution(int n, int m, int[] intArr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i <m ; i++) {
            hashMap.put(intArr[i], hashMap.getOrDefault(intArr[i], 0) + 1);
        }
        answer.add(hashMap.size());

        for (int i = m; i < n; i++) { // 오른쪽 인덱스
            hashMap.put(intArr[i], hashMap.getOrDefault(intArr[i], 0) + 1);

            int j = i - m; // 왼쪽 인덱스
            hashMap.put(intArr[j], hashMap.get(intArr[j]) - 1);
            if (hashMap.get(intArr[j]) == 0) {
                hashMap.remove(intArr[j]);
            }
            answer.add(hashMap.size());

        }
        return answer;
    }
}
