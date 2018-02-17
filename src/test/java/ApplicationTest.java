import Polina.Ksusha.MyGraph;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


/**
 * Created by Ksenia on 11.02.2018.
 */
public class ApplicationTest extends Assert {

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

    }

}