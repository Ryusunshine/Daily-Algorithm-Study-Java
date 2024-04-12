package org.example.해시;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 프로그래머스_해시_메뉴리뉴얼 {
    class Solution {
        static HashMap<String, Integer> hashMap;
        public String[] solution(String[] orders, int[] course) {
            ArrayList<String> answerList = new ArrayList<>();
            // 1. 각 order 정렬
            for (int i = 0; i < orders.length; i++) {
                char[] arr = orders[i].toCharArray(); // 알파벳 담는 배열 만든후, x, y, z 넣어서 알파벳순으로 정렬
                Arrays.sort(arr);
                orders[i] = String.valueOf(arr);
            }
            hashMap = new HashMap<>();
            // 2. course 길이 기준으로 orders에 있는 string배열 돌면서 알파벳 조합 만들기
            for (int courseLen : course){
                for (String order : orders){
                    combination("", order, courseLen); // 만든 조합은 hashMap에 담아져있음.
                }
                // course 길이 기준으로 모든 course 배열 한바퀴를 돌았으면, max 값 찾아서 배열에 담기
                if (!hashMap.isEmpty()){
                    int max = Collections.max(hashMap.values());

                    // 2 이상으로 나와야해
                    if (max> 1){
                        for (String key : hashMap.keySet()){
                            if (hashMap.get(key) == max){
                                answerList.add(key);
                            }
                        }
                    }
                    hashMap.clear(); /// 꼭 중요해!!!!!
                }
            }
            Collections.sort(answerList);
            String[] resultList = new String[answerList.size()];
            for (int a = 0; a < answerList.size(); a ++){
                resultList[a] = answerList.get(a);
            }
            return resultList;
        }

        private static void combination(String now, String left, int count){
            // now = 현재까지 만들어진 조합
            // left = 아직 사용되지 않은 알파벳
            // count= course 길이

            // 탈출조건
            if (count == 0){
                // 여태까지 만든 조합을 hashMap에 넣기
                hashMap.put(now, hashMap.getOrDefault(now, 0)+1);
                return ;
            }

            // 남아있는 알파벳 기준으로 돌면서 조합
            for (int i = 0; i < left.length(); i++){
                //남은애들중에서 i번째 알파벳을 뽑아서 붙여준다.
                // now+left.charAt(i) !!!!중요!!! STRING에서 알파벳만 가져오는것
                combination(now+left.charAt(i), left.substring(i+1), count-1);
            }

        }
    }
}
