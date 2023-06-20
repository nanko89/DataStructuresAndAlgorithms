package Exam09Jan2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex02Paths {
    public static int nodes;
    public static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nodes = Integer.parseInt(reader.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            String input = reader.readLine();
            if (input.equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> children = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
                graph.add(children);
            }
        }

        List<List<Integer>> allPaths = findAllPaths();

        for (List<Integer> path : allPaths) {
            List<String> currentPath = path.stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList());
            System.out.println(String.join(" ", currentPath));
        }

    }

    private static List<List<Integer>> findAllPaths() {
        List<List<Integer>> allPaths = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            List<Integer> currentPath = new ArrayList<>();
            dfs(i, currentPath, allPaths);
        }

        return allPaths;
    }

    private static void dfs(int currentNode, List<Integer> currentPath, List<List<Integer>> allPaths) {
        currentPath.add(currentNode);

        if (graph.get(currentNode).isEmpty()) {
            if (currentPath.size() > 1) {
                allPaths.add(new ArrayList<>(currentPath));
            }
        } else {
            for (int child : graph.get(currentNode)) {
                dfs(child, currentPath, allPaths);
            }
        }
        currentPath.remove(currentPath.size() - 1);
    }
}

