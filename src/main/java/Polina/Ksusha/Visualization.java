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
        int speed;
        for(int i=1; i<answer.size(); i++){
            visualGraph.addNode(answer.get(i));
            visualGraph.addEdge(Integer.toString(i),answer.get(i-1),answer.get(i),true);
        }
        for (Node node : visualGraph) {
            node.addAttribute("ui.label", node.getId());
            node.addAttribute("ui.style", "text-alignment: under;");
        }
        if (answer.size()>50) {
            for (Node node : visualGraph) {
                //needs if number of nodes >50
                node.setAttribute("x", 1);
                node.setAttribute("y", 3);
            }
            sleep(10000);
            speed =10;
        } else {
            sleep(5000);
            speed = 1000;
        }
        explore(visualGraph, answer, speed);
    }

    public static void explore(Graph visualGraph, ArrayList<String> answer, int speed) {
        visualGraph.getNode(answer.get(0)).setAttribute("ui.class", "marked");
        for(int i=1; i<answer.size(); i++){
            visualGraph.getEdge(Integer.toString(i)).setAttribute("ui.class", "marked");
            visualGraph.getNode(answer.get(i)).setAttribute("ui.class", "marked");
            sleep(speed);
        }
    }

    protected static void sleep(int speed) {
        try { Thread.sleep(speed); } catch (Exception e) {}
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
