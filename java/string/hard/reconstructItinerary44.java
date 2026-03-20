
package string.hard;

import java.util.*;

public class reconstructItinerary44 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph
                    .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                    .offer(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        dfs("JFK", graph, result);

        Collections.reverse(result);
        return result;
    }

    private void dfs(String airport,
                     Map<String, PriorityQueue<String>> graph,
                     List<String> result) {

        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, graph, result);
        }

        result.add(airport);
    }

    public static void main(String[] args) {

        reconstructItinerary44 obj = new reconstructItinerary44();

        List<List<String>> tickets1 = new ArrayList<>();
        tickets1.add(Arrays.asList("MUC", "LHR"));
        tickets1.add(Arrays.asList("JFK", "MUC"));
        tickets1.add(Arrays.asList("SFO", "SJC"));
        tickets1.add(Arrays.asList("LHR", "SFO"));

        System.out.println("Itinerary 1: " + obj.findItinerary(tickets1));

        List<List<String>> tickets2 = new ArrayList<>();
        tickets2.add(Arrays.asList("JFK", "SFO"));
        tickets2.add(Arrays.asList("JFK", "ATL"));
        tickets2.add(Arrays.asList("SFO", "ATL"));
        tickets2.add(Arrays.asList("ATL", "JFK"));
        tickets2.add(Arrays.asList("ATL", "SFO"));

        System.out.println("Itinerary 2: " + obj.findItinerary(tickets2));
    }
}