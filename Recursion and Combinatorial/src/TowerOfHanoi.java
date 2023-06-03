import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowerOfHanoi {
    public static StringBuilder stringBuilder = new StringBuilder();
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();

    public static int step = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(bf.readLine());

        fillSource(disk);

        print();

        solve(disk,source,destination,spare);
        System.out.println(stringBuilder.toString());
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {

        if (disk == 1){
            destination.push(source.pop());
           stringBuilder.append("Step #").append(step++).append(": Moved disk\n");
            print();
        }else {
            solve(disk-1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk -1, spare, destination, source);
        }
    }

    private static void print() {
        stringBuilder.append(String.format("Source: %s%n"+
                "Destination: %s%n" +
                "Spare: %s%n%n", formatted(source), formatted(destination), formatted(spare)));
    }

    private static String formatted(Deque<Integer> stack){
        return stack.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static void fillSource(int n) {
        for (int i = n; i >= 1 ; i--) {
            source.push(i);
        }
    }
}
