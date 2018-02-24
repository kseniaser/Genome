package Polina.Ksusha;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.*;

public class MyGraph {

    ArrayList <String> edges;
    Set <String> nodes;

    public MyGraph (){
        edges = new ArrayList<>();
        nodes = new HashSet <String>();
    }

    public void addEdge(String str){
        edges.add(str);
    }

    public void addNode(String str){
        nodes.add(str);
    }

    public boolean equal(MyGraph gr2) {
        if ((this.edges.equals(gr2.edges)) && (this.nodes.equals(gr2.nodes))) return true;
        else return false;
    }

    public MyGraph deserialize(String filename){
        MyGraph expG = new MyGraph();
        int cnt = 0;
        try (Scanner in = new Scanner(new File(filename))) {
            String ns = in.nextLine();
            int n = Integer.parseInt(ns);
            String ms = in.nextLine();
            int m = Integer.parseInt(ms);
            while (in.hasNextLine()) {
                String str = in.nextLine();
                if (cnt < n) expG.addEdge(str);
                else expG.addNode(str);
                cnt++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return expG;
    }

}
