package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
	private WebDriver driver;
	private By welcome = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");
	private By logout = By.xpath("/html/body/div[3]/div/ul/li[15]/a");

	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getWelcomeText() {
		return driver.findElement(welcome).getText();
	}

	public String clickLogout() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(logout).click();
		return driver.switchTo().alert().getText();
	}
}
