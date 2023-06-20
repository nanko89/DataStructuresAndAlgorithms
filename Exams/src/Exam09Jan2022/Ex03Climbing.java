package Exam09Jan2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ex03Climbing {
    public static class PathResult {
        int sum;
        List<Integer> path;

        public PathResult(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }
    }

    public static PathResult findHighestSumPath(int[][] building) {
        int rows = building.length;
        int cols = building[0].length;

        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = building[rows - 1][cols - 1];

        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = dp[i + 1][cols - 1] + building[i][cols - 1];
        }

        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = dp[rows - 1][j + 1] + building[rows - 1][j];
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = building[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(building[0][0]);
        int i = 0, j = 0;

        while (i < rows - 1 || j < cols - 1) {
            if (i < rows - 1 && j < cols - 1) {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    path.add(building[i + 1][j]);
                    i++;
                } else {
                    path.add(building[i][j + 1]);
                    j++;
                }
            } else if (i < rows - 1) {
                path.add(building[i + 1][j]);
                i++;
            } else {
                path.add(building[i][j + 1]);
                j++;
            }
        }

        return new PathResult(dp[0][0], path);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = row;
        }

        PathResult result = findHighestSumPath(matrix);
        int highestSum = result.sum;
        List<Integer> path = result.path;

        Collections.reverse(path);

        System.out.println(highestSum);

        List<String> strings = path.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(" ", strings));
    }
}
