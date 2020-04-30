package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.*;

public class ForgotPassword extends BaseTests {

	@Test
	public void testForgotPassword(){
		ForgotPasswordPage forgotPassword = homePage.clickForgotPassword();
		forgotPassword.setEmail("tau@example.com");
		EmailSentPage emailSentPage = forgotPassword.retrievePassword();
		assertTrue(emailSentPage.getEmailSentText().contains("Your e-mail's been sent!"), "Email sent text is incorrect" );
	}
}
