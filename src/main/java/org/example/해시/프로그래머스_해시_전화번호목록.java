package org.example.해시;

import java.util.HashMap;

public class 프로그래머스_해시_전화번호목록 {
    static String[] phone_book = {"119", "97674223", "1195524421"};
    public static void main(String[] args) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String num : phone_book){
            hash.put(num, 1);
        }
        for (int i = 0; i< phone_book.length; i++){ // phoneBook을 돌면서
            for (int j = 1; j < phone_book[i].length(); j++){ // 각각 전화번호를 자르면서 전화번호부에 있는지 확인할거야
                if (hash.containsKey(phone_book[i].substring(0, j))){
//                    return false;
                }
            }
        }
//        return true;
    }
}

