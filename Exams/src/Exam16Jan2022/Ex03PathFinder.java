package Exam16Jan2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex03PathFinder {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, List<Integer>> dp = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            String input = bufferedReader.readLine();

            if (!input.equals("")) {
                int[] node = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < node.length; j++) {
                    dp.putIfAbsent(i, new ArrayList<>());
                    dp.get(i).add(node[j]);
                }
            }else {
                dp.putIfAbsent(i, new ArrayList<>());
            }
        }

        int paths = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < paths; i++) {
            int[] path = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean isExistPath = false;

            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 0; j < path.length; j++) {
                deque.offer(path[j]);
            }

            while (!deque.isEmpty()) {
                int num = deque.pop();
                if (deque.isEmpty()) {
                    isExistPath = true;
                }else {
                    int child = deque.pop();
                    if (dp.get(num).contains(child)){
                        deque.push(child);
                    }else {
                        break;
                    }
                }
            }
                System.out.println( isExistPath ? "yes" : "no");
        }
    }
}
