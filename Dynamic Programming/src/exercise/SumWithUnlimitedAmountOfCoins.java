package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SumWithUnlimitedAmountOfCoins {
    public static int[] coins;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        coins = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(scanner.nextLine());

        dp = new int[target+ 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= target; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[target]);
    }
}
