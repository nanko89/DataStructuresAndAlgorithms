import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Demo {
    public static char[][] matrix;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] arr = reader.readLine().toCharArray();
            matrix[i] = arr;
        }

        visited = new boolean[rows][cols];

        int connectedTunnels = countTunnels();
        System.out.println(connectedTunnels);
    }

    private static int countTunnels() {
        int count = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col] && matrix[row][col] == 't') {
                    dfs(row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int col) {
        if (row < 0
                || col < 0
                || row >= matrix.length
                || col >= matrix[row].length
                || matrix[row][col] != 't'
                || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
        dfs(row + 1, col - 1);
        dfs(row + 1, col + 1);
        dfs(row - 1, col - 1);
        dfs(row - 1, col + 1);
    }
}

