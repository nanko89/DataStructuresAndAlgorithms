import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int first = 1;
        int second = 1;

        long result = fibonacciSum(first, second, num);

        System.out.println(result);
    }

    private static long fibonacciSum(int first, int second, int number) {

        if (number <= 1) {
            return 1;
        }
        return first + fibonacciSum(second, first + second, number - 1);
    }
}
