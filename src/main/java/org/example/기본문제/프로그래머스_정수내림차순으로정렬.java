package org.example.기본문제;

import java.util.Arrays;

public class 프로그래머스_정수내림차순으로정렬 {
    class Solution {
        public long solution(long n) {
            String[] list = String.valueOf(n).split("");
            Arrays.sort(list);

            StringBuilder sb = new StringBuilder();
            for (String a : list) sb.append(a);

            return Long.parseLong(sb.reverse().toString());
        }
    }

    class Solution2 {
        public long solution(long n) {
            String m = String.valueOf(n);
            String[] arr = new String[m.length()];
            for (int i = 0; i < m.length(); i++){
                arr[i] = m.substring(i, i+1);
            }
            Arrays.sort(arr);
            String num = "";
            for (int j = 0; j < arr.length; j++){
                num += arr[arr.length-1-j];
            }
            return Long.valueOf(num);
        }
    }
}
