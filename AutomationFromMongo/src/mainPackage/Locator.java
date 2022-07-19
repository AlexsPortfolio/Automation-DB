package mainPackage;

public class Locator {
	public Locator() {}
	// Email Locators
	String mail_login_url = "https://login.live.com/login.srf";
	String mail_mainPage_url = "https://outlook.live.com/mail/0/";
	String mail_username_xpath = "//input[@type = 'email']";
	String mail_next_xpath = "//input[@type = 'submit']";
	String mail_password_xpath = "//input[@type = 'password']";
	String code_extract_xpath = "//*[contains(text(), 'is your Facebook account recovery code')]";
	String newMsg_xpath = "//*[contains(text(), 'New message')]";
	String to_xpath = "//input[@role = 'combobox']";
	String messageBody_xpath = "//*[@aria-label='Message body']";
	String send_xpath = "//button[@aria-label = 'Send']";
	
	// Facebook Locators
	String facebook_url = "https://www.facebook.com";
	String fb_regBtn_xpath = "//a[@data-testid = 'open-registration-form-button']";
	String fb_firstName_xpath = "//input[@name = 'firstname']";
	String male_xpath = "//*[contains(text(), 'Male')]";
	String female_xpath = "//*[contains(text(), 'Female')]";
	String confirmEmail_xpath = "//input[@aria-label = 'Re-enter email']";
	String finishSignUp_xpath = "//button[@name = 'websubmit']";
	String code_xpath = "//input[@id = 'recovery-code-entry']";
}