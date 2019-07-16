package services;

import anatations.Service;
import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import objects.Accounts.Account;
import objects.Accounts.Accounts;
import objects.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private LoginPage loginPage;

    public void login(Account account) {
        open(Configuration.baseUrl);
        if(loginPage.getAccount().exists()){
            loginPage.getAccount().click();
        } else {
            loginPage.getIPF_email().sendKeys(account.getLogin());
            loginPage.getBTN_loginNext().click();
        }
        loginPage.getIPF_password().sendKeys(account.getPass());
        loginPage.getBTN_passwordNext().click();

    }
}
