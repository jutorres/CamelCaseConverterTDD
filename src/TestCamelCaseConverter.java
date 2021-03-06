import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestCamelCaseConverter {

	@Test
	public void testOneWordLowerCase() {
		List<String> camelList = Arrays.asList("nome");
		String str = "nome";
		assertEquals(camelList, CamelCaseConverter.converterCamelCase(str));  
	}
	
	@Test
	public void testOneWordUpperCase() {
		List<String> camelList = Arrays.asList("nome");
		String str = "Nome";
		assertEquals(camelList, CamelCaseConverter.converterCamelCase(str));  
	}
	
	@Test
	public void testTwoWordsWithLowerAndUpperCase() {
		List<String> camelList = Arrays.asList("nome", "composto");
		String str = "nomeComposto";
		assertEquals(camelList, CamelCaseConverter.converterCamelCase(str));  
	}
	
	@Test
	public void testTwoWordsWithUpperCase() {
		List<String> camelList = Arrays.asList("nome", "composto");
		String str = "NomeComposto";
		assertEquals(camelList, CamelCaseConverter.converterCamelCase(str));  
	}
	
	@Test
	public void testUpperCaseWord() {
		List<String> camelList = Arrays.asList("CPF");
		String str = "CPF";
		assertEquals(camelList, CamelCaseConverter.converterCamelCase(str));  
	}
	
	@Test
	public void testOneLowerCaseAndUpperCaseWord() {
		List<String> camelList = Arrays.asList("numero","CPF");
		String str = "numeroCPF";
		assertEquals(camelList, CamelCaseConverter.converterCamelCase(str));  
	}
	
	@Test(expected=StartWithDigitException.class)
	public void testStarWithDIgit() {
		String str = "10Primeiros";
		CamelCaseConverter.converterCamelCase(str);  
	}
	
	@Test(expected=HasSpecialCharacterException.class)
	public void testHasSpecialCharacter() {
		String str = "nome#Composto";
		CamelCaseConverter.converterCamelCase(str);  
	}
	
}
