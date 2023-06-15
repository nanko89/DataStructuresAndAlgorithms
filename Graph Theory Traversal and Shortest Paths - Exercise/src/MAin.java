import java.util.Scanner;

public class MAin {
    private static int[] salaries;
    private static String[] hierarchy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        salaries = new int[n];
        hierarchy = new String[n];

        for (int i = 0; i < n; i++) {
            hierarchy[i] = scanner.nextLine();
        }

        for (int i = 0; i < n; i++) {
            calculateSalary(i);
        }

        int totalSalary = 0;
        for (int salary : salaries) {
            totalSalary += salary;
        }

        System.out.println(totalSalary);
    }

    private static int calculateSalary(int employee) {
        if (salaries[employee] != 0) {
            return salaries[employee];
        }

        int salary = 1; // Regular employees have a base salary of 1

        for (int i = 0; i < hierarchy.length; i++) {
            if (hierarchy[employee].charAt(i) == 'Y') {
                salary += calculateSalary(i);
            }
        }

        salaries[employee] = salary;
        return salary;
    }
}
