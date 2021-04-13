package com.farooque.concurutil._1synchronization;

import java.util.concurrent.Semaphore;

class Q {

	int n;
	// Start with consumer semaphore unavailable.
	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	void get() {
		try {
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		System.out.println("Got: " + n);
		semProd.release();
	}

	void put(int n) {
		try {
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		this.n = n;
		System.out.println("Put: " + n);
		semCon.release();
	}
}

class Producer implements Runnable {

	Q q;

	public Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			q.put(i);
		}
	}

}

class Consumer implements Runnable {

	Q q;

	public Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			q.get();
		}
	}

}

public class _02_ProducerConsumer_WithSemaphore {

	public static void main(String... strings) {
		Q q = new Q();
		Consumer consumer = new Consumer(q);
		Producer producer = new Producer(q);

	}
}
