package org.example.큐_스택;

import java.util.ArrayList;

public class 프로그래머스_큐_같은숫자는싫어 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        while (progresses.length > 0) {
            // 각 작업 진도에 속도를 더한다.
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int cnt = 0;
            // 진도가 100% 이상인 작업을 모두 처리
            while (progresses.length > 0 && progresses[0] >= 100) {
                progresses = removeElement(progresses); // 첫번째 요소 제거
                speeds = removeElement(speeds); //첫번째 요소 제거
                cnt++;
            }

            if (cnt > 0) {
                answer.add(cnt);
            }
        }
        return answer.stream().mapToInt(n->n).toArray();
    }

    // 배열의 첫 번째 요소를 제거한 새로운 배열을 반환하는 메소드
    private static int[] removeElement(int[] arr) {
        // 현재보다 하나 작은사이즈의 배열선언
        int[] newArr = new int[arr.length - 1];

        // 1부터 시작하면서 차례대로 배열에 담음
        for (int i = 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        return newArr;
    }

}

