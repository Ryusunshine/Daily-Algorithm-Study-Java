package org.example.완전탐색;

import java.util.ArrayList;

public class 프로그래머스_모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            int[] first = {1,2,3,4,5}; // 5개씩 반복
            int[] second = {2,1,2,3,2,4,2,5}; // 8개씩 반복
            int[] third = {3,3,1,1,2,2,4,4,5,5}; // 10개씩 반복
            int[] score = {0,0,0};

            for (int i = 0; i< answers.length; i++){
                if (first[i%5] == answers[i]) score[0]++;
                if (second[i%8] == answers[i]) score[1]++;
                if (third[i%10] == answers[i]) score[2]++;
            }
            // 최대 점수 구하기
            int max = Math.max(score[0], Math.max(score[1], score[2]));

            ArrayList<Integer> result= new ArrayList<>();
            for (int a = 0; a< score.length; a++){
                if (score[a] == max) result.add(a+1);
            }

            return result.stream().mapToInt(n->n).toArray();
        }
    }

}
