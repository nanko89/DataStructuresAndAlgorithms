import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num  = Integer.parseInt(scanner.nextLine());

        long fact = factorialRecursion(num);

        System.out.println(fact);

    }

    private static long factorialRecursion(int num) {

        if (num == 1){
            return 1;
        }

        return num * factorialRecursion(num -1);
    }
}
