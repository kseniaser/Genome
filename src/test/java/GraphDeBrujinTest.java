import Polina.Ksusha.MyGraph;
import Polina.Ksusha.Reader;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


/**
 * Created by Ksenia on 11.02.2018.
 */
public class GraphDeBrujinTest extends Assert {

    public MyGraph expectedGraph() {
        MyGraph graph = new MyGraph();
        graph.addNode("AA");
        graph.addNode("AB");
        graph.addNode("BB");
        graph.addNode("BA");

        graph.addEdge("AAA");
        graph.addEdge("AAB");
        graph.addEdge("ABB");
        graph.addEdge("BBB");
        graph.addEdge("BBA");
        return graph;
    }

    @Test
    public void reader1() throws IOException  {
        MyGraph expected = new GraphDeBrujinTest().expectedGraph();
        MyGraph actual = new Reader().readGraph();
        assertTrue(actual.equal(expected));
        assertFalse(!actual.equal(expected));
    }

}