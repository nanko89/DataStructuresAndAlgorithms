package ExamPreparations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01MonkeyBusiness {
    public static int[] expression;
    public static int[] numbers;
    public static int n;
    public static int count = 0;
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        expression = new int[n];
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i]= i+1;
        }

        combination(0 );
        System.out.print(builder);
        System.out.println("Total Solutions: " + count);
    }

    private static void combination(int index) {
        if (index >= n) {
            if (Arrays.stream(expression).sum() == 0) {
                count ++;
                printSolution();
            }
        } else {
                expression[index] = numbers[index];
                combination(index + 1);
                expression[index] = -numbers[index];
                combination(index + 1);

        }
    }

    private static void printSolution() {
        for (int i = 0; i < expression.length; i++) {
            if (expression[i] > 0) {
                builder.append("+").append(expression[i]).append(" ");
            } else {
                builder.append(expression[i]).append(" ");
            }
        }
        builder.append("\n");
    }
}
