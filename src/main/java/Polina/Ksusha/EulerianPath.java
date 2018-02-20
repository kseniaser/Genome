package Polina.Ksusha;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class EulerianPath {

    public static ArrayList<String> findEulerianPath(MyGraph graph) {
        ArrayList<String> answer = new ArrayList<>();
        Map<String, ArrayList<String>> adjMatrix = transformToMap(graph);
        String startNode = findStart(adjMatrix, reverseToMap(graph));
        int count = graph.edges.size();
        answer = findEulerianPath(startNode, answer, count, adjMatrix);
        return answer;
    }

    public static ArrayList<String> findEulerianPath(String v, ArrayList<String> answer, int count, Map<String, ArrayList<String>> graph)  {
        if (answer.size() == count) {
            answer.add(v);
            return answer;
        }
        for (int u = 0; u < graph.get(v).size(); u++) {
            answer.add(v);
            String nextV = graph.get(v).get(u);
            graph.get(v).remove(u);
            findEulerianPath(nextV, answer, count, graph);
            graph.get(v).add(u, nextV);
            if (answer.size() == count + 1) {
                return answer;
            }
            answer.remove(answer.size() - 1);
        }
        return answer;
    }

    public static String findStart(Map<String, ArrayList<String>> fromMatrix, Map<String, ArrayList<String>> toMatrix) {
        for (Object obj : fromMatrix.entrySet()) {
            Entry entry = (Entry) obj;
            int fromSize = ((ArrayList<String>) entry.getValue()).size();
            int toSize;
            try{
                toSize = (toMatrix.get(entry.getKey())).size();
            } catch (NullPointerException nullPointer){
                return (String) entry.getKey();
            }
            if (fromSize - toSize > 0)
                return (String) entry.getKey();
        }
        return "";
    }

    public static Map<String, ArrayList<String>> transformToMap(MyGraph inGraph) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (String temp: inGraph.edges){
            String from = temp.substring(0, temp.length() - 1);
            String to = temp.substring(1);
            ArrayList<String> buf = new ArrayList<>();
            if (graph.containsKey(from)){
                buf = graph.get(from);
                if (from.equals(to))
                    buf.add(0,to);
                else
                    buf.add(to);
            } else {
                if (from.equals(to))
                    buf.add(0,to);
                else
                    buf.add(to);
            }
            graph.put(from, buf);
        }
    return graph;
    }

    public static Map<String, ArrayList<String>> reverseToMap(MyGraph inGraph) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (String temp: inGraph.edges){
            String from = temp.substring(0, temp.length() - 1);
            String to = temp.substring(1);
            ArrayList<String> buf = new ArrayList<>();
            if (graph.containsKey(to)){
                buf = graph.get(to);
                buf.add(from);
            } else {
                buf.add(from);
            }
            graph.put(to, buf);
        }
        return graph;
    }

}
