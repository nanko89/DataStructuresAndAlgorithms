import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printStars("*", number);
        printHash("#", number ,1 );
    }

    private static void printHash(String s, int number, int count) {
        if (number < count){
            return;
        }
        System.out.print(s.repeat(count));
        System.out.println();
        printHash(s, number, count + 1 );
    }

    private static void printStars(String s, int number) {
        if (number == 0){
            return;
        }
        System.out.print(s.repeat(number));
        System.out.println();
        printStars(s, number-1);
    }
}
