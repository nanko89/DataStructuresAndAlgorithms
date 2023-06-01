import java.util.Arrays;

public class QueensPuzzle {
    static Character[][] matrix = new Character[8][8];

    public static void main(String[] args) {

        fillMatrix();
        addQueens(0);
    }

    private static void addQueens(int row) {

        if (row == 8) {
            printMatrix();
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (canPlaceQueen(row, col)) {
                putQueen(row, col);
                addQueens(row + 1);
                removeQueen(row, col);
            }
        }

    }

    private static void removeQueen(int row, int col) {
        matrix[row][col] = '-';
    }

    private static void putQueen(int row, int col) {
        matrix[row][col] = '*';

    }

    private static boolean canPlaceQueen(int r, int c) {
        int row = r;
        int col = c;
        while (row >= 0 && col >= 0) {
            if (matrix[row--][col--] == '*') {
                return false;
            }
        }

        row = r;
        col = c;
        while (row < matrix.length && col < matrix[row].length) {
            if (matrix[row++][col++] == '*') {
                return false;
            }
        }
        row = r;
        col = c;
        while (row >= 0 && col < matrix[row].length) {
            if (matrix[row--][col++] == '*') {
                return false;
            }
        }
        row = r;
        col = c;
        while (row < matrix.length && col >= 0) {
            if (matrix[row++][col--] == '*') {
                return false;
            }
        }
        row = r;
        col = c;
        while (row >= 0) {
            if (matrix[row--][col] == '*') {
                return false;
            }
        }

        return true;
    }

    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void fillMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = '-';
            }
        }
    }
}
