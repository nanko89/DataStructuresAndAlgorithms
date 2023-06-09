import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (arr.length == 1) {
            System.out.println(arr[0]);
        }

        sort(arr);

    }
    private static void sort(int []arr){
        sort(arr, 0, arr.length -1);
        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high){
            int pi = partition(arr, low, high);
            sort(arr, low, pi -1);
            sort(arr, pi+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low -1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
