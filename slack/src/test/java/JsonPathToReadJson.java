import java.io.FileNotFoundException;
import java.io.FileReader;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathToReadJson {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Converting to slack report");
		String cucumerReportPath = "./target/cucumber.json";
		FileReader reader = new FileReader(cucumerReportPath);
		
		DocumentContext jsonContext = JsonPath.parse(reader.toString());
		System.out.println(jsonContext.read("$[0]").toString());
	}

}
