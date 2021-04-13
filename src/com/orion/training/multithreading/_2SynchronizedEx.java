package com.orion.training.multithreading;

/**
 * Fetch the value of variable i. Increment the fetched value. And store the
 * increased value of i to its location. Here,
 * 
 * 1st thread fetches the value of i. (Currently value i is 0) and increases it
 * by one, so value of variable i becomes 1. Now 2nd thread accesses the value
 * of i that would be 0 as 1st thread did not store it back to its location. And
 * 2nd thread also increment it and store it back to its location. And 1st also
 * store it. Finally value of variable i is 1. But it should be 2 by the effect
 * of both threads. That’s why we need to synchronize the access to shared
 * variable i.
 * 
 * @author Farooque
 *
 */
public class _2SynchronizedEx {

	public static void main(String[] args) {
		Asset asset = new Asset();
		SynAssetAccess s1 = new SynAssetAccess("A", asset);
		SynAssetAccess s2 = new SynAssetAccess("B", asset);
//		System.out.println("Asset in Main " + asset.getI());
	}

}

class SynAssetAccess implements Runnable{
	String name;
	Asset asset;
	Thread thread;

	public SynAssetAccess(String name, Asset asset) {
//		super(name);
		this.name = name;
		this.asset = asset;
		this.thread = new Thread(this, name);
		thread.start();
	}

	@Override
	public void run() {
		synchronized (this) {
			System.out.println(name + " Doing it.");
			asset.inc();
			System.out.println(name + " Done it.");

		}
	}

}

class Asset {
	int i;

	public int getI() {
		return i;
	}

	synchronized public void inc() {
		System.out.println(">+++++++++++++++");
		System.out.println("In Thread(" + Thread.currentThread().getName() + ") - Increamented");
		++i;
		System.out.println(i);
		System.out.println("+++++++++++++++");
	}

}
