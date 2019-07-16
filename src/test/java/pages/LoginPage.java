package pages;

import anatations.PageObject;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import objects.Accounts.Account;
import objects.Accounts.Accounts;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

@Getter
@PageObject
public class LoginPage extends BasePage {

    public SelenideElement getAccount () {
        return $(format("[data-email='%s']#profileIdentifier",BaseTest.currentUser.get()));
    }

    private SelenideElement IPF_password = $("input[type='password']");
    private SelenideElement IPF_email = $("input[type='email']");
    private SelenideElement BTN_passwordNext = $("[role='button']#passwordNext");
    private SelenideElement BTN_loginNext = $("[role='button']#identifierNext");
}
