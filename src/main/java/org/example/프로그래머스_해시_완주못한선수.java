package org.example;

import java.util.HashMap;

public class 프로그래머스_해시_완주못한선수 {
    static String[] participants = {"leo", "kiki", "eden"};
    static String[] completion = {"eden", "kiki"};
    public static void main(String[] args) {
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        for (String player : participants){
            hash.put(player, hash.getOrDefault(player, 0) + 1);
        }

        for (String find_player: completion){
            hash.put(find_player, hash.get(find_player)-1);
        }

        for (String last_player : hash.keySet()){
            if (hash.get(last_player) != 0){
                answer = last_player;
                break;
            }
        }
//        return answer;
    }
}
