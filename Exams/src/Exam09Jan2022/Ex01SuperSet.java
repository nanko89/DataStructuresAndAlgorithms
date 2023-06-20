package Exam09Jan2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex01SuperSet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        printSuperSet(array);
    }

    public static void printSuperSet(int[] array) {
        List<List<Integer>> superSet = generateSuperSet(array);
        Collections.sort(superSet, (a, b) -> a.size() - b.size()); // Sort superSet by subset size
        for (List<Integer> subset : superSet) {
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generateSuperSet(int[] array) {
        List<List<Integer>> superSet = new ArrayList<>();
        backtrack(superSet, new ArrayList<>(), array, 0);
        return superSet;
    }

    private static void backtrack(List<List<Integer>> superSet, List<Integer> subset, int[] array, int start) {
        superSet.add(new ArrayList<>(subset));
        for (int i = start; i < array.length; i++) {
            subset.add(array[i]);
            backtrack(superSet, subset, array, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
