package org.example.그리디;

import java.util.*;

public class 프로그래머스_체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            HashSet<Integer> resSet = new HashSet<>();
            HashSet<Integer> lostSet = new HashSet<>();

            // reserveSet 세팅
            for (int i : reserve){
                resSet.add(i);
            }

            // lostSet 세팅
            for (int i : lost){
                //만약 잃어버린애가 여분 체육복을 가진(reserve리스트에 포함된 애)라면 reseveSEt에서 삭제
                if (resSet.contains(i)){
                    resSet.remove(i);
                } else {
                    lostSet.add(i);
                }
            }

            // 여분을 가지고 잇는 애들 앞뒤 보면서 lostSet 변경
            for (int i : resSet){
                if (lostSet.contains(i-1)){
                    lostSet.remove(i-1);
                } else if (lostSet.contains(i+1)){
                    lostSet.remove(i+1);
                }
            }
            return n - lostSet.size();
        }
    }

}
