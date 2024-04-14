package org.example.해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 프로그래머스_귤고르기 {
    // hashmap은 .size()
    class Solution {
        public int solution(int k, int[] tangerine) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i: tangerine){
                hashMap.put(i, hashMap.getOrDefault(i, 0)+1);
            }
            ArrayList<Integer> valueList = new ArrayList<>();
            for (int j: hashMap.values()){
                valueList.add(j);
            }
            Collections.sort(valueList);
            int cnt = 0;
            for (int a = 0; a < valueList.size(); a++){
                int num = valueList.get(valueList.size()-1-a);
                if (k <= num) {
                    cnt++;
                    break;
                } else if (k > num){
                    k -= num;
                    cnt++;
                }
            }

            return cnt;
        }
    }
}
