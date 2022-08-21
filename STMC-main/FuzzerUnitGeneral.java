
import java.io.*;

public class FuzzerUnitGeneral {
    String f1 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/fuzz1.csv";
    String f2 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/fuzz2.csv";
    String outputPath = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/result.csv";

    public FuzzerUnitGeneral() {
        System.out.println("hello");
        generateGeneralCsvInput();
        testProgram();
    }

    public void generateGeneralCsvInput() {
        CsvRandomGenerator c = new CsvRandomGenerator();
        c.addFieldDefinition();
        try {
            c.generateString();
            c.generateCsv(f1);
            c.generateCsv(f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testProgram() {

        PrintDiffDataCSV c = new PrintDiffDataCSV(f1, f2, outputPath);
    }
}
