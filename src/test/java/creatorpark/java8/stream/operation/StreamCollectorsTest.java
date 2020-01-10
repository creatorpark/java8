package creatorpark.java8.stream.operation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StreamCollectorsTest {

//	@Test
	public void collectors() {
		Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");
		HashSet<String> fruitHashSet = fruits.collect(HashSet::new, HashSet::add, HashSet::addAll);
		for (String s : fruitHashSet) {
		    System.out.println(s);
		}
	}

//	@Test
	public void collectorsSimple() {
		Stream<String> fruitsSimple = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");
		Set<String> fruitSet = fruitsSimple.collect(Collectors.toSet());
		for (String s : fruitSet) {
		    System.out.println(s);
		}
	}
}
