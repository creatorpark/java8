package creatorpark.java8.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CreateStreamFromCollectionsTest {

	@Test
	public void streamArrayTest() {
		Stream<String> names = Arrays.stream(new String[] {"XML", "Java"});
	}
	
	
	@Test
	public void streamCollectionTest() {
		Set<String> names = new HashSet<>();
		names.add("XML");
		names.add("Java");
		
		Stream<String> seqStream = names.stream();
		seqStream.forEach(System.out::println);
		
		Stream<String> parallelStream = names.parallelStream();
		parallelStream.forEach(System.out::println);
	}
	
}
