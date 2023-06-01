import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = recursionSum(arr, 0);
        System.out.println(sum);
    }

    public static int recursionSum(int[] number, int index) {
        if (index >= number.length) {
            return 0;
        }
        return number[index]  + recursionSum(number, index + 1);
    }
}
