import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CombinationsWithoutRepetition {
    public static int n;
    public static int[] combinations;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

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
            combination(index + 1, i +1);
        }
    }

    private static void print() {
        for (int i = 0; i < combinations.length; i++) {
            System.out.print(combinations[i] + " ");
        }
        System.out.println();
    }
}
