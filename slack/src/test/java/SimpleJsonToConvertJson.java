import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleJsonToConvertJson {

	public static void main(String[] args) throws IOException, ParseException {
		System.out.println("Converting to slack report");
		String cucumerReportPath = "./target/cucumber.json";
		FileReader reader = new FileReader(cucumerReportPath);

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		// Read JSON file
		Object obj = jsonParser.parse(reader);
		JSONArray result = (JSONArray) obj;

		System.out.println("Complete result: " + result);
		System.out.println("Total feature: " + result.size());
		
		System.out.println("Total feature: " + result.toJSONString());

	}

}
