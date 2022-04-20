package test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import page.LoginPage;

public class BaseTests {
	private WebDriver driver;
	protected LoginPage loginPage;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("src/chromedriver.exe")).usingAnyFreePort().build();
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new LinkedHashMap<>();
		prefs.put("profile.default_content_setting_values.cookies", 2);
		options.setExperimentalOption("prefs", prefs);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		driver = new ChromeDriver(service, options);
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

}
