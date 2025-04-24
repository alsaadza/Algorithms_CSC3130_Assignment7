import java.util.*;

public class Question5 {
    static class edge {

        String destination;
        int weight;

        edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class graph {
        private final Map<String, List<edge>> adjacent = new HashMap<>();

        public void addEdge(String from, String destination, int weight) {
            if (!adjacent.containsKey(from)) {
                adjacent.put(from, new ArrayList<>());
            }
            adjacent.get(from).add(new edge(destination, weight));

        }

        public void printweight(String start, String end, int targetWeight) {
            Deque<String> path = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            depthfirst(start, end, 0, targetWeight, path, visited);
        }

        private void depthfirst(String current, String end, int currentWeight, int targetWeight, Deque<String> path, Set<String> visited) {
            path.addLast(current);
            visited.add(current);

            if (current.equals(end) && currentWeight == targetWeight) {
                System.out.println(new ArrayList<>(path));
            }

            if (adjacent.containsKey(current)) {
                for (edge edge : adjacent.get(current)) {
                    if (!visited.contains(edge.destination) && currentWeight + edge.weight <= targetWeight) {
                        depthfirst(edge.destination, end, currentWeight + edge.weight, targetWeight, path, visited);
                    }
                }
            }

            path.removeLast();
            visited.remove(current);
        }
    }

    public static void main(String[] args) {
        graph test = new graph();

        test.addEdge("A", "B", 3);
        test.addEdge("A", "C", 4);
        test.addEdge("A", "F", 5);
        test.addEdge("B", "D", 2);
        test.addEdge("B", "E", 4);
        test.addEdge("C", "D", 3);
        test.addEdge("C", "F", 2);
        test.addEdge("D", "E", 2);
        test.addEdge("D", "F", 1);
        test.addEdge("E", "F", 6);
        String u = "A";
        String w = "D";

        System.out.println("Start: " + u);
        System.out.println("End: " + w);
        System.out.println("PATHS: ");
        test.printweight(u, w, 7);
    }
}
