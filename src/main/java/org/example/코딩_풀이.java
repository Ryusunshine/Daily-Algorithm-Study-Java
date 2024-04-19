package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 코딩_풀이 {
    public class Solution1 {
        public int[] solution(int[] array) {
            int sum = 0;
            for (int i : array) {
                sum += i;
            }
            int[] answer = new int[array.length];
            for (int j : array) {
                answer[j] = sum - j;
            }
            return answer;
        }
    }

    public class Solution2 {
        public int solution(int[] array) {
            int now = array[0];
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                if (now > array[i]) now = array[i];
                else if (now < array[i]) {
                    sum += array[i] - now;
                    now = array[i];
                }
            }
            return sum;
        }
    }


    public class Solution3 {
        public int solution(int[] cards) {
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i <= 51; i++) {
                if (i <= 12) {
                    map.put(i, "SPADE");
                } else if (i <= 25) {
                    map.put(i, "HEART");
                } else if (i <= 38) {
                    map.put(i, "DIAMOND");
                } else {
                    map.put(i, "CLOVA");
                }
            }

            int[] numCnt = new int[13];
            int[] shapeCnt = new int[4];
            int[] results = new int[5];

            for (int i = 0; i < cards.length; i++) {
                int num = cards[i] % 13;
                String shape = map.get(cards[i]);
                numCnt[num]++;
                switch (shape) {
                    case "SPADE":
                        shapeCnt[0]++;
                        break;
                    case "HEART":
                        shapeCnt[1]++;
                        break;
                    case "DIAMOND":
                        shapeCnt[2]++;
                        break;
                    case "CLOVA":
                        shapeCnt[3]++;
                        break;
                }
                results[i] = num;
            }

            Arrays.sort(results);
            boolean isContinuous = (results[4] - results[0] == 4) ||
                    (results[0] == 0 && results[4] == 12);
            boolean sameShape = false;
            for (int cnt : shapeCnt) {
                if (cnt == 5) {
                    sameShape = true;
                    break;
                }
            }

            if (isContinuous && sameShape) return 1;
            for (int cnt : numCnt) {
                if (cnt == 4) return 2;
                if (cnt == 3) {
                    for (int c : numCnt) {
                        if (c == 2) return 3;
                    }
                    return 6;
                }
            }

            if (sameShape) return 4;
            if (isContinuous) return 5;

            int pairCnt = 0;
            for (int cnt : numCnt) {
                if (cnt == 2) pairCnt++;
            }

            if (pairCnt == 2) return 7;
            if (pairCnt == 1) return 8;
            else return 9;
        }
    }


    public class Solution4 {
        public int solution(int[] array) {
            int max_sum = 0;
            int now = 0;
            for (int i = 0; i < array.length - 2; i++) {
                int cnt = 2;
                int sum = 0;
                now = array[i];
                for (int j = i + 1; j < array.length; j++) {
                    if (now > array[j]) now = array[j];
                    else if (now < array[j]) {
                        sum += array[j] - now;
                        now = array[j];
                        cnt--;
                    }
                    if (cnt == 0) {
                        max_sum = Math.max(max_sum, sum);
                    }
                }
            }
            return max_sum;
        }
    }
}

