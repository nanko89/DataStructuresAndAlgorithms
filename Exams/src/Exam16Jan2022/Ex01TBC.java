package Exam16Jan2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01TBC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] row = reader.readLine().toCharArray();
            matrix[i] = row;
        }

        int connectedTunnels = countConnectedTunnels(matrix, rows, cols);

        System.out.println(connectedTunnels);

    }

    private static int countConnectedTunnels(char[][] matrix, int rows, int cols) {
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!visited[i][j] && matrix[i][j] == 't'){
                    dfs(matrix, visited, i , j ,rows,cols);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] matrix, boolean[][] visited, int row, int col, int rows, int cols) {

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || matrix[row][col] != 't') {
            return;
        }
        visited[row][col] = true;

        dfs(matrix, visited, row - 1, col - 1, rows, cols);
        dfs(matrix, visited, row - 1, col, rows, cols);
        dfs(matrix, visited, row - 1, col + 1, rows, cols);
        dfs(matrix, visited, row, col - 1, rows, cols);
        dfs(matrix, visited, row, col + 1, rows, cols);
        dfs(matrix, visited, row + 1, col - 1, rows, cols);
        dfs(matrix, visited, row + 1, col, rows, cols);
        dfs(matrix, visited, row + 1, col + 1, rows, cols);

    }
}
