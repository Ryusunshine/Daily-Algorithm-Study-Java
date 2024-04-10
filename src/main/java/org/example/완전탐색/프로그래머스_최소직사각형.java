package org.example.완전탐색;

public class 프로그래머스_최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int max = 0;
            int min = 0;
            for (int i = 0; i< sizes.length; i++){
                int[] arr = sizes[i];
                int bigger = Math.max(arr[0], arr[1]);
                int smaller = Math.min(arr[0], arr[1]);
                max = Math.max(max, bigger);
                min = Math.max(min, smaller);
            }

            return max * min;
        }
    }

}
