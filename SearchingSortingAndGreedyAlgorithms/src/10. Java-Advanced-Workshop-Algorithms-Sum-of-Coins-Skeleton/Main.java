//import java.util.*;
//
//public class Main {
//    public static boolean reachSum = false;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String[] elements = in.nextLine().substring(7).split(", ");
//        int[] coins = new int[elements.length];
//        for (int i = 0; i < coins.length; i++) {
//            coins[i] = Integer.parseInt(elements[i]);
//        }
//
//        Arrays.sort(coins);
//        Collections.reverse(Arrays.asList(coins));
//
//
//        int targetSum = Integer.parseInt(in.nextLine().substring(5));
//
//
//        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);
//
//        if (!reachSum){
//            System.out.println("Error");
//        }else {
//            int numberOfCoins = usedCoins.values().stream().mapToInt(i -> i).sum();
//            System.out.println("Number of coins to take: " + numberOfCoins);
//            for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
//                if (usedCoin.getValue() > 0) {
//                    System.out.println(usedCoin.getValue() + " coin(s) with value " + usedCoin.getKey());
//                }
//            }
//        }
//    }
//
//    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
//    Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
//        for (int i = coins.length  -1 ;  i >=0; i--) {
//
//            if (targetSum / coins[i] >= 0){
//                int countCoins = targetSum / coins[i];
//                targetSum = targetSum - (countCoins * coins[i]);
//                usedCoins.put(coins[i], countCoins);
//            }
//        }
//        if (targetSum == 0){
//            reachSum = true;
//        }
//    return usedCoins;
//    }
//
//}