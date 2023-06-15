package lab;

import java.util.Scanner;

public class Fibonacci {
    public static long[] memo;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memo = new long[n+1];

        long ftb = calcFib(n);
        System.out.println(ftb);

//        Iterative way

//        memo[1] = 1;
//        memo[2] = 1;
//
//        for (int i = 3; i <= n; i++) {
//            memo[i] = memo[i-1] + memo[i-2];
//        }
//
//        System.out.println(memo[n]);
    }

    private static long calcFib(int n) {

        if (n <= 2){
            return 1;
        }

        if (memo[n] != 0){
            return memo[n];
        }
        return memo[n] = calcFib(n-1) + calcFib(n-2);
    }
}
