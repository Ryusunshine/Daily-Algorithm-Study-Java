package org.example.큐_스택;

import java.sql.Array;
import java.util.*;

public class 프로그래머스_프로세스 {

    class Solution {
        public int solution(int[] priorities, int location){
            // 1. Queue 설정해준다.
            List<PrinterJob> printer = new ArrayList<>();
            for (int i = 0; i < priorities.length; i++){
                printer.add(new PrinterJob(i, priorities[i]));
            }
            int turn = 0;
            while (!printer.isEmpty()){
                PrinterJob job = printer.remove(0);
                if (printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)){
                    printer.add(job);
                } else {
                    turn++;
                    if (job.location == location){
                        break;
                    }
                }
            }
            return turn;
        }

        public static class PrinterJob {
            int priority;
            int location;

            public PrinterJob(int location, int priority) {
                this.priority = priority;
                this.location = location;
            }
        }
    }


    // 우선 순위(priorityQueue)로 구현
    class Solution2 {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int num : priorities) {
                pq.add(num);
            }
            while(!pq.isEmpty()) {
                // pq가 빌때까지 계속 돌거야
                // 즉 pq에 들어있는 숫자들이 priorities에 순서에 맞을때 pop하니깐 그때동안 계속 도는거야
                for(int i=0; i < priorities.length; i++) {
                    if(priorities[i] == pq.peek()) {
                        pq.poll(); // 같으면 pq에서 빼주기
                        answer++;
                        if(i == location) // location은 몇번째를 구해야하는지에 대한 수야!(문제에서 인덱스역할을 하는거야)
                            return answer;
                    }
                }
            }
            return answer;
        }
    }
}
