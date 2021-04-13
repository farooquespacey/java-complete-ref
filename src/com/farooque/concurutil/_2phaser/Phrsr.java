package com.farooque.concurutil._2phaser;
// An example of Phaser. 

import java.util.concurrent.*;

class Phrsr {
	static int j = 0;

	public static void main(String args[]) throws InterruptedException {
		Phaser phsr = new Phaser(1); // one to accomodate Main thread in waiting cycle
		Semaphore semaphore = new Semaphore(1);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					phsr.register();
					j++;
					System.out.println(j);
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// System.out.println("->>>>>" + phsr.getRegisteredParties());
				System.out.println("ARRRRR" + phsr.arriveAndDeregister());
				semaphore.release();
			});
		}
		Thread.sleep(100);
		System.out.println("MAINAINAI" + phsr.arriveAndAwaitAdvance());
//		System.out.println(phsr.arriveAndDeregister());
		System.out.println("Done");
		executorService.shutdown();
	}
}
