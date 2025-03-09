package org.example.해시;

import java.util.HashMap;
import java.util.Scanner;

public class 인프런코테_아나그램 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        HashMap<Character, Integer> hashmap = new HashMap<>();

        for (char ch : input1.toCharArray()) {
            hashmap.put(ch, hashmap.getOrDefault(ch, 0) +1);
        }
        String input2 = in.next();

        for (char ch : input2.toCharArray()) {
            if (!hashmap.containsKey(ch) || hashmap.get(ch) == 0) {
                System.out.println("NO");
                return;
            }
            hashmap.put(ch, hashmap.get(ch) -1);
        }
        System.out.println("YES");
    }
}