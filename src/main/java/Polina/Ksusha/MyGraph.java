package Polina.Ksusha;

import java.util.*;


public class MyGraph {
    Set<String> edges;
    Set<String> nodes;

    public MyGraph() {
        edges = new HashSet<String>();
        nodes = new HashSet<String>();
    }

    public void addEdge(String str) {
        edges.add(str);
    }

    public void addNode(String str) {
        nodes.add(str);
    }

    public boolean equal(MyGraph gr2) {
        if ((this.edges.equals(gr2.edges)) && (this.nodes.equals(gr2.nodes))) return true;
        else return false;
    }

}
