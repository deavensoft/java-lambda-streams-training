package com.deavensoft.training.streams.example.e4_0.lambda;

public class Lambda1 {
	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {
			public void run() {
				System.out.println("In another thread");
			}
		});
		th.start();

		System.out.println("In main");
	}
}
