package org.example.그리디;

import java.util.Arrays;

public class 프로그래머스_h_index {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++){
                int h = citations.length - i;
                if (citations[i] >= h) {
                    answer = h;
                    break;
                }
            }
            return answer;
        }
    }

// 3 0 6 1 5 4
// 0 1 3 4 5 6
// 3 0 6 1 5
// 0 1 3 5 6

}
