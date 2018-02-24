package Polina.Ksusha;



import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class Application {

    public static void main(String args[]) throws IOException {
        MyGraph graph = MyReader.readGraph(args[0]) ;
        ArrayList<String> answer = EulerianPath.findEulerianPath(graph);
 //       System.out.print(answer);
        StringBuilder finalAns = writeGenome(answer);
        String veryFinalAns = finalAns.toString().replace('#', '\n');
        veryFinalAns = veryFinalAns.replace('_',' ');
        System.out.print(veryFinalAns);
        Visualization.visualizatePath(answer);
    }
    public static StringBuilder writeGenome(ArrayList<String> answer) throws IOException {
        String a = answer.get(0);
        StringBuilder genome = new StringBuilder();
        genome.append(a.substring(0, a.length() - 1));
        for (String i :answer){
            genome.append(i.substring(i.length() - 1,i.length()));
        }
        return genome;
    }
}

