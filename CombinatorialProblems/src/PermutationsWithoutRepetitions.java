import java.util.Scanner;

public class PermutationsWithoutRepetitions {
    public static String[] letters;
    public static String[] permutation;
    public static boolean[] isUsed;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        letters = scanner.nextLine().split("\\s+");
        permutation = new String[letters.length];
        isUsed = new boolean[letters.length];

        permute(0);
    }

    private static  void permute(int index) {
        if (index == letters.length){
            printLetter();
            return;
        }

        for (int j = 0; j < letters.length; j++) {
            if (!isUsed[j]){
                isUsed[j] = true;
                permutation[index] = letters[j];
                permute(index + 1);
                isUsed[j] = false;
            }
        }
    }

    private static void printLetter() {
        System.out.println(String.join(" ", permutation));
    }
}
