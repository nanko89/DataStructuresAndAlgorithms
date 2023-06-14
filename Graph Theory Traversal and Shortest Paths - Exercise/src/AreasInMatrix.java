import java.util.*;

public class AreasInMatrix {
    public static class Edge {
        int[] source;
        int[] destination;

        Edge(int sRow, int sCol) {
            this.source = new int[]{sRow, sCol};
        }

        public void setDestination(int row, int col) {
            this.destination = new int[]{row, col};
        }
    }

    public static char[][] matrix;
    public static boolean[][] visited;
    public static boolean[] visitedNode;
    public static List<Edge> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        matrix = new char[n][];
        visited = new boolean[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col]) {
                    dfs(row, col, matrix[row][col]);
                }
            }
        }

        visitedNode = new boolean[graph.size()];
        Map<Character, Integer> areas = new TreeMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedNode[i]) {
                Edge edge = graph.get(i);
                char key = matrix[edge.source[0]][edge.source[1]];
                areas.putIfAbsent(key, 0);
                areas.put(key, areas.get(key) + 1);
                bfs(i);
            }
        }

        System.out.println("Areas: " + areas.values().stream().mapToInt(i->i).sum());
        areas.forEach((key, value) -> System.out.println("Letter '" + key + "' -> " + value));
    }

    private static void bfs(int source) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        visitedNode[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.pop();

            Edge edge = graph.get(node);
            if (edge.destination != null) {

                visitedNode[node + 1] = true;
                queue.offer(node + 1);
            }
        }
    }

    private static void dfs(int row, int col, char symbol) {
        visited[row][col] = true;

        Edge edge = new Edge(row, col);
        graph.add(edge);
        if (isInBounds(row, col + 1) && !visited[row][col + 1] && matrix[row][col + 1] == symbol) {
            graph.get(graph.size() - 1).setDestination(row, col + 1);
            dfs(row, col + 1, symbol);
        }
        if (isInBounds(row, col - 1) && !visited[row][col - 1] && matrix[row][col - 1] == symbol) {
            graph.get(graph.size() - 1).setDestination(row, col - 1);
            dfs(row, col - 1, symbol);
        }
        if (isInBounds(row + 1, col) && !visited[row + 1][col] && matrix[row + 1][col] == symbol) {
            graph.get(graph.size() - 1).setDestination(row + 1, col);
            dfs(row + 1, col, symbol);
        }
        if (isInBounds(row - 1, col) && !visited[row - 1][col] && matrix[row - 1][col] == symbol) {
            graph.get(graph.size() - 1).setDestination(row - 1 , col);
            dfs(row - 1, col, symbol);
        }
    }


    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static boolean isInBounds(int row, int col) {
        return !isOutOfBounds(row, col);
    }
}


