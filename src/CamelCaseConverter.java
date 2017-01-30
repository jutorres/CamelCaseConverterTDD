import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CamelCaseConverter {

	public static List<String> converterCamelCase(String str) {
		List<String> camelList = new ArrayList<String>();
		String res = "";
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				res +=  " " + Character.toLowerCase(ch);
			} else {
				res += ch;
			}
		}
		String[] s = res.split(" ");
		Collections.addAll(camelList, s);
		return camelList;

	}

}
