package org.example.해시;

import java.util.*;

public class 인프런코테_모든아나그램찾기 {
    public static int solution(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (tLen > sLen) return 0; // 예외 처리: T가 S보다 길면 불가능

        // 윈도우 끼리 비교할거야
        // 윈도우마다 알파벳 개수를 Hashmap에 넣울거야
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        int count = 0;

        // T 문자열의 문자 개수 카운트
        for (char c : t.toCharArray()) {
            bm.put(c, bm.getOrDefault(c, 0) + 1);
        }

        // s문자열 초기 윈도우 구성
        for (int i = 0; i < tLen; i++) {
            char c = s.charAt(i);
            am.put(c, am.getOrDefault(c, 0) + 1);
        }

        // 초기값끼리 비교
        if (bm.equals(am)) count++;

        // 슬라이딩 윈도우 이동
        for (int i = tLen; i < sLen; i++) {
            // rt, lt 포인터 설정
            char newChar = s.charAt(i); // 추가되는 문자
            char oldChar = s.charAt(i - tLen); // 제거되는 문자

            // 새 문자 추가
            bm.put(newChar, bm.getOrDefault(newChar, 0) + 1);
            // 이전 문자 제거
            if (bm.get(oldChar) == 1) {
                bm.remove(oldChar); // remove(key)
            } else {
                bm.put(oldChar, bm.get(oldChar) - 1);
            }

            // 아나그램 비교
            if (bm.equals(am)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();

        System.out.println(solution(s, t));
    }
}
