package creatorpark.java8.stream.operation.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StreamMapAndFlatMapTest {

	@Test
	public void mapTest() {
		List<String> data = Arrays.asList("1", "2", "2", "3", "4", "5");
		LongStream stream = data.stream().mapToLong(s -> Long.valueOf(s));
		
		stream.forEach(System.out::println);

		
	}

//	@Test
	public void flatMapTest() {
		List<Integer> primeNum = Arrays.asList(5,7,11,13);
		List<Integer> oddNum = Arrays.asList(1,3,5,7);
		List<Integer> evenNum = Arrays.asList(2,4,8,10);
		
		List<List<Integer>> intList = Arrays.asList(primeNum, oddNum, evenNum);
		
		List<Integer> result = intList.stream()
										.flatMap(list -> list.stream())
										.distinct()
										.collect(Collectors.toList());
		
		// RESULT : [5, 7, 11, 13, 1, 3, 2, 4, 8, 10]
		System.out.println("RESULT : " + result );
	}
	
	
}
