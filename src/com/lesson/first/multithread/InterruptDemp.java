package com.lesson.first.multithread;

import java.util.concurrent.TimeUnit;

public class InterruptDemp implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("in run() - about to work()");
			work();
			System.out.println("in run() + back from work() - this line will net be executed");
		} catch (InterruptedException x) {
			System.out.println("in run() - interrupt in work()");
			return;
		}
		System.out.println("in run() - dogin stuff after nap");
		System.out.println("in run() - leaving normally");
	}
	
	public void work() throws InterruptedException {
		while (true) {
			System.out.println("working");
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("isInterrupted() = " + Thread.currentThread().isInterrupted());
				
				TimeUnit.MILLISECONDS.sleep(1);
				
				System.out.println("this line won't be executed");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		InterruptDemp runnableTask = new InterruptDemp();
		Thread thread = new Thread(runnableTask);
		thread.start();
		
		Thread.sleep(2000);
		
		System.out.println("in main - interrupting other thread");
		thread.interrupt();
		
		thread.join();
		System.out.println("in main() - leaving");
	}
}
