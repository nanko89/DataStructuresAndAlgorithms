package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DividingPresents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] presents = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int totalSum = Arrays.stream(presents).sum();
        int[] sums = new int[totalSum + 1];
        Arrays.fill(sums, -1);
        sums[0] = 0;

        for (int currentIndex = 0; currentIndex < presents.length; currentIndex++) {
            int presentValue = presents[currentIndex];

            for (int prevSumIndex = totalSum - presentValue; prevSumIndex >= 0; prevSumIndex--) {
                if (sums[prevSumIndex] != -1 && sums[prevSumIndex + presentValue] == -1) {
                    sums[prevSumIndex + presentValue] = currentIndex;
                }
            }
        }

        int target = totalSum / 2;

        for (int i = target; i >= 0; i--) {
            if (sums[i] != -1) {
                System.out.println("Difference: " + (totalSum - i - i));
                System.out.println("Alan:" + i + " Bob:" + (totalSum - i));
                System.out.print("Alan takes:");
                while (i != 0) {
                    System.out.print(" " + presents[sums[i]]);
                    i -= presents[sums[i]];
                }
                System.out.println();
                System.out.println("Bob takes the rest.");
            }
        }
    }
}