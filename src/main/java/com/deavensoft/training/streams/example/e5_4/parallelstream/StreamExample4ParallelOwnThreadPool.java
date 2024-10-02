package com.deavensoft.training.streams.example.e5_4.parallelstream;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class StreamExample4ParallelOwnThreadPool {
    public static void main(String[] args) throws Exception{
        long firstNum = 1;
        long lastNum = 1_000_000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .toList();

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool.submit(
                () -> aList.parallelStream().reduce(0L, Long::sum)).get();    }
}
