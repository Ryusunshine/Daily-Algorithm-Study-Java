package org.example.해시;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.stream.Collectors.*;

public class 프로그래머스_의상 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> hash = new HashMap<>();
            for (String[] cloth : clothes) {
                hash.put(cloth[1], hash.getOrDefault(cloth[1], 0) + 1);
            }

            for (int val : hash.values()) {
                answer *= val + 1;  // 조합 -> 안입는 경우도 고려하기 위해 + 1
            }

            answer -= 1; // 모두 '안입음'일 경우 -1 해주기

            return answer;
        }
    }

    class Solution2 {
        public int solution(String[][] clothes) {
            return Arrays.stream(clothes)
                    .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                    .values()
                    .stream()
                    .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;

            //groupingBy(p -> p[1]):
            //의류 항목의 카테고리 (p[1])를 기준으로 그룹화합니다.
            //mapping(p -> p[0], counting()):
            //각 카테고리 내에서 의류 이름 (p[0])을 매핑한 후, 그 수를 셉니다.
            //이 결과는 각 카테고리별로 의류 항목의 개수를 가지는 맵 (Map<String, Long>)을 반환합니다.
//            값 추출 및 곱셈 (values().stream().collect(reducing(1L, (x, y) -> x * (y + 1))))
//
//            values().stream():
//            맵의 값 (카테고리별 의류 항목 수)을 스트림으로 변환합니다.
//                    collect(reducing(1L, (x, y) -> x * (y + 1))):
//            각 카테고리에서 의류 항목 수에 1을 더한 값을 모두 곱합니다.
//            (y + 1)을 하는 이유는 해당 카테고리에서 아무 것도 선택하지 않는 경우를 포함시키기 위해서입니다.
//            전체 조합에서 1을 뺌 (intValue() - 1)
//
//            최종 결과를 int로 변환한 후, 모든 카테고리에서 아무 것도 선택하지 않는 경우를 제외하기 위해 1을 뺍니다.

        }
    }
}
// hash.values().stream().reduce(1, (x, y) -> x *y);