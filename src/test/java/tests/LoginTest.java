package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import services.LoginService;
import services.MainService;


@Test
public class LoginTest extends BaseTest {


    @Autowired
    private LoginService login;
    @Autowired
    private MainService main;

    @Test (description = "Check upload video btn on channel displayed", enabled = true)
    public void checkUploadBtnDisplayedOnUsersWhoHaveAccessToUpload () {
        login.login(currentUser.get());
        main.verifyThatAvatarIsVisible();
    }

}
