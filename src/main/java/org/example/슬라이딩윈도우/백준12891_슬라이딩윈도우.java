package org.example.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  백준12891_슬라이딩윈도우 {
    static int checkArr[];
    static int myArr[];
    static int checkSame;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //전체 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        int result = 0;
        checkArr = new int[4]; // 부분 문자열 배열
        myArr = new int[4]; // 현재 내 배열
        checkSame = 0; // 현재조건과 만족하는 배열의 개수

        char A[] = br.readLine().toCharArray(); // 전체 배열 받기 (CCTGGATTG)
        st = new StringTokenizer(br.readLine()); // 2011 배열이 담겨있음
        for (int i = 0; i < 4; i++) { // checkArr = 2011
            checkArr[i] = Integer.parseInt(st.nextToken()); //checkArr는 AGCT 알파벳의 개수
            if (checkArr[i]== 0) checkSame++; // 만약 알파벳 개수가 0 이라면 checkSame +1
        }
        for (int i = 0; i<P; i++){ // 부분 문자열 돌면서 현재 알파벳 개수 세기
            Add(A[i]); // 초기화
        }

        if (checkSame == 4) result++; //처음 받은 부분 문자열이 정답이면 result + 1

        //슬라이딩 윈도우
        for (int i = P; i < S; i++){ //P = 현재 부분배열의 크기, S = 전체 배열의 크기,
            // 현재 부분배열의 크기 인덱스에서 오른쪽으로 한칸씩 가겠다는 의미
            int j = i-P; // j = 맨 왼쪽, i = 맨 오른쪽 (맨 오른쪽 인덱스에서 배열길이만큼 빼면 왼쪽 인덱스값, j + P = i)
            Add(A[i]); // 맨 오른쪽값 추가
            Remove(A[j]); // 맨 왼쪽값 제거
            // 한번 이동을 할때마다 값이 같은지 확인
            if (checkSame == 4) result++;
        }
        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c){
            case 'A':
                if (myArr[0] == checkArr[0]) checkSame--; // 있어야하는 알파벳 개수와 현재 내 알파벳 개수가 맞는지 확인
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSame--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSame--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSame--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c){
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSame++; // 있어야하는 알파벳 개수와 현재 내 알파벳 개수가 맞는지 확인
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSame++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSame++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSame++;
                break;
        }
    }
}
