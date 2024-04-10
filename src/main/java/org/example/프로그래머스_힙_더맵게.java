package org.example;

import java.util.PriorityQueue;

public class 프로그래머스_힙_더맵게 {
    public class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.offer(s);
            }

            int answer = 0;
            //peek = 큐의 처음에 있는 원소를 삭제하지 않고 가져온다. 큐가 비어있으면 null을 반환
            while (pq.peek() < K) {
                if (pq.size() < 2) {
                    return -1;
                }
                int a = pq.poll();
                int b = pq.poll();
                int mixedScoville = a + (b * 2);
                pq.offer(mixedScoville);
                answer++;
            }
            return answer;
        }
    }
}
