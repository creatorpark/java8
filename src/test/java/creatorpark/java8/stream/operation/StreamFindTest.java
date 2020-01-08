package creatorpark.java8.stream.operation;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StreamFindTest {

	@Test
	public void streamFind() {
		List<String> list = Arrays.asList("A", "B", "C", "D");
		Optional<String> resultAny = list.stream().findAny();
		assertTrue(resultAny.isPresent());
		
		Optional<String> resultFirst = list.stream().findFirst();
		assertTrue( resultFirst.isPresent() );
		assertThat( resultFirst.get(), is("A") );
		
	}
	
}
