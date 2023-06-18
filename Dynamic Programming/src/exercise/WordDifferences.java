package exercise;

import java.util.Scanner;

public class WordDifferences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] firstWord = scanner.nextLine().toCharArray();
        char[] secondWord = scanner.nextLine().toCharArray();

        int[][] dp = new int[firstWord.length + 1][secondWord.length + 1];

        for (int i = 0; i <= firstWord.length; i++) {
            for (int j = 0; j <= secondWord.length; j++) {
                if (i == 0){
                    dp[i][j] =j;
                }else if (j == 0){
                    dp[i][j] = i;
                } else if (firstWord[i-1] == secondWord[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1] )+ 1;
                }
            }
        }
        System.out.println("Deletions and Insertions: " + dp[firstWord.length][secondWord.length]);
    }
}
