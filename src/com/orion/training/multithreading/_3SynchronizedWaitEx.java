package com.orion.training.multithreading;

public class _3SynchronizedWaitEx {

	int n;
	boolean contains;

	synchronized void put(int n) {
		while (contains)
			try {
				System.out.println("Put -> Going in a waiting mode");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		this.n = n;
		contains = true;
		System.out.println("Put: " + this.n + "/" + n);
		System.out.println("Put -> Notifying Consumer");
		notify();
	}

	synchronized int get() {
		while (!contains)
			try {
				System.out.println("Get -> Going in a waiting mode");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Got: " + n);
		contains = false;
		System.out.println("Get -> Notifying Producer");
		notify();
		return this.n;
	}

}

class Producer implements Runnable {

	_3SynchronizedWaitEx q;

	public Producer(_3SynchronizedWaitEx q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		int i = 0;
		for (int j = 0; j < 5; j++) {
			q.put(++i);
		}
	}

}

class Consumer implements Runnable {

	_3SynchronizedWaitEx q;

	public Consumer(_3SynchronizedWaitEx q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			q.get();
		}
	}

}

class Main {

	public static void main(String... strings) {
		_3SynchronizedWaitEx q = new _3SynchronizedWaitEx();
		_3SynchronizedWaitEx qq = new _3SynchronizedWaitEx();
		Consumer consumer = new Consumer(q);
		Producer producer = new Producer(q);

		System.out.println("Press CTRL+C to stop");
	}
}
