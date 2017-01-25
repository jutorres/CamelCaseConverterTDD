import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestCamelCaseConverter {

	@Test
	public void testOneWordLowerCase() {
		CamelCaseConverter c = new CamelCaseConverter();
		List<String> camelList = Arrays.asList("name");
		assertEquals("name", c.converterCamelList(camelList));  
	}
	
}
