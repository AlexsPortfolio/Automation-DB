package mainPackage;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;

public class Operation {
	public Operation(){}
	ChromeOptions options = new ChromeOptions();
	WebDriver driver = new ChromeDriver(options);
	UpdateDB updateDB = new UpdateDB();
	Locator l = new Locator();
	
	private void LoginEmail(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get(l.mail_login_url);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(l.mail_username_xpath))).sendKeys(username);
        driver.findElement(By.xpath(l.mail_next_xpath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(l.mail_password_xpath))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(l.mail_next_xpath))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(l.mail_next_xpath))).click();
        driver.get(l.mail_mainPage_url);
}
	
	public void SendEmail(String username,
			String password, 
			String sendTo, 
			String title, 
			String message, 
			String status,
			int index) {
		options.addArguments("start-maximized");
		LoginEmail(username, password);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(l.newMsg_xpath))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(l.to_xpath))).sendKeys(
				sendTo + Keys.TAB + title);
		driver.findElement(By.xpath(l.messageBody_xpath)).sendKeys(message + Keys.TAB);
		driver.findElement(By.xpath(l.send_xpath)).click();
		updateDB.setStatus("SENT", index);
	}
	public void SignUpFacebook(String firstName, 
			String lastName, 
			String email,
			String password,
			String gender, 
			int year, String month, int day) {
        options.addArguments("start-maximized");
        WebDriver driver =  new ChromeDriver(options); 
		driver.get(l.facebook_url);
		driver.findElement(By.xpath(l.fb_regBtn_xpath)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(l.fb_firstName_xpath)));
		driver.findElement(By.xpath(l.fb_firstName_xpath)).sendKeys(
				firstName + Keys.TAB + 
				lastName + Keys.TAB + 
				email + Keys.TAB + 
				password + Keys.TAB + Keys.TAB +
			    month + Keys.TAB + day + Keys.TAB + year);
		// this program does not support non binaries
		if(gender.equals("male")) {
			driver.findElement(By.xpath(l.male_xpath)).click();
		}
		else {
			driver.findElement(By.xpath(l.female_xpath)).click();
		}	
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(l.confirmEmail_xpath)))
		    .sendKeys(email);
			driver.findElement(By.xpath(l.finishSignUp_xpath)).click();
	}
}