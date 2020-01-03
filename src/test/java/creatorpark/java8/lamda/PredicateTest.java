package creatorpark.java8.lamda;

import java.util.function.Predicate;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PredicateTest {
	
//	@Test
	public void predicateTest() {
		Predicate<String> i = (s) -> s.length() > 5;		
		log.info("Predicate Test : {} ", i.test("JaVa115")  ); // true
	}

	
//	@Test
	public void predicateAnd() {
		Predicate<String> i = (s) -> s.length() > 5;
		Predicate<String> j = (s) -> s.length() < 3;
		log.info("Predicate And : {} ", i.and(j).test("JaVa115")  ); // false
	}
	
	@Test
	public void predicateNegate() {
		Predicate<String> i = (s) -> s.length() < 5;		
		log.info("Predicate Negate : {} ", i.negate().test("JaVa115")  ); // true
	}
	
	@Test
	public void predicateoR() {
		Predicate<String> i = (s) -> s.length() > 5;
		Predicate<String> j = (s) -> s.length() < 3;
		log.info("Predicate Or : {} ", i.or(j).test("JaVa115")  ); // true
		

	}
}
