package Polina.Ksusha;

import scala.util.parsing.combinator.testing.Str;

import java.io.*;
import java.util.ArrayList;

public class Application {

    public static void main(String args[]) throws IOException {
        MyGraph graph = MyReader.readGraph() ;
        ArrayList<String> answer = EulerianPath.findEulerianPath(graph);
        String genome = "";
        for (String i :answer){
            genome+=i.substring(0, i.length() - 1);
        }
        String last = answer.get(answer.size()-1);
        System.out.print(genome+=last.substring(last.length() - 1,last.length()));

        Visualization.visualizateGraph(graph);
    }
}

