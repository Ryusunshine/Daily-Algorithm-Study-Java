package org.example.해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//단어공부
public class 백준_단어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        String word = br.readLine();
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        int max = 0;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }

        int cnt = 0;
        String answer = "";
        for (Character character : map.keySet()) {
            if (map.get(character) == max) {
                answer = character.toString();
                cnt++;
            }
        }

        if (cnt > 1) System.out.println("?");
        else System.out.println(answer.toUpperCase());
    }
}
