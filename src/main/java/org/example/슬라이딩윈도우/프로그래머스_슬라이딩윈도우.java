package org.example.슬라이딩윈도우;

public class 프로그래머스_슬라이딩윈도우 {
    static int count;
    static int[] student = {0,1,0,0,1,1,0};
    static int k =2;
    public static void main(String[] args) {
        int window_sum = 0;

        for (int i = 0; i < student.length; i++){
            window_sum += student[i]; // 윈도우 초기값
            if (window_sum == k) count++;
            sliding_window(window_sum, i+1);
        }
        System.out.println(count);
    }

    private static void sliding_window(int windowSum, int windowSize) {// i는 윈도우 크기
        // 슬라이딩 윈도우
        for (int j = windowSize; j < student.length; j++){
            int s = j-windowSize; //s = 왼쪽 인덱스, j = 오른쪽인덱스
            windowSum += student[j] - student[s];
            if (windowSum == k) count++;
        }
    }
}

//student k result
//[0,1,0,0] 1 6
//[0,1,0,0,1,1,0] 2 8
//[0,1,0] 2 0
