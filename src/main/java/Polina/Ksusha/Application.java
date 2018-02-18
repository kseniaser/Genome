package Polina.Ksusha;

import java.io.IOException;

public class Application {
    public static void main(String args[]) throws IOException {
        MyGraph graph = MyReader.readGraph();
        Visualization.visualizateGraph(graph);
    }
}
