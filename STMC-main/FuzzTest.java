
import java.io.*;
import org.junit.Test;
import java.io.IOException;

public class FuzzTest {

    @Test(expected = Test.None.class /* no exception expected */)
    public void fuzzTestGeneral() {
        for (int i = 0; i < 100; i++) {
            FuzzerUnitGeneral f = new FuzzerUnitGeneral();
        }
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void fuzzTestSpecific() {
        for (int i = 0; i < 100; i++) {
            FuzzerUnitSpecific f = new FuzzerUnitSpecific();
        }
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void fuzzTestMutation() {
        for (int i = 0; i < 100; i++) {
            MutationFuzzUnit f = new MutationFuzzUnit();
        }
    }
}
