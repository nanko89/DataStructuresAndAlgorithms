package Exam28June2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex02NuclearWaste {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] flasksCost = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int flasks = Integer.parseInt(reader.readLine());

        int[] bestCosts = new int[flasks + 1];
        int[] prevIndex = new int[flasks + 1];

        for (int i = 1; i <= flasks; i++) {
            bestCosts[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (j > flasksCost.length) {
                    break;
                }
                int newValue = bestCosts[i - j] + flasksCost[j - 1];
                if (newValue < bestCosts[i]) {
                    bestCosts[i] = newValue;
                    prevIndex[i] = j;
                }
            }
        }
        System.out.println("Cost: " + bestCosts[flasks]);
        while (flasks > 0) {
            System.out.println(prevIndex[flasks] + " => " + bestCosts[prevIndex[flasks]]);
            flasks -= prevIndex[flasks];
        }
    }
}
