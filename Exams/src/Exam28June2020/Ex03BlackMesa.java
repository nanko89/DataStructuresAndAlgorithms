package Exam28June2020;

import java.io.IOException;
import java.util.*;

public class Ex03BlackMesa {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();

        int[][] dp = new int[nodes+1][nodes+1];
        boolean[] visited = new boolean[nodes + 1];


        for (int i = 0; i < edges; i++) {
            dp[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        int start = scanner.nextInt();
        int end = scanner.nextInt();

        List<Integer> path = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        boolean isNotFound = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            visited[node] = true;

            if (isNotFound) {
                path.add(node);
                isNotFound = node != end;
            }

            for (int i = 0; i < dp[node].length; i++) {
                if (dp[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        StringBuilder out = new StringBuilder();

        for (Integer node : path) {
            out.append(node).append(" ");
        }

        out.append(System.lineSeparator());

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                out.append(i).append(" ");
            }
        }

        System.out.println(out.toString().trim());
    }
}
