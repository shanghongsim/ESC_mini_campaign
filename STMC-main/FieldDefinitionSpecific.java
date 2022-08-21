
import java.util.*;

public class FieldDefinitionSpecific {
    String id;
    String accNum; // Alphabetic, Number, Date, etc..
    String currType;
    String balance;
    String txn;
    String[] currencies = { "USD", "AUD", "INR", "CAD", "SGD", "CHF", "GBP", "HKD", "EUR", "SEK" };

    // <getters and setters>
    public FieldDefinitionSpecific(int id) {
        this.id = generateId(id);
        this.accNum = generateRandomAccNum(1000000, 100000000);
        this.currType = generateRandomCurrType();
        this.balance = generateRandomBalance(10000, 100000);
    }

    public String generateId(int id) {
        String num = Integer.toString(id);
        String output = "ID" + num;
        return output;
    }

    public String generateRandomAccNum(int min, int max) {
        int n = (int) (Math.random() * (max - min)) + min;
        String num = Integer.toString(n);
        String output = "BOS" + num;
        return output;
    }

    public String generateRandomCurrType() {
        int rnd = new Random().nextInt(currencies.length);
        return currencies[rnd];
    };

    public String generateRandomBalance(int min, int max) {
        int n = (int) (Math.random() * (max - min)) + min;
        String num = Integer.toString(n);
        return num;
    };

    public String toString() {// overriding the toString() method
        return id + "," + accNum + "," + currType + "," + balance;
    }
}