package pages;

import anatations.PageObject;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

@Getter
@PageObject
public class MainPage extends BasePage {

    public SelenideElement getIMG_avatar () {
        return $(format("a[aria-label*='%s']", BaseTest.currentUser.get().getLogin()));
    }

    private SelenideElement logo = $("a[href='#inbox'] img");
}
