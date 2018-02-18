package Polina.Ksusha;

import java.io.*;
import java.util.ArrayList;

public class Application {

    public static void main(String args[]) throws IOException {
        MyGraph graph = MyReader.readGraph(args[0]) ;
        ArrayList<String> answer = EulerianPath.findEulerianPath(graph);

        System.out.print(writeGenome(answer));

        ArrayList<String> ans = new ArrayList<>();
        for (int i=0;i<answer.size()-1;i++){
            ans.add(i,answer.get(i)+answer.get(i+1).substring(1,2));
        }

        Visualization.VisualizatePath(graph, ans);
    }

    public static String writeGenome ( ArrayList<String> answer) throws IOException {
        String genome = "";
        for (String i :answer){
            genome+=i.substring(0, i.length() - 1);
        }
        String last = answer.get(answer.size()-1);
        genome+=last.substring(last.length() - 1,last.length());
        return genome;
    }
}

