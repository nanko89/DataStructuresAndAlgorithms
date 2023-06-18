package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DividingPresents {
    public static int[] presents;
    public static int[][] dp;
    public static List<Integer> indexes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        presents = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[presents.length + 1][presents.length + 1];
        indexes = new ArrayList<>();

        int totalValue = Arrays.stream(presents).sum();

        int targetValue = totalValue / 2;

        int alanSum = 0;

        int bestSum = 0;
        for (int i = presents.length - 1 ; i > 0; i--) {
            List<Integer> currentIndexes = new ArrayList<>();
            alanSum = presents[i];
            currentIndexes.add(i);
            for (int j = i -1; j >= 0; j--) {

            if (alanSum + presents[j] <= targetValue) {
                alanSum += presents[j];
                currentIndexes.add(j);
            }
            }
            if (bestSum <= alanSum ){
                bestSum = alanSum;
                indexes = currentIndexes;
            }
        }


        List<Integer> alanPresent = new ArrayList<>();

        for (int i = 0; i < indexes.size(); i++) {
            alanPresent.add(presents[indexes.get(i)]);
        }

        int alanPresents = alanPresent.stream().mapToInt(a -> a).sum();
        int bobPresents = totalValue - alanPresents;
        System.out.println("Difference: " + Math.abs(alanPresents - bobPresents));
        System.out.println("Alan:" + alanPresents + " Bob:" + bobPresents);
        System.out.print("Alan takes: ");
        List<String> collect = alanPresent.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(" ", collect));
        System.out.println("Bob takes the rest.");

    }
}