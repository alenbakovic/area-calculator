package org.usermind.calculators;

/**
 *
 * @author alen bakovic
 */
public class TriangleAreaCalculator implements Calculator {
    @Override
    public double calculateArea(double sideSize) {
        return Math.pow(sideSize, 2) * Math.sqrt(3) / 4;
    }
}
