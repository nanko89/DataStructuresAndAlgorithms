import java.util.Scanner;

public class VariationsWithoutRepetitions {
    public static String[] letters;
    public static String[] variationsLetter;
    public static boolean[] isUsed;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        letters = scanner.nextLine().split("\\s+");
        int slots = Integer.parseInt(scanner.nextLine());
        variationsLetter = new String[slots];
        isUsed = new boolean[letters.length];
        variations(0);
    }

    private static void variations(int index) {
        if (index == variationsLetter.length){
            printLetter();
            return;
        }

        for (int j = 0; j < letters.length; j++) {
           if (!isUsed[j]){
               isUsed[j] = true;
                variationsLetter[index] = letters[j];
                variations(index + 1);
               isUsed[j] = false;
           }
        }
    }

    private static void printLetter() {
        System.out.println(String.join(" ", variationsLetter));
    }
}
