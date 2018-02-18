package Polina.Ksusha;

import java.io.*;

public class GraphDeBrujin {

    public static void main(String args[]) throws IOException {
        MyGraph graph = Reader.readGraph();
        Visualization.visualizateGraph(graph);
    }
}

