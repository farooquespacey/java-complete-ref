package com.farooque.concurutil._3executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("STARTED");
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<Integer> future = executorService.submit(() -> 10);
		executorService.execute(() -> {
			System.out.println("2");
		});
		executorService.execute(() -> {
			System.out.println("3");
		});
		executorService.execute(() -> {
			System.out.println("4");
		});
		executorService.execute(() -> {
			System.out.println("5");
		});
		executorService.execute(() -> {
			System.out.println("6");
		});
		executorService.execute(() -> {
			System.out.println("7");
		});
		executorService.execute(() -> {
			System.out.println("8");
		});
		executorService.execute(() -> {
			System.out.println("9");
		});
		executorService.execute(() -> {
			System.out.println("11");
		});
		System.out.println(future.get());
		executorService.execute(() -> {
			System.out.println("12");
		});
		executorService.shutdown();
		System.out.println("DONE");
	}

}

