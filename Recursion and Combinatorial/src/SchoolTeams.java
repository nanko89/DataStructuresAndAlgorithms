import java.util.Arrays;
import java.util.Scanner;

public class SchoolTeams {
    public static String[] combineBoys = new String[2];
    public static String[] combineGirls = new String[3];

    public static String[] girls;
    public static boolean[] isUsedGirl;
    public static boolean[] isUsedBoys;
    public static String[] boys;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        girls = scanner.nextLine().split(", ");
        boys = scanner.nextLine().split(", ");

        isUsedGirl = new boolean[girls.length];
        isUsedBoys = new boolean[boys.length];

        permute(0, 0);
    }

    private static void permute(int index, int start) {
        if (index == combineGirls.length) {
            permuteBoys(0, 0);
        } else {
            for (int i = start; i < girls.length; i++) {
                combineGirls[index] = girls[i];
                permute(index + 1, i + 1);
            }
        }
    }

    private static void permuteBoys(int index, int start) {
        if (index == combineBoys.length) {
            print();
        } else {
            for (int i = start; i < boys.length; i++) {
                combineBoys[index] = boys[i];
                permuteBoys(index + 1, i + 1);
            }
        }
    }

    private static void print() {
        System.out.println(String.join(", ", combineGirls) + ", " + String.join(", ", combineBoys));
    }
}
