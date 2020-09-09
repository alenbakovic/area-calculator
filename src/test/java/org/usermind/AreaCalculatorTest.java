package org.usermind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.usermind.calculators.CircleAreaCalculator;
import org.usermind.calculators.SquareAreaCalculator;
import org.usermind.calculators.TriangleAreaCalculator;

/**
 * Class that tests area calculators
 *
 * @author alen bakovic
 */
public class AreaCalculatorTest {

    @Test
    public void squareAreaCalculatorTest() {
        var calculator = new SquareAreaCalculator();
        var result = calculator.calculateArea(5);
        assertEquals(25, result, 0.01); // add delta when comparing doubles
    }

    @Test
    public void triangleAreaCalculatorTest() {
        var calculator = new TriangleAreaCalculator();
        var result = calculator.calculateArea(5);
        assertEquals(10.82, result, 0.01); // add delta when comparing doubles
    }

    @Test
    public void circleAreaCalculatorTest() {
        var calculator = new CircleAreaCalculator();
        var result = calculator.calculateArea(5);
        assertEquals(78.53, result, 0.01); // add delta when comparing doubles
    }

    @Test
    public void totalAreaCalculatorTest() {
        var circleAreaCalculator = new CircleAreaCalculator();
        var squareAreaCalculator = new SquareAreaCalculator();
        var triangleAreaCalculator = new TriangleAreaCalculator();

        var input = 5;

        var result = circleAreaCalculator.calculateArea(input)
                + squareAreaCalculator.calculateArea(input)
                + triangleAreaCalculator.calculateArea(input);

        assertEquals(114.36, result, 0.01); // add delta when comparing doubles
    }
}
