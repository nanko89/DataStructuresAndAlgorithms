import java.util.*;
import java.util.stream.Collectors;

public class BreakCycles {
    public static Map<Character, List<Character>> graph = new HashMap<>();
    public static Map<Character,Boolean> visited = new HashMap<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals("")){
            String[] token = line.split(" -> ");
            char key = token[0].charAt(0);
            List<Character> collect = Arrays.stream(token[1].split("\\s+")).map(s -> s.charAt(0)).collect(Collectors.toList());

            graph.put(key,collect);
            visited.put(key, false);

            line = scanner.nextLine();
        }

        Character smallestKey = graph.entrySet().stream()
                .min(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(null);


        char started = smallestKey;

        dfs(started);

        System.out.println();
    }

    private static void dfs(char started) {

        if(visited.get(started)){
            return;
        }

        List<Character> characters = graph.get(started);
        visited.put(started,true);

        for (int i = 0; i < characters.size(); i++) {
            if (!visited.get(characters.get(i))){
                dfs(characters.get(i));
            }
        }
    }
}
