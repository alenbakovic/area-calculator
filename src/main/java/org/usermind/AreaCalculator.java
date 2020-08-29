package org.usermind;

import lombok.extern.slf4j.Slf4j;

import org.usermind.calculators.CalculatorFactory;
import org.usermind.calculators.CalculatorType;
import org.usermind.processors.Processor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author alen bakovic
 */
@Slf4j
public class AreaCalculator {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        log.info("Starting Area Calculator");

        if (args.length != 1) {
            log.error("Incorrect number of input arguments! Only 1 input argument is allowed!");
            return;
        }

        Double input;
        try {
            input = Double.valueOf(args[0]);
        } catch (NumberFormatException exception) {
            log.error("Invalid input format '{}'. Input must be number!", args[0]);
            return;
        }

        log.info("Creating calculators.");
        final var circleCalculator = CalculatorFactory.createCalculator(CalculatorType.CIRCLE);
        final var squareCalculator = CalculatorFactory.createCalculator(CalculatorType.SQUARE);
        final var triangleCalculator = CalculatorFactory.createCalculator(CalculatorType.TRIANGLE);

        log.info("Creating processor.");
        Processor processor = Processor.getInstance();

        log.info("Calculating area for input argument: {}", input);
        final var circleAreaFuture = processor.doProcessing(input, circleCalculator::calculateArea);
        final var squareAreaFuture = processor.doProcessing(input, squareCalculator::calculateArea);
        final var triangleAreaFuture = processor.doProcessing(input, triangleCalculator::calculateArea);

        log.info("Processor shutdown.");
        processor.shutDown();

        log.info("Calculating total area.");
        final Double circleArea = circleAreaFuture.get(1, TimeUnit.SECONDS);
        final Double squareArea = squareAreaFuture.get(1, TimeUnit.SECONDS);
        final Double triangleArea = triangleAreaFuture.get(1, TimeUnit.SECONDS);

        final var totalArea = circleArea + squareArea + triangleArea;

        log.info("Circle area: {}", circleArea);
        log.info("Square area: {}", squareArea);
        log.info("Triangle area: {}", triangleArea);
        log.info("Total area: {}", totalArea);
    }
}
