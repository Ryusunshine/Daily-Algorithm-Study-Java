package org.example.해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 문제: https://school.programmers.co.kr/learn/courses/30/lessons/72412

public class 프로그래머스_순위검색{
    public int[] solution(String[] info, String[] query) {
        // INFO를 기반으로 hashmap을 만든다.
        HashMap<String, ArrayList<Integer>> hashmap = new HashMap<>();

        for (String i : info) {
            String[] data = i.split(" ");
            String[] language = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);

            for (String lang : language) {
                for (String job : jobs) {
                    for (String exp : exps) {
                        for (String food : foods) {
                            String[] keyDate = {lang, job, exp, food};
                            String key = String.join(" ", keyDate);
                            ArrayList<Integer> arr = hashmap.getOrDefault(key, new ArrayList<>());
                            arr.add(value);
                            hashmap.put(key, arr);
                        }
                    }
                }
            }
        }
        // 2. hashmap의 value들을 오름차순으로 정렬한다.
        for (ArrayList<Integer> arr: hashmap.values()) {
            Collections.sort(arr);
        }

        // 3. query (조건)에 맞는 지원자를 가져온다.
        int[] answer = new int[query.length];
        int index = 0;
        for (String q : query){
            String[] component = q.split(" and ");
            int target = Integer.parseInt(component[3].split(" ")[1]);
            component[3] = component[3].split(" ")[0];
            String key = String.join(" ", component);

            if (hashmap.containsKey(key)) {
                ArrayList<Integer> list = hashmap.get(key);

                // 4. hashmap.values()에서 binary search를 통해서 원하는 값 이상의 수의 개수를 찾는다.
                int left = 0;
                int right = list.size();
                while (left < right) {
                    int mid = (left+right) / 2;
                    if (list.get(mid) >= target) {
                        right = mid; // 오른쪽 인덱스를 움직여야해
                    } else {
                        left = mid+1;
                    }
                }
                answer[index] = list.size() - left;
            }
            index ++;
        }
        return answer;
    }
}
