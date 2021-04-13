package com.farooque.concurutil._4locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyReadWrite {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		new MyReadThread(lock, "A");
		new MyReadThread(lock, "B");

		new MyWriteThread(lock, "X");

		new MyReadThread(lock, "F");
		new MyReadThread(lock, "G");

		new MyWriteThread(lock, "Z");

		new MyReadThread(lock, "C");
		new MyReadThread(lock, "D");
	}

}

class MyReadThread implements Runnable {

	ReadWriteLock lock;
	String name;

	public MyReadThread(ReadWriteLock lock, String nm) {
		this.lock = lock;
		this.name = nm;
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		System.out.println("-->" + name + " is locking");
		lock.readLock().lock();
		System.out.println("==>" + name + " has locked");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " is printing " + SharedResource.count);
		System.out.println("<--" + name + " is unlocking");
		lock.readLock().unlock();
		System.out.println("<==" + name + " has unlocked");
	}

}

class MyWriteThread implements Runnable {

	ReadWriteLock lock;
	String name;

	public MyWriteThread(ReadWriteLock lock, String nm) {
		this.lock = lock;
		this.name = nm;
		new Thread(this, name).start();
	}

	@Override
	public void run() {
		System.out.println("---->" + name + " is locking");
		lock.writeLock().lock();
		System.out.println("====>" + name + " has locked");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SharedResource.count += 100;
		System.out.println(name + " is printing " + SharedResource.count);
		System.out.println("<----" + name + " is unlocking");
		lock.writeLock().unlock();
		System.out.println("<====" + name + " has unlocked");
	}

}

class SharedResource {
	static int count = 291;
}
