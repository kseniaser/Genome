package Polina.Ksusha;

import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.testng.Assert.*;

public class ApplicationTest {

    // [n - num of edges in expected, m - num of nodes, test.txt - list of n edges && m nodes]

    private MyGraph expGraph = new MyGraph();

    private MyGraph uploadCurGraph(String curFile) {
        MyGraph curG = new MyGraph();
        curG = MyReader.readGraph(curFile);
        return curG;
    }

    @DataProvider
    public Object[][] graphs() {
        return new Object[][]{
                {expGraph.deserialize("testRead.txt"), uploadCurGraph("kmers.txt") }
        };
    }

    @Test(dataProvider = "graphs")
    public void reader1(MyGraph expected, MyGraph actual) {
        assertTrue(actual.equal(expected));

    }

}