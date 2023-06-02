import java.util.Scanner;

public class VariationsWithRepetition {
    public static String[] letters;
    public static String[] variations;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        letters = scanner.nextLine().split("\\s+");
        int slots = Integer.parseInt(scanner.nextLine());

        variations = new String[slots];
        variation(0);

    }

    private static void variation(int index) {

        if (index == variations.length){
            print();
            return;
        }

        for (int i = 0; i < letters.length; i++) {
            variations[index] = letters[i];
            variation(index + 1);
        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations ));
    }
}
