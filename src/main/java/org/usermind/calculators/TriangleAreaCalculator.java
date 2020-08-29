package org.usermind.calculators;

/**
 * Description of {@link THING}
 *
 * @author alen bakovic (alen@getconvey.com)
 */
public class SquareAreaCalculator extends Calculator {
    @Override
    public double calculateArea(int sideSize) {
        return Math.pow(sideSize, 2);
    }
}
