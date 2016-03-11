package jaler.deadlock;

import java.util.concurrent.CountDownLatch;

public class DiningPhilosophersHungryVersion {
	public static void main(String[] args){
		int number = 5;
		Chopstick[] chopsticks = initChopsticks(number);
	    CountDownLatch countDownLatch = new CountDownLatch(number);  
		for(int i = 0; i < number; i++){
			new Thread(new Philosopher(chopsticks[i], chopsticks[(i+1)%number], countDownLatch), "Philosopher" + i).start();
		}
	}

	private static Chopstick[] initChopsticks(int number) {
		Chopstick[] chopsticks = new Chopstick[number];
		for(int i = 0; i < number; i++){
			chopsticks[i] = new Chopstick();
		}
		return chopsticks;
	}
}


