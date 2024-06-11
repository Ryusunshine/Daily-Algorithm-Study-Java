package org.example.그리디;

public class 프로그래머스_키패드누르기 {
    Position left;
    Position right;
    Position numPos; // 다음 눌러야할 숫자 위치
//    0, 1, 2 - row
//    0, 1, 2, 3 - col
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 왼손, 오른손 초기값 설정
        left = new Position(3, 0);
        right = new Position(3, 2);

        // 다음 눌러야할 숫자 위치 설정
        for (int num : numbers) {
            numPos = new Position((num - 1) / 3, (num - 1) % 3); // row, col
            if (num == 0) {
                numPos = new Position(3, 1);
            }
            String finger = numPos.getFinger(hand); // 다음에 눌러야할 숫자(numPos)에 있어야 할 손가락을 구해(.getFinger) 라고 생각해. 초기값 hand 넣어주기
            answer += finger;
            // 눌러야할 손가락(finger)을 해당 숫자 위치로 이동하기
            if (finger.equals("R"))
                right = numPos;
            else
                left = numPos;
        }

        return answer;
    }

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right")? "R" : "L";

            // this = numPos(Postion)
            if (this.col == 0)
                finger = "L";
            else if (this.col == 2)
                finger = "R";
            else {
                //left, right는 위에서 초기화한 멤버 변수
                int leftDist = left.getDist(this);
                int rightDist = right.getDist(this);

                if (leftDist < rightDist)
                    finger = "L";
                else if (leftDist > rightDist)
                    finger = "R";
                // else 생략(leftDist, rightDist 거리가 같으면) 주 손으로 반환
            }

            return finger;
        }

        public int getDist(Position p) { // p 는 numPos
            // 여기서 this 는 left, right
            return Math.abs(this.col - p.col) + Math.abs(this.row - p.row);
        }
    }
}