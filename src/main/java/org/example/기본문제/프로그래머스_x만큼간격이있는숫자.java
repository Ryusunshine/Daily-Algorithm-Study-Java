package org.example.기본문제;

import java.util.ArrayList;

public class 프로그래머스_x만큼간격이있는숫자 {
    class Solution {
        public long[] solution(long x, long n) {
            ArrayList<Long> list = new ArrayList<>();
            list.add(x);
            long num = x;
            for (int i = 0; i < n-1; i++){
                num += x;
                list.add(num);
            }
            return list.stream().mapToLong(a->a).toArray();
        }
    }
}
