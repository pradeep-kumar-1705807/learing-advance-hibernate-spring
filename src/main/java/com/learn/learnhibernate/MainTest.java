package com.learn.learnhibernate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MainTest {
    public static void main(String[] args) {
        List<Long> sequenceList = LongStream.rangeClosed(1, 900000000L)
                .boxed()
                .collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        BinaryOperator<Integer> sum = (a, b) -> a + b;


        sequenceList.parallelStream().forEach(ele -> ele.doubleValue());
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("\nStream Execution Time: " + executionTime + " milliseconds");

        long startTimeP = System.currentTimeMillis();

        sequenceList.parallelStream().forEach(ele -> ele.doubleValue());

        long endTimeP = System.currentTimeMillis();
        long executionTimeP = endTimeP - startTimeP;
        System.out.println("\nParallel Stream Execution Time: " + executionTimeP + " milliseconds");
    }
}
