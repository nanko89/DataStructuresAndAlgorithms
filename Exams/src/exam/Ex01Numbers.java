package exam;

import java.util.*;

public class Ex01Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> currentCombination = new ArrayList<>();
        generateCombinations(N,N, currentCombination);
    }

    private static void generateCombinations(int target, int max, List<Integer> currentCombination) {
        if (target == 0) {
            printCombination(currentCombination);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = Math.min(target,max); i >0 ; i--) {
            currentCombination.add(i);
            generateCombinations(target - i,i, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    private static void printCombination(List<Integer> combination) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < combination.size(); i++) {
            sb.append(combination.get(i));
            if (i != combination.size() - 1) {
                sb.append(" + ");
            }
        }
        System.out.println(sb.toString());
    }
}
