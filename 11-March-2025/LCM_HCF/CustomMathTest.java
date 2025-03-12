import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomMathTest {

    @Test
    public void getHCF() {
        CustomMath customMathObj = new CustomMath();
        assertEquals(15, customMathObj.getHCF(15, 0));
        assertEquals(20, customMathObj.getHCF(60, 40));
    }

    @Test
    public void getLCM() {
        CustomMath customMathObj = new CustomMath();
        assertEquals(0, customMathObj.getLCM(15, 0));
        assertEquals(72, customMathObj.getLCM(24, 36));
    }
}
