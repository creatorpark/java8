package creatorpark.concurrent.synchronizer.countlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 다 끝날때까지 카운트를 세서 마지막 정렬을 맞춘다.
public class CountDownExam {

	public static CountDownLatch latch = new CountDownLatch(10);
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0; i < 10;i++) {
			es.execute(new RandomSleepRunnable(i));
		}
		
		latch.await(); // 모든 Thread가 다 종료할때까지 대기
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
			
			int delay = random.nextInt(1001) + 1000;
			
			try {
				System.out.println("Thread(" + id + ") : Sleep " + delay);
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread(" + id + ") : End.");
			latch.countDown(); // latch count -1
		}
	}
}
