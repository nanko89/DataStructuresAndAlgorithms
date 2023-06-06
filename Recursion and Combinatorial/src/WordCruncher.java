    import java.util.*;
    import java.util.stream.Collectors;

    public class WordCruncher {
        public static List<String> words;
        public static List<String> combined = new ArrayList<>();
        private static Map<Integer, List<String>> table = new HashMap<>();
        private static Map<String,Integer > occurrences = new HashMap<>();
        private static String target;

        private static Set<String> results = new TreeSet<>();

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            words = Arrays.stream(scanner.nextLine().split(", "))
                    .collect(Collectors.toList());

            target = scanner.nextLine();

            words.removeIf(next -> !target.contains(next));

            for (String word: words) {
                occurrences.putIfAbsent(word,0);
                occurrences.put(word, occurrences.get(word) + 1);

                int index = target.indexOf(word);

                while (index != -1){
                    table.putIfAbsent(index, new ArrayList<>());
                    table.get(index).add(word);
                    index = target.indexOf(word, index+1);
                }
            }

            permute(0);
            results.forEach(r -> System.out.println(r));

        }

        private static void permute(int index) {
            if (index == target.length()) {
                print();
            } else if (table.containsKey(index)){
                List<String> strings = table.get(index);
                for (String str: strings) {
                    if (occurrences.get(str) > 0) {
                        occurrences.put(str, occurrences.get(str) - 1);
                        combined.add(str);
                        permute(index + str.length());
                        combined.remove(combined.size() - 1);
                        occurrences.put(str, occurrences.get(str) + 1);
                    }
                }
            }
        }

        private static void print() {
            String result = String.join("", combined);
            if (target.contains(result)){
               results.add(String.join(" " , combined));
            }
        }
    }
