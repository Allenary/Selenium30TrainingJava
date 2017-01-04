package litecartShop;

import Pages.litecartShop.UserLoginWidget;
import Pages.litecartShop.UserMenuWigget;
import Pages.litecartShop.UserRegistrationPage;
import org.junit.Test;
import static testHelper.DataGenerator.getUniqueString;

import testHelper.TestAncestor;

public class UserRegistration extends TestAncestor{

	@Test
	public void registrationLogoutLoginLogoutTest() {
            String email = "mail"+getUniqueString()+"@test.com";
            String password = "testPass123";

            new UserRegistrationPage(driver).createAccount(email, password);
            new UserMenuWigget(driver).logout();
            new UserLoginWidget(driver).login(email, password);
            new UserMenuWigget(driver).logout();
        }

}
