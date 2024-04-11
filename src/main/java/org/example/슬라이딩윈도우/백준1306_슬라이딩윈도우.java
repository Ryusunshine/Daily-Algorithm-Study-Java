package org.example.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준1306_슬라이딩윈도우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] brightness = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            brightness[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();

        // 윈도우 초기화 - 홍준이가 뛰기 시작하는 위치까지
        // 홍준이가 처음으로 광고판을 볼 수 있는 위치부터 시작해서, 홍준이의 시야 범위(2M-1)만큼의 광고판을 처리
        for (int i = 0; i < 2 * M - 1; i++) {
            while (!deque.isEmpty() && brightness[i] >= brightness[deque.getLast()]) {
                deque.removeLast();
        //!deque.isEmpty()는 데크가 비어있지 않을 때만 내부 루프를 실행하도록 합니다.
        // 데크가 비어있으면 검사할 요소가 없기 때문입니다.
        //brightness[i] >= brightness[deque.getLast()]는 현재 처리 중인 광고판의 빛의 세기가
        // 데크의 마지막 요소(인덱스에 해당하는 광고판)의 빛의 세기보다 크거나 같으면
        // 데크의 마지막 요소는 홍준이의 시야 범위 내에서 현재 광고판보다 더 약한 빛의 광고판이므로 제거됩니다.
        //이 과정은 데크의 마지막 요소가 현재 광고판의 빛의 세기보다 작을 때까지, 혹은 데크가 비어있을 때까지 반복됩니다.
        // 이렇게 하면 데크에는 항상 현재 시점에서 홍준이가 볼 수 있는 가장 강렬한 빛의 광고판들만 남게 됩니다.
            }
            deque.addLast(i);
        //위의 조건문을 통과한 후, 현재 광고판의 인덱스 i는 데크의 마지막에 추가됩니다. 이는 현재 광고판이 홍준이가 이 시점에서 볼 수 있는 가장 강렬한 빛 중 하나임을 의미합니다.
        //현재 광고판보다 더 강렬한 빛을 가진 광고판이 이후에 나타날 경우, 이후의 반복문 실행에서 이 광고판은 제거될 수 있습니다.
        }

        StringBuilder sb = new StringBuilder();
        //이 부분에서 홍준이가 뛰기 시작하는 위치(M-1)부터 멈추는 위치(N-M)까지 이동하면서 각 위치에서 볼 수 있는 가장 강렬한 빛의 세기를 출력합니다.
        // StringBuilder를 사용하여 출력할 문자열을 구성합니다.

        for (int i = M - 1; i <= N - M; i++) {
            //이 반복문은 홍준이가 뛰기 시작하는 위치(M-1)부터 멈추는 위치(N-M)까지를 순회합니다.
            // 홍준이는 광고판을 최대한 많이 보기 위해 중앙에서 시작하여 중앙에서 멈추는 것으로 가정합니다.
            // 따라서, 시작 지점과 끝 지점이 이와 같이 설정됩니다.

            sb.append(brightness[deque.getFirst()]).append("\n");

            //데크의 첫 번째 요소는 현재 시야 범위 내에서 가장 강렬한 빛의 광고판의 인덱스를 가리킵니다.
            // brightness[deque.getFirst()]는 해당 광고판의 빛의 세기를 가져옵니다.
            // 이 값을 StringBuilder에 추가하여, 최종적으로 모든 결과를 한 번에 출력할 수 있도록 합니다.

            // 다음 칸으로 윈도우 이동
            while (!deque.isEmpty() && deque.getFirst() <= i - M + 1) {
                deque.removeFirst();
                // 이 부분은 현재 시야 범위(윈도우)에서 벗어난 광고판을 데크에서 제거하는 로직입니다. i - M + 1은 현재 시야 범위의 시작 지점을 나타냅니다.
                // 따라서, 데크의 첫 번째 요소(가장 오래된 광고판)가 이 시작 지점보다 앞서 있다면, 더 이상 시야 범위 내에 없는 것이므로 데크에서 제거됩니다.
            }

            if (i + M < N) {
                while (!deque.isEmpty() && brightness[i + M] >= brightness[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.addLast(i + M);
            }
            //if (i + M < N)는 새로운 광고판이 시야 범위에 들어올 수 있는지를 확인합니다. i + M는 새로운 광고판의 위치를 나타내며, 이 값이 전체 길이 N보다 작아야 새로운 광고판이 존재합니다.
            //내부 while 루프는 새로운 광고판이 기존의 어떤 광고판보다 빛의 세기가 강할 경우, 그보다 약한 빛의 광고판들을 데크에서 제거합니다. 이 과정은 새로운 광고판이 현재 시야 범위 내에서 가장 강렬한 빛을 가진 광고판이 될 때까지 계속됩니다.
            //마지막으로, 새로운 광고판의 인덱스를 데크의 마지막에 추가합니다. 이렇게 함으로써, 데크는 항상 시야 범위 내에서 가장 강렬한 빛을 가진 광고판들만을 유지하게 됩니다.
        }

        System.out.println(sb.toString());
    }
}
