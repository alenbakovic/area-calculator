package org.usermind;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.usermind.calculators.CalculatorFactory;
import org.usermind.calculators.CalculatorType;
import org.usermind.calculators.CircleAreaCalculator;
import org.usermind.calculators.SquareAreaCalculator;
import org.usermind.calculators.TriangleAreaCalculator;

/**
 * Class that tests area calculators factory
 *
 * @author alen bakovic
 */
public class AreaCalculatorFactoryTest {

    @Test
    public void areaCalculatorFactoryTest() {
        var calculator = CalculatorFactory.createCalculator(CalculatorType.CIRCLE);
        assertTrue(calculator instanceof CircleAreaCalculator);

        calculator = CalculatorFactory.createCalculator(CalculatorType.TRIANGLE);
        assertTrue(calculator instanceof TriangleAreaCalculator);

        calculator = CalculatorFactory.createCalculator(CalculatorType.SQUARE);
        assertTrue(calculator instanceof SquareAreaCalculator);
    }
}
