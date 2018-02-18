package Polina.Ksusha;


import java.io.*;
import java.util.ArrayList;

public class Application {


    public static String makeAns (MyGraph g) throws IOException {
        ArrayList<String> answer = EulerianPath.findEulerianPath(g);
        String genome = "";
        for (String i :answer){
            genome+=i.substring(0, i.length() - 1);
        }
        String last = answer.get(answer.size()-1);
        genome+=last.substring(last.length() - 1,last.length());
        return genome;
    }

    public static void main(String args[]) throws IOException {

        MyGraph graph = MyReader.readGraph(args[0]) ;
     //   System.out.print(makeAns(graph));
        Visualization.visualizateGraph(graph);
    }
}

