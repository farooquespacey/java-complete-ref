/*package com.orion.training.multithreading;

public class Main {

	public static void main(String[] args) {
		NewThread child1 = new NewThread("child1");
		NewThread child2 = new NewThread("child2");

		System.out.println("Waiting for child threads to finish executing " + child1.t.isAlive() + " : " + child2.t.isAlive());
		try {
			child1.t.join();
			child2.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Child threads finished executing " + child1.t.isAlive() + " : " + child2.t.isAlive());
		System.out.println("Main exiting");
	}

}
*/