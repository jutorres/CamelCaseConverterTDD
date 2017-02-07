import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseConverter {

	public static List<String> converterCamelCase(String original) {
		List<String> camelList = new ArrayList<String>();
		boolean ultimaLetraEraUpper = false;
		String palavraAtual = "";
		
		if (Character.isDigit(original.charAt(0))) {
			throw new StartWithDigitException("Inválido, não deve começar com números.");
		}
		
		if (hasSpecialCharacter(original)) {
			throw new HasSpecialCharacterException("Inválido, caracteres especiais não são permitidos, somente letras e números.");
		}
		
		for (int i = 0; i < original.length(); i++) {
			Character ch = original.charAt(i);
			
			if (Character.isUpperCase(ch)) {
				if (ultimaLetraEraUpper) {
					palavraAtual += ch.toString();
				} else {
					camelList.add(palavraAtual);
					palavraAtual = ch.toString();
				}
				ultimaLetraEraUpper = true;
			} else {
				palavraAtual += ch;
				ultimaLetraEraUpper = false;
			}
			
		}
		camelList.add(palavraAtual);

		if (camelList.get(0).equals("")) {
			camelList.remove(0);
		}

		for (int i = 0; i < camelList.size(); i++) {
			palavraAtual = camelList.get(i);
			if (hasLowerCase(palavraAtual)) {
				camelList.set(i, palavraAtual.toLowerCase());
			}
		}
		return camelList;
	}

	private static boolean hasLowerCase(String palavraAtual) {
		for (int i = 0; i < palavraAtual.length(); i++) {
			if (Character.isLowerCase(palavraAtual.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean hasSpecialCharacter(String original) {
		Pattern p = Pattern.compile("[^a-zA-Z_0-9]");
		Matcher m = p.matcher(original);
		return m.find();
	}
}
