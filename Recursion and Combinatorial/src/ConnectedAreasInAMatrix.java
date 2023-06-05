import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasInAMatrix {

    public static char[][] matrix;
    public static List<int[]> areas;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[i] = row;
        }

        areas = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '-') {
                    areas.add(new int[]{row, col, 0});
                    findAreas(row, col);
                }
            }
        }

        AtomicInteger counter = new AtomicInteger(1);

        System.out.println("Total areas found: " + areas.size());
        areas.stream().sorted((a,b) -> Integer.compare(b[2],a[2]))
                .forEach(a -> {
                    System.out.printf("Area #%d at (%d, %d), size: %d%n", counter.getAndIncrement(),a[0], a[1], a[2] );
                });

    }

    private static void findAreas(int row, int col) {
        if (!isInBounds(row, col) || !isTraversable(row, col)) {
            return;
        }

        matrix[row][col] = 'V';

        areas.get(areas.size() -1 )[2]++;

        findAreas(row + 1, col);
        findAreas(row, col + 1);
        findAreas(row - 1, col);
        findAreas(row, col - 1);

    }

    private static boolean isTraversable(int row, int col) {
        return matrix[row][col] != 'V' && matrix[row][col] != '*';
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}
