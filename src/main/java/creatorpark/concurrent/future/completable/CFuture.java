package creatorpark.concurrent.future.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CFuture {

	public static void main(String[] args) throws InterruptedException {
		log.info("" + Runtime.getRuntime().availableProcessors() );
	//	runAsync();
		//supplyAsync();
	}
	
	private static void supplyAsync() throws InterruptedException {
		CompletableFuture.supplyAsync(
				() -> {
					log.info("runAsync");
					if ( 1==1) throw new RuntimeException();
					return 1;
				}).thenApply( s -> {
					log.info("thenApply {} ", s);
					return s * 2;
				}).exceptionally( e -> -10)
				.thenAccept(s2 -> {
					log.info("thenAccept {} ", s2);			
				});
		
		log.info("Exit");
				

		ForkJoinPool.commonPool().shutdown();
		ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);
	}

	private static void runAsync() throws InterruptedException {
		CompletableFuture
			.runAsync(() -> log.info("runAsync"))
			.thenRun(() -> log.info("thenRunAsync"))
			.thenRun(() -> log.info("thenRunAsync"));
		log.info("exit");
		
		ForkJoinPool.commonPool().shutdown();
		ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);
	}
}
