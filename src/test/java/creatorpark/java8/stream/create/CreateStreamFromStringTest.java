package creatorpark.java8.stream.create;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CreateStreamFromStringTest {

	@Test
	public void streamTest() {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Integer sum = numbers.stream().reduce(0, Integer::sum);
				
		log.info("SUM : " + sum);
	}
	
}
