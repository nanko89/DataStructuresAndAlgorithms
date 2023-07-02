package FinalExam02July2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex02 {
    public static Map<Character, List<Character>> graph = new HashMap<>();
    public static Set<Character> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String transactions = reader.readLine();
            char from = transactions.charAt(0);
            char to = transactions.charAt(2);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int groups = countGroups();

        System.out.println(groups);
    }

    private static int countGroups() {
        int count = 0;

        for (Character address : graph.keySet()) {
            if (!visited.contains(address)) {
                dfs(address);
                count++;
            }
        }
        return count;
    }

    private static void dfs(Character address) {
        visited.add(address);

        for (Character neighbor : graph.getOrDefault(address, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
    }
}