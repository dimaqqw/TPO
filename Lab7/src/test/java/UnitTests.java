import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTests {
    @Test
    public void testSumWithPositiveValues(){
        assertEquals((Double)7.0, Calculator.Sum(3,4));
    }

    @Test
    public void testSumWithNegativeValues(){
        assertEquals((Double) Double.parseDouble("-7.0"), Calculator.Sum(-3,-4));
    }
    @Test
    public void testMinusWithPositiveValues(){
        assertEquals((Double) Double.parseDouble("-1.0"), Calculator.Minus(3,4));
    }

    @Test
    public void testMinusWithNegativeValues(){
        assertEquals((Double)1.0, Calculator.Minus(-3,-4));
    }
    @Test
    public void testMultiplyWithPositiveValues(){
        assertEquals((Double)12.0, Calculator.Multiply(3,4));
    }

    @Test
    public void testMultiplyWithNegativeValues(){
        assertEquals((Double) Double.parseDouble("12.0"), Calculator.Multiply(-3,-4));
    }
    @Test
    public void testDivideWithPositiveValues(){
        assertEquals((Double)0.75, Calculator.Divide(3,4));
    }

    @Test
    public void testDivideWithNegativeValues(){
        assertEquals((Double) Double.parseDouble("0.75"), Calculator.Divide(-3,-4));
    }
    @Test
    public void testSqrtWithPositiveValue(){
        assertEquals((Double) Double.parseDouble("2.0"), Calculator.Sqrt(4.0));
    }@Test
    public void testSqrtWithNegativeValue(){
        Calculator.Sqrt(-4.0);
    }

}
