package exercise;

import java.awt.*;
import java.util.Scanner;

public class BinomialCoefficients {
    public static long[][] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        memory = new long[n + 1][k + 1];

        for (int row = 0; row <=n ; row++) {
            for (int col = 0; col <=Math.min(k,row) ; col++) {
                if (col == 0 || col == row){
                    memory[row][col] = 1;
                }else {
                    memory[row][col] = memory[row -1][col] + memory[row-1][col-1];
                }
            }
        }

        System.out.println(memory[n][k]);
//        With recursion
//        long binom = calcBinom(n, k);
//        System.out.println(binom);
    }

//    private static long calcBinom(int n, int k) {
//        if (k == 0 || k == n) {
//            return 1;
//        }
//
//        if (memory[n][k] != 0) {
//            return memory[n][k];
//        }
//        return memory[n][k] = calcBinom(n - 1, k) + calcBinom(n - 1, k - 1);
//    }
}
