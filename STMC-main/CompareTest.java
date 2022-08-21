
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import SystemTest.PrintDiffDataCSV;

public class CompareTest {
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

}
