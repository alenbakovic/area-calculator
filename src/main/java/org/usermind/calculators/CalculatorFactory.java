package org.usermind.calculators;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author alen bakovic
 */
@Slf4j
public class CalculatorFactory {
    public static Calculator createCalculator(CalculatorType calculatorType) {
        return switch (calculatorType) {
            case SQUARE -> new SquareAreaCalculator();
            case CIRCLE -> new CircleAreaCalculator();
            case TRIANGLE -> new TriangleAreaCalculator();
            default -> {
                log.error("Calculator type not provided");
                yield null;
            }
        };
    }
}
