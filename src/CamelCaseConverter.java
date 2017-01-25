import java.util.ArrayList;
import java.util.List;


public class CamelCaseConverter {

	public static List<String> converterCamelCase(String str) {
		List<String> camelList = new ArrayList<String>();
		camelList.add(str.toLowerCase());
		return camelList;
	}

}
