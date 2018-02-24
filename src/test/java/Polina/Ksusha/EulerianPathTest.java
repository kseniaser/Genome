package Polina.Ksusha;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class EulerianPathTest {

    private StringBuilder curAns(String fileName) {
        StringBuilder curAns = new StringBuilder();
        try {
            curAns = Application.writeGenome(EulerianPath.findEulerianPath(MyReader.readGraph(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return curAns;
    }

    @DataProvider
    public Object[][] genomes() {
        return new Object[][]{
                {"AAABBBAB", curAns("kmers.txt").toString() }
        };
    }

    @Test(dataProvider = "genomes")
    public void reader1(String expected, String actual) {
        assertEquals(actual, expected);
    }
}