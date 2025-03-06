package org.example.해시;

import java.util.*;

public class 인프런코테_k번째큰수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    treeSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }
        int cnt = 0;
        for (int num : treeSet) {
            cnt++;
            if (cnt == m) return num;
        }

        return -1;
    }
}
