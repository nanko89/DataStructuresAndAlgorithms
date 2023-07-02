package FinalExam02July2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int x = Integer.parseInt(reader.readLine());

        int p = count(n, x);

        System.out.println(p);
    }

    private static int count(int n, int x) {
        if (x > n) {
            return 0;
        }

        if (x == 0 || x == n) {
            return 1;
        }

        return count(n - 1, x - 1) + count(n - 1, x);
    }
}
