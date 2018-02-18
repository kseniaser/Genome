package Polina.Ksusha;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;
import java.io.*;

public class Visualization {

    public static void VisualizatePath(MyGraph graph, ArrayList<String> answer)  {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph visualGraph = new SingleGraph("Polina");
        visualGraph.addAttribute("ui.stylesheet", styleSheet);
        visualGraph.setAutoCreate(true);
        visualGraph.setStrict(false);
        visualGraph.display();
        Iterator<String> tempn = graph.nodes.iterator();
        while (tempn.hasNext()){
            visualGraph.addNode(tempn.next());
        }
        Iterator<String> tempe = graph.edges.iterator();
        while (tempe.hasNext()){
            String tempee = tempe.next();
            visualGraph.addEdge(tempee, tempee.substring(0, tempee.length() - 1), tempee.substring(1), true);
        }
        for (Node node : visualGraph) {
            node.addAttribute("ui.label", node.getId());
            node.addAttribute("ui.style", "text-alignment: under;");
        }

        explore(visualGraph, answer);
    }

    public static void explore(Graph visualGraph, ArrayList<String> answer) {
        for (String i :answer){
            visualGraph.getEdge(i).setAttribute("ui.class", "marked");
            sleep();
        }
    }

    protected static void sleep() {
        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    protected static String styleSheet =
            "edge {" +
                    "	fill-color: black;" +
                    "}" +
                    "edge.marked {" +
                    "	fill-color: red;" +
                    "}";

}
