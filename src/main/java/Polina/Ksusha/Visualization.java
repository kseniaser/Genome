package Polina.Ksusha;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;
import java.io.*;

public class Visualization {

    public static void visualizatePath(ArrayList<String> answer)  {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph visualGraph = new MultiGraph("Polina");
        visualGraph.addAttribute("ui.stylesheet", styleSheet);
        visualGraph.setAutoCreate(true);
        visualGraph.setStrict(false);
        visualGraph.display();
        visualGraph.addNode(answer.get(0));
        for(int i=1; i<answer.size(); i++){
            visualGraph.addNode(answer.get(i));
            visualGraph.addEdge(Integer.toString(i),answer.get(i-1),answer.get(i),true);
        }
        for (Node node : visualGraph) {
            node.addAttribute("ui.label", node.getId());
            node.addAttribute("ui.style", "text-alignment: under;");
        }
        sleep();
        explore(visualGraph, answer);
    }

    public static void explore(Graph visualGraph, ArrayList<String> answer) {
        visualGraph.getNode(answer.get(0)).setAttribute("ui.class", "marked");
        for(int i=1; i<answer.size(); i++){
            visualGraph.getEdge(Integer.toString(i)).setAttribute("ui.class", "marked");
            visualGraph.getNode(answer.get(i)).setAttribute("ui.class", "marked");
            sleep();
        }
    }

    protected static void sleep() {
        try { Thread.sleep(10); } catch (Exception e) {}
    }

    protected static String styleSheet =
            "edge.marked {" +
                    "	fill-color: red;" +
                    "}" +
                    "node{"+
                    "size :5px;"+
                    "}"+
                    "node.marked {" +
                    "	fill-color: red;" +
                    "}";

}