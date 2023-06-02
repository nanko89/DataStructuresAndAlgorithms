import java.util.HashSet;
import java.util.Scanner;

public class PermutationsWithRepetition {
    public static String[] letters;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        letters = scanner.nextLine().split("\\s+");
        permute(0);
    }

    private static  void permute(int index) {
        if (index == letters.length){
            printLetter();
            return;
        }
        permute(index + 1);

        HashSet<String> swapped = new HashSet<>();
        swapped.add(letters[index]);
        for (int j = index + 1; j < letters.length; j++) {
                if (!swapped.contains(letters[j])) {
                    swap(index, j);
                    permute(index + 1);
                    swap(index, j);
                    swapped.add(letters[j]);
                }
            }
        }

    private static void swap(int first, int second) {
        String temp = letters[first];
        letters[first] = letters[second];
        letters[second] = temp;
    }

    private static void printLetter() {
        System.out.println(String.join(" ", letters));
    }
}
