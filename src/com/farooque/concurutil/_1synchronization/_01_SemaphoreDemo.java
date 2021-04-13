package com.farooque.concurutil._1synchronization;

import java.util.concurrent.Semaphore;

public class _01_SemaphoreDemo {

	public static void main(String... strings) throws InterruptedException {
		Semaphore sem = new Semaphore(1);
		new DecClass(sem, "B");
		new IncClass(sem, "A");
		System.out.println(SharedResource.count);
	}

}

class DecClass implements Runnable {

	private String name;
	private Semaphore sem;

	public DecClass(Semaphore sem, String nm) {
		this.sem = sem;
		this.name = nm;
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is waiting to acquire a lock");
			sem.acquire();
			System.out.println(name + ": Lock aquired");
			for (int i = 0; i < 5; i++) {
				SharedResource.count--;
				System.out.println(name + ": " + SharedResource.count);
			}
			System.out.println(name + " is releasing a lock");
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class IncClass implements Runnable {

	private Semaphore sem;
	private String name;

	public IncClass(Semaphore sem, String nm) {
		this.sem = sem;
		this.name = nm;
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is waiting to acquire a lock");
			sem.acquire();
			System.out.println(name + ": Lock aquired");
			for (int i = 0; i < 5; i++) {
				SharedResource.count++;
				System.out.println(name + ": " + SharedResource.count);
			}
			System.out.println(name + " is releasing a lock");
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class SharedResource {
	static int count = 0;

}
