package FinalExam02July2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex03 {

    public static  List<Integer> prevIndex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = reader.readLine().split("\\s+");

        String[] second = reader.readLine().split("\\s+");

        List<String> sequence = findLongestSequence(first, second);

        System.out.println("[" + String.join(" ", sequence).trim() + "]");
    }

    private static List<String> findLongestSequence(String[] first, String[] second) {
        int[][] dp = new int[first.length + 1][second.length + 1];
        int max = 0;

        List<Integer> prevIndex = new ArrayList<>();

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].equals(second[j])) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > max) {
                        max = dp[i + 1][j + 1];
                        prevIndex.add(i);
                    }
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        List<String> sequence = new ArrayList<>();

        for (int i = 0; i < prevIndex.size(); i++) {
            if (prevIndex.size() == 1){
                sequence.add(first[i]);
            }else {
                sequence.add(second[i]);
            }
        }

        return sequence;
    }
}
