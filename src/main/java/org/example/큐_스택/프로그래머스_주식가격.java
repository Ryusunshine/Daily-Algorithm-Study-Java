package org.example.큐_스택;

import java.util.Stack;

public class 프로그래머스_주식가격 {class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans[i]++;
                if (prices[i] > prices[j])
                    break;

            }
        }

        return ans;
    }
}

    class Solution2 {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Integer> stack = new Stack();

            for (int i = 0; i < prices.length; i++) {
                // stack.peek() 등 인덱스값에 접근할려면 우선 배열에 값이 있는지 확인(!!!!isEmpty()!!!!!)
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 가격이 떨어지는 경우
                    int past_index = stack.pop();
                    answer[past_index] = i - past_index; // 현재 인덱스에서 스택의 마지막 인덱스(상승한 인덱스)를 빼준다.
                }
                // 반복이 끝나면 현재 가격이 스택에 저장되어있는 마지막인덱스(최고가)보다 더 크다는 의미이므로 스택에 현재 인덱스를 추가한다.
                stack.push(i);
            }

            // 반복이 끝나면 가격이 떨어지지 않은 인덱스만 스택에 남아있음
            for (int i : stack ){
                answer[i] = prices.length - i -1;
            }

            return answer;
        }

    }

//    스택에 상승하는 인덱스 번호를 넣는다
//    다음 인덱스로 이동하면 전의 prices[stack.peek()] 의 값이랑 비교한후 현재가 크면(상승했으면) 현재 인덱스 번호를 넣는다.
//    즉 스택에는 최고의 값의 인덱스가 마지막에 저장되어있는거다.
//    만약 주식가격이 하락하면 스택에 있는 과거 인덱스를 다시 확인하면서 가격이 떨어지지 않는 기간을 구한다.
//
//    prices = [100, 300, 500, 400 200]
//    stack = [0, 1, 2,
//    우선 가격이 떨어질때 최고가의 인덱스(stack의 마지막 인덱스)를 스택에서 뺴주고 top 가격이라고 지정한다.
//    스택에서 제거한 과거 인덱스에 대한 가격이 떨어지지 않은 기간은 현재 인덱스에서 과거 인덱스를 빼면 된다.
//    즉 떨어지기 시작하는 인덱스를 구하기 위해서는 스택의 마지막 값(과거 인덱스)가 2이고 현재 인덱스인 3에서 과거인덱스 2를 빼주면 된다.(즉 떨어지기 시작하는 인덱스를 구하는것이다.)
//    그리고 스택의 탑의 가르키고 있는 인덱스(stack = [0, 1] 에서 prices[1])은 300원은 현재 인덱스값(prices[3] = 400)이 더 올랐기때문에 스택에 현재 인덱스 3을 추가한다. 그래야 나중에 고려할수 있다. 그리고 200과 현재 스택의 탑에 있는 인덱스(3)의 값을 비교하면 줄어들었기 때문에 스택에서 3을 제거한다음에 top = 3
//    마찬가지로 result[past_index] = current_index - past_index
//    그 다음 스택에 있는 1이 가르키고 있는 300과 비교하면 줄어들었기떄문에 스택에서 1를 제거하고 현재 result[past_index] = current_index - past_index(4 - 1)
//    그리고 스택에 남아있는 0의 값을 현재 인덱스값과 비교해보면 현재 인덱스값이 더 크기때문에 현재 인덱스를 스택에 추가한다.
//            stack = [0, 4]
//    이렇게 루프를 끝내면 스택에 남아있는 인덱스 0과 인덱스 4의 가격은 가격이 내려간적이 없다는것을 뜻한다.
//    그래서 애네들은 result[i] = len(prices) - i - 1

//    https://www.youtube.com/watch?v=VWEYG-vf2dw
}
