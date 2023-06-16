package lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class RodCutting {
    public static int[] prices;
    public static int[] bestPrice;
    public static int[] bestCombo;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        prices = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        bestPrice = new int[prices.length + 1];
        bestCombo = new int[prices.length +1];

        int n  = Integer.parseInt(scanner.nextLine());

        int maxProfit = cutRot(n);
        System.out.println(maxProfit);
        reconstructSolution(n);
    }
    private static int cutRot(int n){
        for (int i = 1 ; i <=n ; i++) {
            int currentBest;
            for (int j = 1; j <= i; j++) {
                currentBest = Math.max(bestPrice[i], prices[j] + bestPrice[i-j]);

                if (currentBest > bestPrice[i]){
                    bestPrice[i] = currentBest;
                    bestCombo[i] = j;
                }
            }
        }
        return bestPrice[n];
    }

    private static void reconstructSolution(int n) {
        while (n - bestCombo[n] != 0) {
            System.out.print(bestCombo[n] + " ");
            n = n - bestCombo[n];
        }
        System.out.println(bestCombo[n]);
    }

}
