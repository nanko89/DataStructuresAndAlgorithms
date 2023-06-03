import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CombinationsWithRepetition {
    public static int[] combinations;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        combinations = new int[k];
        combination(0, 1);
    }

    private static void combination(int index, int start) {
        if (index == combinations.length) {
            print();
            return;
        }

        for (int i = start; i <= n; i++) {
            combinations[index] = i;
            combination(index + 1, i);
        }
    }

    private static void print() {
        for (int i = 0; i < combinations.length; i++) {
            System.out.print(combinations[i] + " ");
        }
        System.out.println();
    }
}
