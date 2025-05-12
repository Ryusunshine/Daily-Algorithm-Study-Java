package org.example.큐_스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 프로그래머스_기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            while (progresses.length > 0) {
                for (int i = 0; i < progresses.length; i++) {
                    progresses[i] += speeds[i];
                }
                int num = 0;
                while (progresses.length > 0 && progresses[0] >= 100) {
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

    //progresses = [93, 30, 55]
    //speeds = [1, 30, 5]
    //작업별 완료 일수: [7, 3, 9]
    //처리 흐름:
    //7 → 큐에 넣음
    //3 → 3 < 7이므로 같은 배포에 포함
    //9 → 9 > 7이므로 지금까지 2개 배포 (7, 3) → 2 저장, 큐 초기화, 9 넣기
    //마지막 큐 크기 1 저장
    class Solution1 {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> q = new LinkedList<>();
            List<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < speeds.length; i++) {
                double remain = (100 - progresses[i]) / (double) speeds[i];
                int date = (int) Math.ceil(remain); //각 기능마다 100까지 남은 작업량을 속도로 나눠서 남은 일 수 계산.
                //Math.ceil()은 자바에서 소수점 이하를 올림하는 함수

                if (!q.isEmpty() && q.peek() < date) { //date은 남은 날짜
                    answerList.add(q.size());
                    q.clear();
                }

                q.offer(date);
            }

            answerList.add(q.size());

            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }

    // 유투브
    class Solutioin2 {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++) {
                // 한개 기능을 개발하는데 필요한 날짜 계산
                double days = (double) (100 - progresses[i]) / (double) speeds[i];
                int daysUp = (int) Math.ceil(days); // int 형이 필요하기때문에 Math.ceil 함수 사용

                // 2. 함께 배포할 기능 찾기
                int j = i + 1;
                for (; j < progresses.length; j++)
                    if (progresses[j] + (daysUp * speeds[j]) < 100)
                        break;

                // 3. 이번에 배포할 개수 측정하기
                // 함께 배포할수 없는 인덱스에서 현재 인덱스를 빼주면 그 사이에 몇개를 한번에 배포할수 있는지
                answer.add(j - i);
                i = j - 1;
                // i 와 j사이에 있던 기능들은 이 answer에 한번에 배포가 되었기 때문에 그 다음 i번째는 j에서 시작하길 원해서 j-1 돼서 그 다음 for 문이 돌때는 i++ 이 돼서 j번째로 시작한다.
            }

            return answer.stream().mapToInt(x -> x).toArray();
        }
    }

}
