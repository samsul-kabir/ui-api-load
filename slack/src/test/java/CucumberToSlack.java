import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONTokener;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class CucumberToSlack {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Converting to slack report");
		
		// Path to cucumber.json file
		String cucumerReportPath = "./target/cucumber.json";
		String webhookPath = "/services/TLEGPJRQR/BLLCYGCF6/hIRwB4mVzSlLY04aocvi5cvO";
		
		// Read cucumber.json file
		FileReader reader = new FileReader(cucumerReportPath);
		
		// Prepare to send message to slack
		RestAssured.baseURI = "https://hooks.slack.com";	
		RequestSpecification request = RestAssured.given();
		
		String messageColor = null;
		String reportLink = "http://testlink.com";

		boolean featureFlag = true;
		boolean scenarioFlag = true;

		int featureLength = 0;
		int failedFeatureSize = 0;

		int scenarioLength = 0;
		int failedScenarioSize = 0;

		int totalSteps = 0;
		int failedStepsSize = 0;

		ArrayList<String> failedFeature = new ArrayList<String>();
		ArrayList<String> failedScenario = new ArrayList<String>();
		ArrayList<String> failedSteps = new ArrayList<String>();
		ArrayList<String> pathToFailedSteps = new ArrayList<String>();

		JSONTokener tokener = new JSONTokener(reader);
		JSONArray jsonArr = new JSONArray(tokener);
		
		featureLength = jsonArr.length();
		
		for (int j = 0; j < jsonArr.length(); j++) {
			for (int i = 0; i < jsonArr.getJSONObject(j).getJSONArray("elements").length(); i++) {
				for (int k = 0; k < jsonArr.getJSONObject(j).getJSONArray("elements").getJSONObject(i)
						.getJSONArray("steps").length(); k++) {
					String stepsStatus = jsonArr.getJSONObject(j).getJSONArray("elements").getJSONObject(i)
							.getJSONArray("steps").getJSONObject(k).getJSONObject("result").getString("status");
					totalSteps++;

					if (stepsStatus.equals("failed")) {
						pathToFailedSteps.add(jsonArr.getJSONObject(j).getString("name") + " > "
								+ jsonArr.getJSONObject(j).getJSONArray("elements").getJSONObject(i).getString("name")
								+ " > " + jsonArr.getJSONObject(j).getJSONArray("elements").getJSONObject(i)
										.getJSONArray("steps").getJSONObject(k).getString("name"));
						
						failedStepsSize++;
						failedSteps.add(jsonArr.getJSONObject(j).getJSONArray("elements").getJSONObject(i)
								.getJSONArray("steps").getJSONObject(k).getString("name"));
						failedScenario.add(
								jsonArr.getJSONObject(j).getJSONArray("elements").getJSONObject(i).getString("name"));

						if (featureFlag) {
							failedFeatureSize++;
							failedFeature.add(jsonArr.getJSONObject(j).getString("name"));
							featureFlag = false;
						}

						if (scenarioFlag) {
							failedScenarioSize++;
						}
					}
				}
				scenarioLength++;
			}
			featureFlag = true;
		}
		
		if (featureLength == failedFeatureSize) {
			messageColor = "FF0000";  // RED
		}else if(failedFeatureSize==0) {
			messageColor = "36a64f";  // GREEN
		}else {
			messageColor = "FFA500";  // ORANGE
		}
		
		
		String requestAttachment = "{\n" + 
				"    \"attachments\": [\n" + 
				"        {\n" + 
				"            \"fallback\": \"Display overview of cucumber report on slack\",\n" + 
				"            \"color\": \"#"+messageColor+"\",\n" + 
				"            \"pretext\": \"Cucumber Test report\",\n" + 
				"            \"title\": \"Test report overview\",\n" + 
				"            \"title_link\": \""+reportLink+"\",\n" + 
				"            \"text\": \"Optional text that appears within the attachment\",\n" + 
				"            \"fields\": [\n" + 
				"                {\n" + 
				"                    \"title\": \"Feature\",\n" + 
				"                    \"value\": \"Total feature: "+featureLength+" \\n:white_check_mark: Passed: "+(featureLength-failedFeatureSize)+"   :o: Failed: "+failedFeatureSize+"\",\n" + 
				"                    \"short\": true\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"Failed Feature\",\n" + 
				"                    \"value\": \""+convertListToString(failedFeature)+"\",\n" + 
				"                    \"short\": true\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"\",\n" + 
				"                    \"value\": \"\",\n" + 
				"                    \"short\": false\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"\",\n" + 
				"                    \"value\": \"\",\n" + 
				"                    \"short\": false\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"Scenario\",\n" + 
				"                    \"value\": \"Total Scenario: "+scenarioLength+" \\n:white_check_mark: Passed: "+(scenarioLength-failedScenarioSize)+"   :o: Failed: "+failedScenarioSize+"\",\n" + 
				"                    \"short\": true\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"Failed Scenario\",\n" + 
				"                    \"value\": \""+convertListToString(failedScenario)+"\",\n" + 
				"                    \"short\": true \n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"\",\n" + 
				"                    \"value\": \"\",\n" + 
				"                    \"short\": false\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"\",\n" + 
				"                    \"value\": \"\",\n" + 
				"                    \"short\": false\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"Steps\",\n" + 
				"                    \"value\": \"Total steps: "+totalSteps+" \\n:white_check_mark: Passed: "+(totalSteps-failedStepsSize)+"   :o: Failed: "+failedStepsSize+"\",\n" + 
				"                    \"short\": true\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"Failed Steps\",\n" + 
				"                    \"value\": \""+convertListToString(failedSteps)+"\",\n" + 
				"                    \"short\": true\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"\",\n" + 
				"                    \"value\": \"\",\n" + 
				"                    \"short\": false\n" + 
				"                },\n" + 
				"				{\n" + 
				"                    \"title\": \"Path to failure\",\n" + 
				"                    \"value\": \""+convertListToString(pathToFailedSteps)+"\",\n" + 
				"                    \"short\": false\n" + 
				"                }\n" + 
				"            ],\n" + 
				"            \"image_url\": \"http://my-website.com/path/to/image.jpg\",\n" + 
				"            \"thumb_url\": \"http://example.com/path/to/thumb.png\",\n" + 
				"            \"footer\": \"Slack API\",\n" + 
				"            \"footer_icon\": \"https://platform.slack-edge.com/img/default_application_icon.png\",\n" + 
				"            \"ts\": 123456789\n" + 
				"        }\n" + 
				"    ]\n" + 
				"}";

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestAttachment);

		// Post the request and check the response
		request.post(webhookPath); 
		
		/*System.out.println("Feature");
		System.out.println("Total feature: " + featureLength + " Passed: " + (featureLength - failedFeatureSize)
				+ "  Failed: " + failedFeatureSize);
		System.out.println("Failed Feature: " + convertListToString(failedFeature));

		System.out.println("");
		System.out.println("Scenario");
		System.out.println("Total Scenario: " + scenarioLength + " Passed: " + (scenarioLength - failedScenarioSize)
				+ "  Failed: " + failedScenarioSize);
		System.out.println("Failed Scenario: " + convertListToString(failedScenario));

		System.out.println("");
		System.out.println("Steps");
		System.out.println("Total steps: " + totalSteps + " Passed: " + (totalSteps - failedStepsSize) + "  Failed: "
				+ failedStepsSize);
		System.out.println("Failed steps: " + convertListToString(failedSteps));
		
		System.out.println("");
		System.out.println("Paths to failed steps:");
		System.out.println("Path: " + convertListToString(pathToFailedSteps));*/

	}
	
	public static String convertListToString(ArrayList<String> messageList) {
		String msg="";
		for(String str: messageList) {
			msg = msg + ">• " +str + "\n";
		}
		return msg;
	}

}
