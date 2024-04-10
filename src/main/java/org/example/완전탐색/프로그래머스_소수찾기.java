package org.example.완전탐색;

import java.util.HashSet;
import java.util.Iterator;

public class 프로그래머스_소수찾기 {
    static HashSet<Integer> hashSet = new HashSet<>();
    class Solution {
        public int solution(String numbers){
            int count = 0;
            // 1. 모든 조합의 숫자를 만든다.
            recursive("", numbers); // 처음 들어가는 값은 "", numbers
            //2. 소수의 개수만 센다
            Iterator<Integer> it = hashSet.iterator();
            while (it.hasNext()){
                if(isPrime(it.next())){
                    count ++;
                }
            }
            return count;
        }
    }

    private static void recursive(String now, String others){
        // 꼭 문자열을 반복할때는 빈 스트링에 대해 예외처리 해줘야해!!
        if (!now.equals("")){
            hashSet.add(Integer.valueOf(now));
        }
        for (int i = 0; i< others.length(); i++){ // others = 안쓴 숫자. 안쓴숫자가 있을때까지 반복문 실행
            recursive(now+others.charAt(i), others.substring(0, i)+others.substring(i+1));

        }
    }

    private static boolean isPrime(int num){
        // 0과 1이 아닌지 확인
        if (num == 0|| num == 1) return false;

        // 에라토스테네스의 방식으로 루트까지 소수 학인
        int limit = (int)Math.sqrt(num);

        // limit까지 num이 배수인지 확인
        // 시작은 2부터 시작해!!
        for(int i = 2; i < limit; i++){
            if (num % limit == 0) return false;
        }

        return true;
    }
}
