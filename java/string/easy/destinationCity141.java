package string.easy;

import java.util.*;

public class destinationCity141 {

    public static String destCity(List<List<String>> paths) {
        Set<String> sourceCities = new HashSet<>();

        for (List<String> path : paths) {
            sourceCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!sourceCities.contains(destination)) {
                return destination;
            }
        }

        return "";
    }

    public static void main(String[] args) {

        List<List<String>> paths = new ArrayList<>();

        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));

        String answer = destCity(paths);

        System.out.println("Destination City: " + answer);

        List<List<String>> paths2 = new ArrayList<>();

        paths2.add(Arrays.asList("B", "C"));
        paths2.add(Arrays.asList("D", "B"));
        paths2.add(Arrays.asList("C", "A"));

        System.out.println("Destination City: " + destCity(paths2));

        List<List<String>> paths3 = new ArrayList<>();

        paths3.add(Arrays.asList("A", "Z"));

        System.out.println("Destination City: " + destCity(paths3));
    }
}






