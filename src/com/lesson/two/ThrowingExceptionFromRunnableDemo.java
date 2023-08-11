package com.lesson.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThrowingExceptionFromRunnableDemo {

	public static void main(String[] args) {
		var t1 = new Thread(() -> {
			try {
				Files.readString(Paths.get("not-existiong-path"));
			} catch (IOException e) {
				throw new RuntimeException("Hello I am Mr. Exception!");
			}
		});
		t1.start();
	}
	
}
