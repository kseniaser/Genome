import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;
import java.io.*;

public class GraphDeBrujin {

    Scanner in;

    public  Graph reader() throws IOException{
        Scanner in = new Scanner(new File("kmers.txt"));
        Graph graph = new SingleGraph("De bruijn");
        try {
            while (in.hasNextLine()) {
                String str = in.nextLine();
                if (!str.equals("")) {
                    String a = str.substring(0, str.length() - 1);
                    String b = str.substring(1);
                    if (graph.getNode(a) == null) {
                        graph.addNode(a);
                    }
                    if (graph.getNode(b) == null) {
                        graph.addNode(b);
                    }
                    if (graph.getEdge(str) == null) {
                        graph.addEdge(str, a, b,true);
                    }
                }
            }
        } finally {
            in.close();
        }
        return graph;
    }


    public  void solve() throws IOException{
        Graph graph = reader();
        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());
            node.addAttribute("ui.style", "text-alignment: under;");
        }
        graph.display();
    }

    public  void run() {
        try {
            //in = new Scanner(new File("kmers.txt"));
            solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]) throws IOException {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        new GraphDeBrujin().run();
    }
}

