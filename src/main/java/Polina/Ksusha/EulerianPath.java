package Polina.Ksusha;

import java.io.IOException;
import java.sql.Array;
import java.util.*;

public class EulerianPath {


    public static Map<String, ArrayList<String>> TransformToMap(MyGraph inGraph) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (String temp : inGraph.edges) {
            String from = temp.substring(0, temp.length() - 1);
            String to = temp.substring(1);
            ArrayList<String> buf = new ArrayList<>();
            if (graph.containsKey(from)) {
                buf = graph.get(from);
                buf.add(to);
            } else {
                buf.add(to);
            }
            graph.put(from, buf);
        }
        return graph;
    }

}
