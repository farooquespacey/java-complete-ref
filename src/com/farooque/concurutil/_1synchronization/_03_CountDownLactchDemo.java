package com.farooque.concurutil._1synchronization;

// An example of CountDownLatch.
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class _03_CountDownLactchDemo {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		System.out.println("Starting");
		new MyThread(cdl, "Faarooque");
		try {
			cdl.await();
//			cdl.await(3, TimeUnit.SECONDS);
			System.out.println("Wait over");
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println("Done");
	}
}

class MyThread implements Runnable {
	CountDownLatch latch;
	String name;

	MyThread(CountDownLatch c, String nm) {
		latch = c;
		name = nm;
		new Thread(this, name).start();
	}

	public void display() {
		System.out.println(Thread.currentThread());
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			latch.countDown(); // decrement count
		}
	}
}