package creatorpark.concurrent.future.task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Future3FutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();
		
		// Future(비동기 작업의 응답값) + Task(비동기 작업)을 동시에
		FutureTask<String> futureTask = new FutureTask<String>( () -> {
			Thread.sleep(2000);
			log.info("Async");
			return "Hello";			
		});
		
		es.execute(futureTask);
		es.shutdown(); // es서비스는 하나의 자체 Thread 서비스 이기 때문에 이렇게 종료해 주지 않으면 직접 IDE에서 종료해야한다.
		log.info(futureTask.get());
		log.info("Exit");
	}
}
