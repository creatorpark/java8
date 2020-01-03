package creatorpark.java8.lamda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SupplierConsumerTest {

//	@Test
	public void supplier() {

		// return을 값으로 공급
		Supplier<String> i = () -> "Java 8";
		
		// Java 8
		log.info(i.get());
	}
	
//	@Test
	public void consumer() {

		// 입력을 소비하고 리턴은 없다.
		Consumer<String> consumer = (x) -> System.out.println(x.toLowerCase());		
		
		// java 8
		consumer.accept("Java 8");
	}
}
