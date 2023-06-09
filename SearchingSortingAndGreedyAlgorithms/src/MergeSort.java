import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (arr.length == 1) {
            System.out.println(arr[0]);
        }

        sortArray(arr);

        System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start+end) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        if (mid < 0 || mid >= array.length || array[mid] < array[mid + 1]) {
            return;
        }

        int left = start;
        int right = mid + 1;

        int[] helper = new int[array.length];
        System.arraycopy(array, 0, helper, 0, array.length);

        for (int i = start; i <= end; i++) {
            if (left > mid ) {
                array[i] = helper[right++];
            } else if (right > end) {
                array[i] = helper[left++];
            } else if (helper[left] < helper[right]) {
                array[i] = helper[left++];
            }else {
                array[i] = helper[right++];
            }
        }
    }
}
