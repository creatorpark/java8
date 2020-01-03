package creatorpark.java8.lamda;

import java.util.function.Function;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FunctionTest {
	
//	@Test
	public void functionApply() {
		Function<Integer,String> f = (i)-> Integer.toString(i);
		
		log.info("Length : {} ", f.apply(3).length()); 	// 1
		log.info("Length : {} ", f.apply(20).length()); // 2
	}

	
//	@Test
	public void functionCompose() {
		Function<Integer,String> c = (i) -> Integer.toString(i);
		Function<String,Integer> r = (s) -> Integer.parseInt(s);
		
		log.info("Length : {} ", c.apply(3).length());
		log.info("Length : {} ", c.compose(r).apply("30").length());
	}
	
//	@Test
	public void functionAndThen() {
		Function<Integer,String> c = (i) -> Integer.toString(i);
		Function<String,Integer> r = (s) -> Integer.parseInt(s);
		
		log.info("Length : {} ", c.apply(3).length());		// 1
		log.info("Length : {} ", c.andThen(r).apply(30));	// 30
	}
	
	@Test
	public void functionIdentity() {
		Function<Integer,Integer> id = Function.identity();

		log.info("Identity : {} ", id.apply(3)); // 3
	}
}
