package com.deavensoft.training.streams.example.ex10.functional;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelExecutionIssues {

	public static void main(String[] args) throws Exception {
		
		List<Integer> list = IntStream.iterate(1, i -> i + 1)
				.boxed()
				.limit(10)
				.collect(Collectors.toList());
		System.out.println(list);
		
		long start = System.currentTimeMillis();
		Stream<Integer> stream = list.parallelStream().map(ParallelExecutionIssues::veryLongProcessing);
		
//		List<Integer> newList = stream.collect(Collectors.toList());
		
		Callable<List<Integer>> task = () -> stream.collect(Collectors.toList());
		ForkJoinPool forkJoinPool = new ForkJoinPool(10);
		List<Integer> newList = forkJoinPool.submit(task).get();

		System.out.println("Executed in (sec): " + (System.currentTimeMillis() - start) / 1000.0d);
		System.out.println(newList);
		
	}
	
	private static Integer veryLongProcessing(Integer number) {
		System.out.println(Thread.currentThread().getName());
		try { Thread.sleep(1000);} catch (InterruptedException e) {}
		return number * 100;
	}

}
