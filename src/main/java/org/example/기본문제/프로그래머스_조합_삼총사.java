package org.example.기본문제;

public class 프로그래머스_조합_삼총사 {
    class Solution {
        public int solution(int[] number) {
            int cnt = 0;
            for (int i = 0; i < number.length-2; i++){
                for (int j = i+1; j<number.length-1; j++){
                    for (int k = j+1; k < number.length; k++){
                        if (number[i]+number[j]+number[k] == 0){
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }
}
