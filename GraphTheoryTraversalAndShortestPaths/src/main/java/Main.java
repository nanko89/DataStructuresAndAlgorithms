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
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while(!graph.isEmpty()){
            String current = graph.keySet().stream().filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (current == null){
                break;
            }

            graph.get(current).forEach( c -> dependenciesCount.put(c, dependenciesCount.get(c) - 1));

            sorted.add(current);
            graph.remove(current);
        }

        if (!graph.isEmpty()){
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {

        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();


        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()){
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) +1);
            }
        }

        return dependenciesCount;
    }
}
