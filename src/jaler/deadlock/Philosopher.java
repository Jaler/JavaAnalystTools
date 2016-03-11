package jaler.deadlock;

import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable{
	Chopstick[] chopsticks = new Chopstick[2];
	CountDownLatch countDownLatch = null;
	public Philosopher(Chopstick left, Chopstick right, CountDownLatch countDownLatch){
		chopsticks[0] = left;
		chopsticks[1] = right;
		this.countDownLatch = countDownLatch;
	}
	
	public void eat() throws InterruptedException{
		synchronized(chopsticks[0]){
			System.out.println(Thread.currentThread().getName() + " get one chopstick");
			Thread.sleep(1000);
			synchronized(chopsticks[1]){
				System.out.println(Thread.currentThread().getName() + " get another chopstick");
				System.out.println(Thread.currentThread().getName() + " start to eat.");
				Thread.sleep(2000);
			}
		}
	}
	
	public void think() throws InterruptedException{
		System.out.println(Thread.currentThread().getName() + " is thinking...");
		Thread.sleep(5000);
	}
	
	public void run(){
		countDownLatch.countDown();
		while(true){
			try {
				eat();
				think();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
