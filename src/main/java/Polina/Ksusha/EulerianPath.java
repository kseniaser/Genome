package Polina.Ksusha;

import jdk.internal.util.xml.impl.Pair;
import scala.Array;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class EulerianPath {

    private static ArrayList<String> usedStart = new ArrayList<>();
    public static ArrayList<String> findEulerianPath(MyGraph graph) {


        Map<String, ArrayList<String>> adjMatrix = transformToMap(graph);
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<String>();
        findStart(graph);
        while (!usedStart.isEmpty()) {
            Stack<String> stack = new Stack<String>();
            stack.push(usedStart.get(0));
            boolean nextEdge = true;
            while (!stack.isEmpty()) {
                String v = stack.peek();
                usedStart.remove(v);
                if ((adjMatrix.get(v) != null) && adjMatrix.get(v).isEmpty()) {
                    stack.pop();
                    nextEdge = true;

                } else if (adjMatrix.get(v) != null) {
                    String cur = adjMatrix.get(v).get(0);
                    if ((((cnt.get(cur)[0] == 1 || cnt.get(cur)[0] == 0)) && !ans.isEmpty()) && !nextEdge) {
                        String mem = ans.get(ans.size() - 1);
                        mem += cur.substring(cur.length() - 1, cur.length());
                        ans.set(ans.size() - 1, mem);
                    } else {
                        ans.add(v.substring(0, v.length()) + cur.substring(cur.length() - 1, cur.length()));
                        nextEdge = false;
                    }
                    stack.push(cur);
                    adjMatrix.get(v).remove(cur);
                }

            }
            ;
        }
        int n = ans.size();
        for (int i = n - 1; i >= 0; i--) {
            answer.add(ans.get(i));
        }

        return answer;
    }


   // private static Map<String, Boolean> starters = new HashMap<>();
    private static Map<String, int[]> cnt = new HashMap<>(); //i = 0 исходящие, i = 1 входящие
    public static void findStart(MyGraph graph) {
        for (String s: graph.nodes){
            int buf[] = cnt.get(s);
             if (buf[0] - buf[1] > 0){
                 usedStart.add(s);
             }
        }
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
