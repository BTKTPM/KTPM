package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	private By userIdInput = By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input");
	private By userIdTxt = By.xpath("//*[@id=\"message23\"]");
	private By passwordInput = By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input");
	private By passwordTxt = By.xpath("//*[@id=\"message18\"]");
	private By loginButton = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]");
	private By resetButton = By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[2]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserIdText() {
		return driver.findElement(userIdTxt).getText();
	}

	public String getPasswordText() {
		return driver.findElement(passwordTxt).getText();
	}

	public void setUserId(String userid) {
		driver.findElement(userIdInput).sendKeys(userid);
	}
	
	public String getUserId() {
		return driver.findElement(userIdInput).getText();
	}

	public void setPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public String getPassword() {
		return driver.findElement(passwordInput).getText();
	}

	public UserPage clickLoginButton() {
		driver.findElement(loginButton).click();
		return new UserPage(driver);
	}

	public void clickResetButton() {
		driver.findElement(resetButton).click();
	}
	
	public String clickLoginButtonAlert() {
		driver.findElement(loginButton).click();
		return driver.switchTo().alert().getText();
	}
	
}
