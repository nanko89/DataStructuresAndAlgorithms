import java.util.*;


public class CyclesInGraph {
    static class Graph {
        private int vertices;
        private Map<String, Integer> nodeMap;
        private List<List<Integer>> adjList;

        public Graph() {
            vertices = 0;
            nodeMap = new HashMap<>();
            adjList = new ArrayList<>();
        }

        public void addEdge(String src, String dest) {
            if (!nodeMap.containsKey(src)) {
                nodeMap.put(src, vertices++);
                adjList.add(new ArrayList<>());
            }
            if (!nodeMap.containsKey(dest)) {
                nodeMap.put(dest, vertices++);
                adjList.add(new ArrayList<>());
            }

            int srcIndex = nodeMap.get(src);
            int destIndex = nodeMap.get(dest);

            adjList.get(srcIndex).add(destIndex);
            adjList.get(destIndex).add(srcIndex);
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    if (hasCycleUtil(i, visited, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean hasCycleUtil(int vertex, boolean[] visited, int parent) {
            visited[vertex] = true;

            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    if (hasCycleUtil(neighbor, visited, vertex)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }

            String[] edge = input.split("-");
            String src = edge[0];
            String dest = edge[1];

            graph.addEdge(src, dest);
        }

        boolean hasCycle = graph.hasCycle();
        if (hasCycle) {
            System.out.println("Acyclic: No");
        } else {
            System.out.println("Acyclic: Yes");
        }
    }
}
