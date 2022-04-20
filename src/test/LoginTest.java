package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import page.UserPage;

public class LoginTest extends BaseTests {

	@Test
	@DisplayName("TC_001")
	void verifyLogin1() {
		loginPage.setUserId("mngr399866");
		loginPage.setPassword("zuqUbYj");
		UserPage userPage = loginPage.clickLoginButton();
		String welcomeText = userPage.getWelcomeText();
		Assertions.assertTrue(welcomeText.contains("Welcome To Manager's Page of Guru99 Bank"));
	}

	@Test
	@DisplayName("TC_002")
	void verifyLogin2() {
		loginPage.setUserId("mngr399866");
		loginPage.setPassword("zuqUbYa");
		String alert = loginPage.clickLoginButtonAlert();
		Assertions.assertTrue(alert.contains("User or Password is not valid"));
	}

	@Test
	@DisplayName("TC_003")
	void verifyLogin3() {
		loginPage.setUserId("mngr39986a");
		loginPage.setPassword("zuqUbYj");
		String alert = loginPage.clickLoginButtonAlert();
		Assertions.assertTrue(alert.contains("User or Password is not valid"));
	}

	@Test
	@DisplayName("TC_004")
	void verifyLogin4() {
		loginPage.setUserId("" + Keys.TAB);
		String txt = loginPage.getUserIdText();
		Assertions.assertTrue(txt.contains("User-ID must not be blank"));
	}

	@Test
	@DisplayName("TC_005")
	void verifyLogin5() {
		loginPage.setPassword("" + Keys.TAB);
		String txt = loginPage.getPasswordText();
		Assertions.assertTrue(txt.contains("Password must not be blank"));
	}

	@Test
	@DisplayName("TC_006")
	void verifyReset1() {
		loginPage.setUserId("mngr399866");
		loginPage.setPassword("zuqUbYj");
		loginPage.clickResetButton();
		String txt1 = loginPage.getUserId();
		String txt2 = loginPage.getPassword();
		Assertions.assertTrue(txt1.contains(""));
		Assertions.assertTrue(txt2.contains(""));
	}

	@Test
	@DisplayName("TC_007")
	void verifyReset2() {
		loginPage.clickResetButton();
		String txt1 = loginPage.getUserId();
		String txt2 = loginPage.getPassword();
		Assertions.assertTrue(txt1.contains(""));
		Assertions.assertTrue(txt2.contains(""));
	}
}
