package Assignment1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ExpressionEvaluatorTest {

    private ExpressionEvaluator evaluator;

    @Before
    public void setUp() {
        evaluator = new ExpressionEvaluator();
    }

    @Test
    public void addition() {
        assertEquals(7, evaluator.evaluateExpression("3 + 4"));
        assertEquals(30, evaluator.evaluateExpression("20 + 10"));
    }

    @Test
    public void subtraction() {
        assertEquals(-1, evaluator.evaluateExpression("3 - 4"));
        assertEquals(15, evaluator.evaluateExpression("20 - 5"));
    }

    @Test
    public void testMultiplication() {
        assertEquals(12, evaluator.evaluateExpression("3 * 4"));
        assertEquals(-12, evaluator.evaluateExpression("-3 * 4"));
        assertEquals(12, evaluator.evaluateExpression("-3 * -4"));
    }

    @Test
    public void testDivision() {
        assertEquals(2, evaluator.evaluateExpression("8 / 4"));
        assertEquals(0, evaluator.evaluateExpression("4 / 8"));
    }

    @Test
    public void greaterThan() {
        assertEquals(1, evaluator.evaluateExpression("5 > 3"));
        assertEquals(0, evaluator.evaluateExpression("3 > 5"));
    }

    @Test
    public void lessThan() {
        assertEquals(1, evaluator.evaluateExpression("3 < 5"));
        assertEquals(0, evaluator.evaluateExpression("5 < 3"));
    }

    @Test
    public void greaterThanOrEqual() {
        assertEquals(1, evaluator.evaluateExpression("5 >= 5"));
        assertEquals(1, evaluator.evaluateExpression("6 >= 5"));
        assertEquals(0, evaluator.evaluateExpression("4 >= 5"));
    }

    @Test
    public void lessThanOrEqual() {
        assertEquals(1, evaluator.evaluateExpression("5 <= 5"));
        assertEquals(1, evaluator.evaluateExpression("4 <= 5"));
        assertEquals(0, evaluator.evaluateExpression("6 <= 5"));
    }

    @Test
    public void equality() {
        assertEquals(1, evaluator.evaluateExpression("4 == 4"));
        assertEquals(0, evaluator.evaluateExpression("4 == 5"));
    }

    @Test
    public void notEqual() {
        assertEquals(1, evaluator.evaluateExpression("4 != 5"));
        assertEquals(0, evaluator.evaluateExpression("5 != 5"));
    }

    @Test
    public void logicalAnd() {
        assertEquals(1, evaluator.evaluateExpression("3 && 4"));
        assertEquals(0, evaluator.evaluateExpression("0 && 4"));
        assertEquals(0, evaluator.evaluateExpression("4 && 0"));
        assertEquals(0, evaluator.evaluateExpression("0 && 0"));
    }

    @Test
    public void logicalOr() {
        assertEquals(1, evaluator.evaluateExpression("3 || 4"));
        assertEquals(1, evaluator.evaluateExpression("0 || 4"));
        assertEquals(1, evaluator.evaluateExpression("4 || 0"));
        assertEquals(0, evaluator.evaluateExpression("0 || 0"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidExpressionMissingOperand() {
        evaluator.evaluateExpression("3 +");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidExpressionMissingOperator() {
        evaluator.evaluateExpression("3 4");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void divisionByZero() {
        evaluator.evaluateExpression("4 / 0");
    }
}