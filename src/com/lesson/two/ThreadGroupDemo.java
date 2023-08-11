package com.lesson.two;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadGroup threadGroup = new ThreadGroup("group");
		
		var t0 = new Thread(threadGroup, ThreadGroupDemo::execute);
		var t1 = new Thread(threadGroup, ThreadGroupDemo::execute);
		
		
		t0.start();
		t1.start();
		
		
		TimeUnit.SECONDS.sleep(1);
		
		threadGroup.interrupt();
		
	}
	
	public static void execute() {
		while (true) {
			try {
				TimeUnit.MICROSECONDS.sleep(50);
				System.out.println(Thread.currentThread().getName());
			} catch(InterruptedException e) {
				break;
			}
		}
	}
	
}
