package org.usermind.calculators;

/**
 *
 * @author alen bakovic
 */
public class SquareAreaCalculator implements Calculator {
    @Override
    public double calculateArea(double sideSize) {
        return Math.pow(sideSize, 2);
    }
}
