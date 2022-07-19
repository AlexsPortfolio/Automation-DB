package mainPackage;
import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import static io.restassured.RestAssured.*;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;


public class Main {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException{	
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		UpdateDB update = new UpdateDB(); // Update DB with Java
		Operation op = new Operation(); // Automation Operations
		// create object mapper instance
		ObjectMapper mapper = new ObjectMapper();
		File file = new File
				("C:\\Users\\Alex\\eclipse-workspace\\AutomationFromMongo\\src\\mainPackage\\dataFB.json");
		DataFR[] dataFR = mapper.readValue(file, DataFR[].class);
		// database variables
		// use this to automate all collection: for(int index = 0; index < dataFB.length; index++) {
		final int index = 0; 
			String f_name = dataFR[index].getFirstName();
			String l_name = dataFR[index].getLastName();
			String emailFB = dataFR[index].getEmail();
			String passwordFB = dataFR[index].getPassword();
			String gender = dataFR[index].getGender().toLowerCase();
		//  date formatting
			String inputDate = dataFR[index].getBirthDate();
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); 
			} catch (java.time.format.DateTimeParseException e) {
				update.setError("BIRTH_DATE", index);
				dataFR[index].setError("BIRTH_DATE");
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			LocalDate localDate = LocalDate.parse(inputDate , formatter);
			int year = localDate.getYear();
			String month = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			int day = localDate.getDayOfMonth();
        
			file = new File
					("C:\\Users\\Alex\\eclipse-workspace\\AutomationFromMongo\\src\\mainPackage\\dataEmail.json");
			DataSE[] dataSE = mapper.readValue(file, DataSE[].class);
			String email = dataSE[index].getEmail();
			String password = dataSE[index].getPassword();
			String[] sendList = dataSE[index].getSendList();
			String sendTo = String.join(",", Arrays.toString(sendList));
			sendTo = sendTo.substring(1, sendTo.length() - 1);
			sendTo += ",";
			String title = dataSE[index].getTitle();
			String message = dataSE[index].getMessage();
			String status = dataSE[index].getStatus();
		// mail API checks if exists and valid (limited to 100 checks monthly - expired 11/7/22)
		/*try {
			given()
			.queryParam("api_key", "fd7a4e9d0d0245649e947b8d166ac9a3")
			.queryParam("email", email)
			.when()
			.get("https://emailvalidation.abstractapi.com/v1")
			.then().assertThat().statusCode(200)
			.body("deliverability", Matchers.equalTo("DELIVERABLE"))
			.body("is_valid_format.value", Matchers.equalTo(true));
		} catch (AssertionError e) {
			System.out.println("USERNAME ERROR: " + email +" is taken OR not valid format OR trial is over (100 limit)");
		    update.setError("EMAIL", index);
			dataFR[index].setError("EMAIL");
			continue;
		} */
		// call for operations
			op.SendEmail(email, password, sendTo, title, message, status, index);
			//op.SignUpFacebook(f_name, l_name, emailFB, passwordFB, gender, year, month, day);
		
	}
}