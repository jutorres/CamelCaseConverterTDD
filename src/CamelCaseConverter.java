import java.util.ArrayList;
import java.util.List;

public class CamelCaseConverter {

	public static List<String> converterCamelCase(String str) {
		boolean ultimaLetraEraUpper = false;
		boolean abbreviation = false;
		String palavraAtual = "";
		List<String> camelList = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);

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

}
