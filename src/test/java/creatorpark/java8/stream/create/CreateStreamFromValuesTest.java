package creatorpark.java8.stream.create;

import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CreateStreamFromValuesTest {

	@Test
	public void ofTests() {
		Stream<String> stream = Stream.of("Hello Galxy");
		stream.forEach(System.out::println); // Consumer 가 어디 있는거지??
	}
	
	@Test
	public void ofSpreadTests() {
		Stream<String> stream = Stream.of("One", "Two", "Threee");
		stream.forEach(System.out::println); // Consumer 가 어디 있는거지??
	}
	
	@Test
	public void emptydTests() {
		Stream<String> stream = Stream.empty();
		stream.forEach(System.out::println); // Consumer 가 어디 있는거지??
	}
}
