package org.example.BFS_DFS;

import java.util.*;

public class 백1987_알파벳 {
    public class Main {
        static int n, m;
        static char[][] graph;
        static HashSet<String> visited;

        static int[] d_row = {0, -1, 0, 1};
        static int[] d_col = {1, 0, -1, 0};

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt(); // 세로
            m = scanner.nextInt(); // 가로
            scanner.nextLine();
            graph = new char[n][m];
            visited = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    graph[i][j] = line.charAt(j);
                }
            }

            bfs();
        }

        public static void bfs() {
            Queue<State> queue = new ArrayDeque<>();
            queue.offer(new State(0, 0, String.valueOf(graph[0][0])));
            int result = 0;

            while (!queue.isEmpty()) {
                State currentState = queue.poll();
                int x = currentState.x;
                int y = currentState.y;
                String word = currentState.word;

                result = Math.max(result, word.length());

                for (int i = 0; i < 4; i++) {
                    int nx = x + d_row[i];
                    int ny = y + d_col[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;

                    if (word.contains(String.valueOf(graph[nx][ny])))
                        continue;

                    String nextWord = word + graph[nx][ny];
                    State nextState = new State(nx, ny, nextWord);

                    if (!visited.contains(nextState.toString())) {
                        visited.add(nextState.toString());
                        queue.offer(nextState);
                    }
                }
            }
            System.out.println(result);
        }

        static class State {
            int x;
            int y;
            String word;

            public State(int x, int y, String word) {
                this.x = x;
                this.y = y;
                this.word = word;
            }

            @Override
            public String toString() {
                return x + " " + y + " " + word;
            }
        }
    }
}
