package Polina.Ksusha;

import jdk.internal.util.xml.impl.Pair;
import scala.Array;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class EulerianPath {


    public static ArrayList<String> findEulerianPath(MyGraph graph) {

        Stack<String> stack = new Stack<String>();
        Map<String, ArrayList<String>> adjMatrix = transformToMap(graph);
        stack.push(findStart(graph));
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<String>();
        while (!stack.isEmpty()) {
            String v = stack.peek();
            if ((adjMatrix.get(v) != null) && adjMatrix.get(v).isEmpty()) {
                ans.add(v);
                stack.pop();
            } else if (adjMatrix.get(v) != null) {
                String cur = adjMatrix.get(v).get(0);
                stack.push(cur);
                adjMatrix.get(v).remove(cur);
            }

        };
        int n = ans.size();
        for (int i = n - 1; i >= 0; i--) {
            answer.add(ans.get(i));
        }

        return answer;
    }

    private static Map<String, int[]> cnt = new HashMap<>(); //i = 0 исходящие, i = 1 входящие
    public static String findStart(MyGraph graph) {
        for (String s: graph.nodes){
            int buf[] = cnt.get(s);
             if (buf[0] - buf[1] > 0) return s;
        }
        return "";
    }


    public static Map<String, ArrayList<String>> transformToMap(MyGraph inGraph) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (String i : inGraph.nodes) {
            graph.put(i, new ArrayList<>());
            int[] buf = new int[2];
            buf[0] = 0; buf[1] = 0;
            cnt.put(i, buf);
        }
        for (String temp : inGraph.edges) {
            String from = temp.substring(0, temp.length() - 1);
            String to = temp.substring(1);
            if (from.equals(to))
                graph.get(from).add(0, to);
            else
                graph.get(from).add(to);
            cnt.get(from)[0]++;
            cnt.get(to)[1]++;
        }
        return graph;
    }

}
