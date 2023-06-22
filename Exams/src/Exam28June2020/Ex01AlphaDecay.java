package Exam28June2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01AlphaDecay {
    public static String[] combinations;
    public static String[] numbers;
    public static boolean[] visited;

    public static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numbers = reader.readLine().split("\\s+");
        length = Integer.parseInt(reader.readLine());

        combinations = new String[length];
        visited = new boolean[numbers.length];

        combination(0);
    }

    private static void combination(int index) {
        if (index == length) {
            print();
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combinations[index] = numbers[i];
                combination(index + 1);
                visited[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", combinations));
    }
}