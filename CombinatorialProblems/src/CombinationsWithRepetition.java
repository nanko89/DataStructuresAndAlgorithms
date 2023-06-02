import java.util.Scanner;

public class CombinationsWithRepetition {
    public static String[] symbols;
    public static String[] combinations;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        symbols = scanner.nextLine().split("\\s+");
        int spots = Integer.parseInt(scanner.nextLine());

        combinations = new String[spots];
        combination(0,0);

    }

    public static void combination(int index, int start){
        if (index == combinations.length){
            print();
        }else {
            for (int i = start; i < symbols.length ; i++) {
                combinations[index] = symbols[i];
                combination(index + 1 , i);
            }
        }

    }

    private static void print() {
        System.out.println(String.join(" ", combinations));
    }
}
