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
                for(int i=0; i<priorities.length; i++) {
                    if(priorities[i] == pq.peek()) {
                        pq.poll();
                        answer++;
                        if(i == location)
                            return answer;
                    }
                }
            }
            return answer;
        }
    }
}
