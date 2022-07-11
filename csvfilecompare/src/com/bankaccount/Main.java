package com.bankaccount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("sample_file_1.csv"));
        BufferedReader br2 = new BufferedReader(new FileReader("sample_file_2.csv"));
        BufferedReader br3 = new BufferedReader(new FileReader("sample_file_3.csv"));

        ArrayList<Account> account1 = new ArrayList<Account>();
        ArrayList<Account> account2 = new ArrayList<Account>();
        ArrayList<Account> account3 = new ArrayList<Account>();
        ArrayList<String> outputaccount = new ArrayList<>();

        String currentLine1;
        String currentLine2;
        String currentLine3;

        int i = 0;

        while ((currentLine1 = br1.readLine()) != null) {
            String[] detailed1 = currentLine1.split(",");
            if (detailed1[0].equals("Customer ID#"))
                continue;
            String account_id1 = detailed1[0].substring(0, detailed1[0].length());
            String account_number1 = detailed1[1].substring(0, detailed1[1].length());
            String account_currency1 = detailed1[2].substring(0, detailed1[2].length());
            String account_type1 = detailed1[3].substring(0, detailed1[3].length());
            String account_balance1 = detailed1[4].substring(0, detailed1[4].length());
            account1.add(new Account(account_id1, account_number1, account_currency1, account_type1, account_balance1));
        }
        while ((currentLine2 = br2.readLine()) != null) {
            String[] detailed2 = currentLine2.split(",");
            if (detailed2[0].equals("Customer ID#"))
                continue;
            String account_id2 = detailed2[0].substring(0, detailed2[0].length());
            String account_number2 = detailed2[1].substring(0, detailed2[1].length());
            String account_currency2 = detailed2[2].substring(0, detailed2[2].length());
            String account_type2 = detailed2[3].substring(0, detailed2[3].length());
            String account_balance2 = detailed2[4].substring(0, detailed2[4].length());
            account2.add(new Account(account_id2,account_number2,account_currency2, account_type2, account_balance2));
        }
        while ((currentLine3 = br3.readLine()) != null) {
            String[] detailed3 = currentLine3.split(",");
            if (detailed3[0].equals("Customer ID#"))
                continue;
            String account_id3 = detailed3[0].substring(0, detailed3[0].length());
            String account_number3 = detailed3[1].substring(0, detailed3[1].length());
            String account_currency3 = detailed3[2].substring(0, detailed3[2].length());
            String account_type3 = detailed3[3].substring(0, detailed3[3].length());
            String account_balance3 = detailed3[4].substring(0, detailed3[4].length());
            account3.add(new Account(account_id3, account_number3,account_currency3, account_type3, account_balance3));
        }

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        while (i < account1.size()) {
            if (!Objects.equals(account1.get(i).toString(), account3.get(i).toString())) {
                outputaccount.add(account1.get(i).toString());
                outputaccount.add(account3.get(i).toString());
            }
            i++;
        }
        System.out.println(outputaccount);
        
        File csvFile = new File("output.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        if (true) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < outputaccount.size(); j++) {
//                line.append("\"");
                line.append(outputaccount.get(j)
//                        .replaceAll("\"","\"\"")
                );
                line.append("\n");
//                line.append("\"");
                if (j != outputaccount.size() - 1) {
                   continue;
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }
}
