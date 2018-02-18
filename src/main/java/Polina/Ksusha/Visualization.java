package Polina.Ksusha;


import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import java.util.*;
import java.io.*;

public class Visualization {
    public static void visualizateGraph(MyGraph graph) throws IOException {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph visualGraph = new SingleGraph("Polina");
        Iterator<String> tempn = graph.nodes.iterator();
        while (tempn.hasNext()) {
            visualGraph.addNode(tempn.next());
        }
        Iterator<String> tempe = graph.edges.iterator();
        while (tempe.hasNext()) {
            String tempee = tempe.next();
            visualGraph.addEdge(tempee, tempee.substring(0, tempee.length() - 1), tempee.substring(1), true);
        }
        for (Node node : visualGraph) {
            node.addAttribute("ui.label", node.getId());
            node.addAttribute("ui.style", "text-alignment: under;");
        }
        visualGraph.display();

    }
}
