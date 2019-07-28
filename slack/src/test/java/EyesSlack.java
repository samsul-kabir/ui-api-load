import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class EyesSlack {
	  
	public static void main(String[] args){
		  // Define the color of the slack message 
		  String messageColor = "FF0000";
		  
		  // Define the default message for the Slack notification
		  String fallback = "Applitools Test Results";
		  
		  // Check if test was aborted
//		  if(testResults.isAborted())
//			  messageColor = "A9A9A9"; // Dark Gray
//
//		  // Check the test results and set the color and Slack notification message
//		  switch(testResults.getStatus())
//		  {
//			case Failed:
//				messageColor = "FF0000"; // Red
//				fallback = "Test Failed: " + testResults.getName();
//				break;
//			case Passed:
//				messageColor = "36a64f"; // Green
//				fallback = "Test Successfully Completed: " + testResults.getName();
//				break;
//			case Unresolved:
//				messageColor = "FFA500"; // Orange
//				fallback = "Test Mismatches Found: " + testResults.getName();
//				break;
//		  }
  
		  // build the httpClient object which will send our request to Slack Webhook
		  HttpClient httpClient = HttpClientBuilder.create().build();

		  try {

			  // build the HttpPost request object
		      HttpPost request = new HttpPost("https://hooks.slack.com/services/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");
     
		      // build the HTTP request 
			StringEntity params =new StringEntity("{\n" + 
	      		"\"attachments\": [\n" + 
	      		"{\n" + 
	      		"\"fallback\": \"Test run" + fallback + ".\",\n" + 
	      		"\"color\": \"#" + "36a64f" + "\",\n" + 
	      		"\"pretext\": \"" + "passed" + "\",\n" + 
	      		"\"author_name\": \"Applitools.com\",\n" + 
	      		"\"author_link\": \"https://eyes.applitools.com\",\n" + 
	      		"\"author_icon\": \"https://applitools.com/images/favicon.ico\",\n" + 
	      		"\"title\": \"See Results\",\n" + 
	      		"\"title_link\": \"" + "App" + "\",\n" + 
	      		"\"fields\": [\n" + 
	      		"{\n" + 
	      		"\"title\": \"App\",\n" + 
	      		"\"value\": \"" + "AppName" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"Test\",\n" + 
	      		"\"value\": \"" + "IntegrationTest" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"Batch\",\n" + 
	      		"\"value\": \"" + "Batch" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"Branch\",\n" + 
	      		"\"value\": \"" + "Develop branch" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"OS\",\n" + 
	      		"\"value\": \"" + "MAC OX S" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"Browser\",\n" + 
	      		"\"value\": \"" + "Chrome" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"Viewport\",\n" + 
	      		"\"value\": \"" + "1024*768" + "\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +
	      		"{\n" + 
	      		"\"title\": \"Duration\",\n" + 
	      		"\"value\": \"" + "2min" + " Seconds\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n," +	      		
	      		"{\n" + 
	      		"\"title\": \"Steps\",\n" + 
	      		"\"value\": \"" + "steps are as following" + " Steps\",\n" + 
	      		"\"short\": true\n" + 
	      		"}\n" +
	      		"],\n" + 
	      		"\"footer\": \"Test Start Time\",\n" + 
	      		"\"footer_icon\": \"https://applitools.com/images/favicon.ico\",\n" + 
	      		"\"ts\": " + "Start time" + "\n" + 
	      		"}\n" + 
	      		"]\n" + 
	      		"}");
		      request.addHeader("content-type", "application/x-www-form-urlencoded");
		      request.setEntity(params);
		      
		      // Executes the HTTP request
		      HttpResponse response = httpClient.execute(request);
		      
		  }catch (Exception ex) {
		      //handle exception here
		  } 
	  }	 
}
