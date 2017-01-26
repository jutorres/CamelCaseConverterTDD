import java.util.ArrayList;
import java.util.List;


public class CamelCaseConverter {

	public static List<String> converterCamelCase(String str) {
		List<String> camelList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				sb.append(str.charAt(i));
			} else {
				sb = new StringBuilder();
				sb.append(str.charAt(i));
			}
		}
		camelList.add(sb.toString().toLowerCase());
		return camelList;
	}

}
