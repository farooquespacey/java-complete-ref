package com.farooque.concurutil._1synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class _04_CyclicBarrierDemo {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(5);
		System.out.println("Starting");
		new MyThread2(cb, "A");
		new MyThread2(cb, "B");
		new MyThread2(cb, "C");
		new MyThread2(cb, "D");
		new MyThread2(cb, "E");
//		new MyThread2(cb, "B");
		System.out.println("Done");
	}
}

class MyThread2 implements Runnable {
	CyclicBarrier latch;
	String name;

	MyThread2(CyclicBarrier c, String nm) {
		latch = c;
		name = nm;
		new Thread(this, name).start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + ": " + i);
			if(i == 5) {
				try {
					System.out.println(name + " waiting for others");
					latch.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}