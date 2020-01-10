package creatorpark.concurrent.future;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Future4Callback {

	interface SuccessCallback {
		void onSuccess(String result);
	}
	
	interface ExceptionCallback {
		void onError(Throwable t);
	}
	
	public static class CallbackFutureTask extends FutureTask<String> {
		SuccessCallback sc;
		ExceptionCallback ec;
		
		
		public CallbackFutureTask(Callable<String> callable, 
								  SuccessCallback sc,
								  ExceptionCallback ec) {
			super(callable);
			this.sc = Objects.requireNonNull(sc);
			this.ec = Objects.requireNonNull(ec);
		}
		
		protected void done() {
			try {
				System.out.println("1");
				sc.onSuccess(get()); // Get에서 Exception이 발생
				System.out.println("2");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} catch (ExecutionException e) {
				System.out.println("3");
				ec.onError(e.getCause());
			}

		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();

		CallbackFutureTask f = new CallbackFutureTask(() -> {
			Thread.sleep(2000);
			if ( 1 == 1) throw new RuntimeException("Async ERROR!!!");
			log.info("Async");
			return "Hello";
		}, 
		s -> System.out.println("Result : " + s ),		
		e -> System.out.println("Error : " + e.getMessage() )				
		);
				
		es.execute(f);
		es.shutdown(); // es서비스는 하나의 자체 Thread 서비스 이기 때문에 이렇게 종료해 주지 않으면 직접 IDE에서 종료해야한다.
//		log.info(futureTask.get());
		log.info("Exit");
	}
}
