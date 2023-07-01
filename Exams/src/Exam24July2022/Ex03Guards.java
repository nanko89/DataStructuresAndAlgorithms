package Exam24July2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Ex03Guards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        int[][] dp = new int[nodes + 1][nodes + 1];
        boolean[] visited = new boolean[nodes + 1];

        for (int i = 0; i < edges; i++) {
            int[] connections = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            dp[connections[0]][connections[1]] = 1;
        }


        int startIndex = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startIndex);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;

                for (int i = 0; i < dp[node].length; i++) {
                    if (dp[node][i] == 1) {
                        queue.offer(i);
                    }
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
