package tests;

import entity.MessageModel;
import entity.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import services.LoginService;
import services.ORMServices.DBFinder;
import services.ORMServices.HibernateUtil;

import java.util.List;

@Slf4j
@Test
public class LoginTest extends BaseTest {

    @Autowired
    private LoginService loginService;

    @Test (description = "Login test")
    public void LoginTest () {
//        var resultList = DBFinder.find(UserModel.class).getResultList();
//        var resultList2 = DBFinder.find(MessageModel.class).getResultList();
        loginService.login(currentUser.get());
        loginService.checkLoggedInUserNameEqualTo(currentUser.get());
    }
}
