package com.farooque.concurutil._1synchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

// 1. Main thread will do payment transaction but it will wait 
// until the inventory op, calculating tax and calculating price op gets over
// 2. Inventory op will access the resource in a locking mode
// 3. Inventory op will exchange the count with calculating tax and calculating price thread
// 3. Calculating price op will exchange the price with Main thread

public class SynchronizationExercise {

	public static void main(String[] args) {
		CountDownLatch latchForTran = new CountDownLatch(3);
		Semaphore inventoryAccessControl = new Semaphore(1);
		new ShoppingThread(latchForTran, inventoryAccessControl);
		try {
			System.out.println("Waiting for other two");
			latchForTran.await();
			System.out.println("Performing Payment Transaction");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class ShoppingThread implements Runnable {

	CountDownLatch latchForTran;
	Semaphore inventoryAccessControl;
	Exchanger<Integer> countExchanger;

	public ShoppingThread(CountDownLatch latchForTran, Semaphore inventoryAccessControl) {
		this.latchForTran = latchForTran;
		this.inventoryAccessControl = inventoryAccessControl;
		// this.latchForCount = new CyclicBarrier(2); // one to wait till inventory
		// count calc, another to wait in
		// // Calculation thread
		this.countExchanger = new Exchanger<>();
		new Thread(this, "Calculation").start();
	}

	@Override
	public void run() {
		new InventoryCheck(inventoryAccessControl, countExchanger, latchForTran);
		System.out.println("Exchanging dup guy");
		int count = 0;
		try {
			count = countExchanger.exchange(new Integer(0));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count is " + count);
		if (count > 0) {
			System.out.println("Calculating Price");
			latchForTran.countDown();
			System.out.println("Calculating Tax");
			latchForTran.countDown();
		}
	}

}

class InventoryCheck implements Runnable {
	Semaphore inventoryCheck;
	Exchanger<Integer> countExchanger;
	CountDownLatch latchForTran;

	public InventoryCheck(Semaphore inventoryCheck, Exchanger<Integer> countExchanger, CountDownLatch latchForTran) {
		this.inventoryCheck = inventoryCheck;
		this.countExchanger = countExchanger;
		this.latchForTran = latchForTran;
		new Thread(this, "Inventory Check").start();
	}

	@Override
	public void run() {
		try {
			System.out.println("Lock acquired");
			inventoryCheck.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int count = Inventory.count;
		try {
			System.out.println("Exchanging real guy");
			System.out.println("dummy guy count was " + countExchanger.exchange(count));
			Thread.sleep(1000); // to check whether the other person starts processing
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Lock released");
		inventoryCheck.release();
		latchForTran.countDown();
	}

}

class Inventory {
	static int count = 1;
}

