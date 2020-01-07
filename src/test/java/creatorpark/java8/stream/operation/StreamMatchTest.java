package creatorpark.java8.stream.operation;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StreamMatchTest {

	@Test
	public void matchStream() {
		int[] intArray = {2, 4, 6, 8 ,10};
		
		boolean resultAll = Arrays.stream(intArray).allMatch(e -> e%2 == 0);
		log.info("All Match Result : {} ", resultAll); // true
		
		boolean resultAny = Arrays.stream(intArray).anyMatch(e -> e%3 == 0);
		log.info("Any Match Result : {} ", resultAny); // true
		
		boolean resultNone = Arrays.stream(intArray).noneMatch(e -> e%3 == 0);
		log.info("None Match Result : {} ", resultNone); // false

	}
	
}
