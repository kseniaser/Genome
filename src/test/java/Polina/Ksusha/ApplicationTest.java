package Polina.Ksusha;

import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.testng.Assert.*;

public class ApplicationTest {

    // [n - num of edges in expected, m - num of nodes, test.txt - list of n edges && m nodes]

    private MyGraph curGraph = new MyGraph();

    private MyGraph uploadExpGraph(String testFile) {
        MyGraph expG = new MyGraph();
        int cnt = 0;
        try (Scanner in = new Scanner(new File(testFile))) {
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


    private MyGraph uploadCurGraph(String curFile) {
        MyGraph curG = new MyGraph();
        try {
            curG = MyReader.readGraph(curFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return curG;
    }

    @DataProvider
    public Object[][] graphs() {
            return new Object[][]{
                    {uploadExpGraph("testRead.txt"), uploadCurGraph("kmers.txt") }
            };
    }



    @Test(dataProvider = "graphs")
    public void reader1(MyGraph expected, MyGraph actual) {
        assertTrue(actual.equal(expected));

    }

}