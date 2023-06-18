package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SumWithLimitedAmountOfCoins {
    public static int[] numbers;
    public static int[] dp;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(scanner.nextLine());

        dp = new int[target+ 1];

        dp[0] = 1;

        System.out.println(dp[target]);
    }
}
