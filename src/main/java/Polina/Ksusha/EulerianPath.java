package Polina.Ksusha;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class EulerianPath {

//    public static ArrayList<String> findEulerianPath(MyGraph graph) {
//        ArrayList<String> answer = new ArrayList<>();
//        Map<String, ArrayList<String>> adjMatrix = transformToMap(graph);
//        String startNode = findStart(adjMatrix, reverseToMap(graph));
//        int count = graph.edges.size();
//        answer = findEulerianPath(startNode, answer, count, adjMatrix);
//        return answer;
//    }
//
//    public static ArrayList<String> findEulerianPath(String v, ArrayList<String> answer, int count, Map<String, ArrayList<String>> graph)  {
//        if (answer.size() == count) {
//            answer.add(v);
//            return answer;
//        }
//        System.out.print("Hey there");
//        for (int u = 0; u < graph.get(v).size(); u++) {
//            answer.add(v);
//            String nextV = graph.get(v).get(u);
//            graph.get(v).remove(u);
//            findEulerianPath(nextV, answer, count, graph);
//            graph.get(v).add(u, nextV);
//            if (answer.size() == count + 1) {
//                return answer;
//            }
//            answer.remove(answer.size() - 1);
//        }
//        return answer;
//    }

    public static ArrayList<String> findEulerianPath(MyGraph graph){

        Stack<String> stack = new Stack<String>();
        Map<String, ArrayList<String>> adjMatrix = transformToMap(graph);
        stack.push(findStart(adjMatrix, reverseToMap(graph)));
        Stack<String> ans = new Stack<String>();
        ArrayList<String> answer = new ArrayList<String>();
        while (!stack.isEmpty()) {
            String v = stack.pop();
            ans.push(v);
      //      System.out.print("I want to pop ");
        //    System.out.println(v);
            while ((adjMatrix.get(v) != null) && !adjMatrix.get(v).isEmpty()) {
                String cur = adjMatrix.get(v).get(0);
//                System.out.print("cur = ");
//                System.out.println(cur);
                stack.push(cur);
                adjMatrix.get(v).remove(cur);
                v = cur;
            }
            // add vertex with no more leaving edges to cycle
      //      System.out.print("I want to add to ans ");
     //       System.out.println(v);

        }
        int n = ans.size();
        for (int i = 1; i < n; i++)
        {
            answer.add(ans.pop());
        }
        answer.add(0, ans.pop());
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
