package creatorpark.concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Future1noReturn {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		
		es.execute(() -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			log.info("Hello");
		});

		
		System.out.println("Exit");
	}
}
