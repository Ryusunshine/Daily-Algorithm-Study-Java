package org.example.큐_스택;

import java.util.ArrayList;
import java.util.List;

public class 프로그래머스_기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            while (progresses.length > 0){
                for (int i = 0; i < progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
                int num = 0;
                while (progresses.length > 0 && progresses[0] >= 100){
                    // progresses[0] 에 접근하기 전에 우선 배열이 있는지 확인해야한다.(progresses.length > 0)
                    // 아니면 인덱스 오류남!!!!
                    progresses = removeElement(progresses);
                    speeds = removeElement(speeds);
                    num++;
                }
                if (num > 0) answer.add(num);
            }
            return answer.stream().mapToInt(x -> x).toArray();
        }

        // 배열의 첫 번째 요소를 제거한 새로운 배열을 반환하는 메소드
        private static int[] removeElement(int[] arr) {
            int[] newArr = new int[arr.length - 1];
            for (int i = 1; i < arr.length; i++) {
                newArr[i - 1] = arr[i];
            }
            return newArr;
        }
    }
}
