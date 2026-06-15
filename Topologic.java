import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Topologic {
    private Map<String, List<String>> adjList;
    private Map<String, Integer> inDegree;

    public Topologic() {
        adjList = new HashMap<>();
        inDegree = new HashMap<>();
    }



    public void addVertex(String vertex) {

        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
            inDegree.put(vertex, 0);
        }
    }



    public void addEdge(String source, String destination) {
        adjList.get(source).add(destination);

        inDegree.put(
                destination,
                inDegree.get(destination) + 1
        );
    }




    public List<String> topologicalSort() {
        Map<String, Integer> tempInDegree = new HashMap<>(inDegree);
        List<String> sorted = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();


        for (String vertex : tempInDegree.keySet()) {
            if (tempInDegree.get(vertex) == 0) {
                queue.offer(vertex);
            }
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            sorted.add(current);

            for (String neighbor : adjList.get(current)) {
                tempInDegree.put(
                        neighbor,
                        tempInDegree.get(neighbor) - 1
                );

                if (tempInDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (sorted.size() != adjList.size()) {
            return null;
        }

        return sorted;
    }
}