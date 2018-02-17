package Polina.Ksusha;

import java.util.*;
import java.io.*;

public class MyReader {

    public static MyGraph readGraph () throws IOException  {
        MyGraph graph = new MyGraph();
        try(Scanner in = new Scanner(new File("kmers.txt"));) {
            while (in.hasNextLine()) {
                String str = in.nextLine();
                if (!str.equals("")) {
                    String a = str.substring(0, str.length() - 1);
                    String b = str.substring(1);
                    graph.addNode(a);
                    graph.addNode(b);
                    graph.addEdge(str);

                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return graph;
    }

}
