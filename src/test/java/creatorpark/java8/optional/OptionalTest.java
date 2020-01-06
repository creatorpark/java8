package creatorpark.java8.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class OptionalTest {

//	@Test
	public void optionalTest() {
		Optional<String> empty = Optional.empty();
		log.info("IS PRESENT : {}", empty.isPresent() ); // true
	}
	
//	@Test
	public void optionalOfTest() {
		Optional<String> str = Optional.of("Hello");
		log.info("Value : {}", str);
		log.info("IS PRESENT : {}", str.isPresent()); // true
		
		Optional<String> str2 = Optional.of(null); // NullPointerException

	}
	
//	@Test
	public void optionalOfNullableTest() {
		Optional<String> str = Optional.ofNullable(null);
		log.info("Value : {}", str);
		log.info("IS PRESENT : {}", str.isPresent() ); // false
	}
	
	
//	@Test
	public void optionalPrimitiveDataTypeTest() {
		OptionalInt number = OptionalInt.of(2);
		
		if ( number.isPresent() ) {
			int value = number.getAsInt();
			log.info("Number is : {} ", value);
		}
	}
	
	
	@Test
	public void optionalWithStream() {
		OptionalInt maxOdd = IntStream.of(10, 20, 30).filter(n -> n %2 == 1).max();
		
		if ( maxOdd.isPresent() ) {
			log.info("Max Integer : {} ", maxOdd.getAsInt() );
		}
	}
}
