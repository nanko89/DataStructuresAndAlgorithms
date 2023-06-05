
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cinema {

    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> people;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        people = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        seats = new String[people.size()];

        String input = scanner.nextLine();
        while (!input.equals("generate")) {
            String name = input.split(" - ")[0];
            int position = Integer.parseInt(input.split(" - ")[1]);
            seats[position - 1] = name;
            people.remove(name);

            input = scanner.nextLine();
        }

        combinations = new String[people.size()];
        used = new boolean[people.size()];

        distributeFriends(0);
    }

    private static void distributeFriends(int index) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = people.get(i);
                    distributeFriends(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (String seat : seats) {
            if (seat != null) {
                sb.append(seat).append(" ");
            } else {
                sb.append(combinations[index++]).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
