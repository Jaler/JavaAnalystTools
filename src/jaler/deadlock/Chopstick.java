package jaler.deadlock;

public class Chopstick{
	public void getChopstick() throws InterruptedException{
		Thread.sleep(1000);
	}
	
	public void putChopstick() throws InterruptedException{
		Thread.sleep(1000);
	}
}
