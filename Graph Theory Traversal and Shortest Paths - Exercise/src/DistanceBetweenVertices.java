import java.util.*;

public class DistanceBetweenVertices {
    public static int[][] graphNodes;
    public static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int pairs = Integer.parseInt(scanner.nextLine());

        graphNodes = new int[nodes + 1][];

        for (int i = 1; i <= nodes; i++) {
            String[] token = scanner.nextLine().split(":");

            indexMapper.put(Integer.parseInt(token[0]), i);

            if (token.length == 1) {
                graphNodes[i] = new int[0];
            } else {
                graphNodes[i] = Arrays.stream(token[1]
                                .split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            }
        }


        while (pairs-- > 0) {
            int[] relations = Arrays.stream(scanner.nextLine()
                            .split("-"))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            int source = relations[0];
            int destination = relations[1];

            System.out.printf("{%d, %d} -> ", source, destination);
            int [] prev = new int[graphNodes.length];
            Arrays.fill(prev, -1);
            bfs(indexMapper.get(source), indexMapper.get(destination), prev);

            List<Integer> path = new ArrayList<>();
            int parent = prev[indexMapper.get(destination)];

            while (parent != -1) {
                path.add(parent);
                parent = prev[parent];
            }
            System.out.println(path.isEmpty() ? -1 : path.size());
        }
    }

    private static void bfs(int source, int destination, int[] prev) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);

        boolean[] visited = new boolean[graphNodes.length];
        visited[source] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (node == destination) {
                return;
            }

            for (int i = 0; i < graphNodes[node].length; i++) {
                int child = indexMapper.get(graphNodes[node][i]);
                if (!visited[child]) {
                    prev[child] = node;
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
        prev[source] = -1;
    }
}