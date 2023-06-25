package exam;

import java.util.Scanner;

public class Ex02TheTyrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] numbers = inputLine.split(" ");

        int[] sequence = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sequence[i] = Integer.parseInt(numbers[i]);
        }

        int minimumSum = findMinimumSum(sequence);
        System.out.println(minimumSum);
    }

    private static int findMinimumSum(int[] sequence) {
        int n = sequence.length;

        if (n <= 3) {
            int sum = 0;
            for (int num : sequence) {
                sum += num;
            }
            return sum;
        }

        int[] dp = new int[n];
        dp[0] = sequence[0];
        dp[1] = sequence[1];
        dp[2] = sequence[2];
        dp[3] = sequence[3];

        for (int i = 4; i < n; i++) {
            dp[i] = sequence[i] + Math.min(Math.min(dp[i - 1], dp[i - 2]), Math.min(dp[i - 3], dp[i - 4]));
        }

        return Math.min(Math.min(dp[n - 1], dp[n - 2]), Math.min(dp[n - 3], dp[n - 4]));
    }
}
