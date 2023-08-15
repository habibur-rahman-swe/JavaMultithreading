package com.lesson.first.multithread;

import java.util.Date;

public class FirstMultithreadProgram extends Thread {
	
	public static void main(String[] args) {
		
		Runnable task = new DefaultRunnable();
		Thread t1 = new Thread(task);
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName() + " Time: " + (new Date()).getTime());
			}
		});
		
		Thread t3 = new FirstMultithreadProgram();
		
		Thread t4 = new Thread(() -> 
				System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName() + " Time: " + (new Date()).getTime())						
				);
		Thread t5 = new Thread(FirstMultithreadProgram::execute);
		
		System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName() + " Time: " + (new Date()).getTime());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		
	}
	
	public static void execute() {
		System.out.println("I'm a new thread! My name is " + Thread.currentThread().getName() + " Time: " + (new Date()).getTime());
	}
}

class DefaultRunnable implements Runnable {

	private String externalString;
	
	public DefaultRunnable() {
		
	}
	
	public DefaultRunnable(String externalString) {
		this.externalString = externalString;
	}
		
	@Override
	public void run() {
		System.out.println("I'm new thread! My name is " + Thread.currentThread().getName() + " Time: " + (new Date()).getTime());
	}
	
}
