package pages;

import anatations.PageObject;
import com.codeborne.selenide.SelenideElement;
import components.NavigationBar;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

@Getter
@PageObject
@Lazy
public class LoginPage extends BasePage {

    @Autowired
    private NavigationBar navigationBar;

    public SelenideElement getAccount () {
        return $(format("[data-email='%s']#profileIdentifier",BaseTest.currentUser.get()));
    }

    private SelenideElement ipfUserName = $("input[name=username]");
    private SelenideElement ipfPassword = $("input[name=password]");
    private SelenideElement btnSubmit = $(".mx-auto button");
}
