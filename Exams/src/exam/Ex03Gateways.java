package exam;

import java.util.*;
import java.util.stream.Collectors;

public class Ex03Gateways {
    public static boolean[] visited;
    private static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edges; i++) {
            int[] paths = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph.get(paths[0]).add(paths[1]);
        }

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        visited = new boolean[n + 1];
        prevNodes = new int[n + 1];

        Arrays.fill(prevNodes, -1);

        bfs(graph, start, end);

        List<Integer> path = new ArrayList<>();
        path.add(end);

        int prevNode = prevNodes[end];

        while (prevNode != -1){
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        if (!path.isEmpty()) {
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print(path.get(i) + " ");
            }
        }
    }

    private static void bfs(List<List<Integer>> graph, int start, int end) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) {
                return;
            }

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }
    }
}
