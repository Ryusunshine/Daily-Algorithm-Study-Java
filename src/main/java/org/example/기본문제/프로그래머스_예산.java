package org.example.기본문제;

import java.util.Arrays;

public class 프로그래머스_예산 {
    class Solution {
        public int solution(int[] d, int budget) {
            Arrays.sort(d);
            int sum = 0;
            int cnt = 0;
            for (int a : d){
                if (sum + a <= budget){
                    sum += a;
                    cnt++;
                } else {
                    break;
                }
            }
            return cnt;
        }
    }

}
