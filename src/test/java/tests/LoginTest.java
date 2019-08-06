package tests;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import services.LoginService;

@Slf4j
@Test
public class LoginTest extends BaseTest {

    @Autowired
    private LoginService loginService;

    @Test (description = "Login test")
    public void LoginTest () {
        loginService.login(currentUser.get());
        loginService.checkLoggedInUserNameEqualTo(currentUser.get());
    }
}
