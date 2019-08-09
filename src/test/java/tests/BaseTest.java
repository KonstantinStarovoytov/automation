package tests;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import objects.Accounts.Account;
import objects.Accounts.Accounts;
import objects.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.*;
import services.LoginService;
import spring.SpringConfig;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.close;

@Slf4j
@ContextConfiguration(classes = SpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LoginService loginService;

    public static ThreadLocal<Account> currentUser = new ThreadLocal<>();

    public static synchronized void setCurrentUser(Account user) {
        currentUser.set(user);
    }

    public static synchronized void setCurrentUser(ITestContext context) {
        Account account = Accounts.getAccount(UserType.getUserTypeByType(context.getCurrentXmlTest().getParameter("type")));
        currentUser.set(account);
    }

    public static boolean isCurrentUserIs(UserType... users) {
        return Arrays.stream(users).anyMatch(item -> item.equals(currentUser.get()));
    }

    @BeforeClass
    public void prepareTest(ITestContext context) {
        setCurrentUser(context);
    }

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://localhost";
        Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
    }

    @AfterClass()
    public void removeUser() {
        log.info("Set no one user instead of " + currentUser.get().getSamAccountName());
        currentUser.remove();
    }

    @BeforeMethod()
    public static void beforeMethod(ITestContext context) {
        log.info("Starts test method with name: " + context.getCurrentXmlTest().getName());
    }

    @BeforeMethod(groups = "withLogin")
    public void login(ITestContext context) {
        loginService.login(currentUser.get());
        log.info("Starts test class with name: " + context.getCurrentXmlTest().getName());
    }

    @AfterSuite(alwaysRun = true, description = "close all browsers")
    public static void killBrowsers() {
        log.info("Kill all browsers");
        close();
    }

}
