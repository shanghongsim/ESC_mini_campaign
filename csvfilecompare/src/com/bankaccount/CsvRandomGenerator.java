package com.bankaccount;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class CsvRandomGenerator {
    ArrayList<String> fields = new ArrayList<String>();
    int len = 1;
    String out;
    FileWriter output;

    public CsvRandomGenerator() {
    }

    public void addFieldDefinition() {
        for (int i = 0; i < len; i++) {
            FieldDefinitionGeneral f = new FieldDefinitionGeneral();
            System.out.println("hello" + f);
            fields.add(f.toString());
        }
    };

    public String generateString() throws IOException {
        Iterator<String> iter = fields.iterator();
        while (iter.hasNext()) {
            String k = iter.next();
            out = out + k + "\n";
        }
        return out;
    };

    public void generateCsv(String fileName) throws IOException {
        output = new FileWriter(fileName);
        output.write(out);
        output.close();
    }

    public static void main(String[] args) {
        CsvRandomGenerator c = new CsvRandomGenerator();
        c.addFieldDefinition();
        try {
            String out = c.generateString();
            c.generateCsv(
                    "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/YuZheng/ESC_mini_campaign/csvfilecompare/src/com/bankaccount/fuzz1.csv");
            c.generateCsv(
                    "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/YuZheng/ESC_mini_campaign/csvfilecompare/src/com/bankaccount/fuzz2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
