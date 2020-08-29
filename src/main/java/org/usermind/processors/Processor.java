package org.usermind.processors;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 *
 * @author alen bakovic
 */
@Slf4j
public class Processor {

    private static Processor instance = null;

    public static Processor getInstance() {
        return instance == null ? new Processor() : instance;
    }

    private ExecutorService executorService = Executors.newFixedThreadPool(4);

    private Processor() {
        // to disable creation of Processor using new
    }

    public Future<Double> doProcessing(final Double input, final Function<Double, Double> calculateArea) {
        return executorService.submit(() -> calculateArea.apply(input));
    }

    public void shutDown() throws InterruptedException {
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
