package com.orion.training.multithreading;

class ThreadDemo {
	public static void main(String args[]) {
		NewThread tt1 = new NewThread("farooque");
		NewThread tt2 = new NewThread("kesavan");
		
		new Thread(tt1); // create a new thread
		new Thread(tt2);
		try {
			tt1.t.join();
			tt2.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}