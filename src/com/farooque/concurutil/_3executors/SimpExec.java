package com.farooque.concurutil._3executors;
// A simple example that uses an Executor. 

import java.util.concurrent.*;

class SimpExec {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);

		System.out.println("Starting");

		// Start the threads.
		es.execute(new MyThread(cdl, "A"));
		es.execute(new MyThread(cdl2, "B"));
		es.execute(new MyThread(cdl3, "C"));
		es.execute(new MyThread(cdl4, "D"));

		try {
			System.out.println("Started...");
			cdl.await();
			System.out.println("Waiting over for cdl");
			cdl2.await();
			System.out.println("Waiting over for cdl2");
			cdl3.await();
			System.out.println("Waiting over for cdl3");
			cdl4.await();
			System.out.println("Waiting over for cdl4");
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}

		es.shutdown();
		System.out.println("Done");
	}
}

class MyThread implements Runnable {
	String name;
	CountDownLatch latch;

	MyThread(CountDownLatch c, String n) {
		latch = c;
		name = n;

		new Thread(this);
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}