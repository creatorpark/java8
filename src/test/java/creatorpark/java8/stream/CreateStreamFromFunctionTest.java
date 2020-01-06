package creatorpark.java8.stream;

import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CreateStreamFromFunctionTest {

	@Test
	public void iterateTest() {
		Stream<Long> tenNaturalNumbers = Stream.iterate(1L, n -> n+1)
											   .limit(10);
		tenNaturalNumbers.forEach(System.out::println);
	}

	
	@Test
	public void generateTest() {
		Stream.generate(Math::random)
		      .limit(5)
		      .forEach(System.out::println);
	}
	
}
