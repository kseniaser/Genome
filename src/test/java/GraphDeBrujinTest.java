import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import org.graphstream.graph.*;

public class GraphDeBrujinTest extends Assert {

    public Graph expectedGraph() {
        Graph graph = new SingleGraph("test");
        graph.addNode("AA");
        graph.addNode("AB");
        graph.addNode("BB");
        graph.addNode("BA");

        graph.addEdge("AAA", "AA", "AA",true);
        graph.addEdge("AAB", "AA", "AB", true);
        graph.addEdge("ABB", "AB", "BB", true);
        graph.addEdge("BBB", "BB", "BB", true);
        graph.addEdge("BBA", "BB", "BA", true);
        graph.addEdge("BAB", "BA", "AB", true);
        return graph;
    }

    @Test
    public void reader1() throws IOException  {
        Graph expected = new GraphDeBrujinTest().expectedGraph();
        Graph actual = new GraphDeBrujin().reader();
        for (Node node : actual) {
            assertTrue(expected.getNode(node.getId()) != null);
        }
        for (Node node : expected) {
            assertTrue(actual.getNode(node.getId()) != null);
        }
        for (Edge edge : actual.getEachEdge()) {
            assertTrue(expected.getEdge(edge.getId()) != null);
        }
        for (Edge edge : expected.getEachEdge()) {
            assertTrue(actual.getEdge(edge.getId()) != null);
        }
    }

}