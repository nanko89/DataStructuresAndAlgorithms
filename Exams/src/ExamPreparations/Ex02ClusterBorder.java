package ExamPreparations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex02ClusterBorder {
    public static int[] dp;
    public static List<String> output = new ArrayList<>();
    public static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] singleShipsTimes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] pairShipsTime = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[singleShipsTimes.length + 1];

        dp[1] = singleShipsTimes[0];

        for (int i = 2; i <= singleShipsTimes.length; i++) {
            if (dp[i -1] + singleShipsTimes[i-1] < dp[i-2] + pairShipsTime[i-2]){
                dp[i] = dp[i-1] + singleShipsTimes[i-1];
            }else {
                dp[i] = dp[i-2] + pairShipsTime[i-2];
            }
        }
        for (int i = dp.length - 1; i > 0; i--) {
            int diffTime = dp[i] - dp[i - 1];
            if (diffTime == singleShipsTimes[i -1 ]){
                output.add("Single "+i);
            }else {
                output.add("Pair of " + (i - 1) +" and " + i);
                i--;
            }

        }
        System.out.println("Optimal Time: " + dp[singleShipsTimes.length]);
        Collections.reverse(output);
        for (int i = 0; i < output.size(); i++) {
            builder.append(output.get(i)).append("\n");
        }
        System.out.println(builder);
    }
}
