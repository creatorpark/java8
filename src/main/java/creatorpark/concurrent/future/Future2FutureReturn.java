package creatorpark.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Future2FutureReturn {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();
		
		Future<String> f = es.submit(() -> {
			Thread.sleep(2000);
			log.info("Async");
			return "Hello";
		});
		
		log.info(f.get()); // Blocking
		
		log.info("Exit");
	}
}
