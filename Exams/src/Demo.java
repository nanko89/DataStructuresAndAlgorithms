import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Demo {
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split("\\s+");

        String[] second = reader.readLine().split("\\s+");

        int max = findLongestSequence(first, second);

        List<String> sequence = new ArrayList<>();

        while (max > 0) {
            sequence.add(0, first[max-1]);
            max--;
        }

        System.out.println(sequence);
    }

    private static int findLongestSequence(String[] first, String[] second) {

        dp = new int[first.length + 1][second.length + 1];

        int max = 0;

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1].equals(second[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return max;
    }
}

