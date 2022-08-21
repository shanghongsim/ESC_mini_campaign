
import java.io.*;

public class FuzzerUnitSpecific {
    String f1 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/fuzz1.csv";
    String f2 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/fuzz2.csv";
    String outputPath = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/result.csv";

    public FuzzerUnitSpecific() {
        System.out.println("hello");
        generateGeneralCsvInput();
        testProgram();
    }

    public void generateGeneralCsvInput() {
        CsvRandomGeneratorSpecific c = new CsvRandomGeneratorSpecific();
        c.addFieldDefinition();
        try {
            c.generateFile(f1);
            c.generateFile(f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testProgram() {

        PrintDiffDataCSV c = new PrintDiffDataCSV(f1, f2, outputPath);

    }
}
