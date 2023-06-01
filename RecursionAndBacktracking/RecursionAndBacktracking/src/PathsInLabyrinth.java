import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth {
    public static List<Character> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        findPath(matrix, 0, 0, ' ');

    }

    private static void findPath(char[][] matrix, int row, int col, char direction) {

        if (!isInBounds(matrix, row, col)
                || matrix[row][col] == 'V'
                || matrix[row][col] == '*' ) {
            return;
        }

        path.add(direction);

        if (matrix[row][col] == 'e'){
            printMatrix();
            return;
        }

        matrix[row][col] = 'V';

        findPath(matrix, row, col + 1, 'R');
        findPath(matrix, row + 1, col, 'D');
        findPath(matrix, row - 1, col, 'U' );
        findPath(matrix, row, col - 1, 'L');
        matrix[row][col]= '-';

        path.remove(path.size() - 1);
    }

    private static void printMatrix() {

        path.stream().filter(p -> p != ' ').forEach(System.out::print);
        System.out.println();
        path.remove(path.size() - 1 );

    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return matrix.length > row && row >= 0 && matrix[row].length > col && col >= 0;
    }
}
