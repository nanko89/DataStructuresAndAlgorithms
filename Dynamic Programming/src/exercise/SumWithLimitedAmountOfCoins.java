package exercise;

import java.util.*;

public class SumWithLimitedAmountOfCoins {
    public static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(scanner.nextLine());

        Map<Integer, Integer> dp = new HashMap<>();

        int result = 0;
        dp.put(0, 0);

        for (int currentCoin : numbers) {

            for (Integer number : new ArrayList<>(dp.keySet())) {
                int newSum = currentCoin + number;

                if (newSum == target) {
                    result++;
                }
                dp.putIfAbsent(newSum, number);
            }
        }
        System.out.println(result);
    }
}
