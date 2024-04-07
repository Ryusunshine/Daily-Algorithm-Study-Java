package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 자바9375_해시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int a = 0; a < T; a++){
            HashMap<String, Integer> hash = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i< N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷의 이름은 필요없으므로 버림
                String type = st.nextToken();
                hash.put(type, hash.getOrDefault(type, 0) + 1); // 지정된 키로 매핑된 값이 없는 경우 0가져온다
            }
            int answer = 1;

            // 전체 경우의 수 계산하여 출력
            for (int val: hash.values()){
                answer *= val+1;
            }
            System.out.println(answer - 1);
        }
    }
}
