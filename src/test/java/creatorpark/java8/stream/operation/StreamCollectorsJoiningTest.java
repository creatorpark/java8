package creatorpark.java8.stream.operation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StreamCollectorsJoiningTest {

//	@Test
	public void joining() {
		Stream<String> fruits = Stream.of("mango", "kiwi", "peach", "cherry", "lemon");
		String joining = fruits.collect(Collectors.joining() );
		log.info(joining); // mangokiwipeachcherrylemon
	}
	
//	@Test
	public void joiningDelimiter() {
		Stream<String> fruits = Stream.of("mango", "kiwi", "peach", "cherry", "lemon");
		String joining = fruits.collect(Collectors.joining(",") ); // mango,kiwi,peach,cherry,lemon
		log.info(joining); // mango,kiwi,peach,cherry,lemon
	}
	
	@Test
	public void joiningDelimiterPrefixPostfix() {
		Stream<String> fruits = Stream.of("mango", "kiwi", "peach", "cherry", "lemon");
		String joining = fruits.collect(Collectors.joining(",", "Name : ", ", Good.") );
		log.info(joining); // Name : mango,kiwi,peach,cherry,lemon, Good.
	}
}
