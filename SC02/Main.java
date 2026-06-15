package SC02;
public class Main {

    public static void main(String[] args) {
        Topologic graph = new Topologic();

        graph.addVertex("Variabel");
        graph.addVertex("Percabangan");
        graph.addVertex("Perulangan");
        graph.addVertex("Array");
        graph.addVertex("OOP");

        graph.addEdge("Variabel", "Percabangan");
        graph.addEdge("Variabel", "Perulangan");
        graph.addEdge("Perulangan", "Array");
        graph.addEdge("Array", "OOP");

        System.out.println("Urutan Belajar:");

        System.out.println(graph.topologicalSort());
    }
}