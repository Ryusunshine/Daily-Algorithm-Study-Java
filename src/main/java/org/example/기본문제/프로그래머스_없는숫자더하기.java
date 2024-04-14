package org.example.기본문제;

import java.util.ArrayList;
import java.util.Arrays;

public class 프로그래머스_없는숫자더하기 {
    class Solution {
        public int solution(int[] numbers) {
            Arrays.sort(numbers);
            ArrayList<Integer> intList = new ArrayList<>();
            for (int num : numbers){
                intList.add(num);
            }
            int answer = 0;
            for (int i = 1; i<= 9; i++){
                if (!intList.contains(i)){
                    answer += i;
                }
            }
            return answer;
        }
    }

    class Solution2 {
        public int solution(int[] numbers) {
            int sum = 45;
            for (int i : numbers) {
                sum -= i;
            }
            return sum;
        }
    }

}
