package org.example.큐_스택;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_다리를_지나는_트럭 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int sum = 0; //현재 다리 위 무게
            int time = 0; //다리를 건너는 시간

            for(int truck : truck_weights) {
                while(true) { // break 문 걸리면 while 문 빠져나옴
                    if(bridge.isEmpty()) { //큐(다리)에 아무것도 없는 경우
                        bridge.add(truck); //큐(다리)에 트럭 추가
                        sum += truck; // 다리 위에 트럭 무게 추가
                        time++; //현재 트럭이 다리 위에 올라가는 시간
                        break;
                    } else if(bridge.size() == bridge_length) { //큐(다리)가 가득 찬 경우
                        // 다리에서 나올떄는 시간이 필요하지 않으므로 시간은 안 더해줘도 됨
                        sum -= bridge.poll(); //다리의 맨 앞 트럭 빼기
                    } else { //큐(다리)가 가득 차지 않은 경우 (이제는 무게를 고려해야함)
                        if(sum+truck <= weight) {
                            bridge.add(truck); //큐에 트럭 추가
                            sum += truck;
                            time++;
                            break;
                        } else { // 무게 초과하는 경우
                            bridge.add(0);
                            //다음 트럭이 올라올 수 없는 경우 0을 넣어서 bridge.size()== bridge_length() 조건문에 걸려서 앞에 있는 truck을 건너게 한다.
                            time++;
                        }
                    }
                }
            }
            return time+bridge_length;
        }
    }
}
// 참고
// https://yummy0102.tistory.com/345

class Solution2 {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}

class Solution3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridQ = new LinkedList<>();
        Queue<Integer> waitQ = new LinkedList<>();
        int wCnt=0;
        for (int i = 0; i < bridge_length; i++) {
            bridQ.offer(0);
        }
        for (int i = 0; i < truck_weights.length; i++) {
            waitQ.offer(truck_weights[i]);
            while(!waitQ.isEmpty()) {
                answer++;
                wCnt -= bridQ.poll();

                if(wCnt + waitQ.peek() > weight) {
                    bridQ.offer(0);
                }else {
                    wCnt += waitQ.peek();
                    bridQ.offer(waitQ.poll());
                }
//              System.out.println(answer + " : " +bridQ.toString());
            }
        }
        while(!bridQ.isEmpty()) {
//          System.out.println(answer + " : " +bridQ.toString());
            bridQ.poll();
            answer++;
        }
//        System.out.println(answer);
        return answer;
    }
}

class Solution4 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<bridge_length;i++){
            list.add(0);
        }
        int sum=0;
        int n=0;
        while(n<truck_weights.length){
            if(sum+truck_weights[n]-list.get(0)<=weight){
                sum=sum+truck_weights[n]-list.get(0);
                list.remove(0);
                list.add(truck_weights[n]);
                n++;
                answer++;
            }else{
                sum = sum-list.get(0);
                list.remove(0);
                list.add(0);
                answer++;
            }

        }
        answer+=bridge_length;
        return answer;
    }
}

