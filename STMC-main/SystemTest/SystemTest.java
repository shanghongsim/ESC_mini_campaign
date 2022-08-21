package SystemTest;



import org.junit.Test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class SystemTest {
    public boolean checkResult(String path1, String path2) throws IOException {
        File file1 = new File(path1);
        FileReader fr1 = new FileReader(file1);
        BufferedReader br1 = new BufferedReader(fr1);
        File file2 = new File(path2);
        FileReader fr2 = new FileReader(file2);
        BufferedReader br2 = new BufferedReader(fr2);

        String line1 = br1.readLine();
        String line2 = br2.readLine();

        if (line1 == null || line2 == null) {
            return line1 == null && line2 == null;
        }

        while (line1 != null && line2 != null) {
            if (!line1.equals(line2)) {
                return false;
            }
            line1 = br1.readLine();
            line2 = br2.readLine();
        }
        return line1 == null && line2 == null;
    }

    @Test
    public void CompetitiveValues() throws IOException {

        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/CompetitiveValues/competitive1.csv", "SystemTest/CompetitiveValues/competitive2.csv", "SystemTest/CompetitiveValues/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/CompetitiveValues/output.csv", "SystemTest/CompetitiveValues/ans.csv");
        System.out.println(state);
        assertTrue(state);

    }


    @Test
    public void DiffLength() throws IOException {
        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/DiffLength/DiffLength1.csv", "SystemTest/DiffLength/DiffLength2.csv", "SystemTest/DiffLength/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/DiffLength/output.csv", "SystemTest/DiffLength/ans.csv");
        System.out.println(state);
        assertTrue(state);

    }

    @Test
    public void Empty() throws IOException {
        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/Empty/empty1.csv", "SystemTest/Empty/empty2.csv", "SystemTest/Empty/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/Empty/output.csv", "SystemTest/Empty/ans.csv");
        System.out.println(state);
        assertTrue(state);

    }

    //This header test cannot pass, since the original code still produces the differences
    @Test
    public void Header() throws IOException {
        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/header/header1.csv", "SystemTest/header/header2.csv", "SystemTest/header/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/header/output.csv", "SystemTest/header/ans.csv");
        System.out.println(state);
        assertTrue(state);
    }


    @Test
    public void IdNotOrdered() throws IOException {
        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/IdNotOrdered/Id1.csv", "SystemTest/IdNotOrdered/Id2.csv", "SystemTest/IdNotOrdered/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/IdNotOrdered/output.csv", "SystemTest/IdNotOrdered/ans.csv");
        System.out.println(state);
        assertTrue(state);

    }
    @Test
    public void MissingValues() throws IOException {
        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/MissingValues/missing1.csv", "SystemTest/MissingValues/missing2.csv", "SystemTest/MissingValues/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/MissingValues/output.csv", "SystemTest/MissingValues/ans.csv");
        System.out.println(state);
        assertTrue(state);

    }
    @Test
    public void MissingColumn() throws IOException {
        PrintDiffDataCSV csvReader = new PrintDiffDataCSV("SystemTest/MissingColumn/missing1.csv", "SystemTest/MissingColumn/missing2.csv", "SystemTest/MissingColumn/output.csv");
        ByteArrayInputStream in = new ByteArrayInputStream("0,1,2,3".getBytes());
        System.setIn(in);
        boolean state = checkResult("SystemTest/MissingColumn/output.csv", "SystemTest/MissingColumn/ans.csv");
        System.out.println(state);
        assertTrue(state);

    }

}
//}
//}
