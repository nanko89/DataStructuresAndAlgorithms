package lab;

import java.util.*;

public class MoveDownRight {
    public static int[][] matrix;
    public static int[][] dp;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new int[rows][cols];
        dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        matrix[i] = arr;

        }

        dp[0][0] = matrix[0][0];
        for (int col = 1; col < cols; col++) {
            dp[0][col ] = dp[0][col-1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row-1][0] + matrix[row][0];
        }

        for (int row = 1; row < rows; row++){
            for (int col = 1; col < cols; col++) {
                 dp[row][col] = Math.max(dp[row-1][col] + matrix[row][col],
                         dp[row][col-1] + matrix[row][col]);
            }
        }

        List<String> path = new ArrayList<>();

        int row = rows - 1;
        int col = cols - 1;

        path.add(formatOutput(row,col));

        while (row > 0 || col > 0){

            int top = -1;
            int left =-1;

            if (row > 0) {
                top = dp[row - 1][col];
            }
            if (col > 0) {
                left = dp[row][col - 1];
            }

            if (top > left){
                row--;
            }else {
                col--;
            }

            path.add(formatOutput(row,col));
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int row, int col) {
        return String.format("[%d, %d]", row,col);
    }
}
