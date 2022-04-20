package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import page.UserPage;

public class LogoutTest extends BaseTests{
	@Test
	@DisplayName("TC")
	void verifyLogout() {
		loginPage.setUserId("mngr399866");
		loginPage.setPassword("zuqUbYj");
		UserPage userPage = loginPage.clickLoginButton();
		String welcomeText = userPage.getWelcomeText();
		Assertions.assertTrue(welcomeText.contains("Welcome To Manager's Page of Guru99 Bank"));
	}
}
