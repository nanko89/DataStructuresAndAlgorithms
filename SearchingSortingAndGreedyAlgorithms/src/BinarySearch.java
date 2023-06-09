import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(scanner.nextLine());

        System.out.println(indexOfArray(arr, num));
    }

    private static int indexOfArray(int[] arr, int key) {
        int start = 0;
        int end = arr.length -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int current = arr[mid];

            if (key < current) {
                end = mid - 1;
            } else if (key > current) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
