package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {


    @Test
    public void login(){
        loginPage
                .login(USERNAME,PASSWORD)
                .isPageOpen();

    }
}
