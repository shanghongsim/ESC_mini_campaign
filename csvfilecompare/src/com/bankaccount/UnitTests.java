package com.bankaccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Tests mainly pertain to partition 1 in equivalence class partitioning
 * diagram
 */
public class UnitTests {
    String[] args = {
            "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/YuZheng/ESC_mini_campaign/csvfilecompare/sample_file_1.csv",
            "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/YuZheng/ESC_mini_campaign/csvfilecompare/sample_file_2.csv",
            "/Users/shanghongsim/SoftwareTestingCampaignPeerTest/YuZheng/ESC_mini_campaign/csvfilecompare/sample_file_3.csv" };

    /**
     * Test constructor
     * 
     * @throws IOException
     */
    @Test
    public void testConstructor() throws IOException {
        csv_compare c1 = new csv_compare();
        System.out.println(c1);
        c1.main(args);
    }

    /**
     * Test that program actually writes to output
     * 
     * @throws IOException
     */
    @Test
    public void testAccount() throws IOException {
        csv_compare c1 = new csv_compare();
        System.out.println(c1);

        BufferedReader csv = new BufferedReader(
                new FileReader("/Users/shanghongsim/SoftwareTestingCampaignPeerTest/YuZheng/output.csv"));
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
