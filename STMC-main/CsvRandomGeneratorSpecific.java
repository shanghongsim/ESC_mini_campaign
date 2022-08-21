
import java.io.*;
import java.util.*;

public class CsvRandomGeneratorSpecific {
    ArrayList<String> fields = new ArrayList<String>();
    int len = 100;
    String out;
    FileWriter output;

    public CsvRandomGeneratorSpecific() {

    }

    public void addFieldDefinition() {
        for (int i = 0; i < len; i++) {
            FieldDefinitionSpecific f = new FieldDefinitionSpecific(i);
            fields.add(f.toString());
        }
    };

    public void generateFile(String fileName) throws IOException {
        Iterator<String> iter = fields.iterator();
        while (iter.hasNext()) {
            String k = iter.next();
            out = out + k + "\n";
        }
        output = new FileWriter(fileName);
        output.write(out);
        output.close();
    };

    public static void main(String[] args) {
        CsvRandomGeneratorSpecific c = new CsvRandomGeneratorSpecific();
        c.addFieldDefinition();
        try {
            c.generateFile("/Users/shanghongsim/SoftwareTestingCampaign/src/output.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
