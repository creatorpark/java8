package creatorpark.concurrent.synchronizer.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 모든 쓰레드가 시작할 때까지 기다려서(await) 주로 시작 정렬을 맞춘다.
public class CyclicBarrierExam {

	public static CyclicBarrier barrier = new CyclicBarrier(10);
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i < 10;i++) {
			es.execute(new RandomSleepRunnable(i));
		}
	}
	
	
	public static class RandomSleepRunnable implements Runnable {
		private int id = 0;
		private static Random random = new Random(System.currentTimeMillis());
		
		public RandomSleepRunnable(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			System.out.println("Thread(" + id + ") : start.");
			
			try {
				barrier.await(); // 모든 쓰레드가 이지점까지 호출되기를 기다린다.
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			int delay = random.nextInt(1001) + 1000;
			
			try {
				System.out.println("Thread(" + id + ") : Sleep " + delay);
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread(" + id + ") : End.");
		}
	}
}
