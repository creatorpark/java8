package creatorpark.java8.stream;

import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CreateIntStreamFromRangeTest {

	@Test
	public void intStreams() {
		
		IntStream oneToFive = IntStream.range(1,6);
		//IntStream oneToFive = IntStream.rangeClosed(1,5);
		oneToFive.forEach(System.out::println);
		
	}
	
}
