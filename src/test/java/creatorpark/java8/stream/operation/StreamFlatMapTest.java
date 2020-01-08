package creatorpark.java8.stream.operation;

import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StreamFlatMapTest {

	@Test
	public void peekTest() {

		int sum = Stream.of(1,2,3,4,5)
						.peek( e -> log.info("Peek : " + e))
						.filter( n -> n % 2 == 1)
						.peek(e -> log.info("Filterd : "  + e))
						.map( n -> n * n )
						.peek( e-> log.info("Mapped : " + e))
						.reduce(0, Integer::sum);
		
		log.info("sum : " + sum);
	}


	
	
}
