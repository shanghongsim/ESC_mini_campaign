
import java.util.*;

public class FieldDefinitionGeneral {
    String f1;
    String f2; // Alphabetic, Number, Date, etc..
    String f3;
    String f4;

    public FieldDefinitionGeneral() {
        this.f1 = generateField();
        this.f2 = generateField();
        this.f3 = generateField();
        this.f4 = generateField();
    }

    public String generateField() {
        int len = (int) ((Math.random() * (30 - 5)) + 5);
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public String toString() {// overriding the toString() method
        return f1 + "," + f2 + "," + f3 + "," + f4;
    }
}