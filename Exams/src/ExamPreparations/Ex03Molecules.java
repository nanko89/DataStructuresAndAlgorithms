package ExamPreparations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Ex03Molecules {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int[] connections = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            graph[connections[0]][connections[1]] = 1;
        }

        int startMolecule = Integer.parseInt(reader.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(startMolecule);
        boolean[] visited = new boolean[n +1 ];

        while (!queue.isEmpty()){
            int node = queue.poll();
            visited[node] = true;
            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0 && !visited[i]){
                    queue.offer(i);
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] ){
                System.out.print(i+ " ");
            }
        }
    }
}
