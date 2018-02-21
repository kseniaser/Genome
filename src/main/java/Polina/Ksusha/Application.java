package Polina.Ksusha;



import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Application {

    public static void main(String args[]) throws IOException {
        MyGraph graph = MyReader.readGraph(args[0]) ;
//        Map<String, ArrayList<String>> answer2 = EulerianPath.reverseToMap(graph);
//        Map<String, ArrayList<String>> answer1 = EulerianPath.transformToMap(graph);
//        String d = EulerianPath.findStart(answer1,answer2);
//        System.out.print(graph.nodes.size());
//        System.out.print(graph.edges.size());

        ArrayList<String> answer = EulerianPath.findEulerianPath(graph);

//        for(String i: answer)
//        {
//            System.out.println(i);
//        }
        System.out.print(writeGenome(answer));

//        ArrayList<String> ans = new ArrayList<>();
//        for (int i=0;i<answer.size()-1;i++){
//            ans.add(i,answer.get(i)+answer.get(i+1).substring(1,2));
//        }

//        Visualization.VisualizatePath(graph, answer);
    }

    public static String writeGenome ( ArrayList<String> answer) throws IOException {
        String a =answer.get(0);
        String genome = a.substring(0, a.length() - 1);
        for (String i :answer){
            genome+=i.substring(i.length() - 1,i.length());
        }
        return genome;
    }
}

