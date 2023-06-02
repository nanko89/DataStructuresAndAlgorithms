import java.util.Scanner;

public class NestedLoops {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        arr = new int[num];

        loopNumber(0);
    }

    private static void loopNumber(int index) {
        if (index == arr.length) {
            print();
            return;
        }

        for (int i = 1; i <= arr.length; i++) {
            arr[index] = i;
            loopNumber(index + 1);
        }
    }

    private static void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
