import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SetCover {
    public static Set<int[]> findingSets = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = reader.readLine().substring(10).split(", ");
        int[] universe = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            universe[i] = Integer.parseInt(elements[i]);
        }


        int numberOfSets = Integer.parseInt(reader.readLine().substring(16));
        List<int[]> sets = new ArrayList<>();

        for (int i = 0; i < numberOfSets; i++) {
            String[] setElements = reader.readLine().split(", ");
            int[] set = new int[setElements.length];
            for (int j = 0; j < setElements.length; j++) {
                set[j] = Integer.parseInt(setElements[j]);
            }
            sets.add(set);
        }

        sets = sets.stream().sorted((a, b) -> {
            return Integer.compare(b.length, a.length);
        }).collect(Collectors.toList());

        List<int[]> chosenSets = chooseSets(sets, universe);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Sets to take (%d):%n", chosenSets.size()));
        for (int[] set : chosenSets) {
            sb.append("{ ");
            sb.append(Arrays.toString(set).replaceAll("\\[|]", ""));
            sb.append(" }").append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {

        List<Integer> universeSets = new ArrayList<>();
        for (int u : universe) {
            universeSets.add(u);
        }

        while (sets.size() > 0 && universeSets.size() >0) {
            int[] current = sets.get(0);
            for (int i = 0; i < current.length; i++) {
                if (universeSets.contains(current[i])){
                    universeSets.remove(Integer.valueOf(current[i]));
                    findingSets.add(current);
                    sets.remove(current);
                }else {
                    sets.remove(current);
                }
            }
        }

        List<int[]> result = findingSets.stream().toList();

        return result;
    }
}
