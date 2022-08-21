
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MutationFuzzUnit {
    String original;
    String f1 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/mutatedCsv1.csv";
    String f2 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/mutatedCsv2.csv";
    String outputPath = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/result.csv";

    public MutationFuzzUnit() {
        generateMutatedCsv();
        testProgram();

    }

    public String loadCsv(String filePath) throws IOException {
        BufferedReader csv = new BufferedReader(new FileReader(filePath));
        List<List<String>> records = new ArrayList<List<String>>();
        String line;
        while ((line = csv.readLine()) != null) {
            original = original + line + "\n";
        }
        csv.close();
        return original;
    }

    public String flip(String m) {
        System.out.println("Input: " + m);
        byte[] input = m.getBytes(StandardCharsets.UTF_8);
        System.out.println(input.length); // 3, 1 Chinese character = 3 bytes
        String binary = convertByteArraysToBinary(input);

        Random random = new Random();// create Random object
        int flip_position = random.nextInt(binary.length()); // generate random number from 0 to 3
        // System.out.println(flip_position);

        char[] ch = binary.toCharArray();
        char i = ch[flip_position];
        if (i == '0') {
            ch[flip_position] = '1';
        } else {
            ch[flip_position] = '0';
        }
        binary = String.valueOf(ch);
        String text2 = new String(new BigInteger(binary, 2).toByteArray());
        System.out.println("As text: " + text2);
        return binary;
    }

    public String trim(String m) {
        System.out.println("Input: " + m);
        Random random = new Random();// create Random object
        int trim_position = random.nextInt(m.length()); // generate random number from 0 to 3
        return m.substring(0, trim_position);
    }

    public String swap(String m) {
        char ch[] = m.toCharArray();
        Random random = new Random();// create Random object
        int i = random.nextInt(m.length()); // generate random number from 0 to 3
        int j = random.nextInt(m.length()); // generate random number from 0 to 3
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    public String insert(String m) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        char c = chars.charAt(rnd.nextInt(chars.length()));
        int i = rnd.nextInt(m.length()); // generate random number from 0 to 3
        String s1 = m.substring(0, i);
        String s2 = m.substring(i, m.length());
        return s1 + c + s2;
    }

    public static String convertByteArraysToBinary(byte[] input) {

        StringBuilder result = new StringBuilder();
        for (byte b : input) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                result.append((val & 128) == 0 ? 0 : 1); // 128 = 1000 0000
                val <<= 1;
            }
        }
        return result.toString();
    }

    public void writeToFile(String outputPath, String m) throws IOException {
        FileWriter output = new FileWriter(outputPath);
        output.write(m);
        output.close();
    }

    public String mutate(String str) {
        String mutatedStr;

        Random random = new Random();// create Random object
        int i = random.nextInt(4); // generate random number from 0 to 3
        switch (i) {
            case 0:
                mutatedStr = flip(str);
                break;

            case 1:
                mutatedStr = trim(str);
                break;

            case 2:
                mutatedStr = swap(str);
                break;

            case 3:
                mutatedStr = insert(str);
                break;

            default:
                mutatedStr = flip(str);
                break;
        }
        return mutatedStr;

    }

    public void generateMutatedCsv() {
        String mutatedStr1;
        String mutatedStr2;

        try {
            String str = loadCsv(
                    "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/STMC/sample_file_1.csv");
            mutatedStr1 = mutate(str);
            mutatedStr2 = mutate(str);
            writeToFile(f1, mutatedStr1);
            writeToFile(f2, mutatedStr2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testProgram() {
        PrintDiffDataCSV c = new PrintDiffDataCSV(f1, f2, outputPath);
    }

    public static void main(String[] args) {
        String f1 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/mutatedCsv1.csv";
        String f2 = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/mutatedCsv2.csv";
        String outputPath = "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/TianQin/result.csv";

        PrintDiffDataCSV c = new PrintDiffDataCSV(f1, f2, outputPath);

    }
}
