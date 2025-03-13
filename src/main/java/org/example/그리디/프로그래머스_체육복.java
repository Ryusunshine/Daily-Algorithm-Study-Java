package org.example.그리디;

import java.util.*;

public class 프로그래머스_체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            HashSet<Integer> resSet = new HashSet<>();
            HashSet<Integer> lostSet = new HashSet<>();

            // reserveSet 세팅
            for (int i : reserve) {
                resSet.add(i);
            }
            // 바로 i 를 빼줄수 있는 이유는 현재 set에 들어있는 숫자가 인덱스 역할하기 때문

            // lostSet 세팅
            for (int i : lost) {
                //만약 잃어버린애가 여분 체육복을 가진(reserve리스트에 포함된 애)라면 reseveSEt에서 삭제
                if (resSet.contains(i)) {
                    resSet.remove(i);
                } else {
                    lostSet.add(i);
                }
            }

            // 여분을 가지고 잇는 애들 앞뒤 보면서 lostSet 변경
            for (int i : resSet) {
                if (lostSet.contains(i - 1)) {
                    lostSet.remove(i - 1);
                } else if (lostSet.contains(i + 1)) {
                    lostSet.remove(i + 1);
                }
            }
            return n - lostSet.size();
        }
    }


    //배열로 풀기
    public int solution2(int n, int[] lost, int[] reserve) {
        int[] arr = new int[n + 2];

        for (int l : lost) {
            arr[l]--;
        }

        for (int r : reserve) {
            arr[r]++;
        }

        //12345
        for (int i = 1; i <= n; i++) { // 인덱스 범위 중요!!
            if (arr[i] == 1) {
                if (arr[i - 1] == -1) {
                    arr[i - 1]++;
                    arr[i]--;
                } else if (arr[i + 1] == -1) {
                    arr[i + 1]++;
                    arr[i]--;
                }
            }
        }

        int answer = 0;
        for (int j = 1; j <= n; j++) { // 인덱스 범위 주위!!!!!! ㅇ
            if (arr[j] >= 0) {// 0 이상이면 다 세줘!!!
                answer++;
            }
        }

        return answer;
    }
}
