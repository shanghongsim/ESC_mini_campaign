package UnitTest.ReadTest;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;



class ReadTest {
    public String path1;
    public String path2;
    File File1;
    File File2;
    public ReadTest(String path1, String path2 ){
        this.path1 = path1;
        this.path2 = path2;
        this.File1 = new File(this.path1);
        this.File2 = new File(this.path2);


    }
    @Test
    public void CompetitiveValues() throws IOException {
        ReadTest paths = new ReadTest("./UnitTest/ReadTest/file1.csv", "./UnitTest/ReadTest/file2.csv");
        assertEquals(paths.File1 , "./UnitTest/ReadTest/file1.csv");
        assertEquals(paths.File2 , "./UnitTest/ReadTest/file2.csv");

    }

    }