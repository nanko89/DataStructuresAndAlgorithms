package Exam24July2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex01Trains {
    public static double[] arrivalTimes;
    public static double[] departureTimes;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        arrivalTimes = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        departureTimes = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        System.out.println(findPlatform(arrivalTimes.length));
    }

    static int findPlatform(int n)
    {
        Arrays.sort(arrivalTimes);
        Arrays.sort(departureTimes);

        int platform = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arrivalTimes[i] < departureTimes[j]) {
                platform++;
                i++;
            }else {
                platform--;
                j++;
            }

            if (platform > result)
                result = platform;
        }

        return result;
    }
}

//----------------Second decision

//public class Ex01Trains {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        double[] arrivals = Arrays.stream(reader.readLine().split("\\s+"))
//                .mapToDouble(Double::parseDouble)
//                .sorted()
//                .toArray();
//
//        double[] departures = Arrays.stream(reader.readLine().split("\\s+"))
//                .mapToDouble(Double::parseDouble)
//                .sorted()
//                .toArray();
//
//        int maxPlatforms = 0;
//        int platforms = 0;
//
//        for (int i = 0, j = 0; i < arrivals.length;) {
//            if (arrivals[i] < departures[j]) {
//                platforms++;
//                i++;
//
//                if (platforms > maxPlatforms) {
//                    maxPlatforms = platforms;
//                }
//            } else {
//                platforms--;
//                j++;
//            }
//        }
//        System.out.println(maxPlatforms);
//    }
//}