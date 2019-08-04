package pages;

import anatations.PageObject;
import com.codeborne.selenide.SelenideElement;
import components.NavigationBar;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Selenide.$;

@Getter
@PageObject
public class MainPage extends BasePage {

    @Autowired
    private NavigationBar navigationBar;

    private SelenideElement btnSignIn = $("#navbarSupportedContent button");
}
