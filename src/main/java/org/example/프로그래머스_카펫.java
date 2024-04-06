package org.example;

public class 프로그래머스_카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            //카펫 사이즈 경우의 수를 구하기 위해서 brown 격자 수 + yellow 격자 수의 약수를 구한다.
            int carpet = brown + yellow;

            //가운데에 노란색 격자가 위치하기 위해선 가로, 세로 길이가 모두 3 이상이여야 한다.
            for (int i = 3; i < carpet; i++) {
                int j = carpet / i;

                if (carpet % i == 0 && j >= 3) {
                    int col = Math.max(i, j);
                    int row = Math.min(i, j);
                    int center = (col - 2) * (row - 2);

                    if (center == yellow) {
                        answer[0] = col;
                        answer[1] = row;
                        return answer;
                    }
                }
            }
            return answer;
        }
    }
}
