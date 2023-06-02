import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] arr = scanner.nextLine().split("\\s+");

        reverseOrder(arr, 0);

        System.out.println(String.join(" ", arr));
    }

    private static void reverseOrder(String[] arr, int index) {
        if (index == arr.length/2){
            return;
        }

        String temp = arr[index];
        arr[index] = arr[arr.length - 1 -index];
        arr[arr.length - 1 - index] = temp;

        reverseOrder(arr, index+1);
    }
}
