package services;

import anatations.Service;
import com.codeborne.selenide.Configuration;
import components.NavigationBar;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import objects.Accounts.Account;
import org.springframework.beans.factory.annotation.Autowired;
import pages.LoginPage;
import services.pageComponentServices.NavigationBarService;

import static com.codeborne.selenide.Selenide.open;

@Slf4j
@Getter
@Service
public class LoginService implements NavigationBarService {

    @Autowired
    private LoginPage page;

    public void login(Account account) {
        open(Configuration.baseUrl);
        clickSignInButton();
        getPage().getIpfUserName().sendKeys(account.getSamAccountName());
        getPage().getIpfPassword().sendKeys(account.getPass());
        getPage().getBtnSubmit().click();


    }

    @Override
    public NavigationBar navigationBar() {
        return getPage().getNavigationBar();
    }
}
