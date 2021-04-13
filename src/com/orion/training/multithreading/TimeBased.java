package com.orion.training.multithreading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeBased {

	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		new TimeBased().sendAllEmails(executorService);
	}
	
	
	public static String timedCall(Runnable r) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		final StringBuilder c = new StringBuilder();
		final Future handler = executor.submit(r);
		executor.schedule(() -> {
			handler.cancel(true);
			System.out.println("SHUTDOWN");
			c.append("False");
			executor.shutdownNow();
		}, 1, TimeUnit.SECONDS);
		return c.toString();
	}

	private void sendAllEmails(ExecutorService executorService) throws InterruptedException {
		executorService.submit(() -> {
			try {
				System.out.println("Sleeping");
				Thread.sleep(10000);
				System.out.println("Waking up");
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			System.out.println("SOMe");
		});
//		executorService.shutdown();
		final boolean done = executorService.awaitTermination(5, TimeUnit.SECONDS);
		executorService.shutdownNow();
		System.out.printf("All e-mails were sent so far? %b", done);
	}

}
