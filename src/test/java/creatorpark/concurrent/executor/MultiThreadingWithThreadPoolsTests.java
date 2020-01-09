package creatorpark.concurrent.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiThreadingWithThreadPoolsTests {

	@Test
	public void oneExcutor() throws InterruptedException, ExecutionException {
		SquareCalculator squareCalculator = new SquareCalculator();
		
		Future<Integer> future1 = squareCalculator.calculate(10);
		Future<Integer> future2 = squareCalculator.calculate(100);
		
		while( !(future1.isDone() && future2.isDone())) {
		
			log.info("Future1 : {}, Future2 : {}", future1.isDone(), future2.isDone() );
			Thread.sleep(300);
		}
		
		Integer result1 = future1.get();
		Integer result2 = future2.get();
		log.info("Future1 : {}, Future2 : {}", future1.isDone(), future2.isDone() );
		log.info("RESULT : {}, {}", result1, result2);
		
	}


}
