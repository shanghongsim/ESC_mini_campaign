import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.io.*;
import java.util.*;

import org.junit.Test;

public class UnitTestSH {
    /**
     * Check that illegal file path throws I/O exception in comparison app
     * 
     */
    @Test
    public void illegalFilePath() {
        String f1 = "/Users/shanghongsim/softwaretestingcampaign/comparison-app/src/main/java/com/example/comparison_app";
        String f2 = "/Users/shanghongsim/softwaretestingcampaign/comparison-app/src/main/java/com/example/comparison_app";
        String outputPath = "/Users/shanghongsim/SoftwareTestingCampaign/src/output.csv";
        try {
            PrintDiffDataCSV c = new PrintDiffDataCSV(f1, f2, outputPath);
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check that illegal file path in helper function throws I/O exception
     *
     * @throws IOException
     */
    @Test(expected = IOException.class)
    public void illegalFilePath2() throws IOException {
        String f1 = "/Users/shanghongsim/softwaretestingcampaign/comparison-app/src/main/java/com/example/comparison_app";
        String f2 = "/Users/shanghongsim/softwaretestingcampaign/comparison-app/src/main/java/com/example/comparison_app";
        String outputPath = "/Users/shanghongsim/SoftwareTestingCampaign/src/output.csv";
        CompareTest c = new CompareTest();
        c.checkResult(f1, f2);
    }

    /**
     * Check that comparison app writes to output successfully
     *
     * @throws IOException
     */
    @Test
    public void csv1and3() throws IOException {
        String f1 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/STMC/sample_file_1.csv";
        String f2 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/STMC/sample_file_3.csv";
        String outputPath = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/STMC/result.csv";
        PrintDiffDataCSV c = new PrintDiffDataCSV(f1, f2, outputPath);

        BufferedReader csv = new BufferedReader(
                new FileReader(outputPath));
        List<List<String>> records = new ArrayList<List<String>>();
        String line;
        while ((line = csv.readLine()) != null) {
            String[] values = line.split(",");
            List<String> rawArr = new ArrayList<String>(Arrays.asList(values));
            // List<String> compareArr = rawArr.subList(1, values.length);
            records.add(rawArr);
        }
        csv.close();
        Object[] arr = records.toArray();
        assertNotEquals(0, arr.length);
    }

}
