import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memoNums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        memoNums = new long[num + 1];

        System.out.println(recursiveFibonacci(num));
    }

    private static long recursiveFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memoNums[n] != 0) {
            return memoNums[n];
        }

        memoNums[n] =
                recursiveFibonacci(n - 1) +
                        recursiveFibonacci(n - 2);

        return memoNums[n];
    }
}
