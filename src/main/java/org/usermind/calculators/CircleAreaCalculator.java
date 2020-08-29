package org.usermind.calculators;

/**
 *
 * @author alen bakovic
 */
public class CircleAreaCalculator implements Calculator {
    @Override
    public double calculateArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }
}
