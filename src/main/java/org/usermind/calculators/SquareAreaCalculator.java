package org.usermind.calculators;

/**
 * Description of {@link THING}
 *
 * @author alen bakovic (alen@getconvey.com)
 */
public class CircleAreaCalculator extends Calculator {
    @Override
    public double calculateArea(int radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}
