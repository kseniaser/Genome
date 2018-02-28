package Polina.Ksusha;
import htsjdk.samtools.fastq.FastqReader;
import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class MyReader {

    public static MyGraph readGraph(String inFile)  {
        MyGraph graph = new MyGraph();
        try(FastqReader in = new FastqReader(new File(inFile));) {
            while (in.hasNext()) {
                String str = in.next().getReadString();
//                System.out.println(str);
//                System.out.println();
                if (!str.equals("")) {
                    String a = str.substring(0, str.length() - 1);
                    String b = str.substring(1);
                    graph.addNode(a);
                    graph.addNode(b);
                    graph.addEdge(str);

                }
            }
        }
        return graph;
    }

}