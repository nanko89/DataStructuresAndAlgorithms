import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nodes = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                graph.add(nodes);
            }
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);
        System.out.println(builder);
    }


    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];

        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                builder.append("Connected component: ");
                dfs(start, components, graph, visited);
                builder.append("\n");
            }
        }

        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;

            for (int child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }
            builder.append(node).append(" ");
        }

    }


    public static Collection<String> topSort(Map<String, List<String>> graph) {
        throw new AssertionError("Not Implemented");
    }
}
