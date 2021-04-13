package com.orion.training.multithreading;

/**
 * 
 * @author Farooque
 *
 */
public class _1ThreadJoinEx {

	public static void main(String[] args) {
		ThreadJoin t1 = new ThreadJoin("A");
		ThreadJoin t2 = new ThreadJoin("B");
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main exiting");
	}

}

class ThreadJoin extends Thread {

//	Thread t;
	
	public ThreadJoin(String nm) {
//		t = new Thread(this, nm);
		start();
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			try {
				System.out.println("Thread(" + Thread.currentThread().getName() + ") in loop " + i);
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
