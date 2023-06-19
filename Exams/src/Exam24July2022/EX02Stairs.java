package Exam24July2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EX02Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        long[] dp = new long[n +1];

        Arrays.fill(dp, -1);

        fib(n, dp);

        System.out.println(dp[n]);

    }

    private static long fib(int n, long[] dp) {
        if (n <= 1){
            return dp[n] = 1;
        }
        if (dp[n] != -1){
            return dp[n];
        }

        return dp[n] = fib(n-1, dp) + fib(n-2, dp);
    }

}
